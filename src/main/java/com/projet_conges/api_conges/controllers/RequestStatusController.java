package com.projet_conges.api_conges.controllers;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet_conges.api_conges.models.RequestStatus;
import com.projet_conges.api_conges.services.RequestStatusService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "onlinestore", description = "Operations permettant de récupérer les statuts des demandes de congés")
@RequestMapping("/request-status")
public class RequestStatusController {
	
	@Autowired
	private RequestStatusService requestStatusService;
	
	
	@ApiOperation(value = "Récupère tous les statuts des congés")
	@GetMapping("/")
	public Iterable<RequestStatus> getAllRequestStatus(){
		return requestStatusService.getAllRequestStatus();
	}

	@ApiOperation(value="Récupère un statut via son id")
	@GetMapping("/{id}")
	public Optional<RequestStatus> getRequestStatusById(
			@ApiParam("Identifiant du statut de la demande - Ne peut être vide ")
			@PathVariable Long id){
		return requestStatusService.getRequestStatusById(id);
	}

}