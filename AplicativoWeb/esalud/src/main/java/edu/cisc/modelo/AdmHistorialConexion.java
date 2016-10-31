package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the admhistorialconexiones database table.
 * 
 */
@Entity
@Table(name="admhistorialconexiones")
@NamedQuery(name="AdmHistorialConexion.findAll", query="SELECT a FROM AdmHistorialConexion a")
public class AdmHistorialConexion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idhistorial;

	private Timestamp fechafin;

	private Timestamp fechaini;

	private String ip;

	private String nombre;

	private String usuario;

	public AdmHistorialConexion() {
	}

	public Long getIdhistorial() {
		return this.idhistorial;
	}

	public void setIdhistorial(Long idhistorial) {
		this.idhistorial = idhistorial;
	}

	public Timestamp getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}

	public Timestamp getFechaini() {
		return this.fechaini;
	}

	public void setFechaini(Timestamp fechaini) {
		this.fechaini = fechaini;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}