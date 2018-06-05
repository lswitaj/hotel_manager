package com.proz.hotel_manager.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Other {
	
	/* data format DD-MM-YYYY*/
	public Date getDataFromString(String dateString) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		return formatter.parse(dateString);
	}
}