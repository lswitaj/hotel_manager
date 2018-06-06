package com.proz.hotel_manager.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proz.hotel_manager.domain.Employee;
import com.proz.hotel_manager.repository.EmployeeRepository;

@Repository
public class InMemoryEmployeeRepository implements EmployeeRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getAllEmployees() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Employee> result = jdbcTemplate.query("SELECT * FROM employee", params, new EmployeeMapper());

		return result;
	}

	/*unused, debuggers tool*/
	@Override
	public Employee getEmployeeByPesel(String employeePesel) {
		String SQL = "SELECT * FROM employee WHERE pesel = :pesel";//:employeePesel";
		Map<String, Object> params = new HashMap<>();
		params.put("pesel", employeePesel);

		// try {
		return jdbcTemplate.queryForObject(SQL, params, new EmployeeMapper());
		// } catch (DataAccessException e) {
		// throw new ClientNotFoundException(clientID);
		// }
	}

	@Override
	public void addEmployee(Employee newEmployee) {
		String SQL = "INSERT INTO Employee VALUES(:pesel, :password, :name, :surname, :position, :phoneNumber, :email, :salary)";
		
		Map<String, Object> params = new HashMap<>();
		params.put("pesel", newEmployee.getPesel());
		params.put("password", newEmployee.getPassword());
		params.put("name", newEmployee.getName());
		params.put("surname", newEmployee.getSurname());
		params.put("position", newEmployee.getPosition());
		params.put("phoneNumber", newEmployee.getPhoneNumber());
		params.put("email", newEmployee.getEmail());
		params.put("salary", newEmployee.getSalary());
		
		jdbcTemplate.update(SQL, params);
	}
	
	@Override
	public void updateEmployee(Employee employee) {
		String SQL = "UPDATE Employee "
				+ "SET position = :newPosition, salary = :newSalary "
				+ "WHERE PESEL = :pesel";
		
		Map<String, Object> params = new HashMap<>();
		params.put("pesel", employee.getPesel());
		params.put("newPosition", employee.getPosition());
		params.put("newSalary", employee.getSalary());
		
		jdbcTemplate.update(SQL, params);	
	}
	
	private static final class EmployeeMapper implements RowMapper<Employee> {
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setPesel(rs.getString("pesel"));
			employee.setPassword(rs.getString("password"));
			employee.setName(rs.getString("name"));
			employee.setSurname(rs.getString("surname"));
			employee.setPosition(rs.getString("position"));
			employee.setPhoneNumber(rs.getString("phoneNumber"));
			employee.setEmail(rs.getString("email"));
			employee.setSalary(rs.getBigDecimal("salary"));
			return employee;
		}
	}
}
