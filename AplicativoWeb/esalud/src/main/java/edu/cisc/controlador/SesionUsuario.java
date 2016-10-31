package edu.cisc.controlador;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

@Component(value="sesionUsuario")
@SessionScoped
public class SesionUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String idRol;
	private Date fechaLogin;
	private String nameRol;
	private String nameUser;
	private String idSexo;
	private String ipRemota;
	private Boolean sesion;
	private String idPersona;
	
	public SesionUsuario() {
		super();
	}	
	
	public SesionUsuario(String usuario, String idRol, Date fechaLogin, String nameRol, String nameUser, String idSexo, String ipRemota, Boolean sesion, String idPersona) {
		super();
		this.usuario = usuario;
		this.idRol = idRol;
		this.fechaLogin = fechaLogin;
		this.nameRol = nameRol;
		this.nameUser = nameUser;
		this.idSexo = idSexo;
		this.ipRemota = ipRemota;
		this.sesion = sesion;
		this.idPersona = idPersona;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getIdRol() {
		return idRol;
	}
	public void setIdRol(String idRol) {
		this.idRol = idRol;
	}
	public Date getFechaLogin() {
		return fechaLogin;
	}
	public void setFechaLogin(Date fechaLogin) {
		this.fechaLogin = fechaLogin;
	}

	public String getNameRol() {
		return nameRol;
	}

	public void setNameRol(String nameRol) {
		this.nameRol = nameRol;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getIdSexo() {
		return idSexo;
	}
	
	public void setIdSexo(String idSexo) {
		this.idSexo = idSexo;
	}

	public String getIpRemota() {
		return ipRemota;
	}

	public void setIpRemota(String ipRemota) {
		this.ipRemota = ipRemota;
	}

	public Boolean getSesion() {
		return sesion;
	}

	public void setSesion(Boolean sesion) {
		this.sesion = sesion;
	}

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	
}
