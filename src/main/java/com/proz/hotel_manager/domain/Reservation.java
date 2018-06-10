package com.proz.hotel_manager.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

public class Reservation implements Serializable {
	private static final long serialVersionUID = 4678151792531716001L;

	@Min(value=1, message="{Min.Reservation.reservationId.validation}")
	@Digits(integer=5, fraction=0, message="{Digits.Reservation.reservationId.validation}")
	private int reservationId;
	
	private String status;
	
	@Min(value=0, message="{Min.Reservation.cost.validation}")
	@Digits(integer=5, fraction=0, message="{Digits.Reservation.cost.validation}")
	private int cost;
	
	private Date firstDay;
	
	private Date lastDay;
	
	private boolean board;
	
	private String clientLogin;
	
	@Min(value=1, message="{Min.Room.roomNumber.validation}")
	@Digits(integer=2, fraction=0, message="{Digits.Room.roomNumber.validation}")
	private int roomId;

	public Reservation() {
		super();
	}

	public Reservation(int reservationId, String status, int cost, Date firstDay, Date lastDay, boolean board,
			String clientLogin, int roomId) {
		this.reservationId = reservationId;
		this.status = status;
		this.cost = cost;
		this.firstDay = firstDay;
		this.lastDay = lastDay;
		this.board = board;
		this.clientLogin = clientLogin;
		this.roomId = roomId;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Date getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(Date firstDay) {
		this.firstDay = firstDay;
	}

	public Date getLastDay() {
		return lastDay;
	}

	public void setLastDay(Date lastDay) {
		this.lastDay = lastDay;
	}

	public boolean isBoard() {
		return board;
	}

	public void setBoard(boolean board) {
		this.board = board;
	}

	public String getClientLogin() {
		return clientLogin;
	}

	public void setClientLogin(String clientLogin) {
		this.clientLogin = clientLogin;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public boolean isPaid() {
		Set<String> completedStatuses = new HashSet<String>();
		completedStatuses.add("after");
		completedStatuses.add("before");
		completedStatuses.add("during");

		if (completedStatuses.contains(this.getStatus().toLowerCase()))
			return true;
		else
			return false;
	}

	public boolean isInPeriod(Date firstDay, Date lastDay) {
		if (!this.isPaid())
			return false;

		/*
		 * ciekawostka - funkcja, ktora zajela mi najdluzej, ok 4 h, bo uzywalem
		 * przestarzalego konstruktora Date zamiast GregorianCalendar i nie moglem dojsc
		 * do przyczyny problemu szukajac jej wszedzie oprocz tego gdzie powienienem, po
		 * sprawdzeniu kazdej sekundy z debuggera w koncu sie udalo, wazne: epochconverter
		 */
		
		if (this.getLastDay().compareTo(firstDay) <= 0 || this.getFirstDay().compareTo(lastDay) >= 0) {
			return false;
		} else {
			return true;
		}
	}
}