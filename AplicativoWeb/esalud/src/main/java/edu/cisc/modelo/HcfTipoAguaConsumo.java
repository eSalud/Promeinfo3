package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hcftiposaguaconsumo database table.
 * 
 */
@Entity
@Table(name="hcftiposaguaconsumo")
@NamedQuery(name="HcfTipoAguaConsumo.findAll", query="SELECT h FROM HcfTipoAguaConsumo h")
public class HcfTipoAguaConsumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipoaguacons;

	private String descripcion;

	private String estado;

	public HcfTipoAguaConsumo() {
	}

	public Long getIdtipoaguacons() {
		return this.idtipoaguacons;
	}

	public void setIdtipoaguacons(Long idtipoaguacons) {
		this.idtipoaguacons = idtipoaguacons;
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