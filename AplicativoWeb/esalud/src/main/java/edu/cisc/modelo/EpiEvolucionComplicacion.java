package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the epievolucioncomplicaciones database table.
 * 
 */
@Entity
@Table(name="epievolucioncomplicaciones")
@NamedQuery(name="EpiEvolucionComplicacion.findAll", query="SELECT e FROM EpiEvolucionComplicacion e")
public class EpiEvolucionComplicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idevoluccomplic;

	private Timestamp fecha;

	private String resumenevolucion;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	//bi-directional many-to-one association to ParProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idprofsalud")
	private ParProfesionalSalud parprofesionalsalud;

	public EpiEvolucionComplicacion() {
	}

	public Long getIdevoluccomplic() {
		return this.idevoluccomplic;
	}

	public void setIdevoluccomplic(Long idevoluccomplic) {
		this.idevoluccomplic = idevoluccomplic;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getResumenevolucion() {
		return this.resumenevolucion;
	}

	public void setResumenevolucion(String resumenevolucion) {
		this.resumenevolucion = resumenevolucion;
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