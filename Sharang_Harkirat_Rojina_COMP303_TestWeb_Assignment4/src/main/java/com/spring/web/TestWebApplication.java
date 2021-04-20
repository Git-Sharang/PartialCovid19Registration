/*
 * Students:
 * Sharang Verma - 300981587
 * Harkirat Grewal - 300987512
 * Rojina Akter - 300756946
 * 
 * Submission Date: April 2, 2021
 * */
package com.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestWebApplication.class, args);
		System.out.println("Test web service has started successfully at port: 8082");
	}

}
