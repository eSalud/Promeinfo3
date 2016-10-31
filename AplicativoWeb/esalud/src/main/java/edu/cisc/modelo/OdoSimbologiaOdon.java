package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the odosimbologiaodon database table.
 * 
 */
@Entity
@NamedQuery(name="OdoSimbologiaOdon.findAll", query="SELECT o FROM OdoSimbologiaOdon o")
public class OdoSimbologiaOdon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idsimbologia;

	private String descripcion;

	private String estado;

	private String imagen;

	public OdoSimbologiaOdon() {
	}

	public Long getIdsimbologia() {
		return this.idsimbologia;
	}

	public void setIdsimbologia(Long idsimbologia) {
		this.idsimbologia = idsimbologia;
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

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}