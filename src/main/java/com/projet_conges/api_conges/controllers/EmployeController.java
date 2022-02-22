package com.projet_conges.api_conges.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projet_conges.api_conges.models.Employe;
import com.projet_conges.api_conges.services.EmployeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "onlinestore", description = "Operations permettant de récupérer des informations sur les employés et leurs congés")
@RequestMapping("/employee")
public class EmployeController {

	@Autowired
	private EmployeService employeService;

	@ApiOperation(value = "Récupère une liste d'employé")
	@GetMapping("/")
	public Iterable<Employe> getAllEmployes() {
		return employeService.getEmployes();
	}

	@ApiOperation(value = "Récupère un employé via son id")
	@GetMapping("/{id}")
	public Optional<Employe> getEmployeById(
			@ApiParam("Identifiant de l'employé - Ne peut être vide ") @PathVariable Long id) {
		return employeService.getEmploye(id);
	}

	@ApiOperation(value = "Récupère la liste des employés d'un manager")
	@GetMapping("/manager/{id}")
	public List<Employe> getEmployesByIdManager(
			@ApiParam("Identifiant du manager - Ne peut être vide ") @PathVariable Long id) {
		return employeService.getEmployesByIdManager(id);
	}

	// SOLDE CONGE
	@JsonIgnore
	@ApiOperation(value = "Récupère la liste des employés en fonction d'une nombre de solde de congés")
	@GetMapping("/solde-conges/{acquiredNb}")
	public List<Employe> getEmployesBySoldeCongeNumber(
			@ApiParam("Nombre de solde de congés supérieur ou égal à - Ne peut être vide ") @PathVariable int acquiredNb) {
		return employeService.getEmployesBySoldeCongeNumber(acquiredNb);
	}
//	@JsonIgnore
	@ApiOperation(value = "Récupère la liste des employés en fonction de la date d'expiration de leur solde")
	@GetMapping("/solde-conge/{endOfValidity}")
	public List<Employe> getEmployeBySoldeEndOfValidity(
			@ApiParam("Date de fin de validité des congés - Ne peut être vide ") @PathVariable String endOfValidity){
		return employeService.getEmployeBySoldeEndOfValidity(endOfValidity);
	}
	
	@ApiOperation(value = "Récupère la liste des employés en fonction du nombre de soldes restant dans 2 mois")
	@GetMapping("/solde-conges/{acquiredNb}/{endOfValidity}")
	public List<Employe> getEmployeBySoldegetEmployeBySoldeAcquiredNbAndEndOfValidity(
			@ApiParam("Nombre de solde de congés supérieur ou égal à - Ne peut être vide") @PathVariable ("acquiredNb") int acquiredNb, Optional<String> endOfValidity){
		LocalDate futureDate = LocalDate.now().plusMonths(2);
		endOfValidity = Optional.of(futureDate.toString());
		System.out.println(acquiredNb +" "+ endOfValidity);
		return employeService.getEmployeBySoldeAcquiredNbAndEndOfValidity(acquiredNb, endOfValidity);
	}
	

}
