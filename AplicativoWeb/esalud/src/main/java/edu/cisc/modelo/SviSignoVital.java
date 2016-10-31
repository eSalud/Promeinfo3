package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the svisignosvitales database table.
 * 
 */
@Entity
@Table(name="svisignosvitales")
@NamedQuery(name="SviSignoVital.findAll", query="SELECT s FROM SviSignoVital s")
public class SviSignoVital implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idsignosvitales;

	@Temporal(TemporalType.DATE)
	private Date diainternacion;

	@Temporal(TemporalType.DATE)
	private Date diapostquirurgico;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechamedicion;

	private Integer frecrespiratoria;

	private Integer frecuenciacar;

	private Integer frecuenciares;

	private BigDecimal masacorporal;

	private BigDecimal perimetroabdom;

	private BigDecimal perimetrocefa;

	private BigDecimal peso;

	private Integer presarterialmax;

	private Integer presarterialmin;

	private Integer presiondiastolica;

	private Integer presionsistolica;

	private BigDecimal pulso;

	private BigDecimal talla;

	private BigDecimal tempaxilar;

	private BigDecimal tempbucal;

	private BigDecimal temperatura;

	//bi-directional many-to-one association to AtmEncuentroPaciente
	@ManyToOne
	@JoinColumn(name="idencpaciente")
	private AtmEncuentroPaciente atmencuentrospaciente;

	//bi-directional many-to-one association to AtmVisitaHCU
	@ManyToOne
	@JoinColumn(name="idvisita")
	private AtmVisitaHCU atmvisitashcu;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	public SviSignoVital() {
	}

	public Long getIdsignosvitales() {
		return this.idsignosvitales;
	}

	public void setIdsignosvitales(Long idsignosvitales) {
		this.idsignosvitales = idsignosvitales;
	}

	public Date getDiainternacion() {
		return this.diainternacion;
	}

	public void setDiainternacion(Date diainternacion) {
		this.diainternacion = diainternacion;
	}

	public Date getDiapostquirurgico() {
		return this.diapostquirurgico;
	}

	public void setDiapostquirurgico(Date diapostquirurgico) {
		this.diapostquirurgico = diapostquirurgico;
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

	public Integer getFrecrespiratoria() {
		return this.frecrespiratoria;
	}

	public void setFrecrespiratoria(Integer frecrespiratoria) {
		this.frecrespiratoria = frecrespiratoria;
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

	public BigDecimal getMasacorporal() {
		return this.masacorporal;
	}

	public void setMasacorporal(BigDecimal masacorporal) {
		this.masacorporal = masacorporal;
	}

	public BigDecimal getPerimetroabdom() {
		return this.perimetroabdom;
	}

	public void setPerimetroabdom(BigDecimal perimetroabdom) {
		this.perimetroabdom = perimetroabdom;
	}

	public BigDecimal getPerimetrocefa() {
		return this.perimetrocefa;
	}

	public void setPerimetrocefa(BigDecimal perimetrocefa) {
		this.perimetrocefa = perimetrocefa;
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

	public Integer getPresiondiastolica() {
		return this.presiondiastolica;
	}

	public void setPresiondiastolica(Integer presiondiastolica) {
		this.presiondiastolica = presiondiastolica;
	}

	public Integer getPresionsistolica() {
		return this.presionsistolica;
	}

	public void setPresionsistolica(Integer presionsistolica) {
		this.presionsistolica = presionsistolica;
	}

	public BigDecimal getPulso() {
		return this.pulso;
	}

	public void setPulso(BigDecimal pulso) {
		this.pulso = pulso;
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

	public BigDecimal getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(BigDecimal temperatura) {
		this.temperatura = temperatura;
	}

	public AtmEncuentroPaciente getAtmencuentrospaciente() {
		return this.atmencuentrospaciente;
	}

	public void setAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		this.atmencuentrospaciente = atmencuentrospaciente;
	}

	public AtmVisitaHCU getAtmvisitashcu() {
		return this.atmvisitashcu;
	}

	public void setAtmvisitashcu(AtmVisitaHCU atmvisitashcu) {
		this.atmvisitashcu = atmvisitashcu;
	}

	public ParPaciente getParpaciente() {
		return this.parpaciente;
	}

	public void setParpaciente(ParPaciente parpaciente) {
		this.parpaciente = parpaciente;
	}

}