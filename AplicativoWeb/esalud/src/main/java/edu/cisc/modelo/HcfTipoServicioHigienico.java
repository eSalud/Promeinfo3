package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hcftiposserivicohigenico database table.
 * 
 */
@Entity
@Table(name="hcftiposserivicohigenico")
@NamedQuery(name="HcfTipoServicioHigienico.findAll", query="SELECT h FROM HcfTipoServicioHigienico h")
public class HcfTipoServicioHigienico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtiposervhig;

	private String descripcion;

	private String estado;

	public HcfTipoServicioHigienico() {
	}

	public Long getIdtiposervhig() {
		return this.idtiposervhig;
	}

	public void setIdtiposervhig(Long idtiposervhig) {
		this.idtiposervhig = idtiposervhig;
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