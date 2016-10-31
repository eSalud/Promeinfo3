package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the atmresultadosnumericos database table.
 * 
 */
@Entity
@Table(name="atmresultadosnumericos")
@NamedQuery(name="AtmResultadoNumerico.findAll", query="SELECT a FROM AtmResultadoNumerico a")
public class AtmResultadoNumerico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idresnumericos;

	private String fecha;

	private String hora;

	private Integer idcita;

	private Integer iddetalleorden;

	private String idinfoclinica;

	private Integer idorden;

	private BigDecimal resultado1;

	private BigDecimal resultado2;

	//bi-directional many-to-one association to AtmEncuentroPaciente
	@ManyToOne
	@JoinColumn(name="idencpaciente")
	private AtmEncuentroPaciente atmencuentrospaciente;

	public AtmResultadoNumerico() {
	}

	public Long getIdresnumericos() {
		return this.idresnumericos;
	}

	public void setIdresnumericos(Long idresnumericos) {
		this.idresnumericos = idresnumericos;
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

	public Integer getIdcita() {
		return this.idcita;
	}

	public void setIdcita(Integer idcita) {
		this.idcita = idcita;
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

	public BigDecimal getResultado1() {
		return this.resultado1;
	}

	public void setResultado1(BigDecimal resultado1) {
		this.resultado1 = resultado1;
	}

	public BigDecimal getResultado2() {
		return this.resultado2;
	}

	public void setResultado2(BigDecimal resultado2) {
		this.resultado2 = resultado2;
	}

	public AtmEncuentroPaciente getAtmencuentrospaciente() {
		return this.atmencuentrospaciente;
	}

	public void setAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		this.atmencuentrospaciente = atmencuentrospaciente;
	}

}