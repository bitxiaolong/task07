package com.controller;


import com.encryption.DESUtil;
import com.pojo.User;
import com.pojo.UserCode;
import com.service.UserCodeMapperService;
import com.service.UserMapperService;
import com.util.AliUtil;
import com.util.EmailUtil;
import com.util.SmsUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@Controller
public class UserController {
    @Autowired
    private UserMapperService userMapperService;
    Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    SmsUtil smsUtil;

    @Autowired
    AliUtil aliUtil;

    @Autowired
    EmailUtil emailUtil;

    @Autowired
    UserCodeMapperService userCodeMapperService;

    Random random = new Random();

    String s1 = String.valueOf(random.nextInt(999999));

    Jedis jedis = new Jedis();

    @RequestMapping(value = "/a/u/register", method = RequestMethod.GET)
    public String registered() {
        return "register";
    }

    @RequestMapping(value = "/a/u/mail", method = RequestMethod.GET)
    public String registerMail() {
        return "registermail";
    }

    @RequestMapping(value = "/a/u/registermegcode", method = RequestMethod.POST)
    public String sendMegCode(String email,UserCode userCode) {
        String mailcode = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
         if (email == null) {
            logger.info("说明没有邮箱进来:" + email);
            return "registermail";
        } else {
            if (email != null && email.matches(mailcode)) {
                logger.info("说明邮箱账号符合规范，输入的邮箱账号为:" + email);
                try {
                    emailUtil.send_common(email, "请尽快在输入框内输入该验证码" + s1);
                    logger.info("发送的验证码为:" + s1);
                    User user2 = userMapperService.selectByEmil(email);
                    logger.info("根据邮箱号在数据库中查询数据");
                    if (user2 != null) {
                        logger.info("说明有数据，已经注册过，则直接返回登录页面");
                        return "redirect:/a/u/login";
                    } else {
                        logger.info("说明数据库中不存在数据，则执行插入操作");
                        jedis.setex("megcode",300,s1);
                        return email;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            logger.info("说明匹配不上，重新定位到注册页面");
            return "register";
        }
    }


    @RequestMapping(value = "/a/u/upload" ,method = RequestMethod.POST)
    public String uplodaImage(@RequestParam("file") MultipartFile file) throws Exception{
        logger.info("测试文件上传");
        boolean b = aliUtil.uploadImage(file);
        if (b){
            logger.info("说明执行成功，则返回登录页面");
            return "login";
        }
         return "register";
    }


    @RequestMapping(value = "/a/u/registerphonecode", method = RequestMethod.POST)
    public String sendCode(String phone,String code) {
        String phonecode = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        logger.info("获取到的邮箱是:" + phone);
        String pwd = String.valueOf(random.nextInt(999999));
        if (phone == null) {
            logger.info("说明没有手机号输入进来:" + phone);
            return "register";
        } else {
            if (phone.matches(phonecode)) {
                logger.info("说明手机号符合规范，号码为:" + phone);
                smsUtil.setSms(pwd, phone);
                logger.info("发送的验证码为:" + pwd);
                User user1 = userMapperService.selectByPhone(phone);
                logger.info("根据手机号在数据库中查询数据:" + user1);
                if (user1 != null) {
                    logger.info("说明有数据，已经注册过，则直接返回登录页面");
                    return "redirect:/a/u/login";
                } else {
                    logger.info("说明数据库中不存在该条记录，则执行插入操作,将验证码存入缓存中");
                    jedis.setex("code",300,pwd);
                    System.out.println("存入的是:"+jedis.get("code"));
                    return phone;
                }
            }
            logger.info("说明匹配不上，重新定位到注册页面");
            return "register";
        }
    }


    @RequestMapping(value = "/a/u/register", method = RequestMethod.POST)
    public String insert(User user, String name,String code) {
        logger.info("新用户的注册信息为：" + user);
        User users = userMapperService.selectByName(name);
        logger.info("根据手机号查看数据库中是否有数据：" + users);
        if (users != null) {
            logger.info("用户已存在");
            return "redirect:/a/u/login";
        } else {
            if (
                    user.getName() != null
                            && user.getName().length() > 0
                            && user.getPassword() != null
                            && user.getPassword().length() > 0) {
                String code1 = jedis.get("code");
                logger.info("从redis中取出数据，然后做比对，看是不是value一样："+code1);
                if (code.equals(code1)) {
                    logger.info("注册用户的信息：" + user);
                    int row = userMapperService.insert(user);
                    logger.info("插入成功：" + row);
                    return "login";
                } else {
                    return "register";
                }
            }
            return "register";
        }
    }


    @RequestMapping(value = "/a/u/registermeg", method = RequestMethod.POST)
    public String insertmeg(User user, String name,String codea,String email) {
        logger.info("新用户的注册邮箱为：" + user.getEmail());
        User users = userMapperService.selectByName(name);
        logger.info("根据邮箱查看数据库中是否有数据：" + users);
        if (users != null) {
            logger.info("用户已存在");
            return "redirect:/a/u/login";
        } else {
            if (
                    user.getName() != null
                            && user.getName().length() > 0
                            && user.getPassword() != null
                            && user.getPassword().length() > 0) {
                String codemeg = jedis.get("megcode");
                logger.info("从redis中取出数据，然后做比对，看是不是value一样："+codemeg);
                if (codea.equals(codemeg)) {
                    logger.info("注册用户的信息：" + user);
                    int row = userMapperService.insertmail(user);
                    logger.info("插入成功：" + row);
                    return "login";
                } else {
                    return "register";
                }
            }
            return "register";
        }
    }


    @RequestMapping(value = "/a/u/login", method = RequestMethod.GET)
    public String login(User user, String name, String password, HttpServletRequest request, HttpServletResponse response, DESUtil desUtil, ModelAndView modelAndView) throws UnsupportedEncodingException {
                //将获取到的用户名与密码放入到用户查询接口中进行查询
                User user1 = userMapperService.selectByCondition(name, password);
                if (user1 != null) {
                    System.out.println("登录成功");
                    Long id = user1.getId();
                    String token = id + "/" + System.currentTimeMillis();

                    DESUtil desUtil1 = null;
                    try {
                        desUtil1 = new DESUtil();
                        token = desUtil1.encrypt(token);
                        Cookie cookie = new Cookie("token", token);
                        cookie.setMaxAge(60 * 3);

                        cookie.setPath("/");
                        response.addCookie(cookie);
                        request.setAttribute("user", user);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return "redirect:/student";
                } else {
                    System.out.println("登录失败");
                    return "login";
                }
            }


    @RequestMapping(value = "/loginout",method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        //清除保存的session
        session.invalidate();
        System.out.println("session已经注销");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            if ("token".equals(cookie.getName())){
                cookie.setPath("/");
                cookie.setMaxAge(0);
                cookie.setValue(null);
                response.addCookie(cookie);
            }
        }
        System.out.println("退出登录");
        return "redirect:/student";
    }

}
