package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the emginsumosingresosemergencia database table.
 * 
 */
@Entity
@Table(name="emginsumosingresosemergencia")
@NamedQuery(name="EmgInsumoIngresoEmergencia.findAll", query="SELECT e FROM EmgInsumoIngresoEmergencia e")
public class EmgInsumoIngresoEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idinsumosingemg;

	private Integer cantidad;

	private String observacion;

	private String prescripcion;

	//bi-directional many-to-one association to EmgIngresoEmergencia
	@ManyToOne
	@JoinColumn(name="idingresosemg")
	private EmgIngresoEmergencia emgingresosemergencia;

	//bi-directional many-to-one association to ProInsumoMedico
	@ManyToOne
	@JoinColumn(name="idinsumo")
	private ProInsumoMedico proinsumosmedico;

	public EmgInsumoIngresoEmergencia() {
	}

	public Long getIdinsumosingemg() {
		return this.idinsumosingemg;
	}

	public void setIdinsumosingemg(Long idinsumosingemg) {
		this.idinsumosingemg = idinsumosingemg;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getPrescripcion() {
		return this.prescripcion;
	}

	public void setPrescripcion(String prescripcion) {
		this.prescripcion = prescripcion;
	}

	public EmgIngresoEmergencia getEmgingresosemergencia() {
		return this.emgingresosemergencia;
	}

	public void setEmgingresosemergencia(EmgIngresoEmergencia emgingresosemergencia) {
		this.emgingresosemergencia = emgingresosemergencia;
	}

	public ProInsumoMedico getProinsumosmedico() {
		return this.proinsumosmedico;
	}

	public void setProinsumosmedico(ProInsumoMedico proinsumosmedico) {
		this.proinsumosmedico = proinsumosmedico;
	}

}