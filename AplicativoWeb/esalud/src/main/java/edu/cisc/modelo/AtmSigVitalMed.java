package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the atmsigvitalmed database table.
 * 
 */
@Entity
@NamedQuery(name="AtmSigVitalMed.findAll", query="SELECT a FROM AtmSigVitalMed a")
public class AtmSigVitalMed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idsigvitalmed;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechamedicion;

	private Integer frecuenciacar;

	private Integer frecuenciares;

	private Integer idencpaciente;

	private Integer idpaciente;

	private BigDecimal masacorporal;

	@Column(name="perimetro_abdom")
	private BigDecimal perimetroAbdom;

	@Column(name="perimetro_cefa")
	private BigDecimal perimetroCefa;

	private BigDecimal peso;

	private Integer presarterialmax;

	private Integer presarterialmin;

	private BigDecimal talla;

	private BigDecimal tempaxilar;

	private BigDecimal tempbucal;

	//bi-directional many-to-one association to AtmVisitaHCU
	@ManyToOne
	@JoinColumn(name="idvisita")
	private AtmVisitaHCU atmvisitashcu;

	public AtmSigVitalMed() {
	}

	public Long getIdsigvitalmed() {
		return this.idsigvitalmed;
	}

	public void setIdsigvitalmed(Long idsigvitalmed) {
		this.idsigvitalmed = idsigvitalmed;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechamedicion() {
		return this.fechamedicion;
	}

	public void setFechamedicion(Date fechamedicion) {
		this.fechamedicion = fechamedicion;
	}

	public Integer getFrecuenciacar() {
		return this.frecuenciacar;
	}

	public void setFrecuenciacar(Integer frecuenciacar) {
		this.frecuenciacar = frecuenciacar;
	}

	public Integer getFrecuenciares() {
		return this.frecuenciares;
	}

	public void setFrecuenciares(Integer frecuenciares) {
		this.frecuenciares = frecuenciares;
	}

	public Integer getIdencpaciente() {
		return this.idencpaciente;
	}

	public void setIdencpaciente(Integer idencpaciente) {
		this.idencpaciente = idencpaciente;
	}

	public Integer getIdpaciente() {
		return this.idpaciente;
	}

	public void setIdpaciente(Integer idpaciente) {
		this.idpaciente = idpaciente;
	}

	public BigDecimal getMasacorporal() {
		return this.masacorporal;
	}

	public void setMasacorporal(BigDecimal masacorporal) {
		this.masacorporal = masacorporal;
	}

	public BigDecimal getPerimetroAbdom() {
		return this.perimetroAbdom;
	}

	public void setPerimetroAbdom(BigDecimal perimetroAbdom) {
		this.perimetroAbdom = perimetroAbdom;
	}

	public BigDecimal getPerimetroCefa() {
		return this.perimetroCefa;
	}

	public void setPerimetroCefa(BigDecimal perimetroCefa) {
		this.perimetroCefa = perimetroCefa;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public Integer getPresarterialmax() {
		return this.presarterialmax;
	}

	public void setPresarterialmax(Integer presarterialmax) {
		this.presarterialmax = presarterialmax;
	}

	public Integer getPresarterialmin() {
		return this.presarterialmin;
	}

	public void setPresarterialmin(Integer presarterialmin) {
		this.presarterialmin = presarterialmin;
	}

	public BigDecimal getTalla() {
		return this.talla;
	}

	public void setTalla(BigDecimal talla) {
		this.talla = talla;
	}

	public BigDecimal getTempaxilar() {
		return this.tempaxilar;
	}

	public void setTempaxilar(BigDecimal tempaxilar) {
		this.tempaxilar = tempaxilar;
	}

	public BigDecimal getTempbucal() {
		return this.tempbucal;
	}

	public void setTempbucal(BigDecimal tempbucal) {
		this.tempbucal = tempbucal;
	}

	public AtmVisitaHCU getAtmvisitashcu() {
		return this.atmvisitashcu;
	}

	public void setAtmvisitashcu(AtmVisitaHCU atmvisitashcu) {
		this.atmvisitashcu = atmvisitashcu;
	}

}