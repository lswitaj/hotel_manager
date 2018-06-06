package com.proz.hotel_manager.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proz.hotel_manager.domain.Employee;
import com.proz.hotel_manager.repository.EmployeeRepository;
import com.proz.hotel_manager.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public BigDecimal sumUpSalaries() {
		BigDecimal sumOfSalaries = BigDecimal.valueOf(0);
		List<Employee> allEmployees = employeeRepository.getAllEmployees();
		
		for(Employee employee : allEmployees) {
			sumOfSalaries = sumOfSalaries.add(employee.getSalary());
		}
		
		return sumOfSalaries;
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.addEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.updateEmployee(employee);
	}
	
	
}
