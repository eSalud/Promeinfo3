package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atmordenes database table.
 * 
 */
@Entity
@Table(name="atmordenes")
@NamedQuery(name="AtmOrden.findAll", query="SELECT a FROM AtmOrden a")
public class AtmOrden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idorden;

	private String fecha;

	private String hora;

	//bi-directional many-to-one association to AtmAltaAmbulatoria
	@OneToMany(mappedBy="atmordene")
	private List<AtmAltaAmbulatoria> atmaltaambulatorias;

	//bi-directional many-to-one association to AtmEgresoHospitalario
	@OneToMany(mappedBy="atmordene")
	private List<AtmEgresoHospitalario> atmegresohospitalarios;

	//bi-directional many-to-one association to AtmEncuentroPaciente
	@ManyToOne
	@JoinColumn(name="idencpaciente")
	private AtmEncuentroPaciente atmencuentrospaciente;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	public AtmOrden() {
	}

	public Long getIdorden() {
		return this.idorden;
	}

	public void setIdorden(Long idorden) {
		this.idorden = idorden;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public List<AtmAltaAmbulatoria> getAtmaltaambulatorias() {
		return this.atmaltaambulatorias;
	}

	public void setAtmaltaambulatorias(List<AtmAltaAmbulatoria> atmaltaambulatorias) {
		this.atmaltaambulatorias = atmaltaambulatorias;
	}

	public AtmAltaAmbulatoria addAtmaltaambulatoria(AtmAltaAmbulatoria atmaltaambulatoria) {
		getAtmaltaambulatorias().add(atmaltaambulatoria);
		atmaltaambulatoria.setAtmordene(this);

		return atmaltaambulatoria;
	}

	public AtmAltaAmbulatoria removeAtmaltaambulatoria(AtmAltaAmbulatoria atmaltaambulatoria) {
		getAtmaltaambulatorias().remove(atmaltaambulatoria);
		atmaltaambulatoria.setAtmordene(null);

		return atmaltaambulatoria;
	}

	public List<AtmEgresoHospitalario> getAtmegresohospitalarios() {
		return this.atmegresohospitalarios;
	}

	public void setAtmegresohospitalarios(List<AtmEgresoHospitalario> atmegresohospitalarios) {
		this.atmegresohospitalarios = atmegresohospitalarios;
	}

	public AtmEgresoHospitalario addAtmegresohospitalario(AtmEgresoHospitalario atmegresohospitalario) {
		getAtmegresohospitalarios().add(atmegresohospitalario);
		atmegresohospitalario.setAtmordene(this);

		return atmegresohospitalario;
	}

	public AtmEgresoHospitalario removeAtmegresohospitalario(AtmEgresoHospitalario atmegresohospitalario) {
		getAtmegresohospitalarios().remove(atmegresohospitalario);
		atmegresohospitalario.setAtmordene(null);

		return atmegresohospitalario;
	}

	public AtmEncuentroPaciente getAtmencuentrospaciente() {
		return this.atmencuentrospaciente;
	}

	public void setAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		this.atmencuentrospaciente = atmencuentrospaciente;
	}

	public ParPaciente getParpaciente() {
		return this.parpaciente;
	}

	public void setParpaciente(ParPaciente parpaciente) {
		this.parpaciente = parpaciente;
	}

}