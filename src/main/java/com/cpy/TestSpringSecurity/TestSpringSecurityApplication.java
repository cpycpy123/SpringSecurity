package com.cpy.TestSpringSecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cpy.TestSpringSecurity.dao" )

public class TestSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringSecurityApplication.class, args);
	}

}
