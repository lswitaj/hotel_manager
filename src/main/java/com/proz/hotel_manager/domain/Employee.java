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

	/**
	 * @return the pesel
	 */
	public String getPesel() {
		return pesel;
	}

	/**
	 * @param pesel the pesel to set
	 */
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the salary
	 */
	public BigDecimal getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}