package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the lprexamenes database table.
 * 
 */
@Entity
@Table(name="lprexamenes")
@NamedQuery(name="LprExamen.findAll", query="SELECT l FROM LprExamen l")
public class LprExamen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idexamen;

	private String descripcion;

	private String diagnostivo;

	@Temporal(TemporalType.DATE)
	private Date fechadiagnostico;

	private String tratamiento;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	//bi-directional many-to-one association to ParProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idprofsalud")
	private ParProfesionalSalud parprofesionalsalud;

	public LprExamen() {
	}

	public Long getIdexamen() {
		return this.idexamen;
	}

	public void setIdexamen(Long idexamen) {
		this.idexamen = idexamen;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDiagnostivo() {
		return this.diagnostivo;
	}

	public void setDiagnostivo(String diagnostivo) {
		this.diagnostivo = diagnostivo;
	}

	public Date getFechadiagnostico() {
		return this.fechadiagnostico;
	}

	public void setFechadiagnostico(Date fechadiagnostico) {
		this.fechadiagnostico = fechadiagnostico;
	}

	public String getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
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