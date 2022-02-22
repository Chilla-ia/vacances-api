package com.projet_conges.api_conges.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet_conges.api_conges.models.SoldeConge;


@Repository
public interface SoldeCongeRepository extends CrudRepository<SoldeConge, Long> {

	List<SoldeConge> findByEmployeIdEmploye(final Long id);
}
