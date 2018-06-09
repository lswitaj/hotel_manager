package com.proz.hotel_manager.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	/* TODO */
	@RequestMapping(value = "/signInClient", method = RequestMethod.GET)
	public String addEmloyee(Model model) {
		Client newClient = new Client();
		model.addAttribute("newClient", newClient);
		
		return "client.signIn";
	}
	
	@RequestMapping(value = "/signInClient", method = RequestMethod.POST)
	public String addEmloyee(@ModelAttribute("newClient") Client newClient) {
		clientService.addClient(newClient);
		
		return "redirect:/welcome";
	}

	
//	@RequestMapping(value = "/Reservations/add", method = RequestMethod.GET)
//	public String getAddNewReservationForm(Model model) {
//	   Reservation newReservation = new Reservation();
//	   model.addAttribute("newReservation", newReservation);
//	   return "addReservation";
//	}
//	   
//	@RequestMapping(value = "/Reservations/add", method = RequestMethod.POST)
//	public String processAddNewReservationForm(@ModelAttribute("newReservation") @Valid Reservation newReservation, BindingResult result, HttpServletRequest request) {
//		
//		if(result.hasErrors()) {
//			   return "addReservation";
//		}
//		
//		String[] suppressedFields = result.getSuppressedFields();
//		   if (suppressedFields.length > 0) {
//		      throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
//		   }
//		   
//		   MultipartFile ReservationImage = newReservation.getReservationImage();
//		   String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//		         
//		      if (ReservationImage!=null && !ReservationImage.isEmpty()) {
//		          try {
//		            ReservationImage.transferTo(new File(rootDirectory+"resources\\images\\"+ newReservation.getReservationId() + ".png"));
//		          } catch (Exception e) {
//		         throw new RuntimeException("Reservation Image saving failed", e);
//		      }
//		      }
//
//	
//	   ReservationService.addReservation(newReservation);
//	   return "redirect:/market/Reservations";
//	}
//	
//	
//	@ExceptionHandler(ReservationNotFoundException.class)
//	public ModelAndView handleError(HttpServletRequest req, ReservationNotFoundException exception) {
//	    ModelAndView mav = new ModelAndView();
//	    mav.addObject("invalidReservationId", exception.getReservationId());
//	    mav.addObject("exception", exception);
//	    mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
//	    mav.setViewName("ReservationNotFound");
//	    return mav;
//	}
//	

}
