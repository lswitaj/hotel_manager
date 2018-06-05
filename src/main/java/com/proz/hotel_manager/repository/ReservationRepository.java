package com.proz.hotel_manager.repository;

import java.util.List;

import com.proz.hotel_manager.domain.Reservation;

public interface ReservationRepository {

	List<Reservation> getAllReservations();
	
	List<Reservation> getReservationsUnderClient(String login);

	Reservation getReservationUnderId(int id);
}