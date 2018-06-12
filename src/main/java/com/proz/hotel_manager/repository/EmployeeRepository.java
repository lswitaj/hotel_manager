package com.proz.hotel_manager.repository;

import java.util.List;

import com.proz.hotel_manager.domain.Employee;

public interface EmployeeRepository {

	/**
	 * @return
	 */
	List<Employee> getAllEmployees();
	
	/**
	 * @param employeePesel
	 * @return
	 */
	Employee getEmployeeByPesel(String employeePesel);
	
	/**
	 * @param employee
	 */
	void addEmployee(Employee employee);

	/**
	 * @param employee
	 */
	void updateEmployee(Employee employee);
}
