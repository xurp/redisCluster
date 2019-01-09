package com.raven.controller;

import com.raven.dto.ReturnSet;
import com.raven.entity.User;
import com.raven.service.UserService;
import com.raven.serviceImpl.ScopeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    UserService userService;
    
    @Autowired
    ScopeService ScopeService1;
    
    @Autowired
    ScopeService ScopeService2;

    @RequestMapping("/index")
    public String index(){
    	System.err.println("  "+ScopeService1.equals(ScopeService2));
        return "123";
    }

    @RequestMapping("/user/{userId}")
    public com.raven.entity.User getUser(@PathVariable Integer userId){
        return userService.getUser(userId);
    }
    
    @RequestMapping("/users")
    public ReturnSet listUser() {
    	ReturnSet set=new ReturnSet();
    	List<User> userList=userService.listUser();
    	set.setTotals(userList.size());
    	set.setRows(userList);
    	set.destory();
    	return set;
    }
}
