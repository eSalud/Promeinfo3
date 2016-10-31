package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the admmodulosroles database table.
 * 
 */
@Entity
@Table(name="admmodulosroles")
@NamedQuery(name="AdmModuloRol.findAll", query="SELECT a FROM AdmModuloRol a")
public class AdmModuloRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idmodulorol;

	//bi-directional many-to-one association to AdmMenu
	@ManyToOne
	@JoinColumn(name="idmenu")
	private AdmMenu admmenus;

	//bi-directional many-to-one association to AdmModulo
	@ManyToOne
	@JoinColumn(name="idmodulo")
	private AdmModulo admmodulo;

	//bi-directional many-to-one association to AdmRol
	@ManyToOne
	@JoinColumn(name="idrol")
	private AdmRol admrole;

	public AdmModuloRol() {
	}

	public Long getIdmodulorol() {
		return this.idmodulorol;
	}

	public void setIdmodulorol(Long idmodulorol) {
		this.idmodulorol = idmodulorol;
	}

	public AdmMenu getAdmmenus() {
		return this.admmenus;
	}

	public void setAdmmenus(AdmMenu admmenus) {
		this.admmenus = admmenus;
	}

	public AdmModulo getAdmmodulo() {
		return this.admmodulo;
	}

	public void setAdmmodulo(AdmModulo admmodulo) {
		this.admmodulo = admmodulo;
	}

	public AdmRol getAdmrole() {
		return this.admrole;
	}

	public void setAdmrole(AdmRol admrole) {
		this.admrole = admrole;
	}

}