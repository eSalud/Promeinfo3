package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hcfriesgosanitariositem database table.
 * 
 */
@Entity
@Table(name="hcfriesgosanitariositem")
@NamedQuery(name="HcfRiesgoSanitarioItem.findAll", query="SELECT h FROM HcfRiesgoSanitarioItem h")
public class HcfRiesgoSanitarioItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idriesgosanit;

	private String descripcion;

	private String estado;

	public HcfRiesgoSanitarioItem() {
	}

	public Long getIdriesgosanit() {
		return this.idriesgosanit;
	}

	public void setIdriesgosanit(Long idriesgosanit) {
		this.idriesgosanit = idriesgosanit;
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

}