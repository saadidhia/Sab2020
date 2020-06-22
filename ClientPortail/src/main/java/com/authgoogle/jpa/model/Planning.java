package com.authgoogle.jpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Planning")
public class Planning {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name="id_planning")
	    private List<Affectation> affectation;
	 
	 @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name="id_planning")
	    private List<Calendrier> calendrier;
	 
	/* @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name="id_planning")
	    private List<Collaborateur> collaborateur;*/
	 
	
	  public Planning () {
	    	
	    }

	public Planning(Long id) {
		super();
		this.id = id;
	}
	
	
	
}
