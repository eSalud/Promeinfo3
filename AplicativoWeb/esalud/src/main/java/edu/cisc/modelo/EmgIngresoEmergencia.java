package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the emgingresosemergencia database table.
 * 
 */
@Entity
@Table(name="emgingresosemergencia")
@NamedQuery(name="EmgIngresoEmergencia.findAll", query="SELECT e FROM EmgIngresoEmergencia e")
public class EmgIngresoEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idingresosemg;

	private String detalle;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechaingreso;

	private String observacion;

	//bi-directional many-to-one association to EmgTipoEmergencia
	@ManyToOne
	@JoinColumn(name="idtipoemergencia")
	private EmgTipoEmergencia emgtiposemergencia;

	//bi-directional many-to-one association to EmgTipoTratamiento
	@ManyToOne
	@JoinColumn(name="idtipotratamiento")
	private EmgTipoTratamiento emgtipostratamiento;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	//bi-directional many-to-one association to ParProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idprofsalud")
	private ParProfesionalSalud parprofesionalsalud;

	//bi-directional many-to-one association to ProEstablecimientoSalud
	@ManyToOne
	@JoinColumn(name="idestablecimiento")
	private ProEstablecimientoSalud proestablecimientosalud;

	//bi-directional many-to-one association to EmgInsumoIngresoEmergencia
	@OneToMany(mappedBy="emgingresosemergencia")
	private List<EmgInsumoIngresoEmergencia> emginsumosingresosemergencias;

	public EmgIngresoEmergencia() {
	}

	public Long getIdingresosemg() {
		return this.idingresosemg;
	}

	public void setIdingresosemg(Long idingresosemg) {
		this.idingresosemg = idingresosemg;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaingreso() {
		return this.fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public EmgTipoEmergencia getEmgtiposemergencia() {
		return this.emgtiposemergencia;
	}

	public void setEmgtiposemergencia(EmgTipoEmergencia emgtiposemergencia) {
		this.emgtiposemergencia = emgtiposemergencia;
	}

	public EmgTipoTratamiento getEmgtipostratamiento() {
		return this.emgtipostratamiento;
	}

	public void setEmgtipostratamiento(EmgTipoTratamiento emgtipostratamiento) {
		this.emgtipostratamiento = emgtipostratamiento;
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

	public ProEstablecimientoSalud getProestablecimientosalud() {
		return this.proestablecimientosalud;
	}

	public void setProestablecimientosalud(ProEstablecimientoSalud proestablecimientosalud) {
		this.proestablecimientosalud = proestablecimientosalud;
	}

	public List<EmgInsumoIngresoEmergencia> getEmginsumosingresosemergencias() {
		return this.emginsumosingresosemergencias;
	}

	public void setEmginsumosingresosemergencias(List<EmgInsumoIngresoEmergencia> emginsumosingresosemergencias) {
		this.emginsumosingresosemergencias = emginsumosingresosemergencias;
	}

	public EmgInsumoIngresoEmergencia addEmginsumosingresosemergencia(EmgInsumoIngresoEmergencia emginsumosingresosemergencia) {
		getEmginsumosingresosemergencias().add(emginsumosingresosemergencia);
		emginsumosingresosemergencia.setEmgingresosemergencia(this);

		return emginsumosingresosemergencia;
	}

	public EmgInsumoIngresoEmergencia removeEmginsumosingresosemergencia(EmgInsumoIngresoEmergencia emginsumosingresosemergencia) {
		getEmginsumosingresosemergencias().remove(emginsumosingresosemergencia);
		emginsumosingresosemergencia.setEmgingresosemergencia(null);

		return emginsumosingresosemergencia;
	}

}