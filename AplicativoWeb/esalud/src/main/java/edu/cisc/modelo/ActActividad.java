package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the actactividades database table.
 * 
 */
@Entity
@Table(name="actactividades")
@NamedQuery(name="ActActividad.findAll", query="SELECT a FROM ActActividad a")
public class ActActividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idactividad;

	private String codactividad;

	private String nombre;

	//bi-directional many-to-one association to ActTipoActividad
	@ManyToOne
	@JoinColumn(name="idtipoactividad")
	private ActTipoActividad acttiposactividade;

	//bi-directional many-to-one association to SisProcesoHospitalario
	@ManyToOne
	@JoinColumn(name="idprocesohosp")
	private SisProcesoHospitalario sisprocesoshospitalario;

	//bi-directional many-to-one association to AtmAgendaInterconsulta
	@OneToMany(mappedBy="actactividade")
	private List<AtmAgendaInterconsulta> atmagendainterconsultas;

	//bi-directional many-to-one association to AtmAgenda
	@OneToMany(mappedBy="actactividade")
	private List<AtmAgenda> atmagendas;

	//bi-directional many-to-one association to AtmEncuentroPaciente
	@OneToMany(mappedBy="actactividade")
	private List<AtmEncuentroPaciente> atmencuentrospacientes;

	public ActActividad() {
	}

	public Long getIdactividad() {
		return this.idactividad;
	}

	public void setIdactividad(Long idactividad) {
		this.idactividad = idactividad;
	}

	public String getCodactividad() {
		return this.codactividad;
	}

	public void setCodactividad(String codactividad) {
		this.codactividad = codactividad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ActTipoActividad getActtiposactividade() {
		return this.acttiposactividade;
	}

	public void setActtiposactividade(ActTipoActividad acttiposactividade) {
		this.acttiposactividade = acttiposactividade;
	}

	public SisProcesoHospitalario getSisprocesoshospitalario() {
		return this.sisprocesoshospitalario;
	}

	public void setSisprocesoshospitalario(SisProcesoHospitalario sisprocesoshospitalario) {
		this.sisprocesoshospitalario = sisprocesoshospitalario;
	}

	public List<AtmAgendaInterconsulta> getAtmagendainterconsultas() {
		return this.atmagendainterconsultas;
	}

	public void setAtmagendainterconsultas(List<AtmAgendaInterconsulta> atmagendainterconsultas) {
		this.atmagendainterconsultas = atmagendainterconsultas;
	}

	public AtmAgendaInterconsulta addAtmagendainterconsulta(AtmAgendaInterconsulta atmagendainterconsulta) {
		getAtmagendainterconsultas().add(atmagendainterconsulta);
		atmagendainterconsulta.setActactividade(this);

		return atmagendainterconsulta;
	}

	public AtmAgendaInterconsulta removeAtmagendainterconsulta(AtmAgendaInterconsulta atmagendainterconsulta) {
		getAtmagendainterconsultas().remove(atmagendainterconsulta);
		atmagendainterconsulta.setActactividade(null);

		return atmagendainterconsulta;
	}

	public List<AtmAgenda> getAtmagendas() {
		return this.atmagendas;
	}

	public void setAtmagendas(List<AtmAgenda> atmagendas) {
		this.atmagendas = atmagendas;
	}

	public AtmAgenda addAtmagenda(AtmAgenda atmagenda) {
		getAtmagendas().add(atmagenda);
		atmagenda.setActactividade(this);

		return atmagenda;
	}

	public AtmAgenda removeAtmagenda(AtmAgenda atmagenda) {
		getAtmagendas().remove(atmagenda);
		atmagenda.setActactividade(null);

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
		atmencuentrospaciente.setActactividade(this);

		return atmencuentrospaciente;
	}

	public AtmEncuentroPaciente removeAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		getAtmencuentrospacientes().remove(atmencuentrospaciente);
		atmencuentrospaciente.setActactividade(null);

		return atmencuentrospaciente;
	}

}