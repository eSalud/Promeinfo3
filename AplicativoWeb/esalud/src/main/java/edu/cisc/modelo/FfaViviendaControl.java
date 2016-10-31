package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ffaviviendacontrol database table.
 * 
 */
@Entity
@NamedQuery(name="FfaViviendaControl.findAll", query="SELECT f FROM FfaViviendaControl f")
public class FfaViviendaControl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idviviendacontrol;

	private String completa;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechavisita;

	private String formulario;

	private String informante;

	private String investigador;

	private String nadie;

	private Integer numvisita;

	private String rechazo;

	private String supervisor;

	//bi-directional many-to-one association to FfaVivienda
	@ManyToOne
	@JoinColumn(name="idvivienda")
	private FfaVivienda ffavivienda;

	public FfaViviendaControl() {
	}

	public Long getIdviviendacontrol() {
		return this.idviviendacontrol;
	}

	public void setIdviviendacontrol(Long idviviendacontrol) {
		this.idviviendacontrol = idviviendacontrol;
	}

	public String getCompleta() {
		return this.completa;
	}

	public void setCompleta(String completa) {
		this.completa = completa;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechavisita() {
		return this.fechavisita;
	}

	public void setFechavisita(Date fechavisita) {
		this.fechavisita = fechavisita;
	}

	public String getFormulario() {
		return this.formulario;
	}

	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}

	public String getInformante() {
		return this.informante;
	}

	public void setInformante(String informante) {
		this.informante = informante;
	}

	public String getInvestigador() {
		return this.investigador;
	}

	public void setInvestigador(String investigador) {
		this.investigador = investigador;
	}

	public String getNadie() {
		return this.nadie;
	}

	public void setNadie(String nadie) {
		this.nadie = nadie;
	}

	public Integer getNumvisita() {
		return this.numvisita;
	}

	public void setNumvisita(Integer numvisita) {
		this.numvisita = numvisita;
	}

	public String getRechazo() {
		return this.rechazo;
	}

	public void setRechazo(String rechazo) {
		this.rechazo = rechazo;
	}

	public String getSupervisor() {
		return this.supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public FfaVivienda getFfavivienda() {
		return this.ffavivienda;
	}

	public void setFfavivienda(FfaVivienda ffavivienda) {
		this.ffavivienda = ffavivienda;
	}

}