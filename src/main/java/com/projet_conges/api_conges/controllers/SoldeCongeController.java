package com.projet_conges.api_conges.controllers;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.projet_conges.api_conges.models.SoldeConge;
import com.projet_conges.api_conges.services.SoldeCongeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@Api(value = "onlinestore", description = "Operations permettant de récupérer les soldes de congés")
@RequestMapping("/solde-conge")
public class SoldeCongeController {
	
	@Autowired
	private SoldeCongeService soldeCongeService;
	
	@ApiOperation(value = "Récupère la liste de tous les soldes de congés")
	@GetMapping("/")
	public Iterable<SoldeConge> getAllSoldeConges(){
		return soldeCongeService.getAllSoldeConges();
	}
	
	@ApiOperation(value="Récupère un solde de congés via son id")
	@GetMapping("/{id}")
	public Optional<SoldeConge> getSoldeCongeById(
			@ApiParam("Identifiant du solde congé - Ne peut être vide ")
			@PathVariable Long id){
		return soldeCongeService.getSoldeCongeById(id);
	}
	
	
	
	//Récupérer les soldes de congés d'un employé => GetAllByIdEmploye
	@ApiOperation(value = "Récupérer les soldes de congés d'un employé")
	@GetMapping("/employe/{id}")
	public List<SoldeConge> getSoldeCongeByEmployeId(
		@ApiParam("Identifiant de l'employé - Ne peut être vide ")
		@PathVariable Long id){
		return soldeCongeService.getSoldeCongeByEmploye(id);
	}

}
