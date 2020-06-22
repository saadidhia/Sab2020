package com.authgoogle.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authgoogle.jpa.model.Client;
import com.authgoogle.jpa.service.ClientService;


@RestController
@RequestMapping("clients")
public class ClientController {
	
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/all")
	
	public List<Client> clientsAll(){
		return clientService.getClients();
		
	}
	
	@PutMapping("/update/{id}")
	public void updateClient(@PathVariable Long id
			,@Param("name") String  name,@Param("adresse") String adresse,@Param("RCC")String RCC){
		 clientService.updateClient(id, name, adresse, RCC);
		
		//return new ResponseEntity<todo>(todo,HttpStatus.OK);
		
	}

	
	@PostMapping("/add")
	public Client postClients(@RequestBody Client client) {
		client=clientService.createClient(client);
		return client;
		
	}

}
