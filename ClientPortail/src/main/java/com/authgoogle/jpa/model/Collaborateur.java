/*package com.authgoogle.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Collaborateur")

public class Collaborateur {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotNull
	    @Size(max = 65)
	    @Column(name = "first_name")
	    private String firstName;

	    @Size(max = 65)
	    @Column(name = "last_name")
	    private String lastName;

	    @NotNull
	    @Email
	    @Size(max = 100)
	    @Column(unique = true)
	    private String email;

	    @NotNull
	    @Size(max = 128)
	    private String password;


	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "calendrier_id", referencedColumnName = "id")
	    private Calendrier calendrier;
	    

	    // Hibernate requires a no-arg constructor
	    public Collaborateur() {

	    }

	    public Collaborateur(String firstName, String lastName, String email, String password) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.password = password;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		

		public Collaborateur getCollaborateur() {
			return getCollaborateur();
		}

		public void setCollaborateur(Collaborateur collaborateur) {
			Collaborateur Collaborateur = collaborateur;
		}
	

}
*/