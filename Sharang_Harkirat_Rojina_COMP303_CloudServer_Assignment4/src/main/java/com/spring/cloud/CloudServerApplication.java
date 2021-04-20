/*
 * Students:
 * Sharang Verma - 300981587
 * Harkirat Grewal - 300987512
 * Rojina Akter - 300756946
 * 
 * Submission Date: April 2, 2021
 * */
package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudServerApplication.class, args);
		System.out.println("Spring Boot Cloud server for Assignment 4 has started at port: 8761");
	}

}
