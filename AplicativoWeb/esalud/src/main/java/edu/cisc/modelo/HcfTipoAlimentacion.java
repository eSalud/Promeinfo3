package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hcftiposalimentacion database table.
 * 
 */
@Entity
@Table(name="hcftiposalimentacion")
@NamedQuery(name="HcfTipoAlimentacion.findAll", query="SELECT h FROM HcfTipoAlimentacion h")
public class HcfTipoAlimentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipoalimentacion;

	private String descripcion;

	private String estado;

	public HcfTipoAlimentacion() {
	}

	public Long getIdtipoalimentacion() {
		return this.idtipoalimentacion;
	}

	public void setIdtipoalimentacion(Long idtipoalimentacion) {
		this.idtipoalimentacion = idtipoalimentacion;
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