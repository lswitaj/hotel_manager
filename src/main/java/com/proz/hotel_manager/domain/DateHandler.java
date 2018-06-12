package com.proz.hotel_manager.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHandler {
	
	private String firstDay;
	private String lastDay;
	
	public String getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(String firstDay) {
		this.firstDay = firstDay;
	}

	public String getLastDay() {
		return lastDay;
	}

	public void setLastDay(String lastDay) {
		this.lastDay = lastDay;
	}
	
	public DateHandler() {
		super();
	}
	
	/**
	 * @param firstDay
	 * @param lastDay
	 */
	public DateHandler(Date firstDay, Date lastDay) {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		this.firstDay = df.format(firstDay);
		this.lastDay = df.format(lastDay);
	}
}
