package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the atmvisitashcu database table.
 * 
 */
@Entity
@Table(name="atmvisitashcu")
@NamedQuery(name="AtmVisitaHCU.findAll", query="SELECT a FROM AtmVisitaHCU a")
public class AtmVisitaHCU implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idvisita;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechavisita;

	private Integer idpaciente;

	private Integer idpromotor;

	private Integer numerohoja;

	//bi-directional many-to-one association to AtmAntFamRegistro
	@OneToMany(mappedBy="atmvisitashcu")
	private List<AtmAntFamRegistro> atmantfamregistros;

	//bi-directional many-to-one association to AtmAntPerRegistro
	@OneToMany(mappedBy="atmvisitashcu")
	private List<AtmAntPerRegistro> atmantperregistros;

	//bi-directional many-to-one association to AtmCancer
	@OneToMany(mappedBy="atmvisitashcu")
	private List<AtmCancer> atmcancers;

	//bi-directional many-to-one association to AtmSigVitalMed
	@OneToMany(mappedBy="atmvisitashcu")
	private List<AtmSigVitalMed> atmsigvitalmeds;

	//bi-directional many-to-one association to ProUnidadOperativa
	@ManyToOne
	@JoinColumn(name="idunidadop")
	private ProUnidadOperativa prounidadoperativa;

	//bi-directional many-to-one association to HcfPrincipal
	@OneToMany(mappedBy="atmvisitashcu")
	private List<HcfPrincipal> hcfprincipals;

	//bi-directional many-to-one association to SviSignoVital
	@OneToMany(mappedBy="atmvisitashcu")
	private List<SviSignoVital> svisignosvitales;

	public AtmVisitaHCU() {
	}

	public Long getIdvisita() {
		return this.idvisita;
	}

	public void setIdvisita(Long idvisita) {
		this.idvisita = idvisita;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechavisita() {
		return this.fechavisita;
	}

	public void setFechavisita(Date fechavisita) {
		this.fechavisita = fechavisita;
	}

	public Integer getIdpaciente() {
		return this.idpaciente;
	}

	public void setIdpaciente(Integer idpaciente) {
		this.idpaciente = idpaciente;
	}

	public Integer getIdpromotor() {
		return this.idpromotor;
	}

	public void setIdpromotor(Integer idpromotor) {
		this.idpromotor = idpromotor;
	}

	public Integer getNumerohoja() {
		return this.numerohoja;
	}

	public void setNumerohoja(Integer numerohoja) {
		this.numerohoja = numerohoja;
	}

	public List<AtmAntFamRegistro> getAtmantfamregistros() {
		return this.atmantfamregistros;
	}

	public void setAtmantfamregistros(List<AtmAntFamRegistro> atmantfamregistros) {
		this.atmantfamregistros = atmantfamregistros;
	}

	public AtmAntFamRegistro addAtmantfamregistro(AtmAntFamRegistro atmantfamregistro) {
		getAtmantfamregistros().add(atmantfamregistro);
		atmantfamregistro.setAtmvisitashcu(this);

		return atmantfamregistro;
	}

	public AtmAntFamRegistro removeAtmantfamregistro(AtmAntFamRegistro atmantfamregistro) {
		getAtmantfamregistros().remove(atmantfamregistro);
		atmantfamregistro.setAtmvisitashcu(null);

		return atmantfamregistro;
	}

	public List<AtmAntPerRegistro> getAtmantperregistros() {
		return this.atmantperregistros;
	}

	public void setAtmantperregistros(List<AtmAntPerRegistro> atmantperregistros) {
		this.atmantperregistros = atmantperregistros;
	}

	public AtmAntPerRegistro addAtmantperregistro(AtmAntPerRegistro atmantperregistro) {
		getAtmantperregistros().add(atmantperregistro);
		atmantperregistro.setAtmvisitashcu(this);

		return atmantperregistro;
	}

	public AtmAntPerRegistro removeAtmantperregistro(AtmAntPerRegistro atmantperregistro) {
		getAtmantperregistros().remove(atmantperregistro);
		atmantperregistro.setAtmvisitashcu(null);

		return atmantperregistro;
	}

	public List<AtmCancer> getAtmcancers() {
		return this.atmcancers;
	}

	public void setAtmcancers(List<AtmCancer> atmcancers) {
		this.atmcancers = atmcancers;
	}

	public AtmCancer addAtmcancer(AtmCancer atmcancer) {
		getAtmcancers().add(atmcancer);
		atmcancer.setAtmvisitashcu(this);

		return atmcancer;
	}

	public AtmCancer removeAtmcancer(AtmCancer atmcancer) {
		getAtmcancers().remove(atmcancer);
		atmcancer.setAtmvisitashcu(null);

		return atmcancer;
	}

	public List<AtmSigVitalMed> getAtmsigvitalmeds() {
		return this.atmsigvitalmeds;
	}

	public void setAtmsigvitalmeds(List<AtmSigVitalMed> atmsigvitalmeds) {
		this.atmsigvitalmeds = atmsigvitalmeds;
	}

	public AtmSigVitalMed addAtmsigvitalmed(AtmSigVitalMed atmsigvitalmed) {
		getAtmsigvitalmeds().add(atmsigvitalmed);
		atmsigvitalmed.setAtmvisitashcu(this);

		return atmsigvitalmed;
	}

	public AtmSigVitalMed removeAtmsigvitalmed(AtmSigVitalMed atmsigvitalmed) {
		getAtmsigvitalmeds().remove(atmsigvitalmed);
		atmsigvitalmed.setAtmvisitashcu(null);

		return atmsigvitalmed;
	}

	public ProUnidadOperativa getProunidadoperativa() {
		return this.prounidadoperativa;
	}

	public void setProunidadoperativa(ProUnidadOperativa prounidadoperativa) {
		this.prounidadoperativa = prounidadoperativa;
	}

	public List<HcfPrincipal> getHcfprincipals() {
		return this.hcfprincipals;
	}

	public void setHcfprincipals(List<HcfPrincipal> hcfprincipals) {
		this.hcfprincipals = hcfprincipals;
	}

	public HcfPrincipal addHcfprincipal(HcfPrincipal hcfprincipal) {
		getHcfprincipals().add(hcfprincipal);
		hcfprincipal.setAtmvisitashcu(this);

		return hcfprincipal;
	}

	public HcfPrincipal removeHcfprincipal(HcfPrincipal hcfprincipal) {
		getHcfprincipals().remove(hcfprincipal);
		hcfprincipal.setAtmvisitashcu(null);

		return hcfprincipal;
	}

	public List<SviSignoVital> getSvisignosvitales() {
		return this.svisignosvitales;
	}

	public void setSvisignosvitales(List<SviSignoVital> svisignosvitales) {
		this.svisignosvitales = svisignosvitales;
	}

	public SviSignoVital addSvisignosvitale(SviSignoVital svisignosvitale) {
		getSvisignosvitales().add(svisignosvitale);
		svisignosvitale.setAtmvisitashcu(this);

		return svisignosvitale;
	}

	public SviSignoVital removeSvisignosvitale(SviSignoVital svisignosvitale) {
		getSvisignosvitales().remove(svisignosvitale);
		svisignosvitale.setAtmvisitashcu(null);

		return svisignosvitale;
	}

}