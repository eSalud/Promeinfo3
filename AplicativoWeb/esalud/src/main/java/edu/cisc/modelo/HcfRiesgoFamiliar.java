package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hcfriesgofamiliar database table.
 * 
 */
@Entity
@NamedQuery(name="HcfRiesgoFamiliar.findAll", query="SELECT h FROM HcfRiesgoFamiliar h")
public class HcfRiesgoFamiliar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idriesgofamiliar;

	private Integer adultosmayores;

	private Integer alcoholismo;

	private Integer desorgfamiliar;

	private Integer discapacitados;

	private Integer drogadiccion;

	private Integer enfermoscronicos;

	private String estado;

	private Integer juegosazar;

	private Integer migracion;

	private Integer otros;

	private Integer prostitucion;

	private Integer tabaquismo;

	private Integer violencia;

	//bi-directional many-to-one association to HcfPrincipal
	@ManyToOne
	@JoinColumn(name="idcab")
	private HcfPrincipal hcfprincipal;

	public HcfRiesgoFamiliar() {
	}

	public Long getIdriesgofamiliar() {
		return this.idriesgofamiliar;
	}

	public void setIdriesgofamiliar(Long idriesgofamiliar) {
		this.idriesgofamiliar = idriesgofamiliar;
	}

	public Integer getAdultosmayores() {
		return this.adultosmayores;
	}

	public void setAdultosmayores(Integer adultosmayores) {
		this.adultosmayores = adultosmayores;
	}

	public Integer getAlcoholismo() {
		return this.alcoholismo;
	}

	public void setAlcoholismo(Integer alcoholismo) {
		this.alcoholismo = alcoholismo;
	}

	public Integer getDesorgfamiliar() {
		return this.desorgfamiliar;
	}

	public void setDesorgfamiliar(Integer desorgfamiliar) {
		this.desorgfamiliar = desorgfamiliar;
	}

	public Integer getDiscapacitados() {
		return this.discapacitados;
	}

	public void setDiscapacitados(Integer discapacitados) {
		this.discapacitados = discapacitados;
	}

	public Integer getDrogadiccion() {
		return this.drogadiccion;
	}

	public void setDrogadiccion(Integer drogadiccion) {
		this.drogadiccion = drogadiccion;
	}

	public Integer getEnfermoscronicos() {
		return this.enfermoscronicos;
	}

	public void setEnfermoscronicos(Integer enfermoscronicos) {
		this.enfermoscronicos = enfermoscronicos;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getJuegosazar() {
		return this.juegosazar;
	}

	public void setJuegosazar(Integer juegosazar) {
		this.juegosazar = juegosazar;
	}

	public Integer getMigracion() {
		return this.migracion;
	}

	public void setMigracion(Integer migracion) {
		this.migracion = migracion;
	}

	public Integer getOtros() {
		return this.otros;
	}

	public void setOtros(Integer otros) {
		this.otros = otros;
	}

	public Integer getProstitucion() {
		return this.prostitucion;
	}

	public void setProstitucion(Integer prostitucion) {
		this.prostitucion = prostitucion;
	}

	public Integer getTabaquismo() {
		return this.tabaquismo;
	}

	public void setTabaquismo(Integer tabaquismo) {
		this.tabaquismo = tabaquismo;
	}

	public Integer getViolencia() {
		return this.violencia;
	}

	public void setViolencia(Integer violencia) {
		this.violencia = violencia;
	}

	public HcfPrincipal getHcfprincipal() {
		return this.hcfprincipal;
	}

	public void setHcfprincipal(HcfPrincipal hcfprincipal) {
		this.hcfprincipal = hcfprincipal;
	}

}