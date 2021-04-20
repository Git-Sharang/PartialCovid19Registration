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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="centre")
public class Centre {

	@Id
	@Column(name = "centreid")
	private int centreId;
	
	@Column(name = "centre_name")
	@NotBlank(message="Centre name is mandatory")
	private String centreName;
	
	@Column(name = "address")
	@NotBlank(message="Address is mandatory")
	private String address;
	
	@Column(name = "city")
	@NotBlank(message="City is mandatory")
	private String city;
	
	@Column(name = "phone")
	@NotBlank(message="Phone is mandatory")
	private String phone;
	
	@Column(name = "website")
	@Pattern(regexp="^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+\\.[a-z]+(\\/[a-zA-Z0-9#]+\\/?)*$", 
	message="Website address is invalid")
	private String website;
	
	@Column(name = "email")
	@Email(message="Valid Email address")
	private String email;
	
	public Centre() {
		
	}
	
	public int getCentreId() {
		return centreId;
	}

	public void setCentreId(int centreId) {
		this.centreId = centreId;
	}

	public String getCentreName() {
		return centreName;
	}

	public void setCentreName(String centreName) {
		this.centreName = centreName;
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
