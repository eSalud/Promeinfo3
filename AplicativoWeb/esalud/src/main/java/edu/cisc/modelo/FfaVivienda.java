package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ffavivienda database table.
 * 
 */
@Entity
@NamedQuery(name="FfaVivienda.findAll", query="SELECT f FROM FfaVivienda f")
public class FfaVivienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idvivienda;

	private String calleprincipial;

	private String callesecundaria;

	private String canton;

	private String desclocalidad;

	private String estado;

	private Integer idaereo;

	private Integer idcalle;

	private Integer idcanoa;

	private Integer idcanton;

	private Integer idcelular;

	private Integer idconvensional;

	private Integer iddepartamento;

	private Integer iddistrito;

	private Integer iddivision;

	private Integer idedificio;

	private Integer idhogar;

	private Integer idinstitucion;

	private Integer idlocalidad;

	private Integer idlote;

	private Integer idmanzana;

	private Integer idmotor;

	private Integer idotro;

	private Integer idparroquia;

	private Integer idpie;

	private Integer idpiso;

	private Integer idprovincia;

	private Integer idsector;

	private Integer idzona;

	private Integer minaereo;

	private Integer minmotor;

	private Integer minotro;

	private Integer minpie;

	private String nombrehabitacional;

	private String parroquia;

	private String provincia;

	private String referenciahabit;

	//bi-directional many-to-one association to FfaCondicionOcupacional
	@OneToMany(mappedBy="ffavivienda")
	private List<FfaCondicionOcupacional> ffacondicionocupacionals;

	//bi-directional many-to-one association to FfaMortalidad
	@OneToMany(mappedBy="ffavivienda")
	private List<FfaMortalidad> ffamortalidads;

	//bi-directional many-to-one association to FfaViviendaControl
	@OneToMany(mappedBy="ffavivienda")
	private List<FfaViviendaControl> ffaviviendacontrols;

	//bi-directional many-to-one association to FfaViviendaDato
	@OneToMany(mappedBy="ffavivienda")
	private List<FfaViviendaDato> ffaviviendadatos;

	//bi-directional many-to-one association to FfaViviendaFactor
	@OneToMany(mappedBy="ffavivienda")
	private List<FfaViviendaFactor> ffaviviendafactores;

	//bi-directional many-to-one association to FfaViviendaHogar
	@OneToMany(mappedBy="ffavivienda")
	private List<FfaViviendaHogar> ffaviviendahogares;

	public FfaVivienda() {
	}

	public Long getIdvivienda() {
		return this.idvivienda;
	}

	public void setIdvivienda(Long idvivienda) {
		this.idvivienda = idvivienda;
	}

	public String getCalleprincipial() {
		return this.calleprincipial;
	}

	public void setCalleprincipial(String calleprincipial) {
		this.calleprincipial = calleprincipial;
	}

	public String getCallesecundaria() {
		return this.callesecundaria;
	}

	public void setCallesecundaria(String callesecundaria) {
		this.callesecundaria = callesecundaria;
	}

	public String getCanton() {
		return this.canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getDesclocalidad() {
		return this.desclocalidad;
	}

	public void setDesclocalidad(String desclocalidad) {
		this.desclocalidad = desclocalidad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdaereo() {
		return this.idaereo;
	}

	public void setIdaereo(Integer idaereo) {
		this.idaereo = idaereo;
	}

	public Integer getIdcalle() {
		return this.idcalle;
	}

	public void setIdcalle(Integer idcalle) {
		this.idcalle = idcalle;
	}

	public Integer getIdcanoa() {
		return this.idcanoa;
	}

	public void setIdcanoa(Integer idcanoa) {
		this.idcanoa = idcanoa;
	}

	public Integer getIdcanton() {
		return this.idcanton;
	}

	public void setIdcanton(Integer idcanton) {
		this.idcanton = idcanton;
	}

	public Integer getIdcelular() {
		return this.idcelular;
	}

	public void setIdcelular(Integer idcelular) {
		this.idcelular = idcelular;
	}

	public Integer getIdconvensional() {
		return this.idconvensional;
	}

	public void setIdconvensional(Integer idconvensional) {
		this.idconvensional = idconvensional;
	}

	public Integer getIddepartamento() {
		return this.iddepartamento;
	}

	public void setIddepartamento(Integer iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public Integer getIddistrito() {
		return this.iddistrito;
	}

	public void setIddistrito(Integer iddistrito) {
		this.iddistrito = iddistrito;
	}

	public Integer getIddivision() {
		return this.iddivision;
	}

	public void setIddivision(Integer iddivision) {
		this.iddivision = iddivision;
	}

	public Integer getIdedificio() {
		return this.idedificio;
	}

	public void setIdedificio(Integer idedificio) {
		this.idedificio = idedificio;
	}

	public Integer getIdhogar() {
		return this.idhogar;
	}

	public void setIdhogar(Integer idhogar) {
		this.idhogar = idhogar;
	}

	public Integer getIdinstitucion() {
		return this.idinstitucion;
	}

	public void setIdinstitucion(Integer idinstitucion) {
		this.idinstitucion = idinstitucion;
	}

	public Integer getIdlocalidad() {
		return this.idlocalidad;
	}

	public void setIdlocalidad(Integer idlocalidad) {
		this.idlocalidad = idlocalidad;
	}

	public Integer getIdlote() {
		return this.idlote;
	}

	public void setIdlote(Integer idlote) {
		this.idlote = idlote;
	}

	public Integer getIdmanzana() {
		return this.idmanzana;
	}

	public void setIdmanzana(Integer idmanzana) {
		this.idmanzana = idmanzana;
	}

	public Integer getIdmotor() {
		return this.idmotor;
	}

	public void setIdmotor(Integer idmotor) {
		this.idmotor = idmotor;
	}

	public Integer getIdotro() {
		return this.idotro;
	}

	public void setIdotro(Integer idotro) {
		this.idotro = idotro;
	}

	public Integer getIdparroquia() {
		return this.idparroquia;
	}

	public void setIdparroquia(Integer idparroquia) {
		this.idparroquia = idparroquia;
	}

	public Integer getIdpie() {
		return this.idpie;
	}

	public void setIdpie(Integer idpie) {
		this.idpie = idpie;
	}

	public Integer getIdpiso() {
		return this.idpiso;
	}

	public void setIdpiso(Integer idpiso) {
		this.idpiso = idpiso;
	}

	public Integer getIdprovincia() {
		return this.idprovincia;
	}

	public void setIdprovincia(Integer idprovincia) {
		this.idprovincia = idprovincia;
	}

	public Integer getIdsector() {
		return this.idsector;
	}

	public void setIdsector(Integer idsector) {
		this.idsector = idsector;
	}

	public Integer getIdzona() {
		return this.idzona;
	}

	public void setIdzona(Integer idzona) {
		this.idzona = idzona;
	}

	public Integer getMinaereo() {
		return this.minaereo;
	}

	public void setMinaereo(Integer minaereo) {
		this.minaereo = minaereo;
	}

	public Integer getMinmotor() {
		return this.minmotor;
	}

	public void setMinmotor(Integer minmotor) {
		this.minmotor = minmotor;
	}

	public Integer getMinotro() {
		return this.minotro;
	}

	public void setMinotro(Integer minotro) {
		this.minotro = minotro;
	}

	public Integer getMinpie() {
		return this.minpie;
	}

	public void setMinpie(Integer minpie) {
		this.minpie = minpie;
	}

	public String getNombrehabitacional() {
		return this.nombrehabitacional;
	}

	public void setNombrehabitacional(String nombrehabitacional) {
		this.nombrehabitacional = nombrehabitacional;
	}

	public String getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getReferenciahabit() {
		return this.referenciahabit;
	}

	public void setReferenciahabit(String referenciahabit) {
		this.referenciahabit = referenciahabit;
	}

	public List<FfaCondicionOcupacional> getFfacondicionocupacionals() {
		return this.ffacondicionocupacionals;
	}

	public void setFfacondicionocupacionals(List<FfaCondicionOcupacional> ffacondicionocupacionals) {
		this.ffacondicionocupacionals = ffacondicionocupacionals;
	}

	public FfaCondicionOcupacional addFfacondicionocupacional(FfaCondicionOcupacional ffacondicionocupacional) {
		getFfacondicionocupacionals().add(ffacondicionocupacional);
		ffacondicionocupacional.setFfavivienda(this);

		return ffacondicionocupacional;
	}

	public FfaCondicionOcupacional removeFfacondicionocupacional(FfaCondicionOcupacional ffacondicionocupacional) {
		getFfacondicionocupacionals().remove(ffacondicionocupacional);
		ffacondicionocupacional.setFfavivienda(null);

		return ffacondicionocupacional;
	}

	public List<FfaMortalidad> getFfamortalidads() {
		return this.ffamortalidads;
	}

	public void setFfamortalidads(List<FfaMortalidad> ffamortalidads) {
		this.ffamortalidads = ffamortalidads;
	}

	public FfaMortalidad addFfamortalidad(FfaMortalidad ffamortalidad) {
		getFfamortalidads().add(ffamortalidad);
		ffamortalidad.setFfavivienda(this);

		return ffamortalidad;
	}

	public FfaMortalidad removeFfamortalidad(FfaMortalidad ffamortalidad) {
		getFfamortalidads().remove(ffamortalidad);
		ffamortalidad.setFfavivienda(null);

		return ffamortalidad;
	}

	public List<FfaViviendaControl> getFfaviviendacontrols() {
		return this.ffaviviendacontrols;
	}

	public void setFfaviviendacontrols(List<FfaViviendaControl> ffaviviendacontrols) {
		this.ffaviviendacontrols = ffaviviendacontrols;
	}

	public FfaViviendaControl addFfaviviendacontrol(FfaViviendaControl ffaviviendacontrol) {
		getFfaviviendacontrols().add(ffaviviendacontrol);
		ffaviviendacontrol.setFfavivienda(this);

		return ffaviviendacontrol;
	}

	public FfaViviendaControl removeFfaviviendacontrol(FfaViviendaControl ffaviviendacontrol) {
		getFfaviviendacontrols().remove(ffaviviendacontrol);
		ffaviviendacontrol.setFfavivienda(null);

		return ffaviviendacontrol;
	}

	public List<FfaViviendaDato> getFfaviviendadatos() {
		return this.ffaviviendadatos;
	}

	public void setFfaviviendadatos(List<FfaViviendaDato> ffaviviendadatos) {
		this.ffaviviendadatos = ffaviviendadatos;
	}

	public FfaViviendaDato addFfaviviendadato(FfaViviendaDato ffaviviendadato) {
		getFfaviviendadatos().add(ffaviviendadato);
		ffaviviendadato.setFfavivienda(this);

		return ffaviviendadato;
	}

	public FfaViviendaDato removeFfaviviendadato(FfaViviendaDato ffaviviendadato) {
		getFfaviviendadatos().remove(ffaviviendadato);
		ffaviviendadato.setFfavivienda(null);

		return ffaviviendadato;
	}

	public List<FfaViviendaFactor> getFfaviviendafactores() {
		return this.ffaviviendafactores;
	}

	public void setFfaviviendafactores(List<FfaViviendaFactor> ffaviviendafactores) {
		this.ffaviviendafactores = ffaviviendafactores;
	}

	public FfaViviendaFactor addFfaviviendafactore(FfaViviendaFactor ffaviviendafactore) {
		getFfaviviendafactores().add(ffaviviendafactore);
		ffaviviendafactore.setFfavivienda(this);

		return ffaviviendafactore;
	}

	public FfaViviendaFactor removeFfaviviendafactore(FfaViviendaFactor ffaviviendafactore) {
		getFfaviviendafactores().remove(ffaviviendafactore);
		ffaviviendafactore.setFfavivienda(null);

		return ffaviviendafactore;
	}

	public List<FfaViviendaHogar> getFfaviviendahogares() {
		return this.ffaviviendahogares;
	}

	public void setFfaviviendahogares(List<FfaViviendaHogar> ffaviviendahogares) {
		this.ffaviviendahogares = ffaviviendahogares;
	}

	public FfaViviendaHogar addFfaviviendahogare(FfaViviendaHogar ffaviviendahogare) {
		getFfaviviendahogares().add(ffaviviendahogare);
		ffaviviendahogare.setFfavivienda(this);

		return ffaviviendahogare;
	}

	public FfaViviendaHogar removeFfaviviendahogare(FfaViviendaHogar ffaviviendahogare) {
		getFfaviviendahogares().remove(ffaviviendahogare);
		ffaviviendahogare.setFfavivienda(null);

		return ffaviviendahogare;
	}

}