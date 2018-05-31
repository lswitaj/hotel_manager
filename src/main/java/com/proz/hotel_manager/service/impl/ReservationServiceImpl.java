package com.proz.hotel_manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proz.hotel_manager.domain.Reservation;
import com.proz.hotel_manager.repository.ReservationRepository;
import com.proz.hotel_manager.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public List<Reservation> getAllClientsReservations() {
		return reservationRepository.getAllClientsReservations();
	}

//	@Override
//	public BigInteger sumIncomes() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Reservation getReservationById(int reservationId) {
		return reservationRepository.getReservationById(reservationId);
	}

	@Override
	public void addReservation(Reservation reservation) {
		reservationRepository.addReservation(reservation);
	}

	@Override
	public List<Reservation> getReservationByUserId(String userId) {
		return reservationRepository.getReservationByUserId(userId);
	}

}
