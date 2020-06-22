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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "client")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotNull
	  //  @Size(max = 65)
	    @Column(name = "name")
	    private String name;

	   /* @Size(max = 65)
	    @Column(name = "last_name")
	    private String lastName;*/

	    @NotNull
	  //  @Email
	  //  @Size(max = 100)
	    @Column(unique = false)
	    private String email;
	    
	    @Column(name="ADRESSE")
	    @NotNull
		private String adresse;
	    
	    @Column(name="telephone")
	    @NotNull
	    private String telephone;

	    
	    @Column(name="RCC")
		@NotNull
		private String RCC;


	 /*   @NotNull
	    @Size(max = 128)
	    private String password;*/
	    
	 @OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	 @JoinColumn(name="id_demandes")
		 private List<demande> demandes;
        
		 
	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name="id_client")
	    private List<Affectation> affectation;
	    
	    public Client () {
	    	
	    }

	   

		public Client(Long id, @NotNull @Size(max = 65) String name, @NotNull @Email @Size(max = 100) String email,
				@NotNull String adresse, @NotNull String rCC, List<Affectation> affectation,String telephone) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.adresse = adresse;
			RCC = rCC;
			this.affectation = affectation;
			this.telephone=telephone;
		}



		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		/*public void setName(String Name) {
			this.Name = Name;
		}*/

		/*public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}*/

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}



		public String getAdresse() {
			return adresse;
		}



		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}



		public String getRCC() {
			return RCC;
		}



		public void setRCC(String rCC) {
			RCC = rCC;
		}



		public List<Affectation> getAffectation() {
			return affectation;
		}



		public void setAffectation(List<Affectation> affectation) {
			this.affectation = affectation;
		}



		public void setName(String name) {
			this.name = name;
		}
		
		

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
	    
}
