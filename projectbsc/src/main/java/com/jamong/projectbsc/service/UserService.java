package com.jamong.projectbsc.service;

import java.util.List;

import com.jamong.projectbsc.dto.User;

public interface UserService {

	public String addUser(User user);
	public List<User> userList();
}
