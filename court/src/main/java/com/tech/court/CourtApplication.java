package com.tech.court;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tech.court.dao")
public class CourtApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourtApplication.class, args);
	}
}
