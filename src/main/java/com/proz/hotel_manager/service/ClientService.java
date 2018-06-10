package com.proz.hotel_manager.service;

import java.util.List;

import com.proz.hotel_manager.domain.Client;

public interface ClientService {
	
	void addClient(Client client);
	
	List<Client> getAllClients();
}
