package com.service.impl;

import com.dao.UserMapper;
import com.encryption.MD5Util;
import com.pojo.User;
import com.service.UserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapperServiceImpl implements UserMapperService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User selectByPhone(String phone) {
        return this.userMapper.selectByPhone(phone);
    }

    @Override
    public User selectById(long id) {
        return this.userMapper.selectById(id);
    }

    @Override
    public int insertphone(User record) {
        String password = MD5Util.convertMD5(record.getPassword());
        record.setPassword(password);
        return userMapper.insertphone(record);
    }

    @Override
    public User selectByEmil(String email) {
        return this.userMapper.selectByEmil(email);
    }

    @Override
    public int insertemail(User recore) {
        String s = MD5Util.convertMD5(recore.getPassword());
        recore.setPassword(s);
        return userMapper.insertemail(recore);
    }

    @Override
    public int insertmail(User user) {
        String password = MD5Util.convertMD5(user.getPassword());
        user.setPassword(password);
        return userMapper.insertmail(user);
    }

    @Override
    public User selectByName(String name) {
        return this.userMapper.selectByName(name);
    }

    @Override
    public int insert(User record) {
      String password = MD5Util.convertMD5(record.getPassword());
      record.setPassword(password);
      return userMapper.insert(record);
    }

    @Override
    public User selectByCondition(String name, String password) {
        User users = userMapper.selectByName(name);
        if (name != null&& MD5Util.convertMD5(MD5Util.convertMD5(password)).equals(MD5Util.convertMD5(users.getPassword()))){
            return users;
        }
        return null;
    }
}
