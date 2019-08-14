package com.interceptor;

import com.encryption.DESUtil;
import com.encryption.JWTUtil;
import com.pojo.User;
import com.service.UserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapperService userMapperService;



    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();

         if (cookies != null && cookies.length>0){
             System.out.println("开始遍历cookie");
             //遍历cookie,如果能找到登录状态则返回true,执行原来controller里面的方法
             for (Cookie cookie: cookies){
                 if ("token".equals(cookie.getName())){
                     DESUtil desUtil = new DESUtil();
                     //登录加密，现在解密
                     String token = desUtil.decrypt(cookie.getValue());
                     System.out.println("解密完成");
                     JWTUtil jwtUtil = new JWTUtil();
                     long id = jwtUtil.tool(token);
                     System.out.println("id为："+id);
                      if (userMapperService.selectById(id)!=null){
                          //验证token的有效性，返回true
                          System.out.println("成功通过测试，即将进入界面");
                          return true;
                      }else {
                          System.out.println("验证失败");
                          httpServletResponse.sendRedirect("/a/u/login");
                          return false;
                      }
                 }
             }
         }
        System.out.println("cookie不存在");
        httpServletResponse.sendRedirect("/a/u/login");
        return false;
        }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
