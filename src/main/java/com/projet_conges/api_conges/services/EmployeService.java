package com.projet_conges.api_conges.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.projet_conges.api_conges.models.Employe;
import com.projet_conges.api_conges.repositories.EmployeRepository;

import lombok.Data;

@Data
@Service
@Component
public class EmployeService {

	@Autowired
	private EmployeRepository employeRepository;

	public Optional<Employe> getEmploye(final Long id) {
		return employeRepository.findById(id);
	}

	public Iterable<Employe> getEmployes() {
		return employeRepository.findAll();
	}

	public List<Employe> getEmployesByIdManager(final Long id) {
		return employeRepository.findByManagerIdEmploye(id);
	}

	public List<Employe> getEmployesBySoldeCongeNumber(int acquiredNb) {
		return employeRepository.findBySoldesAcquiredNbGreaterThanEqualOrderByIdEmploye(acquiredNb);
	}
	
	public List<Employe> getEmployeBySoldeEndOfValidity(String endOfValidity){
		return employeRepository.findBySoldesEndOfValidityBefore(endOfValidity);
	}

	public List<Employe> getEmployeBySoldeAcquiredNbAndEndOfValidity(int acquiredNb, Optional<String> endOfValidity){

		return employeRepository.findBySoldesAcquiredNbGreaterThanEqualAndSoldesEndOfValidityBefore(acquiredNb, endOfValidity);
	}
}
