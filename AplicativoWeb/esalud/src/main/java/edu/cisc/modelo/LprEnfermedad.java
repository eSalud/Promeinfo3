package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lprenfermedades database table.
 * 
 */
@Entity
@Table(name="lprenfermedades")
@NamedQuery(name="LprEnfermedad.findAll", query="SELECT l FROM LprEnfermedad l")
public class LprEnfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idenfermedad;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to LprSegEnfermedad
	@OneToMany(mappedBy="lprenfermedade")
	private List<LprSegEnfermedad> lprsegenfermedads;

	public LprEnfermedad() {
	}

	public Long getIdenfermedad() {
		return this.idenfermedad;
	}

	public void setIdenfermedad(Long idenfermedad) {
		this.idenfermedad = idenfermedad;
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

	public List<LprSegEnfermedad> getLprsegenfermedads() {
		return this.lprsegenfermedads;
	}

	public void setLprsegenfermedads(List<LprSegEnfermedad> lprsegenfermedads) {
		this.lprsegenfermedads = lprsegenfermedads;
	}

	public LprSegEnfermedad addLprsegenfermedad(LprSegEnfermedad lprsegenfermedad) {
		getLprsegenfermedads().add(lprsegenfermedad);
		lprsegenfermedad.setLprenfermedade(this);

		return lprsegenfermedad;
	}

	public LprSegEnfermedad removeLprsegenfermedad(LprSegEnfermedad lprsegenfermedad) {
		getLprsegenfermedads().remove(lprsegenfermedad);
		lprsegenfermedad.setLprenfermedade(null);

		return lprsegenfermedad;
	}

}