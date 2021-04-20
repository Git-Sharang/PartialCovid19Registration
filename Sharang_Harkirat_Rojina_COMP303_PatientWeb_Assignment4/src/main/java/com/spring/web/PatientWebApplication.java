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
public class PatientWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientWebApplication.class, args);
		System.out.println("Patient web service has started successfully at port: 8081");
	}

}
