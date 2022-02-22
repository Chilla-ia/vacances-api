package com.projet_conges.api_conges.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "statut_demande")
@ApiModel(description = "Classe représentant les différents statuts des demandes de congés")
public class RequestStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Id du statut de la demande (1-En attente, 2-Acceptée, 3-Refusée)", example = "1", required = true, position = 0)
	@Column(name = "id_statut")
	private Long id;

	@ApiModelProperty(notes = "Nom du statut sélectionné", example = "En attente", required = true, position = 1)
	private String description;

	public RequestStatus() {
	}

	public RequestStatus(String description) {
		this.description = description;
	}

	public RequestStatus(Long id, String description) {
		this.id = id;
		this.description = description;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", Description =" + description + "]";
	}

	public Long getId() {
		return id;
	}

	public void setIdStatus(Long idStatus) {
		this.id = idStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
