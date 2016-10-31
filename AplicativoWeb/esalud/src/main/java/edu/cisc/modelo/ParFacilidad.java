package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parfacilidades database table.
 * 
 */
@Entity
@Table(name="parfacilidades")
@NamedQuery(name="ParFacilidad.findAll", query="SELECT p FROM ParFacilidad p")
public class ParFacilidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idfacilidad;

	private String descripcion;

	private Integer idtipofacilidad;

	//bi-directional many-to-one association to AtmEncuentroPaciente
	@OneToMany(mappedBy="parfacilidade")
	private List<AtmEncuentroPaciente> atmencuentrospacientes;

	//bi-directional many-to-one association to ParFacilidad
	@ManyToOne
	@JoinColumn(name="idfacilidadrec")
	private ParFacilidad parfacilidade;

	//bi-directional many-to-one association to ParFacilidad
	@OneToMany(mappedBy="parfacilidade")
	private List<ParFacilidad> parfacilidades;

	//bi-directional many-to-one association to ParOrganizacion
	@ManyToOne
	@JoinColumn(name="idorganizacion")
	private ParOrganizacion parorganizacione;

	public ParFacilidad() {
	}

	public Long getIdfacilidad() {
		return this.idfacilidad;
	}

	public void setIdfacilidad(Long idfacilidad) {
		this.idfacilidad = idfacilidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdtipofacilidad() {
		return this.idtipofacilidad;
	}

	public void setIdtipofacilidad(Integer idtipofacilidad) {
		this.idtipofacilidad = idtipofacilidad;
	}

	public List<AtmEncuentroPaciente> getAtmencuentrospacientes() {
		return this.atmencuentrospacientes;
	}

	public void setAtmencuentrospacientes(List<AtmEncuentroPaciente> atmencuentrospacientes) {
		this.atmencuentrospacientes = atmencuentrospacientes;
	}

	public AtmEncuentroPaciente addAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		getAtmencuentrospacientes().add(atmencuentrospaciente);
		atmencuentrospaciente.setParfacilidade(this);

		return atmencuentrospaciente;
	}

	public AtmEncuentroPaciente removeAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		getAtmencuentrospacientes().remove(atmencuentrospaciente);
		atmencuentrospaciente.setParfacilidade(null);

		return atmencuentrospaciente;
	}

	public ParFacilidad getParfacilidade() {
		return this.parfacilidade;
	}

	public void setParfacilidade(ParFacilidad parfacilidade) {
		this.parfacilidade = parfacilidade;
	}

	public List<ParFacilidad> getParfacilidades() {
		return this.parfacilidades;
	}

	public void setParfacilidades(List<ParFacilidad> parfacilidades) {
		this.parfacilidades = parfacilidades;
	}

	public ParFacilidad addParfacilidade(ParFacilidad parfacilidade) {
		getParfacilidades().add(parfacilidade);
		parfacilidade.setParfacilidade(this);

		return parfacilidade;
	}

	public ParFacilidad removeParfacilidade(ParFacilidad parfacilidade) {
		getParfacilidades().remove(parfacilidade);
		parfacilidade.setParfacilidade(null);

		return parfacilidade;
	}

	public ParOrganizacion getParorganizacione() {
		return this.parorganizacione;
	}

	public void setParorganizacione(ParOrganizacion parorganizacione) {
		this.parorganizacione = parorganizacione;
	}

}