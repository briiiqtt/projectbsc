package com.jamong.projectbsc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jamong.projectbsc.dto.User;

@Repository
@Mapper
public interface UserMapper {

	public int addUser(User user);
	
}
