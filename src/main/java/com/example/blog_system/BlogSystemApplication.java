package com.example.blog_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.blog_system.mapper") // 这一行是关键
public class BlogSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlogSystemApplication.class, args);
	}
}
