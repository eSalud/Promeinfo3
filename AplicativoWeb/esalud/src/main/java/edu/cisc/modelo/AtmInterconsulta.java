package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atminterconsulta database table.
 * 
 */
@Entity
@NamedQuery(name="AtmInterconsulta.findAll", query="SELECT a FROM AtmInterconsulta a")
public class AtmInterconsulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idinterconsulta;

	private String atencion;

	private Integer cama;

	private String descripcionmotivo;

	private Integer idencpacinforme;

	private Integer idestabdestino;

	private Integer idestabsolicitante;

	private Integer idmedicointercons;

	private Integer idmedicosolicita;

	private Integer idservconsultado;

	private Integer idservsolicita;

	private Integer sala;

	//bi-directional many-to-one association to AtmEncuentroPaciente
	@ManyToOne
	@JoinColumn(name="idencpaciente")
	private AtmEncuentroPaciente atmencuentrospaciente;

	public AtmInterconsulta() {
	}

	public Long getIdinterconsulta() {
		return this.idinterconsulta;
	}

	public void setIdinterconsulta(Long idinterconsulta) {
		this.idinterconsulta = idinterconsulta;
	}

	public String getAtencion() {
		return this.atencion;
	}

	public void setAtencion(String atencion) {
		this.atencion = atencion;
	}

	public Integer getCama() {
		return this.cama;
	}

	public void setCama(Integer cama) {
		this.cama = cama;
	}

	public String getDescripcionmotivo() {
		return this.descripcionmotivo;
	}

	public void setDescripcionmotivo(String descripcionmotivo) {
		this.descripcionmotivo = descripcionmotivo;
	}

	public Integer getIdencpacinforme() {
		return this.idencpacinforme;
	}

	public void setIdencpacinforme(Integer idencpacinforme) {
		this.idencpacinforme = idencpacinforme;
	}

	public Integer getIdestabdestino() {
		return this.idestabdestino;
	}

	public void setIdestabdestino(Integer idestabdestino) {
		this.idestabdestino = idestabdestino;
	}

	public Integer getIdestabsolicitante() {
		return this.idestabsolicitante;
	}

	public void setIdestabsolicitante(Integer idestabsolicitante) {
		this.idestabsolicitante = idestabsolicitante;
	}

	public Integer getIdmedicointercons() {
		return this.idmedicointercons;
	}

	public void setIdmedicointercons(Integer idmedicointercons) {
		this.idmedicointercons = idmedicointercons;
	}

	public Integer getIdmedicosolicita() {
		return this.idmedicosolicita;
	}

	public void setIdmedicosolicita(Integer idmedicosolicita) {
		this.idmedicosolicita = idmedicosolicita;
	}

	public Integer getIdservconsultado() {
		return this.idservconsultado;
	}

	public void setIdservconsultado(Integer idservconsultado) {
		this.idservconsultado = idservconsultado;
	}

	public Integer getIdservsolicita() {
		return this.idservsolicita;
	}

	public void setIdservsolicita(Integer idservsolicita) {
		this.idservsolicita = idservsolicita;
	}

	public Integer getSala() {
		return this.sala;
	}

	public void setSala(Integer sala) {
		this.sala = sala;
	}

	public AtmEncuentroPaciente getAtmencuentrospaciente() {
		return this.atmencuentrospaciente;
	}

	public void setAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		this.atmencuentrospaciente = atmencuentrospaciente;
	}

}