package com.projet_conges.api_conges.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@DynamicUpdate
@Table(name = "employe")
@ApiModel("Employe Entity")
public class Employe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty("id_employe")
	@Column(name = "id_employe")
	private Long idEmploye;

	@Column(name = "matricule")
	@ApiModelProperty("matricule")
	private int registrationNb;

	@Column(name = "nom")
	@ApiModelProperty("nom")
	private String lastName;

	@Column(name = "prenom")
	@ApiModelProperty("prenom")
	private String name;

	@ApiModelProperty("manager")
	@JoinColumn(name = "id_manager")
	@ManyToOne
	private Employe manager;

	@JsonManagedReference
	@ApiModelProperty("solde")
	@OneToMany(mappedBy = "employe")
	private List<SoldeConge> soldes;

	public Employe() {
	}

	public Employe(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	public Employe(Long id, String name, String lastName) {
		this.idEmploye = id;
		this.name = name;
		this.lastName = lastName;
	}

	public Employe(String name, String lastName, int registrationNb) {
		this.name = name;
		this.lastName = lastName;
		this.registrationNb = registrationNb;
	}

	public Employe(String name, String lastName, int registrationNb, Employe manager) {
		this.name = name;
		this.lastName = lastName;
		this.registrationNb = registrationNb;
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "User [id=" + idEmploye + ", name=" + name + ", lastName=" + lastName + ", registration number="
				+ registrationNb + ", manager=" + this.manager + ", solde=" + this.soldes + "]";
	}

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public int getRegistrationNb() {
		return registrationNb;
	}

	public void setRegistrationNb(int registrationNb) {
		this.registrationNb = registrationNb;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employe getIdManager() {
		return manager;
	}

	public void setIdManager(Employe manager) {
		this.manager = manager;
	}

	public List<SoldeConge> getSoldeConge() {
		return soldes;
	}

	public void setSoldeConge(List<SoldeConge> soldes) {
		this.soldes = soldes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
