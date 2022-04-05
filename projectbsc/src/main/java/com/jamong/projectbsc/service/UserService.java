package com.jamong.projectbsc.service;

import java.util.List;

import com.jamong.projectbsc.dto.User;

public interface UserService {

	String addUser(User user);
	List<User> userList();
	boolean login(User user);
}
