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
@Table(name = "type_conge")
@ApiModel(description = "Classe qui représente les différents types de congés")
public class TypeConge implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Id du type de congé (ex : 1-RTTE, 2-RTTS, 3-CP, 4-CSS)", example = "1", required = true, position = 0)
	@Column(name = "id_type_conge")
	private Long id;

	@ApiModelProperty(notes = "Nom du congé séléctionné", example = "RTTE", required = true, position = 1)
	private String description;

	public TypeConge() {
	}

	public TypeConge(String name) {
		this.description = name;
	}

	public TypeConge(Long id, String name) {
		this.id = id;
		this.description = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idTypeConge) {
		this.id = idTypeConge;
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
