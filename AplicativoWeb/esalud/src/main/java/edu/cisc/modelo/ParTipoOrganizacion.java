package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the partipoorganizacion database table.
 * 
 */
@Entity
@NamedQuery(name="ParTipoOrganizacion.findAll", query="SELECT p FROM ParTipoOrganizacion p")
public class ParTipoOrganizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipoorganizacion;

	private String descripcion;

	//bi-directional many-to-one association to ParOrganizacion
	@OneToMany(mappedBy="partipoorganizacion")
	private List<ParOrganizacion> parorganizaciones;

	public ParTipoOrganizacion() {
	}

	public Long getIdtipoorganizacion() {
		return this.idtipoorganizacion;
	}

	public void setIdtipoorganizacion(Long idtipoorganizacion) {
		this.idtipoorganizacion = idtipoorganizacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ParOrganizacion> getParorganizaciones() {
		return this.parorganizaciones;
	}

	public void setParorganizaciones(List<ParOrganizacion> parorganizaciones) {
		this.parorganizaciones = parorganizaciones;
	}

	public ParOrganizacion addParorganizacione(ParOrganizacion parorganizacione) {
		getParorganizaciones().add(parorganizacione);
		parorganizacione.setPartipoorganizacion(this);

		return parorganizacione;
	}

	public ParOrganizacion removeParorganizacione(ParOrganizacion parorganizacione) {
		getParorganizaciones().remove(parorganizacione);
		parorganizacione.setPartipoorganizacion(null);

		return parorganizacione;
	}

}