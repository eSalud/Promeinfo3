package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the admusuarios database table.
 * 
 */
@Entity
@Table(name="admusuarios")
@NamedQuery(name="AdmUsuario.findAll", query="SELECT a FROM AdmUsuario a")
public class AdmUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idusuario;

	private String clave;

	private String estado;

	private Timestamp fechacreacion;

	private Timestamp fechamodificacion;

	private String usuario;

	private String usuariocreacion;

	private String usuariomodificion;

	//bi-directional many-to-one association to AdmPersonaSistema
	@ManyToOne
	@JoinColumn(name="idpersona")
	private AdmPersonaSistema admpersonassistema;

	//bi-directional many-to-one association to AdmRol
	@ManyToOne
	@JoinColumn(name="idrol")
	private AdmRol admrole;

	public AdmUsuario() {
	}

	public Long getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public Timestamp getFechamodificacion() {
		return this.fechamodificacion;
	}

	public void setFechamodificacion(Timestamp fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuariocreacion() {
		return this.usuariocreacion;
	}

	public void setUsuariocreacion(String usuariocreacion) {
		this.usuariocreacion = usuariocreacion;
	}

	public String getUsuariomodificion() {
		return this.usuariomodificion;
	}

	public void setUsuariomodificion(String usuariomodificion) {
		this.usuariomodificion = usuariomodificion;
	}

	public AdmPersonaSistema getAdmpersonassistema() {
		return this.admpersonassistema;
	}

	public void setAdmpersonassistema(AdmPersonaSistema admpersonassistema) {
		this.admpersonassistema = admpersonassistema;
	}

	public AdmRol getAdmrole() {
		return this.admrole;
	}

	public void setAdmrole(AdmRol admrole) {
		this.admrole = admrole;
	}

}