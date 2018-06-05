package com.proz.hotel_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proz.hotel_manager.repository.EmployeeRepository;
import com.proz.hotel_manager.service.EmployeeService;
import com.proz.hotel_manager.service.ReservationService;

@Controller
@RequestMapping("/boss")
public class BossController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/employeeAll")
	public String list(Model model) {
		//model.addAttribute("Reservations", ReservationService.getAllClientsReservations());
		model.addAttribute("employees", employeeRepository.getAllEmployees());
		
		return "employees";
	}
	
	@RequestMapping("/employeeMonth")
	public String listUnderPesel(Model model) {
		//model.addAttribute("Reservations", ReservationService.getAllClientsReservations());
		model.addAttribute("employeeOfTheMonth", employeeRepository.getEmployeeByPesel("655212375"));
		
		return "employeeOfTheMonth";
	}
	
	@RequestMapping("/summary")
	public String displaySummary(Model model) {
		model.addAttribute("incomes", reservationService.sumUpIncomes());
		model.addAttribute("outcomes", employeeService.sumUpSalaries());
	
		return "money";
	}
	
//	@RequestMapping("/boss/addEmployee")
//	public String addEmloyee(Model model) {
//		//model.addAttribute("Reservations", ReservationService.getAllClientsReservations());
//		model.addAttribute("employees", employeeRepository.getAllEmployees());
//		
//		return "employees";
//	}

//	@RequestMapping("/boss/update")
//	public String updateEmloyee(Model model) {
//		//model.addAttribute("Reservations", ReservationService.getAllClientsReservations());
//		model.addAttribute("employees", employeeRepository.getAllEmployees());
//		
//		return "employees";
//	}
}
