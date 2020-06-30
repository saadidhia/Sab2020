package com.authgoogle.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.authgoogle.model.User;

@Repository
public interface CollaborateurRepository extends JpaRepository<User, Long> {

}
