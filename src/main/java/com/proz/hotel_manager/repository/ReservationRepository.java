package com.proz.hotel_manager.repository;

import java.util.List;

import com.proz.hotel_manager.domain.Reservation;

public interface ReservationRepository {
	
	Reservation getReservationById(int reservationId);
	
	List<Reservation> getAllClientsReservations();

	List<Reservation> getReservationByUserId(String userId);

	long addReservation(Reservation reservation);
}
