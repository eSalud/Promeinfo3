package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atmtiposdiagnosticos database table.
 * 
 */
@Entity
@Table(name="atmtiposdiagnosticos")
@NamedQuery(name="AtmTipoDiagnostico.findAll", query="SELECT a FROM AtmTipoDiagnostico a")
public class AtmTipoDiagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipodiagnostico;

	private String descripcion;

	//bi-directional many-to-one association to AtmDiagnosticoEncPaciente
	@OneToMany(mappedBy="atmtiposdiagnostico")
	private List<AtmDiagnosticoEncPaciente> atmdiagnosticosencpacientes;

	//bi-directional many-to-one association to EpiDiagnostico
	@OneToMany(mappedBy="atmtiposdiagnostico")
	private List<EpiDiagnostico> epidiagnosticos;

	public AtmTipoDiagnostico() {
	}

	public Long getIdtipodiagnostico() {
		return this.idtipodiagnostico;
	}

	public void setIdtipodiagnostico(Long idtipodiagnostico) {
		this.idtipodiagnostico = idtipodiagnostico;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<AtmDiagnosticoEncPaciente> getAtmdiagnosticosencpacientes() {
		return this.atmdiagnosticosencpacientes;
	}

	public void setAtmdiagnosticosencpacientes(List<AtmDiagnosticoEncPaciente> atmdiagnosticosencpacientes) {
		this.atmdiagnosticosencpacientes = atmdiagnosticosencpacientes;
	}

	public AtmDiagnosticoEncPaciente addAtmdiagnosticosencpaciente(AtmDiagnosticoEncPaciente atmdiagnosticosencpaciente) {
		getAtmdiagnosticosencpacientes().add(atmdiagnosticosencpaciente);
		atmdiagnosticosencpaciente.setAtmtiposdiagnostico(this);

		return atmdiagnosticosencpaciente;
	}

	public AtmDiagnosticoEncPaciente removeAtmdiagnosticosencpaciente(AtmDiagnosticoEncPaciente atmdiagnosticosencpaciente) {
		getAtmdiagnosticosencpacientes().remove(atmdiagnosticosencpaciente);
		atmdiagnosticosencpaciente.setAtmtiposdiagnostico(null);

		return atmdiagnosticosencpaciente;
	}

	public List<EpiDiagnostico> getEpidiagnosticos() {
		return this.epidiagnosticos;
	}

	public void setEpidiagnosticos(List<EpiDiagnostico> epidiagnosticos) {
		this.epidiagnosticos = epidiagnosticos;
	}

	public EpiDiagnostico addEpidiagnostico(EpiDiagnostico epidiagnostico) {
		getEpidiagnosticos().add(epidiagnostico);
		epidiagnostico.setAtmtiposdiagnostico(this);

		return epidiagnostico;
	}

	public EpiDiagnostico removeEpidiagnostico(EpiDiagnostico epidiagnostico) {
		getEpidiagnosticos().remove(epidiagnostico);
		epidiagnostico.setAtmtiposdiagnostico(null);

		return epidiagnostico;
	}

}