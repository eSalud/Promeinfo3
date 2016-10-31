package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the odotratamientos database table.
 * 
 */
@Entity
@Table(name="odotratamientos")
@NamedQuery(name="OdoTratamiento.findAll", query="SELECT o FROM OdoTratamiento o")
public class OdoTratamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtratamiento;

	private String codigo;

	private String diagnosticocompl;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String firma;

	private String prescripciones;

	private String procedimiento;

	private String sesion;

	//bi-directional many-to-one association to OdoRegistroOdontologico
	@ManyToOne
	@JoinColumn(name="idregistro")
	private OdoRegistroOdontologico odoregistroodontologico;

	public OdoTratamiento() {
	}

	public Long getIdtratamiento() {
		return this.idtratamiento;
	}

	public void setIdtratamiento(Long idtratamiento) {
		this.idtratamiento = idtratamiento;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDiagnosticocompl() {
		return this.diagnosticocompl;
	}

	public void setDiagnosticocompl(String diagnosticocompl) {
		this.diagnosticocompl = diagnosticocompl;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFirma() {
		return this.firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getPrescripciones() {
		return this.prescripciones;
	}

	public void setPrescripciones(String prescripciones) {
		this.prescripciones = prescripciones;
	}

	public String getProcedimiento() {
		return this.procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public String getSesion() {
		return this.sesion;
	}

	public void setSesion(String sesion) {
		this.sesion = sesion;
	}

	public OdoRegistroOdontologico getOdoregistroodontologico() {
		return this.odoregistroodontologico;
	}

	public void setOdoregistroodontologico(OdoRegistroOdontologico odoregistroodontologico) {
		this.odoregistroodontologico = odoregistroodontologico;
	}

}