package com.proz.hotel_manager.service;

import java.math.BigDecimal;
import java.util.List;

import com.proz.hotel_manager.domain.Employee;

public interface EmployeeService {
	
	/**
	 * @return
	 */
	BigDecimal sumUpSalaries();
	
	/**
	 * @param employee
	 */
	void addEmployee(Employee employee);

	/**
	 * @param employee
	 */
	void updateEmployee(Employee employee);
	
	/**
	 * @param employeeId
	 * @return
	 */
	Employee getEmployeeByPesel(String employeeId);

	/**
	 * @return
	 */
	List<Employee> getAllEmployees();
}
