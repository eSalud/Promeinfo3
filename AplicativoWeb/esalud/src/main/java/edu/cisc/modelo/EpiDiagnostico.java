package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the epidiagnosticos database table.
 * 
 */
@Entity
@Table(name="epidiagnosticos")
@NamedQuery(name="EpiDiagnostico.findAll", query="SELECT e FROM EpiDiagnostico e")
public class EpiDiagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddiagnostico;

	private Integer cie;

	private String descripcion;

	private Timestamp fecharegistro;

	//bi-directional many-to-one association to AtmTipoDiagnostico
	@ManyToOne
	@JoinColumn(name="idtipodiagnostico")
	private AtmTipoDiagnostico atmtiposdiagnostico;

	//bi-directional many-to-one association to EpiResumenHallazgoClinico
	@ManyToOne
	@JoinColumn(name="idresumenhc")
	private EpiResumenHallazgoClinico epiresumenhallazgosclinico;

	public EpiDiagnostico() {
	}

	public Long getIddiagnostico() {
		return this.iddiagnostico;
	}

	public void setIddiagnostico(Long iddiagnostico) {
		this.iddiagnostico = iddiagnostico;
	}

	public Integer getCie() {
		return this.cie;
	}

	public void setCie(Integer cie) {
		this.cie = cie;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public AtmTipoDiagnostico getAtmtiposdiagnostico() {
		return this.atmtiposdiagnostico;
	}

	public void setAtmtiposdiagnostico(AtmTipoDiagnostico atmtiposdiagnostico) {
		this.atmtiposdiagnostico = atmtiposdiagnostico;
	}

	public EpiResumenHallazgoClinico getEpiresumenhallazgosclinico() {
		return this.epiresumenhallazgosclinico;
	}

	public void setEpiresumenhallazgosclinico(EpiResumenHallazgoClinico epiresumenhallazgosclinico) {
		this.epiresumenhallazgosclinico = epiresumenhallazgosclinico;
	}

}