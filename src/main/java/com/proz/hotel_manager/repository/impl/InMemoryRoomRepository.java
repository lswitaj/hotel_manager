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

import com.proz.hotel_manager.domain.Room;
import com.proz.hotel_manager.repository.RoomRepository;

@Repository
public class InMemoryRoomRepository implements RoomRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Room> getAllRooms() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Room> result = jdbcTemplate.query("SELECT * FROM Room", params, new RoomMapper());

		return result;
	}

	@Override
	public Room getRoomById(int roomId) {
		String SQL = "SELECT * FROM Room WHERE roomNumber = :roomId";
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("roomId", roomId);

		return jdbcTemplate.queryForObject(SQL, params, new RoomMapper());
	}

	private static final class RoomMapper implements RowMapper<Room> {
		public Room mapRow(ResultSet rs, int rownum) throws SQLException {
			Room room = new Room();
			room.setRoomNumber(rs.getInt("roomNumber"));
			room.setSize(rs.getInt("size"));
			room.setPrice(rs.getBigDecimal("price"));

			return room;
		}
	}
}
