package com.proz.hotel_manager.service;

import java.math.BigDecimal;

import com.proz.hotel_manager.domain.Employee;

public interface EmployeeService {
	
	BigDecimal sumUpSalaries();
	
	void addEmployee(Employee employee);

	void updateEmployee(Employee employee);
}
