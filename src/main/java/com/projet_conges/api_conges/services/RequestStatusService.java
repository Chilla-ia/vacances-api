package com.projet_conges.api_conges.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.projet_conges.api_conges.models.RequestStatus;
import com.projet_conges.api_conges.repositories.RequestStatusRepository;

import lombok.Data;

@Data
@Service
@Component
public class RequestStatusService {

    @Autowired
    private RequestStatusRepository requestStatusRepository;

    public Optional<RequestStatus> getRequestStatusById(final Long id) {
        return requestStatusRepository.findById(id);
    }

    public Iterable<RequestStatus> getAllRequestStatus() {
        return requestStatusRepository.findAll();
    }

}

;