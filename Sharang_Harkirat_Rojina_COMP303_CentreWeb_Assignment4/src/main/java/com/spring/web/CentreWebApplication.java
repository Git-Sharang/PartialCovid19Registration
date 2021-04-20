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
public class CentreWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentreWebApplication.class, args);
		System.out.println("Centre web service has started successfully at port: 8083");
	}

}
