package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the svibalanceohidrico database table.
 * 
 */
@Entity
@NamedQuery(name="SviBalanceoHidrico.findAll", query="SELECT s FROM SviBalanceoHidrico s")
public class SviBalanceoHidrico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idbalanceohid;

	private BigDecimal drenaje;

	private BigDecimal orina;

	private BigDecimal otros;

	private BigDecimal parenteral;

	@Column(name="total_eliminados")
	private BigDecimal totalEliminados;

	@Column(name="total_ingresos")
	private BigDecimal totalIngresos;

	@Column(name="via_oral")
	private BigDecimal viaOral;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	public SviBalanceoHidrico() {
	}

	public Long getIdbalanceohid() {
		return this.idbalanceohid;
	}

	public void setIdbalanceohid(Long idbalanceohid) {
		this.idbalanceohid = idbalanceohid;
	}

	public BigDecimal getDrenaje() {
		return this.drenaje;
	}

	public void setDrenaje(BigDecimal drenaje) {
		this.drenaje = drenaje;
	}

	public BigDecimal getOrina() {
		return this.orina;
	}

	public void setOrina(BigDecimal orina) {
		this.orina = orina;
	}

	public BigDecimal getOtros() {
		return this.otros;
	}

	public void setOtros(BigDecimal otros) {
		this.otros = otros;
	}

	public BigDecimal getParenteral() {
		return this.parenteral;
	}

	public void setParenteral(BigDecimal parenteral) {
		this.parenteral = parenteral;
	}

	public BigDecimal getTotalEliminados() {
		return this.totalEliminados;
	}

	public void setTotalEliminados(BigDecimal totalEliminados) {
		this.totalEliminados = totalEliminados;
	}

	public BigDecimal getTotalIngresos() {
		return this.totalIngresos;
	}

	public void setTotalIngresos(BigDecimal totalIngresos) {
		this.totalIngresos = totalIngresos;
	}

	public BigDecimal getViaOral() {
		return this.viaOral;
	}

	public void setViaOral(BigDecimal viaOral) {
		this.viaOral = viaOral;
	}

	public ParPaciente getParpaciente() {
		return this.parpaciente;
	}

	public void setParpaciente(ParPaciente parpaciente) {
		this.parpaciente = parpaciente;
	}

}