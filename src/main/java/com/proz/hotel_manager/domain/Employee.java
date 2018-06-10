package com.proz.hotel_manager.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Employee implements Serializable {
	private static final long serialVersionUID = 7861077252925052601L;

	@Pattern(regexp="\\d{11}", message="{Pattern.Employee.pesel.validation}")
	private String pesel;
	
	@Size(min = 6, max = 15, message="{Size.Employee.password.validation}")
	private String password;
	private String name;
	private String surname;
	private String position;
	
	@Pattern(regexp="\\d{9}", message="{Pattern.Employee.phoneNumber.validation}")
	private String phoneNumber;
	
	@Pattern(regexp="[A-Za-z0-9+_.-]+@(.+)$", message="{Pattern.Employee.email.validation}")
	private String email;
	
	@Min(value=0, message="{Min.Employee.salary.validation}")
	@Digits(integer=5, fraction=2, message="{Digits.Employee.salary.validation}")
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