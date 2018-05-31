package com.proz.hotel_manager.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

public class Reservation implements Serializable {
	private static final long serialVersionUID = 4678151792531716001L;

	private BigInteger reservationId;
	private String status;
	private BigInteger cost;
	private Date firstDay;
	private Date lastDay;
	private boolean board;					//wyzywienie
	private String clientLogin;
	private String roomId;
	
	public Reservation() {
		super();
	}

	public Reservation(BigInteger reservationId, String status, BigInteger cost, Date firstDay, Date lastDay,
			boolean board, String clientLogin, String roomId) {
		this.reservationId = reservationId;
		this.status = status;
		this.cost = cost;
		this.firstDay = firstDay;
		this.lastDay = lastDay;
		this.board = board;
		this.clientLogin = clientLogin;
		this.roomId = roomId;
	}

	/**
	 * @return the reservationId
	 */
	public BigInteger getReservationId() {
		return reservationId;
	}

	/**
	 * @param reservationId the reservationId to set
	 */
	public void setReservationId(BigInteger reservationId) {
		this.reservationId = reservationId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the cost
	 */
	public BigInteger getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(BigInteger cost) {
		this.cost = cost;
	}

	/**
	 * @return the firstDay
	 */
	public Date getFirstDay() {
		return firstDay;
	}

	/**
	 * @param firstDay the firstDay to set
	 */
	public void setFirstDay(Date firstDay) {
		this.firstDay = firstDay;
	}

	/**
	 * @return the lastDay
	 */
	public Date getLastDay() {
		return lastDay;
	}

	/**
	 * @param lastDay the lastDay to set
	 */
	public void setLastDay(Date lastDay) {
		this.lastDay = lastDay;
	}

	/**
	 * @return the board
	 */
	public boolean isBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(boolean board) {
		this.board = board;
	}

	/**
	 * @return the clientLogin
	 */
	public String getClientLogin() {
		return clientLogin;
	}

	/**
	 * @param clientLogin the clientLogin to set
	 */
	public void setClientLogin(String clientLogin) {
		this.clientLogin = clientLogin;
	}

	/**
	 * @return the roomId
	 */
	public String getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}


}