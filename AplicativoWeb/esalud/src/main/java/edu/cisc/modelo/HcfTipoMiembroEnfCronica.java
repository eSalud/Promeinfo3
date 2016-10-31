package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hcftiposmiembrosenfcronicas database table.
 * 
 */
@Entity
@Table(name="hcftiposmiembrosenfcronicas")
@NamedQuery(name="HcfTipoMiembroEnfCronica.findAll", query="SELECT h FROM HcfTipoMiembroEnfCronica h")
public class HcfTipoMiembroEnfCronica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipomiemenfcron;

	private String descripcion;

	private String estado;

	public HcfTipoMiembroEnfCronica() {
	}

	public Long getIdtipomiemenfcron() {
		return this.idtipomiemenfcron;
	}

	public void setIdtipomiemenfcron(Long idtipomiemenfcron) {
		this.idtipomiemenfcron = idtipomiemenfcron;
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