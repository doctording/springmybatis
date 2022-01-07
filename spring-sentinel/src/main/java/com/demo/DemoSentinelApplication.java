package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.demo.repository")
@EnableScheduling
public class DemoSentinelApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSentinelApplication.class, args);
	}

}