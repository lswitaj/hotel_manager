package com.proz.hotel_manager.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proz.hotel_manager.domain.Client;
import com.proz.hotel_manager.domain.Other;
import com.proz.hotel_manager.service.ClientService;
import com.proz.hotel_manager.service.ReservationService;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	private Other other = new Other();
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ClientService clientService;
	
	/* TODO change it to simply /myReservations without client*/
	@RequestMapping("/myReservations/{clientId}")
	public String listReservationsOfClient(Model model, @PathVariable("clientId") String clientId) {
		model.addAttribute("login", clientId);
		model.addAttribute("reservations", reservationService.getReservationsUnderClient(clientId));
		
		return "client.myReservations";
	}

	/* "/period;firstDay=dd-mm-yyyy;lastDay=dd-mm-yyyy" */
	@RequestMapping("/getFreeRoomsInPeriod/{period}")
	public String getFreeRoomsInPeriod(Model model, @MatrixVariable(pathVar="period") Map<String, String> filterData) throws ParseException {
		Date firstDay = other.getDataFromString(filterData.get("firstDay")); //new GregorianCalendar(2018, Calendar.MARCH, 20).getTime();
		Date lastDay = other.getDataFromString(filterData.get("lastDay")); //new GregorianCalendar(2018, Calendar.MARCH, 28).getTime();
		
		model.addAttribute("rooms", reservationService.getFreeRoomsInPeriod(firstDay, lastDay));
		
		return "client.freeRooms";
	}

	@RequestMapping(value = "/makeReservation")
	public String makeReservation() {

		return "client.choseDate";
	}
	
	/* TODO */
	@RequestMapping(value = "/signInClient", method = RequestMethod.GET)
	public String addEmloyee(Model model) {
		Client newClient = new Client();
		model.addAttribute("newClient", newClient);
		
		return "client.signIn";
	}

	@RequestMapping(value = "/signInClient", method = RequestMethod.POST)
	public String addEmloyee(@ModelAttribute("newClient") @Valid Client newClient, BindingResult result) {
		clientService.addClient(newClient);
		
		if(result.hasErrors()) {
			return "client.signIn";
		}
		
		return "redirect:/welcome";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
	
	}
}
