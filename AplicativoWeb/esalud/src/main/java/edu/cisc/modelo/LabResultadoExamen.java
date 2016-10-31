package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the labresultadosexamenes database table.
 * 
 */
@Entity
@Table(name="labresultadosexamenes")
@NamedQuery(name="LabResultadoExamen.findAll", query="SELECT l FROM LabResultadoExamen l")
public class LabResultadoExamen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idresexamen;

	private String auxiliar1;

	private String auxiliar2;

	private String auxiliar3;

	private String auxiliar4;

	private String auxiliar5;

	private String resultado;

	private String unidadmedida;

	private String valorreferencia;

	//bi-directional many-to-one association to LabDescripcionResExamen
	@ManyToOne
	@JoinColumn(name="iddescresexamen")
	private LabDescripcionResExamen labdescripcionresexamene;

	//bi-directional many-to-one association to LabOrdenExamen
	@ManyToOne
	@JoinColumn(name="idorden")
	private LabOrdenExamen labordenexamen;

	public LabResultadoExamen() {
	}

	public Long getIdresexamen() {
		return this.idresexamen;
	}

	public void setIdresexamen(Long idresexamen) {
		this.idresexamen = idresexamen;
	}

	public String getAuxiliar1() {
		return this.auxiliar1;
	}

	public void setAuxiliar1(String auxiliar1) {
		this.auxiliar1 = auxiliar1;
	}

	public String getAuxiliar2() {
		return this.auxiliar2;
	}

	public void setAuxiliar2(String auxiliar2) {
		this.auxiliar2 = auxiliar2;
	}

	public String getAuxiliar3() {
		return this.auxiliar3;
	}

	public void setAuxiliar3(String auxiliar3) {
		this.auxiliar3 = auxiliar3;
	}

	public String getAuxiliar4() {
		return this.auxiliar4;
	}

	public void setAuxiliar4(String auxiliar4) {
		this.auxiliar4 = auxiliar4;
	}

	public String getAuxiliar5() {
		return this.auxiliar5;
	}

	public void setAuxiliar5(String auxiliar5) {
		this.auxiliar5 = auxiliar5;
	}

	public String getResultado() {
		return this.resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getUnidadmedida() {
		return this.unidadmedida;
	}

	public void setUnidadmedida(String unidadmedida) {
		this.unidadmedida = unidadmedida;
	}

	public String getValorreferencia() {
		return this.valorreferencia;
	}

	public void setValorreferencia(String valorreferencia) {
		this.valorreferencia = valorreferencia;
	}

	public LabDescripcionResExamen getLabdescripcionresexamene() {
		return this.labdescripcionresexamene;
	}

	public void setLabdescripcionresexamene(LabDescripcionResExamen labdescripcionresexamene) {
		this.labdescripcionresexamene = labdescripcionresexamene;
	}

	public LabOrdenExamen getLabordenexamen() {
		return this.labordenexamen;
	}

	public void setLabordenexamen(LabOrdenExamen labordenexamen) {
		this.labordenexamen = labordenexamen;
	}

}