package com.dom.service;

import com.dom.bean.User;

/**
 * Created by little Stone
 * Date 2019/6/24 Time 14:46
 */
public interface UserService {

	User queryUserById(int id);
	User queryUserByUsernameAndPassword(User user);

}
