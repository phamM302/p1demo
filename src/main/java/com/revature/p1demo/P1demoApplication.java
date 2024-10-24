package com.revature.p1demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.revature.models")
public class P1demoApplication {

	public static void main(String[] args) {
		SpringApplication.run(P1demoApplication.class, args);
	}

}
