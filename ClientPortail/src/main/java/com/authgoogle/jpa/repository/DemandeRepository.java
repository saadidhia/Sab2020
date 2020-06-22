package com.authgoogle.jpa.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.authgoogle.jpa.model.demande;

@Repository
public interface DemandeRepository extends JpaRepository<demande,Long> {
	
	  @Modifying
	  @Transactional
	  @Query("UPDATE demande d SET d.priorite = :priorite , d.type_demande = :type_demande  WHERE d.id_demande = :demandeId")
	    void updatedemande(@Param("demandeId") Long demande_id,@Param("priorite") int priorite
	    		, @Param("type_demande") char type_demande );

	Optional<demande> findByPriorite(int priorite);

}
