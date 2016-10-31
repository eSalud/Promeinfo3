package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atmantecedentespersonales database table.
 * 
 */
@Entity
@Table(name="atmantecedentespersonales")
@NamedQuery(name="AtmAntecedentePersonal.findAll", query="SELECT a FROM AtmAntecedentePersonal a")
public class AtmAntecedentePersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idantecperson;

	private String coddiagnostico;

	private String descripcion;

	private String estado;

	private Integer idantecpersonal;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	public AtmAntecedentePersonal() {
	}

	public Long getIdantecperson() {
		return this.idantecperson;
	}

	public void setIdantecperson(Long idantecperson) {
		this.idantecperson = idantecperson;
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

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdantecpersonal() {
		return this.idantecpersonal;
	}

	public void setIdantecpersonal(Integer idantecpersonal) {
		this.idantecpersonal = idantecpersonal;
	}

	public ParPaciente getParpaciente() {
		return this.parpaciente;
	}

	public void setParpaciente(ParPaciente parpaciente) {
		this.parpaciente = parpaciente;
	}

}