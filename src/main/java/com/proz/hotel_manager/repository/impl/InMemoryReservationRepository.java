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

import com.proz.hotel_manager.domain.Reservation;
import com.proz.hotel_manager.repository.ReservationRepository;

@Repository
public class InMemoryReservationRepository implements ReservationRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Reservation> getAllReservations() {
		Map<String, Object> params = new HashMap<String, Object>();
		
		List<Reservation> result = jdbcTemplate.query("SELECT * FROM Reservation",
				params, new ReservationMapper());
		
		return result;
	}
	
	@Override
	public List<Reservation> getReservationsUnderClient(String login) {
		String SQL = "SELECT * FROM Reservation WHERE Client_login = :login";
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("login", login);
		
		return jdbcTemplate.query(SQL, params, new ReservationMapper());
	}
	
	private static final class ReservationMapper implements RowMapper<Reservation> {
		public Reservation mapRow(ResultSet rs, int rownum) throws SQLException {
			Reservation reservation = new Reservation();
			reservation.setReservationId(rs.getInt("reservationId"));
			reservation.setStatus(rs.getString("status"));
			reservation.setCost(rs.getInt("cost"));
			
			java.util.Date firstDay = new java.util.Date(rs.getDate("firstDay").getTime());
			java.util.Date lastDay = new java.util.Date(rs.getDate("lastDay").getTime());
			reservation.setFirstDay(firstDay);
			reservation.setLastDay(lastDay);
			
			reservation.setBoard(rs.getBoolean("board"));
			reservation.setClientLogin(rs.getString("Client_login"));
			reservation.setRoomId(rs.getInt("Room_roomNumber"));
			
			return reservation;
		}
	}
}
