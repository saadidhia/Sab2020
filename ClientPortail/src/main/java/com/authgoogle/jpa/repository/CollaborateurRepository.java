package com.authgoogle.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authgoogle.jpa.model.Client;
import com.authgoogle.jpa.model.Collaborateur;

@Repository
public interface CollaborateurRepository extends JpaRepository<Client, Long> {

}
