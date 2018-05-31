package com.proz.hotel_manager.service;

import java.util.List;

import com.proz.hotel_manager.domain.Reservation;

public interface ReservationService {
	
	List<Reservation> getAllClientsReservations();
	
//	BigInteger sumIncomes();
	
	Reservation getReservationById(int reservationId);

	List<Reservation> getReservationByUserId(String userId);
	
	void addReservation(Reservation reservation);
}