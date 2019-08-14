package com.service.impl;

import com.dao.UserCodeMapper;
import com.pojo.User;
import com.pojo.UserCode;
import com.service.UserCodeMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;

@Service
public class UserCodeMapperServiceImpl implements UserCodeMapperService {

    @Autowired
    UserCodeMapper userCodeMapper;

    @Override
    public int insertNameAndCode(UserCode userCode) {
        return this.userCodeMapper.insertNameAndCode(userCode);
    }

    @Override
    public UserCode selectByCode(String code) {
        return userCodeMapper.selectByCode(code);
    }
}












