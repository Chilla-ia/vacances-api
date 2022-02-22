package com.projet_conges.api_conges.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.projet_conges.api_conges.models.LeaveRequest;
import com.projet_conges.api_conges.repositories.LeaveRequestRepository;

import lombok.Data;

@Data
@Service
@Component
public class LeaveRequestService {

	@Autowired
	private LeaveRequestRepository leaveRequestRepo;

	public Optional<LeaveRequest> getLeaveRequestById(final Long id) {
		return leaveRequestRepo.findById(id);
	}

	public Iterable<LeaveRequest> getAllLeaveRequest() {
		return leaveRequestRepo.findAll();
	}

	public List<LeaveRequest> getLeavesRequestByManager(final Long id) {
		return leaveRequestRepo.findByManagerIdEmploye(id);
	}

	public List<LeaveRequest> getLeavesRequestByEmploye(final Long id) {
		return leaveRequestRepo.findByEmployeIdEmploye(id);
	}

	public List<LeaveRequest> getLeavesRequestBetweenStartDateAndEndDate(Date startDate, Date endDate) {
		return leaveRequestRepo.findByStartDateGreaterThanAndEndDateLessThanOrderByStartDate(startDate, endDate);
	}

	public List<LeaveRequest> getLeavesRequestFromStartDate(Date startDate) {
		return leaveRequestRepo.findByStartDateGreaterThanOrderByStartDate(startDate);
	}
	
	public List<LeaveRequest> getLeaveRequestByRequestStatus(final Long id){
		return leaveRequestRepo.findByRequestStatusId(id);
	}
	
	public List<LeaveRequest> getLeaveRequestByTypeConge(final Long id){
		return leaveRequestRepo.findByTypeCongeId(id);
	}
}