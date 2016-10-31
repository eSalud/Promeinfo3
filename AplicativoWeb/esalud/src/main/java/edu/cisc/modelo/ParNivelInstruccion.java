package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parnivelinstruccion database table.
 * 
 */
@Entity
@NamedQuery(name="ParNivelInstruccion.findAll", query="SELECT p FROM ParNivelInstruccion p")
public class ParNivelInstruccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idnivelinst;

	private String codnivelinst;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to FfaTipoInstruccion
	@OneToMany(mappedBy="parnivelinstruccion")
	private List<FfaTipoInstruccion> ffatiposinstrucciones;

	public ParNivelInstruccion() {
	}

	public Long getIdnivelinst() {
		return this.idnivelinst;
	}

	public void setIdnivelinst(Long idnivelinst) {
		this.idnivelinst = idnivelinst;
	}

	public String getCodnivelinst() {
		return this.codnivelinst;
	}

	public void setCodnivelinst(String codnivelinst) {
		this.codnivelinst = codnivelinst;
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

	public List<FfaTipoInstruccion> getFfatiposinstrucciones() {
		return this.ffatiposinstrucciones;
	}

	public void setFfatiposinstrucciones(List<FfaTipoInstruccion> ffatiposinstrucciones) {
		this.ffatiposinstrucciones = ffatiposinstrucciones;
	}

	public FfaTipoInstruccion addFfatiposinstruccione(FfaTipoInstruccion ffatiposinstruccione) {
		getFfatiposinstrucciones().add(ffatiposinstruccione);
		ffatiposinstruccione.setParnivelinstruccion(this);

		return ffatiposinstruccione;
	}

	public FfaTipoInstruccion removeFfatiposinstruccione(FfaTipoInstruccion ffatiposinstruccione) {
		getFfatiposinstrucciones().remove(ffatiposinstruccione);
		ffatiposinstruccione.setParnivelinstruccion(null);

		return ffatiposinstruccione;
	}

}