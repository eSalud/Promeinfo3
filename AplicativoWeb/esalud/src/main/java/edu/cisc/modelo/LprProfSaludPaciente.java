package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the lprprofsaludpaciente database table.
 * 
 */
@Entity
@NamedQuery(name="LprProfSaludPaciente.findAll", query="SELECT l FROM LprProfSaludPaciente l")
public class LprProfSaludPaciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idprofsaludpac;

	@Temporal(TemporalType.DATE)
	private Date fechaasignacion;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	//bi-directional many-to-one association to ParProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idprofsalud")
	private ParProfesionalSalud parprofesionalsalud;

	public LprProfSaludPaciente() {
	}

	public Long getIdprofsaludpac() {
		return this.idprofsaludpac;
	}

	public void setIdprofsaludpac(Long idprofsaludpac) {
		this.idprofsaludpac = idprofsaludpac;
	}

	public Date getFechaasignacion() {
		return this.fechaasignacion;
	}

	public void setFechaasignacion(Date fechaasignacion) {
		this.fechaasignacion = fechaasignacion;
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