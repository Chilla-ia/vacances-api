package com.projet_conges.api_conges.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.projet_conges.api_conges.models.SoldeConge;
import com.projet_conges.api_conges.repositories.SoldeCongeRepository;

import lombok.Data;

@Data
@Service
@Component
public class SoldeCongeService {

    @Autowired
    private SoldeCongeRepository soldeCongeRepository;


    public Optional<SoldeConge> getSoldeCongeById(final Long id) {
        return soldeCongeRepository.findById(id);
    }

    public Iterable<SoldeConge> getAllSoldeConges() {
        return soldeCongeRepository.findAll(); 
    }
    
    public List<SoldeConge> getSoldeCongeByEmploye(final Long id){
    	return soldeCongeRepository.findByEmployeIdEmploye(id);
    }

}
