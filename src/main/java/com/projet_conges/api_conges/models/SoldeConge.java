package com.projet_conges.api_conges.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "solde_conge")
@ApiModel("Solde Conge Entity")
@Configuration
@AutoConfigureBefore({JacksonAutoConfiguration.class})
public class SoldeConge implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty("id_solde")
	@Column(name = "id_solde")
	private Long idSolde;

	@ApiModelProperty("annee")
	@Column(name = "annee")
	private int yearRef;

	@ApiModelProperty(name = "date_debut_validite")
	@Column(name = "date_debut_validite")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private String startOfValidity;

	@ApiModelProperty(name = "date_fin_validite")
	@Column(name = "date_fin_validite")
	@JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "MM-dd-yyyy")
	private String endOfValidity;

	@ApiModelProperty("nb_acquis")
	@Column(name = "nb_acquis")
	private int acquiredNb;

	@ApiModelProperty("id_type_conge")
	@JoinColumn(name = "id_type_conge")
	@ManyToOne
	private TypeConge typeConge;

	@JsonBackReference
	@ApiModelProperty(notes = "Employé possédant ce solde", example = "John Doe", required = true, position = 6)
	@JoinColumn(name = "id_employe")
	@ManyToOne
	private Employe employe;

	public SoldeConge() {
	}

	public SoldeConge(int yearRef,String startOfValidity, String endOfValidity, int acquiredNb, TypeConge idTypeConge,
			Employe idEmploye) {
		this.yearRef = yearRef;
		this.startOfValidity = startOfValidity;
		this.endOfValidity = endOfValidity;
		this.acquiredNb = acquiredNb;
		this.typeConge = idTypeConge;
		this.employe = idEmploye;

	}

	public SoldeConge(Long id, Employe idEmploye) {
		this.idSolde = id;
		this.employe = idEmploye;
	}

	@Override
	public String toString() {
		return "User [id=" + idSolde + ", Year reference =" + yearRef + ", Start of validity= " + startOfValidity
				+ ", End of validity=" + endOfValidity + ", Acquired number=" + acquiredNb + ", id type conge= "
				+ typeConge + ", id employe=" + employe + "]";
	}

	public Long getIdSolde() {
		return idSolde;
	}

	public void setIdSolde(Long idSolde) {
		this.idSolde = idSolde;
	}

	public int getYearRef() {
		return yearRef;
	}

	public void setYearRef(int yearRef) {
		this.yearRef = yearRef;
	}

	public String getStartOfValidity() {
		return startOfValidity;
	}

	public void setStartOfValidity(String startOfValidity) {
		this.startOfValidity = startOfValidity;
	}

	public String getEndOfValidity() {
		return endOfValidity;
	}

	public void setEndOfValidity(String endOfValidity) {
		this.endOfValidity = endOfValidity;
	}

	public int getAcquiredNb() {
		return acquiredNb;
	}

	public void setAcquiredNb(int acquiredNb) {
		this.acquiredNb = acquiredNb;
	}

	public TypeConge getIdTypeConge() {
		return typeConge;
	}

	public void setIdTypeConge(TypeConge idTypeConge) {
		this.typeConge = idTypeConge;
	}

	public Employe getIdEmploye() {
		return null;
	}


	public void setIdEmploye(Employe idEmploye) {
		this.employe = idEmploye;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
