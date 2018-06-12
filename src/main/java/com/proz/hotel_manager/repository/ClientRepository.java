package com.proz.hotel_manager.repository;

import java.util.List;

import com.proz.hotel_manager.domain.Client;

public interface ClientRepository {
	
	/**
	 * @param clientID
	 * @return
	 */
	Client getClientById(String clientID);

	/**
	 * @param client
	 */
	void addClient(Client client);

	/**
	 * @return
	 */
	List<Client> getAllClients();
}
