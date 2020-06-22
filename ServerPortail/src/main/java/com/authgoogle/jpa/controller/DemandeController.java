package com.authgoogle.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.authgoogle.jpa.service.demandeService;

import com.authgoogle.jpa.model.demande;


@RestController
@RequestMapping("demandes")
public class DemandeController {
	
	
	@Autowired
	private demandeService demandeService;
	
	@GetMapping("/all")
	
	public List<demande> clientsAll(){
		return demandeService.getDemandes();
		
	}
	
	@PutMapping("/update/{id}")
	public void updateDemande(@PathVariable Long id
			,@Param("priorite") int  priorite,@Param("type_demande") char type_demande){
		demandeService.updateDemande(id, priorite, type_demande);
		
		//return new ResponseEntity<todo>(todo,HttpStatus.OK);
		
	}

	
	@PostMapping("/add")
	public demande postDemandes(@RequestBody demande demande,@RequestParam Long id) {
		demande=demandeService.createDemande(demande,id);
		return demande;
		
	}

}
