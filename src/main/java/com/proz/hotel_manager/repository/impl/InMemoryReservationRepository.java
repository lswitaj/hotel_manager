package com.proz.hotel_manager.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.proz.hotel_manager.domain.Reservation;
import com.proz.hotel_manager.repository.ReservationRepository;

public class InMemoryReservationRepository implements ReservationRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public Reservation getReservationById(int reservationId) {
		String SQL = "SELECT * FROM reservation WHERE reservationId = :reservationId";
		Map<String, Object> params = new HashMap<>();
		params.put("reservationId", reservationId);

		// try {
		return jdbcTemplate.queryForObject(SQL, params, new ReservationMapper());
		// } catch (DataAccessException e) {
		// throw new ClientNotFoundException(clientID);
		// }
	}

	public List<Reservation> getAllClientsReservations() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Reservation> result = jdbcTemplate.query(
				"SELECT * FROM reservation WHERE status IN ('before', 'after', 'during')", params,
				new ReservationMapper());

		return result;
	}


	@Override
	public List<Reservation> getReservationByUserId(String userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Reservation> result = jdbcTemplate.query(
				"SELECT * FROM reservation WHERE Client_login = userId", params,
				new ReservationMapper());

		return result;		
	}

	
	@Override
	public long addReservation(Reservation reservation) {
		String SQL = "INSERT INTO reservation(status, cost, firstDay, lastDay, board, Client_login, Room_roomId) "
				+ "VALUES (:status, :cost, :firstDay, :lastDay, :board, :Client_login, :Room_roomId)";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", reservation.getStatus());
		params.put("cost", reservation.getCost());
		params.put("firstDay", reservation.getFirstDay());
		params.put("lastDay", reservation.getLastDay());
		params.put("board", reservation.isBoard());
		params.put("Client_login", reservation.getClientLogin());
		params.put("Room_roomId", reservation.getRoomId());
		
		SqlParameterSource paramSource = new MapSqlParameterSource(params);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(SQL, paramSource, keyHolder, new String[] { "ID" });

		return keyHolder.getKey().longValue();
	}

	private static final class ReservationMapper implements RowMapper<Reservation> {
		public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
			Reservation reservation = new Reservation();
			reservation.setReservationId(rs.getBigDecimal("reservationId").toBigInteger());
			reservation.setStatus(rs.getString("status"));
			reservation.setCost(rs.getBigDecimal("cost").toBigInteger());
			reservation.setFirstDay(rs.getDate("firstDay"));
			reservation.setFirstDay(rs.getDate("lastDay"));
			reservation.setBoard(rs.getBoolean("board"));
			reservation.setClientLogin(rs.getString("Client_login"));
			reservation.setRoomId(rs.getString("Room_roomId"));
			return reservation;
		}
	}
}
