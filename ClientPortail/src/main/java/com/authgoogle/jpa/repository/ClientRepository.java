package com.authgoogle.jpa.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.authgoogle.jpa.model.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
	
	   @Modifying
	   @Transactional
	    @Query("UPDATE Client c SET c.name = :name , c.adresse = :adresse , c.RCC = :RCC WHERE c.id = :clientId")
	    void updateClient(@Param("clientId") Long client_Id,@Param("name") String Name
	    		, @Param("adresse") String adresse,@Param("RCC") String RCC );

	Optional<Client> findByName(String name);
	
}