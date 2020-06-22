package com.authgoogle.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authgoogle.jpa.model.statistique;

@Repository
public interface StatistiqueRepository extends JpaRepository<statistique,Long> {

}
