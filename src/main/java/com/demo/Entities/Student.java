package com.demo.Entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;

/**
 * nric
 * email
 * phone
 * id
 */

@Entity
@Table(name = "TABLE_STUDENT")
public class Student {
	
	public Student() {
	}

	/**Id*/
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(precision = 19, scale = 0)
	private BigDecimal id;

	/**name*/
	@Column(name = "NAME", length = 255)
//	@NotBlank
	private String name;
	
	@Column(name = "NRIC", length = 255)
//	@NotBlank
	private String nric;

	@Column(name = "PHONE", length =255)
	private String phoneNumber;
	
	@Column(name = "EMAIL", length = 255)
	private String email;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getNric() {
		return nric;
	}

	public void setNric(String nric) {
		this.nric = nric;
	}
	public Student(BigDecimal id, String name, String nric, String phoneNumber,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.nric = nric;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	

}
