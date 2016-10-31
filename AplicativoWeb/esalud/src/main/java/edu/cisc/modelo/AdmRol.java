package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the admroles database table.
 * 
 */
@Entity
@Table(name="admroles")
@NamedQuery(name="AdmRol.findAll", query="SELECT a FROM AdmRol a")
public class AdmRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idrol;

	private String descripcion;

	private String estado;

	private Timestamp fechacreacion;

	private String modificable;

	private String nombre;

	private String usuariocreacion;

	//bi-directional many-to-one association to AdmModuloRol
	@OneToMany(mappedBy="admrole")
	private List<AdmModuloRol> admmodulosroles;

	//bi-directional many-to-one association to AdmUsuario
	@OneToMany(mappedBy="admrole")
	private List<AdmUsuario> admusuarios;

	public AdmRol() {
	}

	public Long getIdrol() {
		return this.idrol;
	}

	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getModificable() {
		return this.modificable;
	}

	public void setModificable(String modificable) {
		this.modificable = modificable;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuariocreacion() {
		return this.usuariocreacion;
	}

	public void setUsuariocreacion(String usuariocreacion) {
		this.usuariocreacion = usuariocreacion;
	}

	public List<AdmModuloRol> getAdmmodulosroles() {
		return this.admmodulosroles;
	}

	public void setAdmmodulosroles(List<AdmModuloRol> admmodulosroles) {
		this.admmodulosroles = admmodulosroles;
	}

	public AdmModuloRol addAdmmodulosrole(AdmModuloRol admmodulosrole) {
		getAdmmodulosroles().add(admmodulosrole);
		admmodulosrole.setAdmrole(this);

		return admmodulosrole;
	}

	public AdmModuloRol removeAdmmodulosrole(AdmModuloRol admmodulosrole) {
		getAdmmodulosroles().remove(admmodulosrole);
		admmodulosrole.setAdmrole(null);

		return admmodulosrole;
	}

	public List<AdmUsuario> getAdmusuarios() {
		return this.admusuarios;
	}

	public void setAdmusuarios(List<AdmUsuario> admusuarios) {
		this.admusuarios = admusuarios;
	}

	public AdmUsuario addAdmusuario(AdmUsuario admusuario) {
		getAdmusuarios().add(admusuario);
		admusuario.setAdmrole(this);

		return admusuario;
	}

	public AdmUsuario removeAdmusuario(AdmUsuario admusuario) {
		getAdmusuarios().remove(admusuario);
		admusuario.setAdmrole(null);

		return admusuario;
	}

}