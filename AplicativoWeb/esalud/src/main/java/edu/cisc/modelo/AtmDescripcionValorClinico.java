package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atmdescripcionesvaloresclinicos database table.
 * 
 */
@Entity
@Table(name="atmdescripcionesvaloresclinicos")
@NamedQuery(name="AtmDescripcionValorClinico.findAll", query="SELECT a FROM AtmDescripcionValorClinico a")
public class AtmDescripcionValorClinico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddescvalclinico;

	private String codvalclinico;

	private String descripcion;

	//bi-directional many-to-one association to AtmInformacionClinica
	@ManyToOne
	@JoinColumn(name="idinfoclinica")
	private AtmInformacionClinica atminformacionesclinica;

	public AtmDescripcionValorClinico() {
	}

	public Long getIddescvalclinico() {
		return this.iddescvalclinico;
	}

	public void setIddescvalclinico(Long iddescvalclinico) {
		this.iddescvalclinico = iddescvalclinico;
	}

	public String getCodvalclinico() {
		return this.codvalclinico;
	}

	public void setCodvalclinico(String codvalclinico) {
		this.codvalclinico = codvalclinico;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public AtmInformacionClinica getAtminformacionesclinica() {
		return this.atminformacionesclinica;
	}

	public void setAtminformacionesclinica(AtmInformacionClinica atminformacionesclinica) {
		this.atminformacionesclinica = atminformacionesclinica;
	}

}