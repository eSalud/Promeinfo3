package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hcftipospersonasdormitorio database table.
 * 
 */
@Entity
@Table(name="hcftipospersonasdormitorio")
@NamedQuery(name="HcfTipoPersonaDormitorio.findAll", query="SELECT h FROM HcfTipoPersonaDormitorio h")
public class HcfTipoPersonaDormitorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipopersdorm;

	private String descripcion;

	private String estado;

	public HcfTipoPersonaDormitorio() {
	}

	public Long getIdtipopersdorm() {
		return this.idtipopersdorm;
	}

	public void setIdtipopersdorm(Long idtipopersdorm) {
		this.idtipopersdorm = idtipopersdorm;
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