package com.proz.hotel_manager.repository;

import java.util.List;

import com.proz.hotel_manager.domain.Employee;

public interface EmployeeRepository {

	List<Employee> getAllEmployees();
	
	Employee getEmployeeByPesel(String employeePesel);
	
	void addEmployee(Employee employee);

	void updateEmployee(Employee employee);
}
