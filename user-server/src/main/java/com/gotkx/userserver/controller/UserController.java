package com.gotkx.userserver.controller;

import com.gotkx.userserver.model.User;
import com.gotkx.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@Value("${server.port}")
	private String port;

	
	@RequestMapping("/findAllUsers")
	@ResponseBody
	public List<User> findAllUsers() {
		System.out.println("当前访问端口为： " + port);
		return userService.findAllUsers() ;
	}
	
}