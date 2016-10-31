package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the partiposprofesionalessalud database table.
 * 
 */
@Entity
@Table(name="partiposprofesionalessalud")
@NamedQuery(name="ParTipoProfesionalSalud.findAll", query="SELECT p FROM ParTipoProfesionalSalud p")
public class ParTipoProfesionalSalud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipoprofsalud;

	private String descripcion;

	//bi-directional many-to-one association to ParProfesionalSalud
	@OneToMany(mappedBy="partiposprofesionalessalud")
	private List<ParProfesionalSalud> parprofesionalsaluds;

	public ParTipoProfesionalSalud() {
	}

	public Long getIdtipoprofsalud() {
		return this.idtipoprofsalud;
	}

	public void setIdtipoprofsalud(Long idtipoprofsalud) {
		this.idtipoprofsalud = idtipoprofsalud;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ParProfesionalSalud> getParprofesionalsaluds() {
		return this.parprofesionalsaluds;
	}

	public void setParprofesionalsaluds(List<ParProfesionalSalud> parprofesionalsaluds) {
		this.parprofesionalsaluds = parprofesionalsaluds;
	}

	public ParProfesionalSalud addParprofesionalsalud(ParProfesionalSalud parprofesionalsalud) {
		getParprofesionalsaluds().add(parprofesionalsalud);
		parprofesionalsalud.setPartiposprofesionalessalud(this);

		return parprofesionalsalud;
	}

	public ParProfesionalSalud removeParprofesionalsalud(ParProfesionalSalud parprofesionalsalud) {
		getParprofesionalsaluds().remove(parprofesionalsalud);
		parprofesionalsalud.setPartiposprofesionalessalud(null);

		return parprofesionalsalud;
	}

}