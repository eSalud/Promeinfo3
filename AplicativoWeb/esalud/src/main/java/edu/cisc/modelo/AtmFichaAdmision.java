package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the atmfichasadmision database table.
 * 
 */
@Entity
@Table(name="atmfichasadmision")
@NamedQuery(name="AtmFichaAdmision.findAll", query="SELECT a FROM AtmFichaAdmision a")
public class AtmFichaAdmision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idfichaadmision;

	private String admisionista;

	private String atencion;

	private Integer edad;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String infoadicional;

	private Integer numero;

	private String referido;

	//bi-directional many-to-one association to AtmRegistroAdmision
	@ManyToOne
	@JoinColumn(name="idregistroadmision")
	private AtmRegistroAdmision atmregistroadmision;

	public AtmFichaAdmision() {
	}

	public Long getIdfichaadmision() {
		return this.idfichaadmision;
	}

	public void setIdfichaadmision(Long idfichaadmision) {
		this.idfichaadmision = idfichaadmision;
	}

	public String getAdmisionista() {
		return this.admisionista;
	}

	public void setAdmisionista(String admisionista) {
		this.admisionista = admisionista;
	}

	public String getAtencion() {
		return this.atencion;
	}

	public void setAtencion(String atencion) {
		this.atencion = atencion;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getInfoadicional() {
		return this.infoadicional;
	}

	public void setInfoadicional(String infoadicional) {
		this.infoadicional = infoadicional;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getReferido() {
		return this.referido;
	}

	public void setReferido(String referido) {
		this.referido = referido;
	}

	public AtmRegistroAdmision getAtmregistroadmision() {
		return this.atmregistroadmision;
	}

	public void setAtmregistroadmision(AtmRegistroAdmision atmregistroadmision) {
		this.atmregistroadmision = atmregistroadmision;
	}

}