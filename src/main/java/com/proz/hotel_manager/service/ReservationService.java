package com.proz.hotel_manager.service;

import java.util.Date;
import java.util.List;

import com.proz.hotel_manager.domain.Reservation;
import com.proz.hotel_manager.domain.Room;

public interface ReservationService {

	/**
	 * @return
	 */
	List<Reservation> getAllReservations();
	
	/**
	 * @param login
	 * @return
	 */
	List<Reservation> getReservationsUnderClient(String login);

	/**
	 * @param firstDay
	 * @param lastDay
	 * @return
	 */
	List<Room> getFreeRoomsInPeriod(Date firstDay, Date lastDay);
	
	/**
	 * @param reservationId
	 * @return
	 */
	Reservation getReservationUnderId(int reservationId);

	/**
	 * @param reservation
	 */
	void updateReservation(Reservation reservation);
	
	/**
	 * @return
	 */
	int sumUpIncomes();
	
	/**
	 * @return
	 */
	Reservation getNewReservation();
}
