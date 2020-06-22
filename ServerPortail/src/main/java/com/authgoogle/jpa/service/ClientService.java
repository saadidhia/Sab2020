package com.authgoogle.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.authgoogle.jpa.model.Client;
import com.authgoogle.jpa.repository.Client1Repository;
import com.authgoogle.jpa.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired 
	private ClientRepository clientRepository;
	


	public void updateClient(Long client_Id ,String name,String adresse,String RCC ) {
	clientRepository.updateClient(client_Id, name, adresse, RCC);
	
	
	}


public Optional<Client> findClientById(Long id) {
	Optional<Client> client=clientRepository.findById(id);
	return client;
}
	  


	public List<Client> getClients(){
		
	return 	clientRepository.findAll();
		
	}
	
	public Client createClient( Client client) {
		
		return clientRepository.save(client);
	}
	
	public void deleteClient( Long id) {
	
		clientRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	

}
