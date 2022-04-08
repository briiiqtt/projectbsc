package com.jamong.projectbsc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jamong.projectbsc.dto.User;

@Repository
@Mapper
public interface UserMapper {

	int addUser(User user);
	String getPassword(User user);
	User findUser(User user);
}
