package com.authgoogle.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authgoogle.jpa.model.Client;
import com.authgoogle.jpa.model.Statistique;
import com.authgoogle.jpa.model.demande;
import com.authgoogle.jpa.repository.DemandeRepository;
import com.authgoogle.jpa.repository.StatistiqueRepository;

@Service
public class StatistiqueService {

    @Autowired
	private StatistiqueRepository statistiqueRepository;
    
    @Autowired 
    private DemandeRepository demandeRepository;
    
    
public Statistique createStatistique( Statistique stat, List<Long> demandeIds) {
		
	    List<demande> dlist=demandeRepository.findAllById(demandeIds);
	    System.out.println(dlist);
		
		
		
  	stat.setDemandes(dlist);
		
		
		return statistiqueRepository.save(stat);
	}

public List<Statistique> getStatistique(){
	
return 	statistiqueRepository.findAll();
	
}
}
