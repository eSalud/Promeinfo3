package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atmdiagnosticos database table.
 * 
 */
@Entity
@Table(name="atmdiagnosticos")
@NamedQuery(name="AtmDiagnostico.findAll", query="SELECT a FROM AtmDiagnostico a")
public class AtmDiagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddiagnostico;

	private String coddiagnostico;

	private String descripcion;

	//bi-directional many-to-one association to AtmAntecedenteFamiliar
	@OneToMany(mappedBy="atmdiagnostico")
	private List<AtmAntecedenteFamiliar> atmantecedentesfamiliares;

	public AtmDiagnostico() {
	}

	public Long getIddiagnostico() {
		return this.iddiagnostico;
	}

	public void setIddiagnostico(Long iddiagnostico) {
		this.iddiagnostico = iddiagnostico;
	}

	public String getCoddiagnostico() {
		return this.coddiagnostico;
	}

	public void setCoddiagnostico(String coddiagnostico) {
		this.coddiagnostico = coddiagnostico;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<AtmAntecedenteFamiliar> getAtmantecedentesfamiliares() {
		return this.atmantecedentesfamiliares;
	}

	public void setAtmantecedentesfamiliares(List<AtmAntecedenteFamiliar> atmantecedentesfamiliares) {
		this.atmantecedentesfamiliares = atmantecedentesfamiliares;
	}

	public AtmAntecedenteFamiliar addAtmantecedentesfamiliare(AtmAntecedenteFamiliar atmantecedentesfamiliare) {
		getAtmantecedentesfamiliares().add(atmantecedentesfamiliare);
		atmantecedentesfamiliare.setAtmdiagnostico(this);

		return atmantecedentesfamiliare;
	}

	public AtmAntecedenteFamiliar removeAtmantecedentesfamiliare(AtmAntecedenteFamiliar atmantecedentesfamiliare) {
		getAtmantecedentesfamiliares().remove(atmantecedentesfamiliare);
		atmantecedentesfamiliare.setAtmdiagnostico(null);

		return atmantecedentesfamiliare;
	}

}