package com.raven.service;

import java.util.List;

import com.raven.entity.User;

public interface UserService {

    User getUser(Integer userId);
    
    List<User> listUser();
}
