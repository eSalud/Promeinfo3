package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ffacondicionocupacional database table.
 * 
 */
@Entity
@NamedQuery(name="FfaCondicionOcupacional.findAll", query="SELECT f FROM FfaCondicionOcupacional f")
public class FfaCondicionOcupacional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcondicionocupac;

	private String desocupada;

	private String estado;

	private String ocupada;

	private String otra;

	private String temporal;

	//bi-directional many-to-one association to FfaVivienda
	@ManyToOne
	@JoinColumn(name="idvivienda")
	private FfaVivienda ffavivienda;

	public FfaCondicionOcupacional() {
	}

	public Long getIdcondicionocupac() {
		return this.idcondicionocupac;
	}

	public void setIdcondicionocupac(Long idcondicionocupac) {
		this.idcondicionocupac = idcondicionocupac;
	}

	public String getDesocupada() {
		return this.desocupada;
	}

	public void setDesocupada(String desocupada) {
		this.desocupada = desocupada;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getOcupada() {
		return this.ocupada;
	}

	public void setOcupada(String ocupada) {
		this.ocupada = ocupada;
	}

	public String getOtra() {
		return this.otra;
	}

	public void setOtra(String otra) {
		this.otra = otra;
	}

	public String getTemporal() {
		return this.temporal;
	}

	public void setTemporal(String temporal) {
		this.temporal = temporal;
	}

	public FfaVivienda getFfavivienda() {
		return this.ffavivienda;
	}

	public void setFfavivienda(FfaVivienda ffavivienda) {
		this.ffavivienda = ffavivienda;
	}

}