package com.authgoogle.jpa.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
@Entity
	@Table(name = "Client_profiles")

public class ClientProfile {
	

	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "phone_number")
	    @Size(max = 15)
	    private String phoneNumber;

	    @Enumerated(EnumType.STRING)
	    @Column(length = 10)
	    private GenderClient gender;

	    @Temporal(TemporalType.DATE)
	    @Column(name = "dob")
	    private Date dateOfBirth;

	    @Size(max = 100)
	    private String address1;

	    @Size(max = 100)
	    private String address2;

	    @Size(max = 100)
	    private String street;

	    @Size(max = 100)
	    private String city;

	    @Size(max = 100)
	    private String state;

	    @Size(max = 100)
	    private String country;

	    @Column(name = "zip_code")
	    @Size(max = 32)
	    private String zipCode;

	    

	    public ClientProfile() {

	    }

	    public ClientProfile(String phoneNumber, GenderClient gender, Date dateOfBirth, 
	                       String address1, String address2, String street, String city, 
	                       String state, String country, String zipCode) {
	        this.phoneNumber = phoneNumber;
	        this.gender = gender;
	        this.dateOfBirth = dateOfBirth;
	        this.address1 = address1;
	        this.address2 = address2;
	        this.street = street;
	        this.city = city;
	        this.state = state;
	        this.country = country;
	        this.zipCode = zipCode;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public GenderClient getGender() {
			return gender;
		}

		public void setGender(GenderClient gender) {
			this.gender = gender;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getAddress1() {
			return address1;
		}

		public void setAddress1(String address1) {
			this.address1 = address1;
		}

		public String getAddress2() {
			return address2;
		}

		public void setAddress2(String address2) {
			this.address2 = address2;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}

	

	    
	}

