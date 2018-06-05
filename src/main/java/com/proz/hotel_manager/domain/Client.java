package com.proz.hotel_manager.domain;

import java.io.Serializable;

public class Client implements Serializable {
	private static final long serialVersionUID = 3678107792576131001L;

	private String login;
	private String password;
	private String name;
	private String surname;
	private String phoneNumber;
	private String email;
	
	public Client() {
		super();
	}

	public Client(String login, String password, String name, String surname, String phoneNumber, String email) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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
}