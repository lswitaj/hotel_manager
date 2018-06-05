package com.proz.hotel_manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proz.hotel_manager.domain.Reservation;
import com.proz.hotel_manager.domain.Room;
import com.proz.hotel_manager.repository.ReservationRepository;
import com.proz.hotel_manager.repository.RoomRepository;
import com.proz.hotel_manager.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepository.getAllReservations();
	}

	@Override
	public List<Reservation> getReservationsUnderClient(String login) {
		return reservationRepository.getReservationsUnderClient(login);
	}

	/*TODO dziala, testowane 10 razy*/
	@Override
	public List<Room> getFreeRoomsInPeriod(Date firstDay, Date lastDay) {
		List<Room> freeRooms = roomRepository.getAllRooms();
		List<Reservation> allReservations = reservationRepository.getAllReservations();

		/* TODO exceptions lastday>firstday*/
		for (Reservation reservation : allReservations) {
			if (reservation.isInPeriod(firstDay, lastDay))
				freeRooms.remove(roomRepository.getRoomById(reservation.getRoomId()));
		}
		/* TODO exceptions empty set*/
		return freeRooms;
	}

	@Override
	public int sumUpIncomes() {
		int sumOfPayments = 0;
		List<Reservation> allReservations = reservationRepository.getAllReservations();

		for (Reservation reservation : allReservations) {
			if (reservation.isPaid())
				sumOfPayments = sumOfPayments + reservation.getCost();
		}

		return sumOfPayments;
	}

	@Override
	public Reservation getReservationUnderId(int reservationId) {
		return reservationRepository.getReservationUnderId(reservationId);
	}
}
