package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ffaintervenciones database table.
 * 
 */
@Entity
@Table(name="ffaintervenciones")
@NamedQuery(name="FfaIntervencion.findAll", query="SELECT f FROM FfaIntervencion f")
public class FfaIntervencion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idintervenciones;

	private String causas;

	private String codcumple;

	private String codresultado;

	private String compromisos;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechaintervencion;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@ManyToOne
	@JoinColumn(name="idpersona")
	private FfaPersonaFichaFamiliar ffapersonasfichafamiliar;

	public FfaIntervencion() {
	}

	public Long getIdintervenciones() {
		return this.idintervenciones;
	}

	public void setIdintervenciones(Long idintervenciones) {
		this.idintervenciones = idintervenciones;
	}

	public String getCausas() {
		return this.causas;
	}

	public void setCausas(String causas) {
		this.causas = causas;
	}

	public String getCodcumple() {
		return this.codcumple;
	}

	public void setCodcumple(String codcumple) {
		this.codcumple = codcumple;
	}

	public String getCodresultado() {
		return this.codresultado;
	}

	public void setCodresultado(String codresultado) {
		this.codresultado = codresultado;
	}

	public String getCompromisos() {
		return this.compromisos;
	}

	public void setCompromisos(String compromisos) {
		this.compromisos = compromisos;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaintervencion() {
		return this.fechaintervencion;
	}

	public void setFechaintervencion(Date fechaintervencion) {
		this.fechaintervencion = fechaintervencion;
	}

	public FfaPersonaFichaFamiliar getFfapersonasfichafamiliar() {
		return this.ffapersonasfichafamiliar;
	}

	public void setFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		this.ffapersonasfichafamiliar = ffapersonasfichafamiliar;
	}

}