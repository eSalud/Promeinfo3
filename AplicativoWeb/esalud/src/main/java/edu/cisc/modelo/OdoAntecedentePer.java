package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the odoantecedentespers database table.
 * 
 */
@Entity
@Table(name="odoantecedentespers")
@NamedQuery(name="OdoAntecedentePer.findAll", query="SELECT o FROM OdoAntecedentePer o")
public class OdoAntecedentePer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idantecedente;

	private String alergiaanestesia;

	private String alergiaantibiot;

	private String asma;

	private String diabetes;

	private String enfcardiaca;

	private String hemorrogias;

	private String hipertension;

	private String otro;

	private String tuberculosis;

	private String vihsida;

	//bi-directional many-to-one association to OdoRegistroOdontologico
	@ManyToOne
	@JoinColumn(name="idregistro")
	private OdoRegistroOdontologico odoregistroodontologico;

	public OdoAntecedentePer() {
	}

	public Long getIdantecedente() {
		return this.idantecedente;
	}

	public void setIdantecedente(Long idantecedente) {
		this.idantecedente = idantecedente;
	}

	public String getAlergiaanestesia() {
		return this.alergiaanestesia;
	}

	public void setAlergiaanestesia(String alergiaanestesia) {
		this.alergiaanestesia = alergiaanestesia;
	}

	public String getAlergiaantibiot() {
		return this.alergiaantibiot;
	}

	public void setAlergiaantibiot(String alergiaantibiot) {
		this.alergiaantibiot = alergiaantibiot;
	}

	public String getAsma() {
		return this.asma;
	}

	public void setAsma(String asma) {
		this.asma = asma;
	}

	public String getDiabetes() {
		return this.diabetes;
	}

	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}

	public String getEnfcardiaca() {
		return this.enfcardiaca;
	}

	public void setEnfcardiaca(String enfcardiaca) {
		this.enfcardiaca = enfcardiaca;
	}

	public String getHemorrogias() {
		return this.hemorrogias;
	}

	public void setHemorrogias(String hemorrogias) {
		this.hemorrogias = hemorrogias;
	}

	public String getHipertension() {
		return this.hipertension;
	}

	public void setHipertension(String hipertension) {
		this.hipertension = hipertension;
	}

	public String getOtro() {
		return this.otro;
	}

	public void setOtro(String otro) {
		this.otro = otro;
	}

	public String getTuberculosis() {
		return this.tuberculosis;
	}

	public void setTuberculosis(String tuberculosis) {
		this.tuberculosis = tuberculosis;
	}

	public String getVihsida() {
		return this.vihsida;
	}

	public void setVihsida(String vihsida) {
		this.vihsida = vihsida;
	}

	public OdoRegistroOdontologico getOdoregistroodontologico() {
		return this.odoregistroodontologico;
	}

	public void setOdoregistroodontologico(OdoRegistroOdontologico odoregistroodontologico) {
		this.odoregistroodontologico = odoregistroodontologico;
	}

}