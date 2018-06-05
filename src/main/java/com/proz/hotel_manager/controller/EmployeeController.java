package com.proz.hotel_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proz.hotel_manager.service.ReservationService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/reservation")
	public String listReservationUnderId(Model model, @RequestParam("id") int reservationId) {
		model.addAttribute("reservation", reservationService.getReservationUnderId(reservationId));
		
		return "reservationToUpdate";
	}
		
	/* "/reservations/login" */
	@RequestMapping("/reservations/{clientId}")
	public String listReservationsOfClient(Model model, @PathVariable("clientId") String clientId) {
		model.addAttribute("login", clientId);
		model.addAttribute("reservations", reservationService.getReservationsUnderClient(clientId));
		
		return "reservationsEmployee";
	}
	
//	public void updateReservation(int reservationId, Reservation reservation) {
//		
//	}
}
