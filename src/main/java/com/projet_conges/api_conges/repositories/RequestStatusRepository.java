package com.projet_conges.api_conges.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet_conges.api_conges.models.RequestStatus;

@Repository
public interface RequestStatusRepository extends CrudRepository<RequestStatus, Long> {

}
