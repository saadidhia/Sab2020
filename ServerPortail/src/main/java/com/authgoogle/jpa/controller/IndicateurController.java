package com.authgoogle.jpa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.authgoogle.jpa.model.indicateur;
import com.authgoogle.jpa.service.IndicateurService;

@RestController
@RequestMapping("indicateurs")
public class IndicateurController {
	
	@Autowired 
	private IndicateurService indicateurService;
	
	
	@GetMapping("/all")
	public List<indicateur> indicateursAll(){
		return indicateurService.getIndicateurs();
		
	}
	
	@PostMapping("/add")
	public indicateur postIndicateurs(@RequestBody indicateur indicateur) {
		indicateur=indicateurService.createIndicateur(indicateur);
		return indicateur;
		
	}


}
