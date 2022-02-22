package com.projet_conges.api_conges.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.projet_conges.api_conges.models.LeaveRequest;
import com.projet_conges.api_conges.services.LeaveRequestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "onlinestore", description = "Operations permettant de récupérer les demandes de congés")
@RequestMapping("/leave-request")
public class LeaveRequestController {

	@Autowired
	private LeaveRequestService leaveRequestService;

	@ApiOperation(value = "Récupère la liste de toutes les demandes de congés")
	@GetMapping("/")
	public Iterable<LeaveRequest> getAllLeaveRequest() {
		return leaveRequestService.getAllLeaveRequest();
	}

	@ApiOperation(value = "Récupère une demande de congés via son id")
	@GetMapping("/{id}")
	public Optional<LeaveRequest> getLeaveRequestById(
			@ApiParam("Identifiant de la demande de congés - Ne peut être vide ") @PathVariable Long id) {
		return leaveRequestService.getLeaveRequestById(id);
	}

	@ApiOperation(value = "Récupère la liste de demande de congés des employés par l'id de leur manager")
	@GetMapping("/manager/{id}")
	public List<LeaveRequest> getLeavesRequestByManagerId(
			@ApiParam("Identifiant du manager - Ne peut être vide ") @PathVariable Long id) {
		return leaveRequestService.getLeavesRequestByManager(id);
	}

	@ApiOperation(value = "Récupére une liste de demande de congés par l'id d'un employé")
	@GetMapping("/employee/{id}")
	public List<LeaveRequest> getLeavesRequestByEmployeId(
			@ApiParam("Identifiant de l'employé - Ne peut être vide ") @PathVariable Long id) {
		return leaveRequestService.getLeavesRequestByEmploye(id);
	}

	@ApiOperation(value = "Récupére une liste de demande de congés entre une date de départ et une date de fin")
	@GetMapping("/start-date/{startDate}/end-date/{endDate}")
	public List<LeaveRequest> getLeavesRequestBetweenStartDateAndEndDate(
			@ApiParam("Date de début - Ne peut être vide ") @PathVariable Date startDate,
			@ApiParam("Date de fin - Ne peut être vide ") @PathVariable Date endDate) {
		return leaveRequestService.getLeavesRequestBetweenStartDateAndEndDate(startDate, endDate);
	}

	@ApiOperation(value = "Récupére une liste de demande de congés à partir d'une certaine date")
	@GetMapping("/start-date/{startDate}")
	public List<LeaveRequest> getLeavesRequestFromStartDate(
			@ApiParam("Date de début - Ne peut être vide ") @PathVariable Date startDate) {
		return leaveRequestService.getLeavesRequestFromStartDate(startDate);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		// convert the date Note that the conversion here should always be in the same
		// format as the string passed in, e.g. 2015-9-9 should be yyyy-MM-dd
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor is a custom
	}
	
	//Récupérer une liste de demande de congés en fonction du statut de la demande => GetAllByRequestStatus
	@ApiOperation(value = "Récupère une liste de demande de congés en fonction du statut de la demande")
	@GetMapping("/request-status/{id}")
	public List<LeaveRequest> getLeaveRequestByResquestStatus(
			@ApiParam("Identifiant du statut de la demande - Ne peut être vide ")
			@PathVariable Long id){
		return leaveRequestService.getLeaveRequestByRequestStatus(id);
	}
	
	@ApiOperation(value = "Récupère une liste de demande de congés en fonction du type de congés")
	@GetMapping("/type-conge/{id}")
	public List<LeaveRequest> getLeaveRequestByTypeConge(
			@ApiParam("Identifiant du statut de la demande - Ne peut être vide")
			@PathVariable Long id){
		return leaveRequestService.getLeaveRequestByTypeConge(id);
	}
	
}
