package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the acttiposactividades database table.
 * 
 */
@Entity
@Table(name="acttiposactividades")
@NamedQuery(name="ActTipoActividad.findAll", query="SELECT a FROM ActTipoActividad a")
public class ActTipoActividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipoactividad;

	private String descripcion;

	//bi-directional many-to-one association to ActActividad
	@OneToMany(mappedBy="acttiposactividade")
	private List<ActActividad> actactividades;

	public ActTipoActividad() {
	}

	public Long getIdtipoactividad() {
		return this.idtipoactividad;
	}

	public void setIdtipoactividad(Long idtipoactividad) {
		this.idtipoactividad = idtipoactividad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ActActividad> getActactividades() {
		return this.actactividades;
	}

	public void setActactividades(List<ActActividad> actactividades) {
		this.actactividades = actactividades;
	}

	public ActActividad addActactividade(ActActividad actactividade) {
		getActactividades().add(actactividade);
		actactividade.setActtiposactividade(this);

		return actactividade;
	}

	public ActActividad removeActactividade(ActActividad actactividade) {
		getActactividades().remove(actactividade);
		actactividade.setActtiposactividade(null);

		return actactividade;
	}

}