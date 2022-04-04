package com.jamong.projectbsc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = { "com.jamong.projectbsc.mapper" })
@SpringBootApplication
public class ProjectbscApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectbscApplication.class, args);
	}

}
