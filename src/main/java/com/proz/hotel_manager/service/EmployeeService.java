package com.proz.hotel_manager.service;

import java.math.BigDecimal;
import java.util.List;

import com.proz.hotel_manager.domain.Employee;

public interface EmployeeService {
	
	BigDecimal sumUpSalaries();
	
	void addEmployee(Employee employee);

	void updateEmployee(Employee employee);
	
	Employee getEmployeeByPesel(String employeeId);

	List<Employee> getAllEmployees();
}
