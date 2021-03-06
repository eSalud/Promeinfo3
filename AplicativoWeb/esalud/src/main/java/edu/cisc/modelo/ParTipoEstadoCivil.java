package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the partiposestadocivil database table.
 * 
 */
@Entity
@Table(name="partiposestadocivil")
@NamedQuery(name="ParTipoEstadoCivil.findAll", query="SELECT p FROM ParTipoEstadoCivil p")
public class ParTipoEstadoCivil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipoestcivil;

	private String codtipoestcivil;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to AdmPersonaSistema
	@OneToMany(mappedBy="partiposestadocivil")
	private List<AdmPersonaSistema> admpersonassistemas;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@OneToMany(mappedBy="partiposestadocivil")
	private List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars;

	//bi-directional many-to-one association to ParPersona
	@OneToMany(mappedBy="partiposestadocivil")
	private List<ParPersona> parpersonas;

	public ParTipoEstadoCivil() {
	}

	public Long getIdtipoestcivil() {
		return this.idtipoestcivil;
	}

	public void setIdtipoestcivil(Long idtipoestcivil) {
		this.idtipoestcivil = idtipoestcivil;
	}

	public String getCodtipoestcivil() {
		return this.codtipoestcivil;
	}

	public void setCodtipoestcivil(String codtipoestcivil) {
		this.codtipoestcivil = codtipoestcivil;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<AdmPersonaSistema> getAdmpersonassistemas() {
		return this.admpersonassistemas;
	}

	public void setAdmpersonassistemas(List<AdmPersonaSistema> admpersonassistemas) {
		this.admpersonassistemas = admpersonassistemas;
	}

	public AdmPersonaSistema addAdmpersonassistema(AdmPersonaSistema admpersonassistema) {
		getAdmpersonassistemas().add(admpersonassistema);
		admpersonassistema.setPartiposestadocivil(this);

		return admpersonassistema;
	}

	public AdmPersonaSistema removeAdmpersonassistema(AdmPersonaSistema admpersonassistema) {
		getAdmpersonassistemas().remove(admpersonassistema);
		admpersonassistema.setPartiposestadocivil(null);

		return admpersonassistema;
	}

	public List<FfaPersonaFichaFamiliar> getFfapersonasfichafamiliars() {
		return this.ffapersonasfichafamiliars;
	}

	public void setFfapersonasfichafamiliars(List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars) {
		this.ffapersonasfichafamiliars = ffapersonasfichafamiliars;
	}

	public FfaPersonaFichaFamiliar addFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().add(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setPartiposestadocivil(this);

		return ffapersonasfichafamiliar;
	}

	public FfaPersonaFichaFamiliar removeFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().remove(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setPartiposestadocivil(null);

		return ffapersonasfichafamiliar;
	}

	public List<ParPersona> getParpersonas() {
		return this.parpersonas;
	}

	public void setParpersonas(List<ParPersona> parpersonas) {
		this.parpersonas = parpersonas;
	}

	public ParPersona addParpersona(ParPersona parpersona) {
		getParpersonas().add(parpersona);
		parpersona.setPartiposestadocivil(this);

		return parpersona;
	}

	public ParPersona removeParpersona(ParPersona parpersona) {
		getParpersonas().remove(parpersona);
		parpersona.setPartiposestadocivil(null);

		return parpersona;
	}

}