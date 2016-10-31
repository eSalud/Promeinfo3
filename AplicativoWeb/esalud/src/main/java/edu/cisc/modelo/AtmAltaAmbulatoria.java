package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the atmaltaambulatoria database table.
 * 
 */
@Entity
@NamedQuery(name="AtmAltaAmbulatoria.findAll", query="SELECT a FROM AtmAltaAmbulatoria a")
public class AtmAltaAmbulatoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idaltaamb;

	private String coddiagnostico;

	private String condicionalta;

	private Integer consulemegergencia;

	private String descripcion;

	private String especservicio;

	@Temporal(TemporalType.DATE)
	private Date fechaadmision;

	private Integer numconsulext;

	private String proclinicosquirurg;

	private Integer tipoconsulta;

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

	public AtmAltaAmbulatoria() {
	}

	public Long getIdaltaamb() {
		return this.idaltaamb;
	}

	public void setIdaltaamb(Long idaltaamb) {
		this.idaltaamb = idaltaamb;
	}

	public String getCoddiagnostico() {
		return this.coddiagnostico;
	}

	public void setCoddiagnostico(String coddiagnostico) {
		this.coddiagnostico = coddiagnostico;
	}

	public String getCondicionalta() {
		return this.condicionalta;
	}

	public void setCondicionalta(String condicionalta) {
		this.condicionalta = condicionalta;
	}

	public Integer getConsulemegergencia() {
		return this.consulemegergencia;
	}

	public void setConsulemegergencia(Integer consulemegergencia) {
		this.consulemegergencia = consulemegergencia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEspecservicio() {
		return this.especservicio;
	}

	public void setEspecservicio(String especservicio) {
		this.especservicio = especservicio;
	}

	public Date getFechaadmision() {
		return this.fechaadmision;
	}

	public void setFechaadmision(Date fechaadmision) {
		this.fechaadmision = fechaadmision;
	}

	public Integer getNumconsulext() {
		return this.numconsulext;
	}

	public void setNumconsulext(Integer numconsulext) {
		this.numconsulext = numconsulext;
	}

	public String getProclinicosquirurg() {
		return this.proclinicosquirurg;
	}

	public void setProclinicosquirurg(String proclinicosquirurg) {
		this.proclinicosquirurg = proclinicosquirurg;
	}

	public Integer getTipoconsulta() {
		return this.tipoconsulta;
	}

	public void setTipoconsulta(Integer tipoconsulta) {
		this.tipoconsulta = tipoconsulta;
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