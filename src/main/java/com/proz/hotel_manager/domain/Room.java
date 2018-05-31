package com.proz.hotel_manager.domain;

import java.io.Serializable;
import java.math.BigInteger;

public class Room implements Serializable {
	private static final long serialVersionUID = 2343251781631753171L;

	private String roomId;
	private String floorNumber;
	private String roomNumber;
	private BigInteger size;
	private BigInteger price;

	public Room() {
		super();
	}

	public Room(String roomId, String floorNumber, String roomNumber, BigInteger size, BigInteger price) {
		this.roomId = roomId;
		this.floorNumber = floorNumber;
		this.roomNumber = roomNumber;
		this.size = size;
		this.price = price;
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

	/**
	 * @return the floorNumber
	 */
	public String getFloorNumber() {
		return floorNumber;
	}

	/**
	 * @param floorNumber the floorNumber to set
	 */
	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	/**
	 * @return the roomNumber
	 */
	public String getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * @return the size
	 */
	public BigInteger getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(BigInteger size) {
		this.size = size;
	}

	/**
	 * @return the price
	 */
	public BigInteger getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigInteger price) {
		this.price = price;
	}
}
