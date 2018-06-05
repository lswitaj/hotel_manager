package com.proz.hotel_manager.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Employee implements Serializable {
	private static final long serialVersionUID = 7861077252925052601L;

	private String pesel;
	private String password;
	private String name;
	private String surname;
	private String position;
	private String phoneNumber;
	private String email;
	private BigDecimal salary;
	
	public Employee() {
		super();
	}

	public Employee(String pesel, String password, String name, String surname, String position, String phoneNumber, String email, BigDecimal salary) {
		this.pesel = pesel;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.position = position;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.salary = salary;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}