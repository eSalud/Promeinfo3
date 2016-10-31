package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atmcancerubica database table.
 * 
 */
@Entity
@NamedQuery(name="AtmCancerUbica.findAll", query="SELECT a FROM AtmCancerUbica a")
public class AtmCancerUbica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcancerub;

	private String codcancer;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to AtmCancer
	@OneToMany(mappedBy="atmcancerubica")
	private List<AtmCancer> atmcancers;

	public AtmCancerUbica() {
	}

	public Long getIdcancerub() {
		return this.idcancerub;
	}

	public void setIdcancerub(Long idcancerub) {
		this.idcancerub = idcancerub;
	}

	public String getCodcancer() {
		return this.codcancer;
	}

	public void setCodcancer(String codcancer) {
		this.codcancer = codcancer;
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

	public List<AtmCancer> getAtmcancers() {
		return this.atmcancers;
	}

	public void setAtmcancers(List<AtmCancer> atmcancers) {
		this.atmcancers = atmcancers;
	}

	public AtmCancer addAtmcancer(AtmCancer atmcancer) {
		getAtmcancers().add(atmcancer);
		atmcancer.setAtmcancerubica(this);

		return atmcancer;
	}

	public AtmCancer removeAtmcancer(AtmCancer atmcancer) {
		getAtmcancers().remove(atmcancer);
		atmcancer.setAtmcancerubica(null);

		return atmcancer;
	}

}