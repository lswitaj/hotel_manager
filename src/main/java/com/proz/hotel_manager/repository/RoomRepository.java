package com.proz.hotel_manager.repository;

import java.util.List;

import com.proz.hotel_manager.domain.Room;

public interface RoomRepository {

	List<Room> getAllRooms();
	
	Room getRoomById(int roomId);
}