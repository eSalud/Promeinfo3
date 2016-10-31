package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sisprocesoshospitalarios database table.
 * 
 */
@Entity
@Table(name="sisprocesoshospitalarios")
@NamedQuery(name="SisProcesoHospitalario.findAll", query="SELECT s FROM SisProcesoHospitalario s")
public class SisProcesoHospitalario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idprocesohosp;

	private String codprocesohosp;

	private String color;

	private Integer idprocesohosprec;

	private String nombre;

	private String tipo;

	//bi-directional many-to-one association to ActActividad
	@OneToMany(mappedBy="sisprocesoshospitalario")
	private List<ActActividad> actactividades;

	//bi-directional many-to-one association to AtmAgenda
	@OneToMany(mappedBy="sisprocesoshospitalario")
	private List<AtmAgenda> atmagendas;

	//bi-directional many-to-one association to AtmEncuentroPaciente
	@OneToMany(mappedBy="sisprocesoshospitalario")
	private List<AtmEncuentroPaciente> atmencuentrospacientes;

	public SisProcesoHospitalario() {
	}

	public Long getIdprocesohosp() {
		return this.idprocesohosp;
	}

	public void setIdprocesohosp(Long idprocesohosp) {
		this.idprocesohosp = idprocesohosp;
	}

	public String getCodprocesohosp() {
		return this.codprocesohosp;
	}

	public void setCodprocesohosp(String codprocesohosp) {
		this.codprocesohosp = codprocesohosp;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getIdprocesohosprec() {
		return this.idprocesohosprec;
	}

	public void setIdprocesohosprec(Integer idprocesohosprec) {
		this.idprocesohosprec = idprocesohosprec;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<ActActividad> getActactividades() {
		return this.actactividades;
	}

	public void setActactividades(List<ActActividad> actactividades) {
		this.actactividades = actactividades;
	}

	public ActActividad addActactividade(ActActividad actactividade) {
		getActactividades().add(actactividade);
		actactividade.setSisprocesoshospitalario(this);

		return actactividade;
	}

	public ActActividad removeActactividade(ActActividad actactividade) {
		getActactividades().remove(actactividade);
		actactividade.setSisprocesoshospitalario(null);

		return actactividade;
	}

	public List<AtmAgenda> getAtmagendas() {
		return this.atmagendas;
	}

	public void setAtmagendas(List<AtmAgenda> atmagendas) {
		this.atmagendas = atmagendas;
	}

	public AtmAgenda addAtmagenda(AtmAgenda atmagenda) {
		getAtmagendas().add(atmagenda);
		atmagenda.setSisprocesoshospitalario(this);

		return atmagenda;
	}

	public AtmAgenda removeAtmagenda(AtmAgenda atmagenda) {
		getAtmagendas().remove(atmagenda);
		atmagenda.setSisprocesoshospitalario(null);

		return atmagenda;
	}

	public List<AtmEncuentroPaciente> getAtmencuentrospacientes() {
		return this.atmencuentrospacientes;
	}

	public void setAtmencuentrospacientes(List<AtmEncuentroPaciente> atmencuentrospacientes) {
		this.atmencuentrospacientes = atmencuentrospacientes;
	}

	public AtmEncuentroPaciente addAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		getAtmencuentrospacientes().add(atmencuentrospaciente);
		atmencuentrospaciente.setSisprocesoshospitalario(this);

		return atmencuentrospaciente;
	}

	public AtmEncuentroPaciente removeAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		getAtmencuentrospacientes().remove(atmencuentrospaciente);
		atmencuentrospaciente.setSisprocesoshospitalario(null);

		return atmencuentrospaciente;
	}

}