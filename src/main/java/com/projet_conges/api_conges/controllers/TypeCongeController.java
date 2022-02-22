package com.projet_conges.api_conges.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet_conges.api_conges.models.TypeConge;
import com.projet_conges.api_conges.services.TypeCongeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "onlinestore", description = "Operations permettant de récupérer les types de congés")
@RequestMapping("/type-conge")
public class TypeCongeController {

	@Autowired
	private TypeCongeService typeCongeService;

	@ApiOperation(value = "Récupère la liste de tous les types de congés")
	@GetMapping("/")
	public Iterable<TypeConge> getAllTypeConges() {
		return typeCongeService.getAllTypeConges();
	}

	@ApiOperation(value = "Récupère un type de congé via son id")
	@GetMapping("/{id}")
	public Optional<TypeConge> getTypeCongeById(
			@ApiParam("Identifiant du type de congés - Ne peut être vide ") @PathVariable Long id) {
		return typeCongeService.getTypeCongeById(id);
	}
}
