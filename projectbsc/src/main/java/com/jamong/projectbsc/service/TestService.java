package com.jamong.projectbsc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamong.projectbsc.mapper.TimeMapper;

@Service
public class TestService {

	@Autowired TimeMapper timemapper;
	
	public String getTime() {
		String time = timemapper.getTime();
		System.out.println(time);
		return time;
	}
	
}
