package com.proz.hotel_manager.repository;

import java.util.List;

import com.proz.hotel_manager.domain.Room;

public interface RoomRepository {

	/**
	 * @return
	 */
	List<Room> getAllRooms();
	
	/**
	 * @param roomId
	 * @return
	 */
	Room getRoomById(int roomId);
}