package com.authgoogle.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authgoogle.jpa.model.Client;
import com.authgoogle.jpa.model.indicateur;
import com.authgoogle.jpa.repository.IndicateurRepository;

@Service 
public class IndicateurService {
	

	@Autowired 
	private IndicateurRepository indicateurRepository;
	
	
public indicateur createIndicateur( indicateur indic) {
		
		return indicateurRepository.save(indic);
	}


public List<indicateur> getIndicateurs(){
	
return 	indicateurRepository.findAll();
	
}

}
