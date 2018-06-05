package com.proz.hotel_manager.service;

import java.util.Date;
import java.util.List;

import com.proz.hotel_manager.domain.Reservation;
import com.proz.hotel_manager.domain.Room;

public interface ReservationService {

	List<Reservation> getAllReservations();
	
	List<Reservation> getReservationsUnderClient(String login);

	List<Room> getFreeRoomsInPeriod(Date firstDay, Date lastDay);
	
	Reservation getReservationUnderId(int reservationId);
	
	int sumUpIncomes();
}
