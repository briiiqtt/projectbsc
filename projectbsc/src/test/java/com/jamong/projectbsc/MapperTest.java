package com.jamong.projectbsc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jamong.projectbsc.mapper.TimeMapper;

@SpringBootTest
public class MapperTest {

	@Autowired TimeMapper timeMapper;
	
	@Test
	void connectionTest() {
		System.out.println(timeMapper.getTime());
	}
	
}
