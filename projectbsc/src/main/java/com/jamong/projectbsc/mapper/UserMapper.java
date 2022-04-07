package com.jamong.projectbsc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jamong.projectbsc.dto.User;

@Repository
@Mapper
public interface UserMapper {

	int addUser(User user);
	List<User> userList();
	String getPassword(User user);
	User findUser(User user);
}
