package  com.authgoogle.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authgoogle.jpa.model.indicateur;
@Repository
public interface IndicateurRepository extends JpaRepository<indicateur,Long>{
	

}
