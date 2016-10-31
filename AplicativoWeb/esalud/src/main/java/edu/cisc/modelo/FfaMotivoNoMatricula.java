package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ffamotivonomatricula database table.
 * 
 */
@Entity
@NamedQuery(name="FfaMotivoNoMatricula.findAll", query="SELECT f FROM FfaMotivoNoMatricula f")
public class FfaMotivoNoMatricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idmotivonomatric;

	private String descripcion;

	//bi-directional many-to-one association to FfaTipoInstruccion
	@OneToMany(mappedBy="ffamotivonomatricula")
	private List<FfaTipoInstruccion> ffatiposinstrucciones;

	public FfaMotivoNoMatricula() {
	}

	public Long getIdmotivonomatric() {
		return this.idmotivonomatric;
	}

	public void setIdmotivonomatric(Long idmotivonomatric) {
		this.idmotivonomatric = idmotivonomatric;
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
		ffatiposinstruccione.setFfamotivonomatricula(this);

		return ffatiposinstruccione;
	}

	public FfaTipoInstruccion removeFfatiposinstruccione(FfaTipoInstruccion ffatiposinstruccione) {
		getFfatiposinstrucciones().remove(ffatiposinstruccione);
		ffatiposinstruccione.setFfamotivonomatricula(null);

		return ffatiposinstruccione;
	}

}