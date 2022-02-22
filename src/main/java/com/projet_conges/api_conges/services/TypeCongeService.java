package com.projet_conges.api_conges.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.projet_conges.api_conges.models.TypeConge;
import com.projet_conges.api_conges.repositories.TypeCongeRepository;

import lombok.Data;

@Data
@Service
@Component
public class TypeCongeService {

	@Autowired
	private TypeCongeRepository typeCongeRepo;

	public Optional<TypeConge> getTypeCongeById(final Long id) {
		return typeCongeRepo.findById(id);
	}

	public Iterable<TypeConge> getAllTypeConges() {
		return typeCongeRepo.findAll();
	}
}
