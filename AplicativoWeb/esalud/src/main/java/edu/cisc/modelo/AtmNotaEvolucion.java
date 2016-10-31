package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the atmnotasevolucion database table.
 * 
 */
@Entity
@Table(name="atmnotasevolucion")
@NamedQuery(name="AtmNotaEvolucion.findAll", query="SELECT a FROM AtmNotaEvolucion a")
public class AtmNotaEvolucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idnotasevolucion;

	private String descripcion;

	private Timestamp fechaingreso;

	private String soap;

	//bi-directional many-to-one association to LprProblema
	@ManyToOne
	@JoinColumn(name="idlistaproblemas")
	private LprProblema lprproblema1;

	//bi-directional many-to-one association to LprProblema
	@ManyToOne
	@JoinColumn(name="idprofsalud")
	private LprProblema lprproblema2;

	//bi-directional many-to-one association to ParPersona
	@ManyToOne
	@JoinColumn(name="idpersona")
	private ParPersona parpersona;

	public AtmNotaEvolucion() {
	}

	public Long getIdnotasevolucion() {
		return this.idnotasevolucion;
	}

	public void setIdnotasevolucion(Long idnotasevolucion) {
		this.idnotasevolucion = idnotasevolucion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFechaingreso() {
		return this.fechaingreso;
	}

	public void setFechaingreso(Timestamp fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public String getSoap() {
		return this.soap;
	}

	public void setSoap(String soap) {
		this.soap = soap;
	}

	public LprProblema getLprproblema1() {
		return this.lprproblema1;
	}

	public void setLprproblema1(LprProblema lprproblema1) {
		this.lprproblema1 = lprproblema1;
	}

	public LprProblema getLprproblema2() {
		return this.lprproblema2;
	}

	public void setLprproblema2(LprProblema lprproblema2) {
		this.lprproblema2 = lprproblema2;
	}

	public ParPersona getParpersona() {
		return this.parpersona;
	}

	public void setParpersona(ParPersona parpersona) {
		this.parpersona = parpersona;
	}

}