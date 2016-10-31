package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the epicondicionesegreso database table.
 * 
 */
@Entity
@Table(name="epicondicionesegreso")
@NamedQuery(name="EpiCondicionEgreso.findAll", query="SELECT e FROM EpiCondicionEgreso e")
public class EpiCondicionEgreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcondicionesegreso;

	private String descripcion;

	private Timestamp fecha;

	//bi-directional many-to-one association to EpiResumenHallazgoClinico
	@ManyToOne
	@JoinColumn(name="idresumenhc")
	private EpiResumenHallazgoClinico epiresumenhallazgosclinico;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	//bi-directional many-to-one association to ParProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idprofsalud")
	private ParProfesionalSalud parprofesionalsalud;

	public EpiCondicionEgreso() {
	}

	public Long getIdcondicionesegreso() {
		return this.idcondicionesegreso;
	}

	public void setIdcondicionesegreso(Long idcondicionesegreso) {
		this.idcondicionesegreso = idcondicionesegreso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public EpiResumenHallazgoClinico getEpiresumenhallazgosclinico() {
		return this.epiresumenhallazgosclinico;
	}

	public void setEpiresumenhallazgosclinico(EpiResumenHallazgoClinico epiresumenhallazgosclinico) {
		this.epiresumenhallazgosclinico = epiresumenhallazgosclinico;
	}

	public ParPaciente getParpaciente() {
		return this.parpaciente;
	}

	public void setParpaciente(ParPaciente parpaciente) {
		this.parpaciente = parpaciente;
	}

	public ParProfesionalSalud getParprofesionalsalud() {
		return this.parprofesionalsalud;
	}

	public void setParprofesionalsalud(ParProfesionalSalud parprofesionalsalud) {
		this.parprofesionalsalud = parprofesionalsalud;
	}

}