package com.proz.hotel_manager.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ReservationController {

	/*@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("status", "cost", "board");
	}
	*/
	// @Autowired
	// private ReservationService ReservationService;

	// @Autowired
	// private ReservationValidator ReservationValidator;

	// @RequestMapping("/Reservations/{userId}")
	// public String getReservationsByUser(Model model, @PathVariable("userId")
	// String userId) {
	// List<Reservation> Reservations =
	// ReservationService.getReservationByUserId(userId);
	//
	// if (Reservations == null || Reservations.isEmpty()) {
	// throw new NoReservationsFoundUnderUserException();
	// }
	//
	// model.addAttribute("Reservations", Reservations);
	// return "Reservations";
	// }
	//
	// @RequestMapping("/Reservation")
	// public String getReservationById(@RequestParam("id") String ReservationId,
	// Model model) {
	// model.addAttribute("Reservation",
	// ReservationService.getReservationById(ReservationId));
	// return "Reservation";
	// }
	//
	// @RequestMapping(value = "/Reservations/add", method = RequestMethod.GET)
	// public String getAddNewReservationForm(Model model) {
	// Reservation newReservation = new Reservation();
	// model.addAttribute("newReservation", newReservation);
	// return "addReservation";
	// }
	//
	// @RequestMapping(value = "/Reservations/add", method = RequestMethod.POST)
	// public String processAddNewReservationForm(@ModelAttribute("newReservation")
	// @Valid Reservation newReservation, BindingResult result, HttpServletRequest
	// request) {
	//
	// if(result.hasErrors()) {
	// return "addReservation";
	// }
	//
	// String[] suppressedFields = result.getSuppressedFields();
	// if (suppressedFields.length > 0) {
	// throw new RuntimeException("Attempting to bind disallowed fields: " +
	// StringUtils.arrayToCommaDelimitedString(suppressedFields));
	// }
	//
	// MultipartFile ReservationImage = newReservation.getReservationImage();
	// String rootDirectory =
	// request.getSession().getServletContext().getRealPath("/");
	//
	// if (ReservationImage!=null && !ReservationImage.isEmpty()) {
	// try {
	// ReservationImage.transferTo(new File(rootDirectory+"resources\\images\\"+
	// newReservation.getReservationId() + ".png"));
	// } catch (Exception e) {
	// throw new RuntimeException("Reservation Image saving failed", e);
	// }
	// }
	//
	//
	// ReservationService.addReservation(newReservation);
	// return "redirect:/market/Reservations";
	// }
	//
	// /* TODO change fields */
	// @InitBinder
	// public void initialiseBinder(WebDataBinder binder) {
	// binder.setValidator(ReservationValidator);
	// binder.setAllowedFields("ReservationId",
	// "name",
	// "unitPrice",
	// "description",
	// "manufacturer",
	// "category",
	// "unitsInStock",
	// "condition",
	// "ReservationImage",
	// "language");
	// }
	//
	// @ExceptionHandler(ReservationNotFoundException.class)
	// public ModelAndView handleError(HttpServletRequest req,
	// ReservationNotFoundException exception) {
	// ModelAndView mav = new ModelAndView();
	// mav.addObject("invalidReservationId", exception.getReservationId());
	// mav.addObject("exception", exception);
	// mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
	// mav.setViewName("ReservationNotFound");
	// return mav;
	// }
	//
	// @RequestMapping("/Reservations/invalidPromoCode")
	// public String invalidPromoCode() {
	// return "invalidPromoCode";
	// }
}
