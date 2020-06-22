package com.authgoogle.jpa.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "statistique")
public class statistique {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_state;
	@Column(name="TYPE_STAT")
	private String type_Stat;
	@Column(name="PERIODE")
	private Integer periode;
	
	@ManyToMany
	private List<demande> demandes;
	
	public statistique () {
		
	}





	public statistique(long id_state, String type_Stat, Integer periode, List<demande> demandes) {
		super();
		this.id_state = id_state;
		this.type_Stat = type_Stat;
		this.periode = periode;
		this.demandes = demandes;
	}





	public long getId_state() {
		return id_state;
	}





	public void setId_state(long id_state) {
		this.id_state = id_state;
	}





	public List<demande> getDemandes() {
		return demandes;
	}





	public void setDemandes(List<demande> demandes) {
		this.demandes = demandes;
	}





	public String getType_Stat() {
		return type_Stat;
	}

	public void setType_Stat(String type_Stat) {
		this.type_Stat = type_Stat;
	}

	public Integer getPeriode() {
		return periode;
	}

	public void setPeriode(Integer periode) {
		this.periode = periode;
	}

	@Override
	public String toString() {
		return "statistique [type_Stat=" + type_Stat + ", periode=" + periode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((periode == null) ? 0 : periode.hashCode());
		result = prime * result + ((type_Stat == null) ? 0 : type_Stat.hashCode());
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
		statistique other = (statistique) obj;
		if (periode == null) {
			if (other.periode != null)
				return false;
		} else if (!periode.equals(other.periode))
			return false;
		if (type_Stat == null) {
			if (other.type_Stat != null)
				return false;
		} else if (!type_Stat.equals(other.type_Stat))
			return false;
		return true;
	}
	
	
	

}

