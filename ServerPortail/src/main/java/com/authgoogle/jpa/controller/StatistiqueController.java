package com.authgoogle.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.authgoogle.jpa.model.Client;
import com.authgoogle.jpa.model.Statistique;
import com.authgoogle.jpa.model.demande;
import com.authgoogle.jpa.service.StatistiqueService;

@RestController
@RequestMapping("stat")
public class StatistiqueController{
	
	@Autowired
	private StatistiqueService statistiqueService;
	
	
@GetMapping("/all")
	
	public List<Statistique> statisticsAll(){
		return statistiqueService.getStatistique();
		
	}
	
	@PostMapping("/add")
	public Statistique postStatistique(@RequestBody Statistique stat,@RequestParam List<Long> ids ) {
		stat=statistiqueService.createStatistique(stat ,ids);
		return stat;
		
	}
	
	
}

