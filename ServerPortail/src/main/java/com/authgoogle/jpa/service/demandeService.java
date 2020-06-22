package com.authgoogle.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authgoogle.jpa.model.Client;
import com.authgoogle.jpa.model.demande;
import com.authgoogle.jpa.repository.ClientRepository;
import com.authgoogle.jpa.repository.DemandeRepository;

@Service
public class demandeService {
	
	@Autowired 
	private DemandeRepository demandeRepository;
    
	@Autowired 
	private ClientRepository clientRepository;
	
	
	public void updateDemande(Long demande_Id ,int priorite, char type_demande  ) {
	demandeRepository.updatedemande(demande_Id, priorite, type_demande);
		
	}


public Optional<demande> findClientById(Long id) {
	Optional<demande> demande= demandeRepository.findById(id);
	return demande;
}
	  


	public List<demande> getDemandes(){
		
	return 	demandeRepository.findAll();
		
	}
	
	public demande createDemande( demande demande, long clientId) {
		
		Client cl=clientRepository.getOne(clientId);
		cl.getEmail();
		demande.setClient(cl);
		
		
		return demandeRepository.save(demande);
	}
	
	public void deleteClient( Long id) {
	
		demandeRepository.deleteById(id);
	}
}
