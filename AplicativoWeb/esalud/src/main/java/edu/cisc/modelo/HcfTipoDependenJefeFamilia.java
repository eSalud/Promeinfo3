package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hcftiposdependenjefefamilia database table.
 * 
 */
@Entity
@Table(name="hcftiposdependenjefefamilia")
@NamedQuery(name="HcfTipoDependenJefeFamilia.findAll", query="SELECT h FROM HcfTipoDependenJefeFamilia h")
public class HcfTipoDependenJefeFamilia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipodepjefefam;

	private String descripcion;

	private String estado;

	public HcfTipoDependenJefeFamilia() {
	}

	public Long getIdtipodepjefefam() {
		return this.idtipodepjefefam;
	}

	public void setIdtipodepjefefam(Long idtipodepjefefam) {
		this.idtipodepjefefam = idtipodepjefefam;
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