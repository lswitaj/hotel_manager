package com.proz.hotel_manager.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

public class Room implements Serializable {
	private static final long serialVersionUID = 2343251781631753171L;

	@Min(value=1, message="{Min.Room.roomNumber.validation}")
	@Digits(integer=2, fraction=0, message="{Digits.Room.roomNumber.validation}")
	private int roomNumber;
	
	@Min(value=1, message="{Min.Room.size.validation}")
	@Digits(integer=1, fraction=0, message="{Digits.Room.size.validation}")
	private int size;
	
	@Digits(integer=5, fraction=2, message="{Digits.Room.price.validation}")
	private BigDecimal price;

	public Room() {
		super();
	}

	public Room(int roomNumber, int size, BigDecimal price) {
		super();
		this.roomNumber = roomNumber;
		this.size = size;
		this.price = price;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (roomNumber == other.roomNumber && size == other.size && price.equals(other.price))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 29;
		int result = 432121451;
		return result + prime * roomNumber;
	}
	
	
}
