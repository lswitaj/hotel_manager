package com.proz.hotel_manager.domain;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Client implements Serializable {
	private static final long serialVersionUID = 3678107792576131001L;

	private String login;

	@Size(min = 6, max = 15, message="{Size.Client.password.validation}")
	private String password;
	private String name;
	private String surname;

	@Pattern(regexp="\\d{9}", message="{Pattern.Client.phoneNumber.validation}")
	private String phoneNumber;

	@Pattern(regexp="[A-Za-z0-9+_.-]+@(.+)$", message="{Pattern.Client.email.validation}")
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