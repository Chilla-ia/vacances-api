package com.projet_conges.api_conges.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet_conges.api_conges.models.LeaveRequest;

@Repository
public interface LeaveRequestRepository extends CrudRepository<LeaveRequest, Long> {

	List<LeaveRequest> findByManagerIdEmploye(final Long id);

	List<LeaveRequest> findByEmployeIdEmploye(final Long id);

	List<LeaveRequest> findByStartDateGreaterThanAndEndDateLessThanOrderByStartDate(Date startDate, Date endDate);

	List<LeaveRequest> findByStartDateGreaterThanOrderByStartDate(Date startDate);
	
	List<LeaveRequest> findByRequestStatusId(final Long id);
	
	List<LeaveRequest> findByTypeCongeId(final Long id);

}
