package com.projet_conges.api_conges.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "demande_conges")
@ApiModel(description = "Classe qui représente les demandes de congés")
public class LeaveRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Id dde la demannde de congés", example = "3", required = true, position = 0)
	@Column(name = "id_demande")
	private Long idRequest;

	@ApiModelProperty(notes = "Date de la demande de congés", example = "2021-11-08 16:43:52", position = 1)
	@Column(name = "date_demande")
	private Date requestDate;

	@ApiModelProperty(notes = "Date de début du congés", example = "2021-12-19", position = 2)
	@Column(name = "date_debut")
	private Date startDate;

	@ApiModelProperty(notes = "Date de la fin du congés", example = "2021-12-19", position = 3)
	@Column(name = "date_fin")
	private Date endDate;

	@ApiModelProperty(notes = "Prise de congés seulement l'après-midi", example = "1 = true, 0 = false", position = 4)
	@Column(name = "depart_midi")
	private Boolean afternoon;

	@ApiModelProperty(notes = "Prise de congés seulement le matin", example = "1 = true, 0 = false", position = 5)
	@Column(name = "arrivee_midi")
	private Boolean morning;

	@ApiModelProperty(notes = "Le commentaire de l'employé", example = "Veuillez trouver ci-joint ma demande de congés, cordialement", position = 6)
	@Column(name = "comm_employe")
	private String employeComment;

	@ApiModelProperty(notes = "Le commentaire du manager", example = "J'ai le plaisir de vous informer que votre demande a été acceptée, cordialement", position = 7)
	@Column(name = "comm_manager")
	private String managerComment;

	@ApiModelProperty(notes = "Identifiant de l'employé effectuant la demande", example = "5", position = 8)
	@JoinColumn(name = "id_employe")
	@ManyToOne
	private Employe employe;

	@ApiModelProperty(notes = "Identifiant du manager de l'employé effectuant la demande", example = "12", position = 9)
	@JoinColumn(name = "id_manager_force")
	@ManyToOne
	private Employe manager;

	@ApiModelProperty(notes = "Identifiant du type de congé demandé", example = "1-RTTE, 2-RTTS, 3-CP, 4-CSS", position = 10)
	@JoinColumn(name = "id_type_conge")
	@ManyToOne
	private TypeConge typeConge;

	@ApiModelProperty(notes = "Identifiant du statut de la demande de congé demandé", example = "1-En attente, 2-Acceptée, 3-Refusée", position = 11)
	@JoinColumn(name = "id_statut")
	@ManyToOne
	private RequestStatus requestStatus;

	public LeaveRequest() {
	}

	@Override
	public String toString() {
		return "User [id=" + idRequest + ", Date demande =" + requestDate + ", Date debut =" + startDate
				+ ", Date fin =" + endDate + ", Depart midi =" + afternoon + ", Arrivee midi =" + morning
				+ ", Commentaire employe =" + employeComment + ", Commentaire manager =" + managerComment
				+ ", id employe =" + employe + ", id manager =" + manager + ", id type conge =" + typeConge
				+ ", id statut =" + requestStatus + "]";
	}

	public Long getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(Long idRequest) {
		this.idRequest = idRequest;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getAfternoon() {
		return afternoon;
	}

	public void setAfternoon(Boolean afternoon) {
		this.afternoon = afternoon;
	}

	public Boolean getMorning() {
		return morning;
	}

	public void setMorning(Boolean morning) {
		this.morning = morning;
	}

	public String getEmployeComment() {
		return employeComment;
	}

	public void setEmployeComment(String employeComment) {
		this.employeComment = employeComment;
	}

	public String getManagerComment() {
		return managerComment;
	}

	public void setManagerComment(String managerComment) {
		this.managerComment = managerComment;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Employe getManager() {
		return manager;
	}

	public void setManager(Employe manager) {
		this.manager = manager;
	}

	public TypeConge getTypeConge() {
		return typeConge;
	}

	public void setTypeConge(TypeConge typeConge) {
		this.typeConge = typeConge;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}
	public Long getIdRequestStatus() {		
		return requestStatus.getId();
	}

	public void setRequestStatus(RequestStatus status) {
		this.requestStatus = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
