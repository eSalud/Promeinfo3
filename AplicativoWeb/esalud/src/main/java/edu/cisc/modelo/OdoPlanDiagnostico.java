package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the odoplandiagnostico database table.
 * 
 */
@Entity
@NamedQuery(name="OdoPlanDiagnostico.findAll", query="SELECT o FROM OdoPlanDiagnostico o")
public class OdoPlanDiagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idplandiag;

	private String biometria;

	private String otro;

	private String quimicasanguinea;

	private String rayosx;

	//bi-directional many-to-one association to OdoRegistroOdontologico
	@ManyToOne
	@JoinColumn(name="idregistro")
	private OdoRegistroOdontologico odoregistroodontologico;

	public OdoPlanDiagnostico() {
	}

	public Long getIdplandiag() {
		return this.idplandiag;
	}

	public void setIdplandiag(Long idplandiag) {
		this.idplandiag = idplandiag;
	}

	public String getBiometria() {
		return this.biometria;
	}

	public void setBiometria(String biometria) {
		this.biometria = biometria;
	}

	public String getOtro() {
		return this.otro;
	}

	public void setOtro(String otro) {
		this.otro = otro;
	}

	public String getQuimicasanguinea() {
		return this.quimicasanguinea;
	}

	public void setQuimicasanguinea(String quimicasanguinea) {
		this.quimicasanguinea = quimicasanguinea;
	}

	public String getRayosx() {
		return this.rayosx;
	}

	public void setRayosx(String rayosx) {
		this.rayosx = rayosx;
	}

	public OdoRegistroOdontologico getOdoregistroodontologico() {
		return this.odoregistroodontologico;
	}

	public void setOdoregistroodontologico(OdoRegistroOdontologico odoregistroodontologico) {
		this.odoregistroodontologico = odoregistroodontologico;
	}

}