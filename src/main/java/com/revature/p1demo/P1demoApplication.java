package com.revature.p1demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.revature.models")
@ComponentScan("com.revature") //tells Spring Boot to look in com.revature for Beans(Stereotype Annotations
@EnableJpaRepositories("com.revature.daos") //tells Spring Boot in the daos package for JPARepositories
public class P1demoApplication {

	public static void main(String[] args) {
		SpringApplication.run(P1demoApplication.class, args);
	}

}
