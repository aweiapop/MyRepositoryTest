package com.dom.controller;


import com.dom.bean.User;
import com.dom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by little Stone
 * Date 2019/6/24 Time 15:53
 */
@Controller
public class HelloController {

	@Autowired
    UserService userService;
	@RequestMapping("hello")
	@ResponseBody
	public String hello(){
		return "hello";
	}

	@RequestMapping("query")
	@ResponseBody
	public User queryUserById(int id){
		User user = userService.queryUserById(id);
		return user;
	}

	@RequestMapping("/")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("login")
	public String doLogin(User user, MultipartFile multipartFile) {
		System.out.println(user);
        return "loginSuccess";
    }



}
