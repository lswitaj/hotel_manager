package com.proz.hotel_manager.repository;

import java.util.List;

import com.proz.hotel_manager.domain.Client;

public interface ClientRepository {
	
	Client getClientById(String clientID);

	void addClient(Client client);

	List<Client> getAllClients();
}
