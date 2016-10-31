package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hcfviviendaservicio database table.
 * 
 */
@Entity
@NamedQuery(name="HcfViviendaServicio.findAll", query="SELECT h FROM HcfViviendaServicio h")
public class HcfViviendaServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idviviendaserv;

	private Integer aguaconsumo;

	private Integer calidadvivienda;

	private String estado;

	private Integer luzelectrica;

	private Integer personasdormitorio;

	private Integer serviciohigienico;

	private Integer subtotal1;

	private Integer subtotal2;

	private String subtotal3;

	private Integer totalpunto;

	//bi-directional many-to-one association to HcfPrincipal
	@ManyToOne
	@JoinColumn(name="idcab")
	private HcfPrincipal hcfprincipal;

	public HcfViviendaServicio() {
	}

	public Long getIdviviendaserv() {
		return this.idviviendaserv;
	}

	public void setIdviviendaserv(Long idviviendaserv) {
		this.idviviendaserv = idviviendaserv;
	}

	public Integer getAguaconsumo() {
		return this.aguaconsumo;
	}

	public void setAguaconsumo(Integer aguaconsumo) {
		this.aguaconsumo = aguaconsumo;
	}

	public Integer getCalidadvivienda() {
		return this.calidadvivienda;
	}

	public void setCalidadvivienda(Integer calidadvivienda) {
		this.calidadvivienda = calidadvivienda;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getLuzelectrica() {
		return this.luzelectrica;
	}

	public void setLuzelectrica(Integer luzelectrica) {
		this.luzelectrica = luzelectrica;
	}

	public Integer getPersonasdormitorio() {
		return this.personasdormitorio;
	}

	public void setPersonasdormitorio(Integer personasdormitorio) {
		this.personasdormitorio = personasdormitorio;
	}

	public Integer getServiciohigienico() {
		return this.serviciohigienico;
	}

	public void setServiciohigienico(Integer serviciohigienico) {
		this.serviciohigienico = serviciohigienico;
	}

	public Integer getSubtotal1() {
		return this.subtotal1;
	}

	public void setSubtotal1(Integer subtotal1) {
		this.subtotal1 = subtotal1;
	}

	public Integer getSubtotal2() {
		return this.subtotal2;
	}

	public void setSubtotal2(Integer subtotal2) {
		this.subtotal2 = subtotal2;
	}

	public String getSubtotal3() {
		return this.subtotal3;
	}

	public void setSubtotal3(String subtotal3) {
		this.subtotal3 = subtotal3;
	}

	public Integer getTotalpunto() {
		return this.totalpunto;
	}

	public void setTotalpunto(Integer totalpunto) {
		this.totalpunto = totalpunto;
	}

	public HcfPrincipal getHcfprincipal() {
		return this.hcfprincipal;
	}

	public void setHcfprincipal(HcfPrincipal hcfprincipal) {
		this.hcfprincipal = hcfprincipal;
	}

}