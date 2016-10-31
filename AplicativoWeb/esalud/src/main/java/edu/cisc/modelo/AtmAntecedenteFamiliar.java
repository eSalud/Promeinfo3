package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atmantecedentesfamiliares database table.
 * 
 */
@Entity
@Table(name="atmantecedentesfamiliares")
@NamedQuery(name="AtmAntecedenteFamiliar.findAll", query="SELECT a FROM AtmAntecedenteFamiliar a")
public class AtmAntecedenteFamiliar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idantfamiliares;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to AtmDiagnostico
	@ManyToOne
	@JoinColumn(name="iddiagnostico")
	private AtmDiagnostico atmdiagnostico;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	public AtmAntecedenteFamiliar() {
	}

	public Long getIdantfamiliares() {
		return this.idantfamiliares;
	}

	public void setIdantfamiliares(Long idantfamiliares) {
		this.idantfamiliares = idantfamiliares;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public AtmDiagnostico getAtmdiagnostico() {
		return this.atmdiagnostico;
	}

	public void setAtmdiagnostico(AtmDiagnostico atmdiagnostico) {
		this.atmdiagnostico = atmdiagnostico;
	}

	public ParPaciente getParpaciente() {
		return this.parpaciente;
	}

	public void setParpaciente(ParPaciente parpaciente) {
		this.parpaciente = parpaciente;
	}

}