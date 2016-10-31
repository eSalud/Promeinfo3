package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atmagendas database table.
 * 
 */
@Entity
@Table(name="atmagendas")
@NamedQuery(name="AtmAgenda.findAll", query="SELECT a FROM AtmAgenda a")
public class AtmAgenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idagenda;

	private String estado;

	private String fechaagenda;

	private String horaagenda;

	//bi-directional many-to-one association to ActActividad
	@ManyToOne
	@JoinColumn(name="idactividad")
	private ActActividad actactividade;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	//bi-directional many-to-one association to ParProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idprofsalud")
	private ParProfesionalSalud parprofesionalsalud;

	//bi-directional many-to-one association to SisProcesoHospitalario
	@ManyToOne
	@JoinColumn(name="idprocesohosp")
	private SisProcesoHospitalario sisprocesoshospitalario;

	//bi-directional many-to-one association to AtmEncuentroPaciente
	@OneToMany(mappedBy="atmagenda")
	private List<AtmEncuentroPaciente> atmencuentrospacientes;

	public AtmAgenda() {
	}

	public Long getIdagenda() {
		return this.idagenda;
	}

	public void setIdagenda(Long idagenda) {
		this.idagenda = idagenda;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaagenda() {
		return this.fechaagenda;
	}

	public void setFechaagenda(String fechaagenda) {
		this.fechaagenda = fechaagenda;
	}

	public String getHoraagenda() {
		return this.horaagenda;
	}

	public void setHoraagenda(String horaagenda) {
		this.horaagenda = horaagenda;
	}

	public ActActividad getActactividade() {
		return this.actactividade;
	}

	public void setActactividade(ActActividad actactividade) {
		this.actactividade = actactividade;
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

	public SisProcesoHospitalario getSisprocesoshospitalario() {
		return this.sisprocesoshospitalario;
	}

	public void setSisprocesoshospitalario(SisProcesoHospitalario sisprocesoshospitalario) {
		this.sisprocesoshospitalario = sisprocesoshospitalario;
	}

	public List<AtmEncuentroPaciente> getAtmencuentrospacientes() {
		return this.atmencuentrospacientes;
	}

	public void setAtmencuentrospacientes(List<AtmEncuentroPaciente> atmencuentrospacientes) {
		this.atmencuentrospacientes = atmencuentrospacientes;
	}

	public AtmEncuentroPaciente addAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		getAtmencuentrospacientes().add(atmencuentrospaciente);
		atmencuentrospaciente.setAtmagenda(this);

		return atmencuentrospaciente;
	}

	public AtmEncuentroPaciente removeAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		getAtmencuentrospacientes().remove(atmencuentrospaciente);
		atmencuentrospaciente.setAtmagenda(null);

		return atmencuentrospaciente;
	}

}