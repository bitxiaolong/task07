package com.service;

import com.pojo.User;
import com.pojo.UserCode;

public interface UserCodeMapperService {

    int insertNameAndCode(UserCode userCode);

    UserCode selectByCode(String code);

}
