package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ffaviviendafactores database table.
 * 
 */
@Entity
@Table(name="ffaviviendafactores")
@NamedQuery(name="FfaViviendaFactor.findAll", query="SELECT f FROM FfaViviendaFactor f")
public class FfaViviendaFactor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idviviendafactor;

	private String animalesconvivenc;

	private String animalesdomicilio;

	private String animalesenfermedad;

	private String contaminacionagua;

	private String contaminacionaire;

	private String contaminacionsuelo;

	private String estado;

	private String riesgococina;

	private String riesgofamilia;

	private String riesgomosquitero;

	private String riesgoplaguicidas;

	private String riesgoventana;

	//bi-directional many-to-one association to FfaVivienda
	@ManyToOne
	@JoinColumn(name="idvivienda")
	private FfaVivienda ffavivienda;

	public FfaViviendaFactor() {
	}

	public Long getIdviviendafactor() {
		return this.idviviendafactor;
	}

	public void setIdviviendafactor(Long idviviendafactor) {
		this.idviviendafactor = idviviendafactor;
	}

	public String getAnimalesconvivenc() {
		return this.animalesconvivenc;
	}

	public void setAnimalesconvivenc(String animalesconvivenc) {
		this.animalesconvivenc = animalesconvivenc;
	}

	public String getAnimalesdomicilio() {
		return this.animalesdomicilio;
	}

	public void setAnimalesdomicilio(String animalesdomicilio) {
		this.animalesdomicilio = animalesdomicilio;
	}

	public String getAnimalesenfermedad() {
		return this.animalesenfermedad;
	}

	public void setAnimalesenfermedad(String animalesenfermedad) {
		this.animalesenfermedad = animalesenfermedad;
	}

	public String getContaminacionagua() {
		return this.contaminacionagua;
	}

	public void setContaminacionagua(String contaminacionagua) {
		this.contaminacionagua = contaminacionagua;
	}

	public String getContaminacionaire() {
		return this.contaminacionaire;
	}

	public void setContaminacionaire(String contaminacionaire) {
		this.contaminacionaire = contaminacionaire;
	}

	public String getContaminacionsuelo() {
		return this.contaminacionsuelo;
	}

	public void setContaminacionsuelo(String contaminacionsuelo) {
		this.contaminacionsuelo = contaminacionsuelo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRiesgococina() {
		return this.riesgococina;
	}

	public void setRiesgococina(String riesgococina) {
		this.riesgococina = riesgococina;
	}

	public String getRiesgofamilia() {
		return this.riesgofamilia;
	}

	public void setRiesgofamilia(String riesgofamilia) {
		this.riesgofamilia = riesgofamilia;
	}

	public String getRiesgomosquitero() {
		return this.riesgomosquitero;
	}

	public void setRiesgomosquitero(String riesgomosquitero) {
		this.riesgomosquitero = riesgomosquitero;
	}

	public String getRiesgoplaguicidas() {
		return this.riesgoplaguicidas;
	}

	public void setRiesgoplaguicidas(String riesgoplaguicidas) {
		this.riesgoplaguicidas = riesgoplaguicidas;
	}

	public String getRiesgoventana() {
		return this.riesgoventana;
	}

	public void setRiesgoventana(String riesgoventana) {
		this.riesgoventana = riesgoventana;
	}

	public FfaVivienda getFfavivienda() {
		return this.ffavivienda;
	}

	public void setFfavivienda(FfaVivienda ffavivienda) {
		this.ffavivienda = ffavivienda;
	}

}