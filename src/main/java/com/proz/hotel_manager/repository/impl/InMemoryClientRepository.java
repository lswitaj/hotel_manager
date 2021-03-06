package com.proz.hotel_manager.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
//import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proz.hotel_manager.domain.Client;
import com.proz.hotel_manager.repository.ClientRepository;

@Repository
public class InMemoryClientRepository implements ClientRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public Client getClientById(String clientID) {
		String SQL = "SELECT * FROM client WHERE login = :clientId";
		Map<String, Object> params = new HashMap<>();
		params.put("clientId", clientID);
		
		return jdbcTemplate.queryForObject(SQL, params, new ClientMapper());
	}

	@Override
	public void addClient(Client client) {
		String SQL = "INSERT INTO Client "
				+ "VALUES (:login, :password, :name, :surname, :phoneNumber, :email)";

		Map<String, Object> params = new HashMap<>();
		params.put("login", client.getLogin());
		params.put("password", client.getPassword());
		params.put("name", client.getName());
		params.put("surname", client.getSurname());
		params.put("phoneNumber", client.getPhoneNumber());
		params.put("email", client.getEmail());

		jdbcTemplate.update(SQL, params);
	}

	@Override
	public List<Client> getAllClients() {
		String SQL = "SELECT * FROM client";
		
		return jdbcTemplate.query(SQL, new ClientMapper());
	}
	
	private static final class ClientMapper implements RowMapper<Client> {
		public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
			Client client = new Client();
			client.setLogin(rs.getString("login"));
			client.setPassword(rs.getString("password"));
			client.setName(rs.getString("name"));
			client.setSurname(rs.getString("surname"));
			client.setPhoneNumber(rs.getString("phoneNumber"));
			client.setEmail(rs.getString("email"));
			return client;
		}
	}
}
