package com.proz.hotel_manager.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proz.hotel_manager.domain.DateHandler;
import com.proz.hotel_manager.domain.Other;
import com.proz.hotel_manager.domain.Reservation;
import com.proz.hotel_manager.service.ReservationService;
import com.proz.hotel_manager.service.RoomService;

@Controller
@RequestMapping("/client")
public class ClientController {

	private Other other = new Other();

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private RoomService roomService;

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {

	}

	/* TODO change it to simply /myReservations without client */
	@RequestMapping("/myReservations")
	public String listReservationsOfClient(Model model) {
		model.addAttribute("login", other.getLogin());
		model.addAttribute("reservations", reservationService.getReservationsUnderClient(other.getLogin()));

		return "client.myReservations";
	}

	/* Making reservations */
	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	public String choseDate(Model model) {
		DateHandler dateHandler = new DateHandler();

		model.addAttribute("reservation", dateHandler);
		return "client.choseDate";
	}

	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public String choseDate(@ModelAttribute("reservation") DateHandler dateHandler,
			RedirectAttributes redirectAttributes) throws ParseException {
		Reservation reservation = new Reservation();

		reservation.setFirstDay(dateHandler.getFirstDay());
		reservation.setLastDay(dateHandler.getLastDay());

		redirectAttributes.addFlashAttribute("reservation", reservation);
		return "redirect:/client/getFreeRoomsInPeriod";
	}

	/* "/period;firstDay=dd-mm-yyyy;lastDay=dd-mm-yyyy" */
	@RequestMapping(value = "/getFreeRoomsInPeriod", method = RequestMethod.GET)
	public String getFreeRoomsInPeriod(Model model, @ModelAttribute("reservation") Reservation reservation,
			RedirectAttributes redirectAttributes) throws ParseException {
		DateHandler dateHandler = new DateHandler(reservation.getFirstDay(), reservation.getLastDay());

		model.addAttribute("rooms",
				reservationService.getFreeRoomsInPeriod(reservation.getFirstDay(), reservation.getLastDay()));
		model.addAttribute("dates", dateHandler);

		redirectAttributes.addFlashAttribute("reservation", reservation);

		return "client.freeRooms";
	}

	@RequestMapping(value = "/pay/room={roomId}/first={firstDay}/last={lastDay}", method = RequestMethod.GET)
	public String payForReservation(Model model, @ModelAttribute("reservation") Reservation reservation,
			@PathVariable("roomId") int roomId, @PathVariable("firstDay") String firstDay,
			@PathVariable("lastDay") String lastDay, RedirectAttributes redirectAttributes) throws ParseException {

		reservation.setCost(roomService.getRoomById(roomId).getPrice().intValue());
		reservation.setClientLogin(other.getLogin());
		reservation.setFirstDay(firstDay);
		reservation.setLastDay(lastDay);
		
		model.addAttribute("reservation", reservation);
		
		return "client.displayReservation";
	}
}
