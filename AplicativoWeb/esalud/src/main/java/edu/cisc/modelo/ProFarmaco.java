package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the profarmacos database table.
 * 
 */
@Entity
@Table(name="profarmacos")
@NamedQuery(name="ProFarmaco.findAll", query="SELECT p FROM ProFarmaco p")
public class ProFarmaco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idfarmaco;

	private String codfarmaco;

	private String concentracion;

	private Integer idgrupoterapeutico;

	private String indicaciones;

	private String nombrecomercial;

	private String nombregenerico;

	private String presentacion;

	public ProFarmaco() {
	}

	public Long getIdfarmaco() {
		return this.idfarmaco;
	}

	public void setIdfarmaco(Long idfarmaco) {
		this.idfarmaco = idfarmaco;
	}

	public String getCodfarmaco() {
		return this.codfarmaco;
	}

	public void setCodfarmaco(String codfarmaco) {
		this.codfarmaco = codfarmaco;
	}

	public String getConcentracion() {
		return this.concentracion;
	}

	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}

	public Integer getIdgrupoterapeutico() {
		return this.idgrupoterapeutico;
	}

	public void setIdgrupoterapeutico(Integer idgrupoterapeutico) {
		this.idgrupoterapeutico = idgrupoterapeutico;
	}

	public String getIndicaciones() {
		return this.indicaciones;
	}

	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}

	public String getNombrecomercial() {
		return this.nombrecomercial;
	}

	public void setNombrecomercial(String nombrecomercial) {
		this.nombrecomercial = nombrecomercial;
	}

	public String getNombregenerico() {
		return this.nombregenerico;
	}

	public void setNombregenerico(String nombregenerico) {
		this.nombregenerico = nombregenerico;
	}

	public String getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

}