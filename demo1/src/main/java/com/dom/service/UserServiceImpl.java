package com.dom.service;


import com.dom.bean.User;
import com.dom.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by little Stone
 * Date 2019/6/24 Time 14:49
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
    UserMapper userMapper;

	@Override
	public User queryUserById(int id) {
		User user = userMapper.queryUserById(id);
		return user;
	}

	@Override
	public User queryUserByUsernameAndPassword(User user) {
		return userMapper.queryUserByUsernameAndPassword(user);
	}


}
