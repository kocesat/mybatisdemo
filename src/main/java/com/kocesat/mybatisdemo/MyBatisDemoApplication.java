package com.kocesat.mybatisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MyBatisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisDemoApplication.class, args);
	}

}
