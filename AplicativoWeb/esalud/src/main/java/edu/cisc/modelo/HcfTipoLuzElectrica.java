package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hcftiposluzelectrica database table.
 * 
 */
@Entity
@Table(name="hcftiposluzelectrica")
@NamedQuery(name="HcfTipoLuzElectrica.findAll", query="SELECT h FROM HcfTipoLuzElectrica h")
public class HcfTipoLuzElectrica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipoluzelect;

	private String descripcion;

	private String estado;

	public HcfTipoLuzElectrica() {
	}

	public Long getIdtipoluzelect() {
		return this.idtipoluzelect;
	}

	public void setIdtipoluzelect(Long idtipoluzelect) {
		this.idtipoluzelect = idtipoluzelect;
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