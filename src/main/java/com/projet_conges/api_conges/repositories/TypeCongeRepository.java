package com.projet_conges.api_conges.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet_conges.api_conges.models.TypeConge;


@Repository
public interface TypeCongeRepository extends CrudRepository<TypeConge, Long	> {

}
