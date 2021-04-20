/*
 * Students:
 * Sharang Verma - 300981587
 * Harkirat Grewal - 300987512
 * Rojina Akter - 300756946
 * 
 * Submission Date: April 2, 2021
 * */
package com.spring.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="test")
public class Test {

	@Id
	@Column(name = "testid")
	private int testId;
	
	@Column(name = "testdate")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotBlank(message="Test date is mandatory")
	private String testDate;
	
	@Column(name = "symptoms")
	@NotBlank(message="Symptoms is mandatory")
	private String symptoms;
	
	@Column(name = "status")
	@NotBlank(message="Status is mandatory")
	private String status;
	
	public Test() {
		
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
