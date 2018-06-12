package com.proz.hotel_manager.controller;

import javax.validation.Valid;

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
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/menu")
	public String welcome(Model model) {
		return "boss.menu";
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/displayEmployees")
	public String list(Model model) {
		model.addAttribute("employees", employeeRepository.getAllEmployees());
		
		return "boss.displayEmployees";
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/summary")
	public String displaySummary(Model model) {
		model.addAttribute("incomes", reservationService.sumUpIncomes());
		model.addAttribute("outcomes", employeeService.sumUpSalaries());
	
		return "boss.money";
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmloyee(Model model) {
		Employee newEmployee = new Employee();
		model.addAttribute("newEmployee", newEmployee);
		
		return "boss.addEmployee";
	}
	
	/**
	 * @param newEmployee
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmloyee(@ModelAttribute("newEmployee") @Valid Employee newEmployee, BindingResult result) {
		employeeService.addEmployee(newEmployee);
		
		if(result.hasErrors()) {
			return "boss.addEmployee";
		}
		
		return "redirect:/boss/displayEmployees";
	}

	/**
	 * @param model
	 * @param employeeId
	 * @return
	 */
	@RequestMapping(value = "/promoteEmployee/{pesel}", method = RequestMethod.GET)
	public String updateEmloyee(Model model, @PathVariable("pesel") String employeeId) {
		model.addAttribute("actualEmployee", employeeService.getEmployeeByPesel(employeeId));
		
		return "boss.promoteEmployee";
	}
	
	/**
	 * @param employee
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/promoteEmployee/{pesel}", method = RequestMethod.POST)
	public String updateEmloyee(@ModelAttribute("actualEmployee") @Valid Employee employee, BindingResult result) {
		employeeService.updateEmployee(employee);
		
		if(result.hasErrors()) {
			return "boss.promoteEmployee";
		}
		
		return "redirect:/boss/displayEmployees/";
	}
	
	/**
	 * @param binder
	 */
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
	
	}
}
