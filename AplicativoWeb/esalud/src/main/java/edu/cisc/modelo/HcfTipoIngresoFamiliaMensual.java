package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hcftiposingresosfamiliamensual database table.
 * 
 */
@Entity
@Table(name="hcftiposingresosfamiliamensual")
@NamedQuery(name="HcfTipoIngresoFamiliaMensual.findAll", query="SELECT h FROM HcfTipoIngresoFamiliaMensual h")
public class HcfTipoIngresoFamiliaMensual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipoingfammens;

	private String descripcion;

	private String estado;

	public HcfTipoIngresoFamiliaMensual() {
	}

	public Long getIdtipoingfammens() {
		return this.idtipoingfammens;
	}

	public void setIdtipoingfammens(Long idtipoingfammens) {
		this.idtipoingfammens = idtipoingfammens;
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