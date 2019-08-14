package com.dao;

import com.pojo.UserCode;

public interface UserCodeMapper {

    int insertNameAndCode(UserCode userCode);

    UserCode selectByCode(String code);
}
