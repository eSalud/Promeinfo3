package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parorganizaciones database table.
 * 
 */
@Entity
@Table(name="parorganizaciones")
@NamedQuery(name="ParOrganizacion.findAll", query="SELECT p FROM ParOrganizacion p")
public class ParOrganizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idorganizacion;

	private Integer idtipoprovsalud;

	private String indorgasegurada;

	private String indorginterna;

	private String indorgreguladora;

	private String indproveedorsalud;

	private String nombre;

	//bi-directional many-to-one association to ParFacilidad
	@OneToMany(mappedBy="parorganizacione")
	private List<ParFacilidad> parfacilidades;

	//bi-directional many-to-one association to ParOrganizacion
	@ManyToOne
	@JoinColumn(name="idorgpadre")
	private ParOrganizacion parorganizacione;

	//bi-directional many-to-one association to ParOrganizacion
	@OneToMany(mappedBy="parorganizacione")
	private List<ParOrganizacion> parorganizaciones;

	//bi-directional many-to-one association to ParTipoOrganizacion
	@ManyToOne
	@JoinColumn(name="idtipoorganizacion")
	private ParTipoOrganizacion partipoorganizacion;

	public ParOrganizacion() {
	}

	public Long getIdorganizacion() {
		return this.idorganizacion;
	}

	public void setIdorganizacion(Long idorganizacion) {
		this.idorganizacion = idorganizacion;
	}

	public Integer getIdtipoprovsalud() {
		return this.idtipoprovsalud;
	}

	public void setIdtipoprovsalud(Integer idtipoprovsalud) {
		this.idtipoprovsalud = idtipoprovsalud;
	}

	public String getIndorgasegurada() {
		return this.indorgasegurada;
	}

	public void setIndorgasegurada(String indorgasegurada) {
		this.indorgasegurada = indorgasegurada;
	}

	public String getIndorginterna() {
		return this.indorginterna;
	}

	public void setIndorginterna(String indorginterna) {
		this.indorginterna = indorginterna;
	}

	public String getIndorgreguladora() {
		return this.indorgreguladora;
	}

	public void setIndorgreguladora(String indorgreguladora) {
		this.indorgreguladora = indorgreguladora;
	}

	public String getIndproveedorsalud() {
		return this.indproveedorsalud;
	}

	public void setIndproveedorsalud(String indproveedorsalud) {
		this.indproveedorsalud = indproveedorsalud;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ParFacilidad> getParfacilidades() {
		return this.parfacilidades;
	}

	public void setParfacilidades(List<ParFacilidad> parfacilidades) {
		this.parfacilidades = parfacilidades;
	}

	public ParFacilidad addParfacilidade(ParFacilidad parfacilidade) {
		getParfacilidades().add(parfacilidade);
		parfacilidade.setParorganizacione(this);

		return parfacilidade;
	}

	public ParFacilidad removeParfacilidade(ParFacilidad parfacilidade) {
		getParfacilidades().remove(parfacilidade);
		parfacilidade.setParorganizacione(null);

		return parfacilidade;
	}

	public ParOrganizacion getParorganizacione() {
		return this.parorganizacione;
	}

	public void setParorganizacione(ParOrganizacion parorganizacione) {
		this.parorganizacione = parorganizacione;
	}

	public List<ParOrganizacion> getParorganizaciones() {
		return this.parorganizaciones;
	}

	public void setParorganizaciones(List<ParOrganizacion> parorganizaciones) {
		this.parorganizaciones = parorganizaciones;
	}

	public ParOrganizacion addParorganizacione(ParOrganizacion parorganizacione) {
		getParorganizaciones().add(parorganizacione);
		parorganizacione.setParorganizacione(this);

		return parorganizacione;
	}

	public ParOrganizacion removeParorganizacione(ParOrganizacion parorganizacione) {
		getParorganizaciones().remove(parorganizacione);
		parorganizacione.setParorganizacione(null);

		return parorganizacione;
	}

	public ParTipoOrganizacion getPartipoorganizacion() {
		return this.partipoorganizacion;
	}

	public void setPartipoorganizacion(ParTipoOrganizacion partipoorganizacion) {
		this.partipoorganizacion = partipoorganizacion;
	}

}