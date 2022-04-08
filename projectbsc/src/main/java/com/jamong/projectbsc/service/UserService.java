package com.jamong.projectbsc.service;

import com.jamong.projectbsc.dto.User;

public interface UserService {

	String addUser(User user);
	User findUser(User user);
	
}
