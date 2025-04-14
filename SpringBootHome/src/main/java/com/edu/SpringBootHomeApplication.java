package com.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringBootHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHomeApplication.class, args);
		
		System.out.println("일단 되나?");
	}

}
