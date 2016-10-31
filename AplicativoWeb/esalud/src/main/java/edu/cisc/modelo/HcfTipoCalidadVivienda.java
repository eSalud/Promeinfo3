package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hcftiposcalidadvivienda database table.
 * 
 */
@Entity
@Table(name="hcftiposcalidadvivienda")
@NamedQuery(name="HcfTipoCalidadVivienda.findAll", query="SELECT h FROM HcfTipoCalidadVivienda h")
public class HcfTipoCalidadVivienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipocalvivienda;

	private String descripcion;

	private String estado;

	public HcfTipoCalidadVivienda() {
	}

	public Long getIdtipocalvivienda() {
		return this.idtipocalvivienda;
	}

	public void setIdtipocalvivienda(Long idtipocalvivienda) {
		this.idtipocalvivienda = idtipocalvivienda;
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