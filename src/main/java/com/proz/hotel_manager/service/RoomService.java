package com.proz.hotel_manager.service;

import com.proz.hotel_manager.domain.Room;

public interface RoomService {
	
	/**
	 * @param roomId
	 * @return
	 */
	Room getRoomById(int roomId);
}
