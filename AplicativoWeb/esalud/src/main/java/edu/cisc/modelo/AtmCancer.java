package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atmcancer database table.
 * 
 */
@Entity
@NamedQuery(name="AtmCancer.findAll", query="SELECT a FROM AtmCancer a")
public class AtmCancer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcancer;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to AtmCancerUbica
	@ManyToOne
	@JoinColumn(name="idcancerub")
	private AtmCancerUbica atmcancerubica;

	//bi-directional many-to-one association to AtmVisitaHCU
	@ManyToOne
	@JoinColumn(name="idvisita")
	private AtmVisitaHCU atmvisitashcu;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	public AtmCancer() {
	}

	public Long getIdcancer() {
		return this.idcancer;
	}

	public void setIdcancer(Long idcancer) {
		this.idcancer = idcancer;
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

	public AtmCancerUbica getAtmcancerubica() {
		return this.atmcancerubica;
	}

	public void setAtmcancerubica(AtmCancerUbica atmcancerubica) {
		this.atmcancerubica = atmcancerubica;
	}

	public AtmVisitaHCU getAtmvisitashcu() {
		return this.atmvisitashcu;
	}

	public void setAtmvisitashcu(AtmVisitaHCU atmvisitashcu) {
		this.atmvisitashcu = atmvisitashcu;
	}

	public ParPaciente getParpaciente() {
		return this.parpaciente;
	}

	public void setParpaciente(ParPaciente parpaciente) {
		this.parpaciente = parpaciente;
	}

}