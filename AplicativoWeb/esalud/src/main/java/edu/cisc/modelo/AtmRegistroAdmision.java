package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atmregistroadmision database table.
 * 
 */
@Entity
@NamedQuery(name="AtmRegistroAdmision.findAll", query="SELECT a FROM AtmRegistroAdmision a")
public class AtmRegistroAdmision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idregistroadmision;

	private String barrio;

	private String codcanton;

	private String codestablecimiento;

	private String codparroquia;

	private String codprovincia;

	private String codtipoestcivil;

	private String codtipogrupocult;

	private String codtipoinstruccion;

	private String codtiponacional;

	private String codtiposeguro;

	private String codtiposexo;

	private String codzona;

	private String direccionparent;

	private String empresa;

	private String idadmisionista;

	private String lugarnacimiento;

	private String lugartrabajo;

	private String necesariollamar;

	private String ocupacion;

	private String parentesco;

	private String recidenciahabitual;

	private String telefono;

	//bi-directional many-to-one association to AtmFichaAdmision
	@OneToMany(mappedBy="atmregistroadmision")
	private List<AtmFichaAdmision> atmfichasadmisions;

	//bi-directional many-to-one association to ParPersona
	@ManyToOne
	@JoinColumn(name="idpersona")
	private ParPersona parpersona;

	public AtmRegistroAdmision() {
	}

	public Long getIdregistroadmision() {
		return this.idregistroadmision;
	}

	public void setIdregistroadmision(Long idregistroadmision) {
		this.idregistroadmision = idregistroadmision;
	}

	public String getBarrio() {
		return this.barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCodcanton() {
		return this.codcanton;
	}

	public void setCodcanton(String codcanton) {
		this.codcanton = codcanton;
	}

	public String getCodestablecimiento() {
		return this.codestablecimiento;
	}

	public void setCodestablecimiento(String codestablecimiento) {
		this.codestablecimiento = codestablecimiento;
	}

	public String getCodparroquia() {
		return this.codparroquia;
	}

	public void setCodparroquia(String codparroquia) {
		this.codparroquia = codparroquia;
	}

	public String getCodprovincia() {
		return this.codprovincia;
	}

	public void setCodprovincia(String codprovincia) {
		this.codprovincia = codprovincia;
	}

	public String getCodtipoestcivil() {
		return this.codtipoestcivil;
	}

	public void setCodtipoestcivil(String codtipoestcivil) {
		this.codtipoestcivil = codtipoestcivil;
	}

	public String getCodtipogrupocult() {
		return this.codtipogrupocult;
	}

	public void setCodtipogrupocult(String codtipogrupocult) {
		this.codtipogrupocult = codtipogrupocult;
	}

	public String getCodtipoinstruccion() {
		return this.codtipoinstruccion;
	}

	public void setCodtipoinstruccion(String codtipoinstruccion) {
		this.codtipoinstruccion = codtipoinstruccion;
	}

	public String getCodtiponacional() {
		return this.codtiponacional;
	}

	public void setCodtiponacional(String codtiponacional) {
		this.codtiponacional = codtiponacional;
	}

	public String getCodtiposeguro() {
		return this.codtiposeguro;
	}

	public void setCodtiposeguro(String codtiposeguro) {
		this.codtiposeguro = codtiposeguro;
	}

	public String getCodtiposexo() {
		return this.codtiposexo;
	}

	public void setCodtiposexo(String codtiposexo) {
		this.codtiposexo = codtiposexo;
	}

	public String getCodzona() {
		return this.codzona;
	}

	public void setCodzona(String codzona) {
		this.codzona = codzona;
	}

	public String getDireccionparent() {
		return this.direccionparent;
	}

	public void setDireccionparent(String direccionparent) {
		this.direccionparent = direccionparent;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getIdadmisionista() {
		return this.idadmisionista;
	}

	public void setIdadmisionista(String idadmisionista) {
		this.idadmisionista = idadmisionista;
	}

	public String getLugarnacimiento() {
		return this.lugarnacimiento;
	}

	public void setLugarnacimiento(String lugarnacimiento) {
		this.lugarnacimiento = lugarnacimiento;
	}

	public String getLugartrabajo() {
		return this.lugartrabajo;
	}

	public void setLugartrabajo(String lugartrabajo) {
		this.lugartrabajo = lugartrabajo;
	}

	public String getNecesariollamar() {
		return this.necesariollamar;
	}

	public void setNecesariollamar(String necesariollamar) {
		this.necesariollamar = necesariollamar;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getRecidenciahabitual() {
		return this.recidenciahabitual;
	}

	public void setRecidenciahabitual(String recidenciahabitual) {
		this.recidenciahabitual = recidenciahabitual;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<AtmFichaAdmision> getAtmfichasadmisions() {
		return this.atmfichasadmisions;
	}

	public void setAtmfichasadmisions(List<AtmFichaAdmision> atmfichasadmisions) {
		this.atmfichasadmisions = atmfichasadmisions;
	}

	public AtmFichaAdmision addAtmfichasadmision(AtmFichaAdmision atmfichasadmision) {
		getAtmfichasadmisions().add(atmfichasadmision);
		atmfichasadmision.setAtmregistroadmision(this);

		return atmfichasadmision;
	}

	public AtmFichaAdmision removeAtmfichasadmision(AtmFichaAdmision atmfichasadmision) {
		getAtmfichasadmisions().remove(atmfichasadmision);
		atmfichasadmision.setAtmregistroadmision(null);

		return atmfichasadmision;
	}

	public ParPersona getParpersona() {
		return this.parpersona;
	}

	public void setParpersona(ParPersona parpersona) {
		this.parpersona = parpersona;
	}

}