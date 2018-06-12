package com.proz.hotel_manager.repository;

import java.util.List;

import com.proz.hotel_manager.domain.Reservation;

public interface ReservationRepository {

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
	 * @param id
	 * @return
	 */
	Reservation getReservationUnderId(int id);
	
	/**
	 * @param reservation
	 */
	void updateReservation(Reservation reservation);
}