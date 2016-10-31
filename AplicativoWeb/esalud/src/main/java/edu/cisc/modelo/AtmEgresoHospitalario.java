package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the atmegresohospitalario database table.
 * 
 */
@Entity
@NamedQuery(name="AtmEgresoHospitalario.findAll", query="SELECT a FROM AtmEgresoHospitalario a")
public class AtmEgresoHospitalario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idegresohosp;

	private String coddiagnostico;

	private String condicionegreso;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fechaadmision;

	private String nombreservicio;

	private Integer numdiasentrada;

	private String proclinicosquirurg;

	private String tipodiagnostico;

	private String tipotratamiento;

	//bi-directional many-to-one association to AtmOrden
	@ManyToOne
	@JoinColumn(name="idorden")
	private AtmOrden atmordene;

	//bi-directional many-to-one association to ParProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idprofsalud")
	private ParProfesionalSalud parprofesionalsalud;

	public AtmEgresoHospitalario() {
	}

	public Long getIdegresohosp() {
		return this.idegresohosp;
	}

	public void setIdegresohosp(Long idegresohosp) {
		this.idegresohosp = idegresohosp;
	}

	public String getCoddiagnostico() {
		return this.coddiagnostico;
	}

	public void setCoddiagnostico(String coddiagnostico) {
		this.coddiagnostico = coddiagnostico;
	}

	public String getCondicionegreso() {
		return this.condicionegreso;
	}

	public void setCondicionegreso(String condicionegreso) {
		this.condicionegreso = condicionegreso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaadmision() {
		return this.fechaadmision;
	}

	public void setFechaadmision(Date fechaadmision) {
		this.fechaadmision = fechaadmision;
	}

	public String getNombreservicio() {
		return this.nombreservicio;
	}

	public void setNombreservicio(String nombreservicio) {
		this.nombreservicio = nombreservicio;
	}

	public Integer getNumdiasentrada() {
		return this.numdiasentrada;
	}

	public void setNumdiasentrada(Integer numdiasentrada) {
		this.numdiasentrada = numdiasentrada;
	}

	public String getProclinicosquirurg() {
		return this.proclinicosquirurg;
	}

	public void setProclinicosquirurg(String proclinicosquirurg) {
		this.proclinicosquirurg = proclinicosquirurg;
	}

	public String getTipodiagnostico() {
		return this.tipodiagnostico;
	}

	public void setTipodiagnostico(String tipodiagnostico) {
		this.tipodiagnostico = tipodiagnostico;
	}

	public String getTipotratamiento() {
		return this.tipotratamiento;
	}

	public void setTipotratamiento(String tipotratamiento) {
		this.tipotratamiento = tipotratamiento;
	}

	public AtmOrden getAtmordene() {
		return this.atmordene;
	}

	public void setAtmordene(AtmOrden atmordene) {
		this.atmordene = atmordene;
	}

	public ParProfesionalSalud getParprofesionalsalud() {
		return this.parprofesionalsalud;
	}

	public void setParprofesionalsalud(ParProfesionalSalud parprofesionalsalud) {
		this.parprofesionalsalud = parprofesionalsalud;
	}

}