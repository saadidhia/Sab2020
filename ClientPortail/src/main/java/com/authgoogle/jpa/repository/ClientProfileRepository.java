package com.authgoogle.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authgoogle.jpa.model.ClientProfile;
import com.authgoogle.jpa.model.CollaborateurProfile;

@Repository
public interface ClientProfileRepository extends JpaRepository<ClientProfile, Long> {

}
