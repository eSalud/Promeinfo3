package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the atminformacionesclinicas database table.
 * 
 */
@Entity
@Table(name="atminformacionesclinicas")
@NamedQuery(name="AtmInformacionClinica.findAll", query="SELECT a FROM AtmInformacionClinica a")
public class AtmInformacionClinica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idinfoclinica;

	private String codinfoclinica;

	private String codinfoclinicapdr;

	private Integer idactividad;

	private Integer idmetodocontrol;

	private Integer idprocesohosp;

	private String nombre;

	private BigDecimal rango1;

	private BigDecimal rango2;

	private String valor;

	//bi-directional many-to-one association to AtmDescripcionValorClinico
	@OneToMany(mappedBy="atminformacionesclinica")
	private List<AtmDescripcionValorClinico> atmdescripcionesvaloresclinicos;

	//bi-directional many-to-one association to AtmTipoInformacionClinica
	@ManyToOne
	@JoinColumn(name="idtipoinfoclinica")
	private AtmTipoInformacionClinica atmtiposinformacionclinica;

	public AtmInformacionClinica() {
	}

	public Long getIdinfoclinica() {
		return this.idinfoclinica;
	}

	public void setIdinfoclinica(Long idinfoclinica) {
		this.idinfoclinica = idinfoclinica;
	}

	public String getCodinfoclinica() {
		return this.codinfoclinica;
	}

	public void setCodinfoclinica(String codinfoclinica) {
		this.codinfoclinica = codinfoclinica;
	}

	public String getCodinfoclinicapdr() {
		return this.codinfoclinicapdr;
	}

	public void setCodinfoclinicapdr(String codinfoclinicapdr) {
		this.codinfoclinicapdr = codinfoclinicapdr;
	}

	public Integer getIdactividad() {
		return this.idactividad;
	}

	public void setIdactividad(Integer idactividad) {
		this.idactividad = idactividad;
	}

	public Integer getIdmetodocontrol() {
		return this.idmetodocontrol;
	}

	public void setIdmetodocontrol(Integer idmetodocontrol) {
		this.idmetodocontrol = idmetodocontrol;
	}

	public Integer getIdprocesohosp() {
		return this.idprocesohosp;
	}

	public void setIdprocesohosp(Integer idprocesohosp) {
		this.idprocesohosp = idprocesohosp;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getRango1() {
		return this.rango1;
	}

	public void setRango1(BigDecimal rango1) {
		this.rango1 = rango1;
	}

	public BigDecimal getRango2() {
		return this.rango2;
	}

	public void setRango2(BigDecimal rango2) {
		this.rango2 = rango2;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public List<AtmDescripcionValorClinico> getAtmdescripcionesvaloresclinicos() {
		return this.atmdescripcionesvaloresclinicos;
	}

	public void setAtmdescripcionesvaloresclinicos(List<AtmDescripcionValorClinico> atmdescripcionesvaloresclinicos) {
		this.atmdescripcionesvaloresclinicos = atmdescripcionesvaloresclinicos;
	}

	public AtmDescripcionValorClinico addAtmdescripcionesvaloresclinico(AtmDescripcionValorClinico atmdescripcionesvaloresclinico) {
		getAtmdescripcionesvaloresclinicos().add(atmdescripcionesvaloresclinico);
		atmdescripcionesvaloresclinico.setAtminformacionesclinica(this);

		return atmdescripcionesvaloresclinico;
	}

	public AtmDescripcionValorClinico removeAtmdescripcionesvaloresclinico(AtmDescripcionValorClinico atmdescripcionesvaloresclinico) {
		getAtmdescripcionesvaloresclinicos().remove(atmdescripcionesvaloresclinico);
		atmdescripcionesvaloresclinico.setAtminformacionesclinica(null);

		return atmdescripcionesvaloresclinico;
	}

	public AtmTipoInformacionClinica getAtmtiposinformacionclinica() {
		return this.atmtiposinformacionclinica;
	}

	public void setAtmtiposinformacionclinica(AtmTipoInformacionClinica atmtiposinformacionclinica) {
		this.atmtiposinformacionclinica = atmtiposinformacionclinica;
	}

}