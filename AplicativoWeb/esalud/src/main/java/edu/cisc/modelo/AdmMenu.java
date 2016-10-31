package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the admmenus database table.
 * 
 */
@Entity
@Table(name="admmenus")
@NamedQuery(name="AdmMenu.findAll", query="SELECT a FROM AdmMenu a")
public class AdmMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idmenu;

	private String descripcion;

	private String estado;

	private Timestamp fechacreacion;

	private String icono;

	private Integer idmenupadre;

	private Integer nivel;

	private String nombre;

	private Integer orden;

	private String urldestino;

	private String usuariocreacion;

	//bi-directional many-to-one association to AdmModuloRol
	@OneToMany(mappedBy="admmenus")
	private List<AdmModuloRol> admmodulosroles;

	public AdmMenu() {
	}

	public Long getIdmenu() {
		return this.idmenu;
	}

	public void setIdmenu(Long idmenu) {
		this.idmenu = idmenu;
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

	public String getIcono() {
		return this.icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public Integer getIdmenupadre() {
		return this.idmenupadre;
	}

	public void setIdmenupadre(Integer idmenupadre) {
		this.idmenupadre = idmenupadre;
	}

	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getUrldestino() {
		return this.urldestino;
	}

	public void setUrldestino(String urldestino) {
		this.urldestino = urldestino;
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
		admmodulosrole.setAdmmenus(this);

		return admmodulosrole;
	}

	public AdmModuloRol removeAdmmodulosrole(AdmModuloRol admmodulosrole) {
		getAdmmodulosroles().remove(admmodulosrole);
		admmodulosrole.setAdmmenus(null);

		return admmodulosrole;
	}

}