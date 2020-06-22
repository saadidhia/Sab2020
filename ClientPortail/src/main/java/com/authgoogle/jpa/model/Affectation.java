package com.authgoogle.jpa.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name ="Affectation")

public class Affectation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 65)
    @Column(name = "nature")
    private String nature;

    @Size(max = 65)
    @Column(name = "type")
    private String type;

   
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name="id_affectation")
    private List<Client> client;
    
    public Affectation () {
    	
    }

    public Affectation(String nature, String type) {
        this.nature = nature;
        this.type = type;
       
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	/* 
	* Excuse me, wtf? 
	*
	public Affectation getAffectation() {
		return getAffectation();
	}

	public void setAffectation(Affectation affectation) {
		this.affectation = affectation;
	}
	*
	*/
}
