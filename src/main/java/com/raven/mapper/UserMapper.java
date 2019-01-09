package com.raven.mapper;

import com.raven.entity.User;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {

    User findUserById(int userId);
    List<User> selectAllUser();
    
}
