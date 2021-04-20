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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="patient")
public class Patient {
	
	@Id
	@Column(name = "patientid")
	private int patientId;
	
	@Column(name = "firstname")
	@NotBlank(message="First name is mandatory")
	private String firstname;
	
	@Column(name = "lastname")
	@NotBlank(message="Last name is mandatory")
	private String lastname;
	
	@Column(name = "age")
	@NotNull(message="Age cannot be left empty")
	@Range(min=1, max=110) 
	private int age;
	
	@Column(name = "gender")
	@NotBlank(message="Gender is mandatory")
	private String gender;
	
	@Column(name = "ohip_id")
	@NotBlank(message="OHIP ID is mandatory")
	private String ohip_id;
	
	@Column(name = "address")
	@NotBlank(message="Address is mandatory")
	private String address;
	
	@Column(name = "city")
	@NotBlank(message="City is mandatory")
	private String city;
	
	@Column(name = "phone")
	@NotBlank(message="Phone is mandatory")
	private String phone;
	
	public Patient() {
		
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOhip_id() {
		return ohip_id;
	}

	public void setOhip_id(String ohip_id) {
		this.ohip_id = ohip_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
