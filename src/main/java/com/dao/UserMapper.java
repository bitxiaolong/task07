package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectById(Long id);

    User selectByName(String name);

    int insert(User record);

    int insertmail(User user);

    int insertphone(User record);

    User selectByPhone(String phone);

    User selectByEmil(String email);

    int insertemail(User recore);

    User selectByCondition(@Param("name") String name, @Param("password") String password);
}
