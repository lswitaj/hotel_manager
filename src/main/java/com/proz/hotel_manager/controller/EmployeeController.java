package com.proz.hotel_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proz.hotel_manager.service.ReservationService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/reservations")
	public String list(Model model) {
		//model.addAttribute("Reservations", ReservationService.getAllClientsReservations());
		model.addAttribute("reservations", reservationService.getAllReservations());
		
		return "reservations";
	}
		
//	public void updateReservation(int reservationId, Reservation reservation) {
//		
//	}
}
