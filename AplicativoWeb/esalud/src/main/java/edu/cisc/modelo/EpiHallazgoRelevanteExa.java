package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the epihallazgosrelevantesexa database table.
 * 
 */
@Entity
@Table(name="epihallazgosrelevantesexa")
@NamedQuery(name="EpiHallazgoRelevanteExa.findAll", query="SELECT e FROM EpiHallazgoRelevanteExa e")
public class EpiHallazgoRelevanteExa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idhallazgo;

	private String descripcion;

	private Timestamp fecha;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	//bi-directional many-to-one association to ParProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idprofsalud")
	private ParProfesionalSalud parprofesionalsalud;

	public EpiHallazgoRelevanteExa() {
	}

	public Long getIdhallazgo() {
		return this.idhallazgo;
	}

	public void setIdhallazgo(Long idhallazgo) {
		this.idhallazgo = idhallazgo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
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

}