package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ffaviviendadatos database table.
 * 
 */
@Entity
@Table(name="ffaviviendadatos")
@NamedQuery(name="FfaViviendaDato.findAll", query="SELECT f FROM FfaViviendaDato f")
public class FfaViviendaDato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idviviendadato;

	private String adobe;

	private String asbesto;

	private String baharaque;

	private String baldosa;

	private String bloque;

	private String cana;

	private String cania;

	private String carretera;

	private String casa;

	private String cemento;

	private String cuarto;

	private String departamento;

	private String duela;

	private String empedrado;

	private String estado;

	private String fibrolit;

	private String hormigon;

	private String ladrillo;

	private String lastrado;

	private String madera;

	private String marmol;

	private String mediagua;

	private String otrosacceso;

	private String otrosmaterial;

	private String otrospiso;

	private String otrostipo;

	private String palma;

	private String paredbueno;

	private String paredmalo;

	private String paredregular;

	private String pisobueno;

	private String pisomalo;

	private String pisoregular;

	private String rio;

	private String sendero;

	private String tabla;

	private String techobueno;

	private String techomalo;

	private String techoregular;

	private String teja;

	private String tierra;

	private String zinc;

	//bi-directional many-to-one association to FfaVivienda
	@ManyToOne
	@JoinColumn(name="idvivienda")
	private FfaVivienda ffavivienda;

	public FfaViviendaDato() {
	}

	public Long getIdviviendadato() {
		return this.idviviendadato;
	}

	public void setIdviviendadato(Long idviviendadato) {
		this.idviviendadato = idviviendadato;
	}

	public String getAdobe() {
		return this.adobe;
	}

	public void setAdobe(String adobe) {
		this.adobe = adobe;
	}

	public String getAsbesto() {
		return this.asbesto;
	}

	public void setAsbesto(String asbesto) {
		this.asbesto = asbesto;
	}

	public String getBaharaque() {
		return this.baharaque;
	}

	public void setBaharaque(String baharaque) {
		this.baharaque = baharaque;
	}

	public String getBaldosa() {
		return this.baldosa;
	}

	public void setBaldosa(String baldosa) {
		this.baldosa = baldosa;
	}

	public String getBloque() {
		return this.bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public String getCana() {
		return this.cana;
	}

	public void setCana(String cana) {
		this.cana = cana;
	}

	public String getCania() {
		return this.cania;
	}

	public void setCania(String cania) {
		this.cania = cania;
	}

	public String getCarretera() {
		return this.carretera;
	}

	public void setCarretera(String carretera) {
		this.carretera = carretera;
	}

	public String getCasa() {
		return this.casa;
	}

	public void setCasa(String casa) {
		this.casa = casa;
	}

	public String getCemento() {
		return this.cemento;
	}

	public void setCemento(String cemento) {
		this.cemento = cemento;
	}

	public String getCuarto() {
		return this.cuarto;
	}

	public void setCuarto(String cuarto) {
		this.cuarto = cuarto;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDuela() {
		return this.duela;
	}

	public void setDuela(String duela) {
		this.duela = duela;
	}

	public String getEmpedrado() {
		return this.empedrado;
	}

	public void setEmpedrado(String empedrado) {
		this.empedrado = empedrado;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFibrolit() {
		return this.fibrolit;
	}

	public void setFibrolit(String fibrolit) {
		this.fibrolit = fibrolit;
	}

	public String getHormigon() {
		return this.hormigon;
	}

	public void setHormigon(String hormigon) {
		this.hormigon = hormigon;
	}

	public String getLadrillo() {
		return this.ladrillo;
	}

	public void setLadrillo(String ladrillo) {
		this.ladrillo = ladrillo;
	}

	public String getLastrado() {
		return this.lastrado;
	}

	public void setLastrado(String lastrado) {
		this.lastrado = lastrado;
	}

	public String getMadera() {
		return this.madera;
	}

	public void setMadera(String madera) {
		this.madera = madera;
	}

	public String getMarmol() {
		return this.marmol;
	}

	public void setMarmol(String marmol) {
		this.marmol = marmol;
	}

	public String getMediagua() {
		return this.mediagua;
	}

	public void setMediagua(String mediagua) {
		this.mediagua = mediagua;
	}

	public String getOtrosacceso() {
		return this.otrosacceso;
	}

	public void setOtrosacceso(String otrosacceso) {
		this.otrosacceso = otrosacceso;
	}

	public String getOtrosmaterial() {
		return this.otrosmaterial;
	}

	public void setOtrosmaterial(String otrosmaterial) {
		this.otrosmaterial = otrosmaterial;
	}

	public String getOtrospiso() {
		return this.otrospiso;
	}

	public void setOtrospiso(String otrospiso) {
		this.otrospiso = otrospiso;
	}

	public String getOtrostipo() {
		return this.otrostipo;
	}

	public void setOtrostipo(String otrostipo) {
		this.otrostipo = otrostipo;
	}

	public String getPalma() {
		return this.palma;
	}

	public void setPalma(String palma) {
		this.palma = palma;
	}

	public String getParedbueno() {
		return this.paredbueno;
	}

	public void setParedbueno(String paredbueno) {
		this.paredbueno = paredbueno;
	}

	public String getParedmalo() {
		return this.paredmalo;
	}

	public void setParedmalo(String paredmalo) {
		this.paredmalo = paredmalo;
	}

	public String getParedregular() {
		return this.paredregular;
	}

	public void setParedregular(String paredregular) {
		this.paredregular = paredregular;
	}

	public String getPisobueno() {
		return this.pisobueno;
	}

	public void setPisobueno(String pisobueno) {
		this.pisobueno = pisobueno;
	}

	public String getPisomalo() {
		return this.pisomalo;
	}

	public void setPisomalo(String pisomalo) {
		this.pisomalo = pisomalo;
	}

	public String getPisoregular() {
		return this.pisoregular;
	}

	public void setPisoregular(String pisoregular) {
		this.pisoregular = pisoregular;
	}

	public String getRio() {
		return this.rio;
	}

	public void setRio(String rio) {
		this.rio = rio;
	}

	public String getSendero() {
		return this.sendero;
	}

	public void setSendero(String sendero) {
		this.sendero = sendero;
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getTechobueno() {
		return this.techobueno;
	}

	public void setTechobueno(String techobueno) {
		this.techobueno = techobueno;
	}

	public String getTechomalo() {
		return this.techomalo;
	}

	public void setTechomalo(String techomalo) {
		this.techomalo = techomalo;
	}

	public String getTechoregular() {
		return this.techoregular;
	}

	public void setTechoregular(String techoregular) {
		this.techoregular = techoregular;
	}

	public String getTeja() {
		return this.teja;
	}

	public void setTeja(String teja) {
		this.teja = teja;
	}

	public String getTierra() {
		return this.tierra;
	}

	public void setTierra(String tierra) {
		this.tierra = tierra;
	}

	public String getZinc() {
		return this.zinc;
	}

	public void setZinc(String zinc) {
		this.zinc = zinc;
	}

	public FfaVivienda getFfavivienda() {
		return this.ffavivienda;
	}

	public void setFfavivienda(FfaVivienda ffavivienda) {
		this.ffavivienda = ffavivienda;
	}

}