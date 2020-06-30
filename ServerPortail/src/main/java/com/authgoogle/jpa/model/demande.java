package com.authgoogle.jpa.model;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "demande")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class demande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_DEMANDE")
     private long id_demande;
	@Column(name="TYPE_DEMANDE")
     private char type_demande;
	@Column(name="PRIORITE")
     private Integer priorite;
     @ManyToOne(fetch = FetchType.LAZY, optional = false)
     @JoinColumn(name = "id_client", nullable = false)
     private Client client;
     @ManyToMany
     private List<Statistique> statistiques;
     
     @OneToMany
     private List<indicateur> indicateurs;
     
     public demande() {
    	 
     }
     
     public demande (long id_demande) {
    	 this.id_demande=id_demande;
     }
     
     

	public Client getClient() {
		return client;
	}



	public void setClient(Client cl) {
		this.client = cl;
	}



	public List<Statistique> getStatistiques() {
		return statistiques;
	}



	public void setStatistiques(List<Statistique> statistiques) {
		this.statistiques = statistiques;
	}



	public List<indicateur> getIndicateurs() {
		return indicateurs;
	}



	public void setIndicateurs(List<indicateur> indicateurs) {
		this.indicateurs = indicateurs;
	}



	public long getId_demande() {
		return id_demande;
	}

	public void setId_demande(long id_demande) {
		this.id_demande = id_demande;
	}

	public char getType_demande() {
		return type_demande;
	}

	public void setType_demande(char type_demande) {
		this.type_demande = type_demande;
	}

	public Integer getPriorite() {
		return priorite;
	}

	public void setPriorite(Integer priorite) {
		this.priorite = priorite;
	}

	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
	
		result = prime * result + (int) (id_demande ^ (id_demande >>> 32));
		result = prime * result + ((priorite == null) ? 0 : priorite.hashCode());
		result = prime * result + type_demande;
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
		demande other = (demande) obj;
		
		if (id_demande != other.id_demande)
			return false;
		if (priorite == null) {
			if (other.priorite != null)
				return false;
		} else if (!priorite.equals(other.priorite))
			return false;
		if (type_demande != other.type_demande)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "demande [id_demande=" + id_demande + ", type_demande=" + type_demande + ", priorite=" + priorite
				+ ", id_client="  + "]";
	}
     
     
}
