package com.proz.hotel_manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proz.hotel_manager.domain.Room;
import com.proz.hotel_manager.repository.RoomRepository;
import com.proz.hotel_manager.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Override
	public Room getRoomById(int roomId)
	{
		return roomRepository.getRoomById(roomId);
	}
}
