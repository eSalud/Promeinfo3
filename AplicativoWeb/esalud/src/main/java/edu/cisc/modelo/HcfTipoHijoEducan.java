package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hcftiposhijoseducan database table.
 * 
 */
@Entity
@Table(name="hcftiposhijoseducan")
@NamedQuery(name="HcfTipoHijoEducan.findAll", query="SELECT h FROM HcfTipoHijoEducan h")
public class HcfTipoHijoEducan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipojefeeducan;

	private String descripcion;

	private String estado;

	public HcfTipoHijoEducan() {
	}

	public Long getIdtipojefeeducan() {
		return this.idtipojefeeducan;
	}

	public void setIdtipojefeeducan(Long idtipojefeeducan) {
		this.idtipojefeeducan = idtipojefeeducan;
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