package com.gotkx.userserver.service;

import com.gotkx.userserver.mapper.UserMapper;
import com.gotkx.userserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public List<User> findAllUsers() {
		return userMapper.findAllUsers();
	}
	
}