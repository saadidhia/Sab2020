package com.authgoogle.jpa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "indicateur")
public class indicateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_indicateur;
	private String indicateur;
	// @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "client_id", nullable = false)
//	private client client;
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
     @JoinColumn(name = "id_demande", nullable = false)
	 private demande demande;
	private String formule;
	
	
	
	public indicateur () {
		
	}

	public indicateur(long id_indicateur, String indicateur, Client client,
			demande demande, String formule) {
		super();
		this.id_indicateur = id_indicateur;
		this.indicateur = indicateur;
	//	this.client = client;
		this.demande = demande;
		this.formule = formule;
	}

	

	public demande getDemande() {
		return demande;
	}

	public void setDemande(demande demande) {
		this.demande = demande;
	}

	public long getId_indicateur() {
		return id_indicateur;
	}
	public void setId_indicateur(long id_indicateur) {
		this.id_indicateur = id_indicateur;
	}
	public String getIndicateur() {
		return indicateur;
	}
	public void setIndicateur(String indicateur) {
		this.indicateur = indicateur;
	}
	
	
	public String getFormule() {
		return formule;
	}
	public void setFormule(String formule) {
		this.formule = formule;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formule == null) ? 0 : formule.hashCode());
		
		result = prime * result + (int) (id_indicateur ^ (id_indicateur >>> 32));
		result = prime * result + ((indicateur == null) ? 0 : indicateur.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		indicateur other = (indicateur) obj;
		if (formule == null) {
			if (other.formule != null)
				return false;
		} else if (!formule.equals(other.formule))
			return false;
		
		if (id_indicateur != other.id_indicateur)
			return false;
		if (indicateur == null) {
			if (other.indicateur != null)
				return false;
		} else if (!indicateur.equals(other.indicateur))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "indicateur [id_indicateur=" + id_indicateur + ", indicateur=" + indicateur 
				+ ", demande=" + demande + ", formule=" + formule + "]";
	}
	
	
	
	
	
}
