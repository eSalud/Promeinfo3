package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the parpersonasatmaplicacion database table.
 * 
 */
@Entity
@Table(name="parpersonasatmaplicacion")
@NamedQuery(name="ParPersonaAtmAplicacion.findAll", query="SELECT p FROM ParPersonaAtmAplicacion p")
public class ParPersonaAtmAplicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpersonaapp;

	private String estado;

	private Timestamp fechacreacion;

	private Integer idaplicacion;

	private Integer idpersona;

	private Integer idusuario;

	private Integer perfil;

	private String tipopersona;

	public ParPersonaAtmAplicacion() {
	}

	public Long getIdpersonaapp() {
		return this.idpersonaapp;
	}

	public void setIdpersonaapp(Long idpersonaapp) {
		this.idpersonaapp = idpersonaapp;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Timestamp fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Integer getIdaplicacion() {
		return this.idaplicacion;
	}

	public void setIdaplicacion(Integer idaplicacion) {
		this.idaplicacion = idaplicacion;
	}

	public Integer getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}

	public String getTipopersona() {
		return this.tipopersona;
	}

	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}

}