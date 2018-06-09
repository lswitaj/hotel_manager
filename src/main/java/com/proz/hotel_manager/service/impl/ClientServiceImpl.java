package com.proz.hotel_manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proz.hotel_manager.domain.Client;
import com.proz.hotel_manager.repository.ClientRepository;
import com.proz.hotel_manager.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void addClient(Client client) {
		clientRepository.addClient(client);
	}
}
