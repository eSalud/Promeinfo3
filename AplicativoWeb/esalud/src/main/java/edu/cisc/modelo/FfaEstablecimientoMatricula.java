package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ffaestablecimientomatricula database table.
 * 
 */
@Entity
@NamedQuery(name="FfaEstablecimientoMatricula.findAll", query="SELECT f FROM FfaEstablecimientoMatricula f")
public class FfaEstablecimientoMatricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idestabmatricula;

	private String descripcion;

	//bi-directional many-to-one association to FfaTipoInstruccion
	@OneToMany(mappedBy="ffaestablecimientomatricula")
	private List<FfaTipoInstruccion> ffatiposinstrucciones;

	public FfaEstablecimientoMatricula() {
	}

	public Long getIdestabmatricula() {
		return this.idestabmatricula;
	}

	public void setIdestabmatricula(Long idestabmatricula) {
		this.idestabmatricula = idestabmatricula;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<FfaTipoInstruccion> getFfatiposinstrucciones() {
		return this.ffatiposinstrucciones;
	}

	public void setFfatiposinstrucciones(List<FfaTipoInstruccion> ffatiposinstrucciones) {
		this.ffatiposinstrucciones = ffatiposinstrucciones;
	}

	public FfaTipoInstruccion addFfatiposinstruccione(FfaTipoInstruccion ffatiposinstruccione) {
		getFfatiposinstrucciones().add(ffatiposinstruccione);
		ffatiposinstruccione.setFfaestablecimientomatricula(this);

		return ffatiposinstruccione;
	}

	public FfaTipoInstruccion removeFfatiposinstruccione(FfaTipoInstruccion ffatiposinstruccione) {
		getFfatiposinstrucciones().remove(ffatiposinstruccione);
		ffatiposinstruccione.setFfaestablecimientomatricula(null);

		return ffatiposinstruccione;
	}

}