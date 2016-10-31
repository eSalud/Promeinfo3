package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lprhistoriaclinicaproblemas database table.
 * 
 */
@Entity
@Table(name="lprhistoriaclinicaproblemas")
@NamedQuery(name="LprHistoriaClinicaProblema.findAll", query="SELECT l FROM LprHistoriaClinicaProblema l")
public class LprHistoriaClinicaProblema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idhistproblemas;

	private String antecfamiliares;

	private String antecpersonales;

	private String diagprevios;

	private String enfermedadactual;

	private String enfermedadadulto;

	private String enfermedadinfancia;

	private String factoresriesgos;

	private String motivoconsulta;

	private String operaciones;

	private String signos;

	private String sintomas;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	//bi-directional many-to-one association to LprSegEnfermedad
	@OneToMany(mappedBy="lprhistoriaclinicaproblema")
	private List<LprSegEnfermedad> lprsegenfermedads;

	public LprHistoriaClinicaProblema() {
	}

	public Long getIdhistproblemas() {
		return this.idhistproblemas;
	}

	public void setIdhistproblemas(Long idhistproblemas) {
		this.idhistproblemas = idhistproblemas;
	}

	public String getAntecfamiliares() {
		return this.antecfamiliares;
	}

	public void setAntecfamiliares(String antecfamiliares) {
		this.antecfamiliares = antecfamiliares;
	}

	public String getAntecpersonales() {
		return this.antecpersonales;
	}

	public void setAntecpersonales(String antecpersonales) {
		this.antecpersonales = antecpersonales;
	}

	public String getDiagprevios() {
		return this.diagprevios;
	}

	public void setDiagprevios(String diagprevios) {
		this.diagprevios = diagprevios;
	}

	public String getEnfermedadactual() {
		return this.enfermedadactual;
	}

	public void setEnfermedadactual(String enfermedadactual) {
		this.enfermedadactual = enfermedadactual;
	}

	public String getEnfermedadadulto() {
		return this.enfermedadadulto;
	}

	public void setEnfermedadadulto(String enfermedadadulto) {
		this.enfermedadadulto = enfermedadadulto;
	}

	public String getEnfermedadinfancia() {
		return this.enfermedadinfancia;
	}

	public void setEnfermedadinfancia(String enfermedadinfancia) {
		this.enfermedadinfancia = enfermedadinfancia;
	}

	public String getFactoresriesgos() {
		return this.factoresriesgos;
	}

	public void setFactoresriesgos(String factoresriesgos) {
		this.factoresriesgos = factoresriesgos;
	}

	public String getMotivoconsulta() {
		return this.motivoconsulta;
	}

	public void setMotivoconsulta(String motivoconsulta) {
		this.motivoconsulta = motivoconsulta;
	}

	public String getOperaciones() {
		return this.operaciones;
	}

	public void setOperaciones(String operaciones) {
		this.operaciones = operaciones;
	}

	public String getSignos() {
		return this.signos;
	}

	public void setSignos(String signos) {
		this.signos = signos;
	}

	public String getSintomas() {
		return this.sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public ParPaciente getParpaciente() {
		return this.parpaciente;
	}

	public void setParpaciente(ParPaciente parpaciente) {
		this.parpaciente = parpaciente;
	}

	public List<LprSegEnfermedad> getLprsegenfermedads() {
		return this.lprsegenfermedads;
	}

	public void setLprsegenfermedads(List<LprSegEnfermedad> lprsegenfermedads) {
		this.lprsegenfermedads = lprsegenfermedads;
	}

	public LprSegEnfermedad addLprsegenfermedad(LprSegEnfermedad lprsegenfermedad) {
		getLprsegenfermedads().add(lprsegenfermedad);
		lprsegenfermedad.setLprhistoriaclinicaproblema(this);

		return lprsegenfermedad;
	}

	public LprSegEnfermedad removeLprsegenfermedad(LprSegEnfermedad lprsegenfermedad) {
		getLprsegenfermedads().remove(lprsegenfermedad);
		lprsegenfermedad.setLprhistoriaclinicaproblema(null);

		return lprsegenfermedad;
	}

}