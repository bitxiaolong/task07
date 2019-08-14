package com.service;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapperService {


    User selectByPhone(String phone);

    User selectById(long id);

    int insertphone(User record);

    User selectByEmil(String email);

    int insertemail(User recore);

    int insertmail(User user);

    User selectByName(String name);

    int insert(User record);

    User selectByCondition(@Param("name") String name, @Param("password") String password);

}
