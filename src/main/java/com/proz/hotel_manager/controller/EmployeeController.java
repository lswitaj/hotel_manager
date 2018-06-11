package com.proz.hotel_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proz.hotel_manager.domain.Client;
import com.proz.hotel_manager.domain.Reservation;
import com.proz.hotel_manager.service.ReservationService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private ReservationService reservationService;

	/* "/reservations/login" */
	@RequestMapping("/reservations/{clientId}")
	public String listReservationsOfClient(Model model, @PathVariable("clientId") String clientId) {
		model.addAttribute("login", clientId);
		model.addAttribute("reservations", reservationService.getReservationsUnderClient(clientId));

		return "employee.displayReservationsOfClient";
	}

	@RequestMapping(value = "/chooseClient", method = RequestMethod.GET)
	public String chooseClientToDisplayReservations(Model model) {
		Client client = new Client();
		model.addAttribute("client", client);

		return "employee.chooseClient";
	}

	@RequestMapping(value = "/chooseClient", method = RequestMethod.POST)
	public String chooseClientToDisplayReservations(@ModelAttribute("login") String login) {

		return "redirect:/employee/reservations/" + login;
	}

	@RequestMapping(value = "/editReservation/id={id}", method = RequestMethod.GET)
	public String updateReservation(Model model, @PathVariable("id") int reservationId,
			RedirectAttributes redirectAttributes) {
		model.addAttribute("actualReservation", reservationService.getReservationUnderId(reservationId));
		redirectAttributes.addFlashAttribute("id", reservationId);
		
		return "employee.editReservation";
	}

	@RequestMapping(value = "/editReservation/id={id}", method = RequestMethod.POST)
	public String updateReservation(@ModelAttribute("actualReservation") Reservation reservation,
			@ModelAttribute("id") int id, BindingResult result) {
		
		reservation.setReservationId(id);
		reservationService.updateReservation(reservation);
		return "redirect:/employee/chooseClient/";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
	
	}
}
