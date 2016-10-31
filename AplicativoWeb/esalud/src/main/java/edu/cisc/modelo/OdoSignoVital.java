package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the odosignosvitales database table.
 * 
 */
@Entity
@Table(name="odosignosvitales")
@NamedQuery(name="OdoSignoVital.findAll", query="SELECT o FROM OdoSignoVital o")
public class OdoSignoVital implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idsignovital;

	private BigDecimal frecuenciacard;

	private BigDecimal frecuenciaresp;

	private String otro;

	private BigDecimal presionarterial;

	private BigDecimal temperatura;

	//bi-directional many-to-one association to OdoRegistroOdontologico
	@ManyToOne
	@JoinColumn(name="idregistro")
	private OdoRegistroOdontologico odoregistroodontologico;

	public OdoSignoVital() {
	}

	public Long getIdsignovital() {
		return this.idsignovital;
	}

	public void setIdsignovital(Long idsignovital) {
		this.idsignovital = idsignovital;
	}

	public BigDecimal getFrecuenciacard() {
		return this.frecuenciacard;
	}

	public void setFrecuenciacard(BigDecimal frecuenciacard) {
		this.frecuenciacard = frecuenciacard;
	}

	public BigDecimal getFrecuenciaresp() {
		return this.frecuenciaresp;
	}

	public void setFrecuenciaresp(BigDecimal frecuenciaresp) {
		this.frecuenciaresp = frecuenciaresp;
	}

	public String getOtro() {
		return this.otro;
	}

	public void setOtro(String otro) {
		this.otro = otro;
	}

	public BigDecimal getPresionarterial() {
		return this.presionarterial;
	}

	public void setPresionarterial(BigDecimal presionarterial) {
		this.presionarterial = presionarterial;
	}

	public BigDecimal getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(BigDecimal temperatura) {
		this.temperatura = temperatura;
	}

	public OdoRegistroOdontologico getOdoregistroodontologico() {
		return this.odoregistroodontologico;
	}

	public void setOdoregistroodontologico(OdoRegistroOdontologico odoregistroodontologico) {
		this.odoregistroodontologico = odoregistroodontologico;
	}

}