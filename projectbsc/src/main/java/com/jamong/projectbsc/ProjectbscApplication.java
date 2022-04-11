package com.jamong.projectbsc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan(value = { "com.jamong.projectbsc.mapper" })
@SpringBootApplication
@EnableScheduling
public class ProjectbscApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectbscApplication.class, args);
	}

}
