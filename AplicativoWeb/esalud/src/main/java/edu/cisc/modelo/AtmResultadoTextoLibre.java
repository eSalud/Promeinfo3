package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atmresultadostextoslibres database table.
 * 
 */
@Entity
@Table(name="atmresultadostextoslibres")
@NamedQuery(name="AtmResultadoTextoLibre.findAll", query="SELECT a FROM AtmResultadoTextoLibre a")
public class AtmResultadoTextoLibre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idrestextolibre;

	private String fecha;

	private String hora;

	private Integer iddetalleorden;

	private String idinfoclinica;

	private Integer idorden;

	private String resultado1;

	private String resultado2;

	//bi-directional many-to-one association to AtmEncuentroPaciente
	@ManyToOne
	@JoinColumn(name="idencpaciente")
	private AtmEncuentroPaciente atmencuentrospaciente;

	public AtmResultadoTextoLibre() {
	}

	public Long getIdrestextolibre() {
		return this.idrestextolibre;
	}

	public void setIdrestextolibre(Long idrestextolibre) {
		this.idrestextolibre = idrestextolibre;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Integer getIddetalleorden() {
		return this.iddetalleorden;
	}

	public void setIddetalleorden(Integer iddetalleorden) {
		this.iddetalleorden = iddetalleorden;
	}

	public String getIdinfoclinica() {
		return this.idinfoclinica;
	}

	public void setIdinfoclinica(String idinfoclinica) {
		this.idinfoclinica = idinfoclinica;
	}

	public Integer getIdorden() {
		return this.idorden;
	}

	public void setIdorden(Integer idorden) {
		this.idorden = idorden;
	}

	public String getResultado1() {
		return this.resultado1;
	}

	public void setResultado1(String resultado1) {
		this.resultado1 = resultado1;
	}

	public String getResultado2() {
		return this.resultado2;
	}

	public void setResultado2(String resultado2) {
		this.resultado2 = resultado2;
	}

	public AtmEncuentroPaciente getAtmencuentrospaciente() {
		return this.atmencuentrospaciente;
	}

	public void setAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		this.atmencuentrospaciente = atmencuentrospaciente;
	}

}