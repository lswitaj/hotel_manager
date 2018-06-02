package com.proz.hotel_manager.repository;

import com.proz.hotel_manager.domain.Client;

public interface ClientRepository {
	
	Client getClientById(String clientID);
}
