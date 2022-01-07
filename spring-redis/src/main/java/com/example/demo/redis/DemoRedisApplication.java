package com.example.demo.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.demo.redis.repository")
@EnableScheduling
public class DemoRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRedisApplication.class, args);
	}

}