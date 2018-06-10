package com.proz.hotel_manager.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Other {

	/* data format DD-MM-YYYY */
	public Date getDataFromString(String dateString) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		return formatter.parse(dateString);
	}

	public String getRoleOfUser() {
		Object[] list = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray();

		/* list[0].toString() is like "ROLE_CLIENT" */
		String onlyRole = list[0].toString();

		/* return value is like "client" */
		return onlyRole.toLowerCase().substring(5);
	}

	public String getLogin() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentLogin = authentication.getName();
		
		return currentLogin;
	}
}