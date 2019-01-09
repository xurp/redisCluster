package com.raven.serviceImpl;

import com.raven.entity.User;
import com.raven.mapper.UserMapper;
import com.raven.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    
    @Autowired
    UserMapper userMapper;

    /* (non-Javadoc)
     * @see com.raven.service.UserService#getUser(java.lang.Integer)
     * @value:   在redis中 保存缓存在以user命名的集合中
     * @key  :   user集合中的关键字，注意字符串要以单引号括住  'user_id'
     */
    @Override
    @Cacheable(value="user",key="'user_id'+#userId")
    public User getUser(Integer userId) {
        return userMapper.findUserById(userId);
    }

	@Override
	@Cacheable(value="user",key="'userList'")
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return userMapper.selectAllUser();
	}
}
