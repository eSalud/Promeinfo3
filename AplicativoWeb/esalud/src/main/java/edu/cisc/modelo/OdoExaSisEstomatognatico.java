package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the odoexasisestomatognatico database table.
 * 
 */
@Entity
@NamedQuery(name="OdoExaSisEstomatognatico.findAll", query="SELECT o FROM OdoExaSisEstomatognatico o")
public class OdoExaSisEstomatognatico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idexasis;

	private String atm;

	private String carrillos;

	private String descpatologia1;

	private String descpatologia2;

	private String ganglios;

	private String glandulassalivales;

	private String labios;

	private String lengua;

	private String maxilarinferior;

	private String maxilarsuperior;

	private String mejillas;

	private String orofaringe;

	private String paladar;

	private String piso;

	//bi-directional many-to-one association to OdoRegistroOdontologico
	@ManyToOne
	@JoinColumn(name="idregistro")
	private OdoRegistroOdontologico odoregistroodontologico;

	public OdoExaSisEstomatognatico() {
	}

	public Long getIdexasis() {
		return this.idexasis;
	}

	public void setIdexasis(Long idexasis) {
		this.idexasis = idexasis;
	}

	public String getAtm() {
		return this.atm;
	}

	public void setAtm(String atm) {
		this.atm = atm;
	}

	public String getCarrillos() {
		return this.carrillos;
	}

	public void setCarrillos(String carrillos) {
		this.carrillos = carrillos;
	}

	public String getDescpatologia1() {
		return this.descpatologia1;
	}

	public void setDescpatologia1(String descpatologia1) {
		this.descpatologia1 = descpatologia1;
	}

	public String getDescpatologia2() {
		return this.descpatologia2;
	}

	public void setDescpatologia2(String descpatologia2) {
		this.descpatologia2 = descpatologia2;
	}

	public String getGanglios() {
		return this.ganglios;
	}

	public void setGanglios(String ganglios) {
		this.ganglios = ganglios;
	}

	public String getGlandulassalivales() {
		return this.glandulassalivales;
	}

	public void setGlandulassalivales(String glandulassalivales) {
		this.glandulassalivales = glandulassalivales;
	}

	public String getLabios() {
		return this.labios;
	}

	public void setLabios(String labios) {
		this.labios = labios;
	}

	public String getLengua() {
		return this.lengua;
	}

	public void setLengua(String lengua) {
		this.lengua = lengua;
	}

	public String getMaxilarinferior() {
		return this.maxilarinferior;
	}

	public void setMaxilarinferior(String maxilarinferior) {
		this.maxilarinferior = maxilarinferior;
	}

	public String getMaxilarsuperior() {
		return this.maxilarsuperior;
	}

	public void setMaxilarsuperior(String maxilarsuperior) {
		this.maxilarsuperior = maxilarsuperior;
	}

	public String getMejillas() {
		return this.mejillas;
	}

	public void setMejillas(String mejillas) {
		this.mejillas = mejillas;
	}

	public String getOrofaringe() {
		return this.orofaringe;
	}

	public void setOrofaringe(String orofaringe) {
		this.orofaringe = orofaringe;
	}

	public String getPaladar() {
		return this.paladar;
	}

	public void setPaladar(String paladar) {
		this.paladar = paladar;
	}

	public String getPiso() {
		return this.piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public OdoRegistroOdontologico getOdoregistroodontologico() {
		return this.odoregistroodontologico;
	}

	public void setOdoregistroodontologico(OdoRegistroOdontologico odoregistroodontologico) {
		this.odoregistroodontologico = odoregistroodontologico;
	}

}