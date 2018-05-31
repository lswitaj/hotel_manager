package com.proz.hotel_manager.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.proz.hotel_manager.domain.Employee;
import com.proz.hotel_manager.repository.EmployeeRepository;

public class InMemoryEmployeeRepository implements EmployeeRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	// @Autowired
	// private Employee employee;

	@Override
	public List<Employee> getAllEmployees() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Employee> result = jdbcTemplate.query("SELECT * FROM employee", params, new EmployeeMapper());

		return result;
	}

	@Override
	public Employee getEmployeeByPesel(String employeePesel) {
		String SQL = "SELECT * FROM employee WHERE pesel = :employeePesel";
		Map<String, Object> params = new HashMap<>();
		params.put("pesel", employeePesel);

		// try {
		return jdbcTemplate.queryForObject(SQL, params, new EmployeeMapper());
		// } catch (DataAccessException e) {
		// throw new ClientNotFoundException(clientID);
		// }
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
