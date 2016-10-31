package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the epiegresos database table.
 * 
 */
@Entity
@Table(name="epiegresos")
@NamedQuery(name="EpiEgreso.findAll", query="SELECT e FROM EpiEgreso e")
public class EpiEgreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idegreso;

	private String altadefinitiva;

	private String altatransitoria;

	private String asintomatico;

	private Integer diasestadia;

	private Integer diasincapacidad;

	private String difuncionmas;

	private String difuncionmenos;

	private String discapacidadgrav;

	private String discapacidadleve;

	private String discapacidadmode;

	private String retiroautorizado;

	private String retironoautorizado;

	//bi-directional many-to-one association to EpiResumenHallazgoClinico
	@ManyToOne
	@JoinColumn(name="idresumenhc")
	private EpiResumenHallazgoClinico epiresumenhallazgosclinico;

	public EpiEgreso() {
	}

	public Long getIdegreso() {
		return this.idegreso;
	}

	public void setIdegreso(Long idegreso) {
		this.idegreso = idegreso;
	}

	public String getAltadefinitiva() {
		return this.altadefinitiva;
	}

	public void setAltadefinitiva(String altadefinitiva) {
		this.altadefinitiva = altadefinitiva;
	}

	public String getAltatransitoria() {
		return this.altatransitoria;
	}

	public void setAltatransitoria(String altatransitoria) {
		this.altatransitoria = altatransitoria;
	}

	public String getAsintomatico() {
		return this.asintomatico;
	}

	public void setAsintomatico(String asintomatico) {
		this.asintomatico = asintomatico;
	}

	public Integer getDiasestadia() {
		return this.diasestadia;
	}

	public void setDiasestadia(Integer diasestadia) {
		this.diasestadia = diasestadia;
	}

	public Integer getDiasincapacidad() {
		return this.diasincapacidad;
	}

	public void setDiasincapacidad(Integer diasincapacidad) {
		this.diasincapacidad = diasincapacidad;
	}

	public String getDifuncionmas() {
		return this.difuncionmas;
	}

	public void setDifuncionmas(String difuncionmas) {
		this.difuncionmas = difuncionmas;
	}

	public String getDifuncionmenos() {
		return this.difuncionmenos;
	}

	public void setDifuncionmenos(String difuncionmenos) {
		this.difuncionmenos = difuncionmenos;
	}

	public String getDiscapacidadgrav() {
		return this.discapacidadgrav;
	}

	public void setDiscapacidadgrav(String discapacidadgrav) {
		this.discapacidadgrav = discapacidadgrav;
	}

	public String getDiscapacidadleve() {
		return this.discapacidadleve;
	}

	public void setDiscapacidadleve(String discapacidadleve) {
		this.discapacidadleve = discapacidadleve;
	}

	public String getDiscapacidadmode() {
		return this.discapacidadmode;
	}

	public void setDiscapacidadmode(String discapacidadmode) {
		this.discapacidadmode = discapacidadmode;
	}

	public String getRetiroautorizado() {
		return this.retiroautorizado;
	}

	public void setRetiroautorizado(String retiroautorizado) {
		this.retiroautorizado = retiroautorizado;
	}

	public String getRetironoautorizado() {
		return this.retironoautorizado;
	}

	public void setRetironoautorizado(String retironoautorizado) {
		this.retironoautorizado = retironoautorizado;
	}

	public EpiResumenHallazgoClinico getEpiresumenhallazgosclinico() {
		return this.epiresumenhallazgosclinico;
	}

	public void setEpiresumenhallazgosclinico(EpiResumenHallazgoClinico epiresumenhallazgosclinico) {
		this.epiresumenhallazgosclinico = epiresumenhallazgosclinico;
	}

}