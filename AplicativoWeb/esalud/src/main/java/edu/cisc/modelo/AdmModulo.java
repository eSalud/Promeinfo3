package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the admmodulos database table.
 * 
 */
@Entity
@Table(name="admmodulos")
@NamedQuery(name="AdmModulo.findAll", query="SELECT a FROM AdmModulo a")
public class AdmModulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idmodulo;

	private String descripcion;

	private String estado;

	private Timestamp fechacreacion;

	private String modificable;

	private String nombre;

	private Integer orden;

	private String usuariocreacion;

	//bi-directional many-to-one association to AdmAplicacion
	@ManyToOne
	@JoinColumn(name="idaplicacion")
	private AdmAplicacion admaplicacione;

	//bi-directional many-to-one association to AdmModuloRol
	@OneToMany(mappedBy="admmodulo")
	private List<AdmModuloRol> admmodulosroles;

	public AdmModulo() {
	}

	public Long getIdmodulo() {
		return this.idmodulo;
	}

	public void setIdmodulo(Long idmodulo) {
		this.idmodulo = idmodulo;
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

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getUsuariocreacion() {
		return this.usuariocreacion;
	}

	public void setUsuariocreacion(String usuariocreacion) {
		this.usuariocreacion = usuariocreacion;
	}

	public AdmAplicacion getAdmaplicacione() {
		return this.admaplicacione;
	}

	public void setAdmaplicacione(AdmAplicacion admaplicacione) {
		this.admaplicacione = admaplicacione;
	}

	public List<AdmModuloRol> getAdmmodulosroles() {
		return this.admmodulosroles;
	}

	public void setAdmmodulosroles(List<AdmModuloRol> admmodulosroles) {
		this.admmodulosroles = admmodulosroles;
	}

	public AdmModuloRol addAdmmodulosrole(AdmModuloRol admmodulosrole) {
		getAdmmodulosroles().add(admmodulosrole);
		admmodulosrole.setAdmmodulo(this);

		return admmodulosrole;
	}

	public AdmModuloRol removeAdmmodulosrole(AdmModuloRol admmodulosrole) {
		getAdmmodulosroles().remove(admmodulosrole);
		admmodulosrole.setAdmmodulo(null);

		return admmodulosrole;
	}

}