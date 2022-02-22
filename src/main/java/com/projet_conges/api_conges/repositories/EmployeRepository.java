package com.projet_conges.api_conges.repositories;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet_conges.api_conges.models.Employe;

@Repository
public interface EmployeRepository extends CrudRepository<Employe, Long> {

	List<Employe> findByManagerIdEmploye(final Long id);

	// SOLDE CONGES
	List<Employe> findBySoldesAcquiredNbGreaterThanEqualOrderByIdEmploye(int acquiredNb);
	
	List<Employe> findBySoldesEndOfValidityBefore(String endOfValidity);

	List<Employe> findBySoldesAcquiredNbGreaterThanEqualAndSoldesEndOfValidityBefore(int acquiredNb, Optional<String> endOfValidity);
}


//Récupérer une liste d'employé dont le solde de congés est sup à
//5 jours && qui expire dans moins de 2 mois =>
//GetEmployeByAcquiredNbAndEndOfValidity