package com.jamong.projectbsc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.jamong.projectbsc.dto.User;
import com.jamong.projectbsc.mapper.UserMapper;
import com.jamong.projectbsc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired UserMapper userMapper;
	
	@Override
	public String addUser(User user) {
		try {
			userMapper.addUser(user);
		} catch (DuplicateKeyException e) {
			return "users/error";
		}
		return "home";
	}

	@Override
	public List<User> userList() {
		return userMapper.userList();
	}

}
