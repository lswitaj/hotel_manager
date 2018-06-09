package com.proz.hotel_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proz.hotel_manager.domain.Employee;
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
	
	@RequestMapping("/menu")
	public String welcome(Model model) {
		return "boss.menu";
	}
	
	@RequestMapping("/displayEmployees")
	public String list(Model model) {
		model.addAttribute("employees", employeeRepository.getAllEmployees());
		
		return "boss.displayEmployees";
	}

	@RequestMapping("/summary")
	public String displaySummary(Model model) {
		model.addAttribute("incomes", reservationService.sumUpIncomes());
		model.addAttribute("outcomes", employeeService.sumUpSalaries());
	
		return "boss.money";
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmloyee(Model model) {
		Employee newEmployee = new Employee();
		model.addAttribute("newEmployee", newEmployee);
		
		return "boss.addEmployee";
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmloyee(@ModelAttribute("newEmployee") Employee newEmployee) {
		employeeService.addEmployee(newEmployee);
		
		return "redirect:/boss/displayEmployees";
	}

	@RequestMapping(value = "/promoteEmployee/{pesel}", method = RequestMethod.GET)
	public String updateEmloyee(Model model, @PathVariable("pesel") String employeeId) {
		model.addAttribute("actualEmployee", employeeService.getEmployeeByPesel(employeeId));
		
		return "boss.promoteEmployee";
	}
	
	@RequestMapping(value = "/promoteEmployee/{pesel}", method = RequestMethod.POST)
	public String updateEmloyee(@ModelAttribute("actualEmployee") Employee employee) {
		employeeService.updateEmployee(employee);
		
		return "redirect:/boss/displayEmployees/";
	}
}
