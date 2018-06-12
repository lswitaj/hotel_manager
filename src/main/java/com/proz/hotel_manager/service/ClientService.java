package com.proz.hotel_manager.service;

import java.util.List;

import com.proz.hotel_manager.domain.Client;

public interface ClientService {
	
	/**
	 * @param client
	 */
	void addClient(Client client);
	
	/**
	 * @return
	 */
	List<Client> getAllClients();
}
