package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the partipossexos database table.
 * 
 */
@Entity
@Table(name="partipossexos")
@NamedQuery(name="ParTipoSexo.findAll", query="SELECT p FROM ParTipoSexo p")
public class ParTipoSexo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtiposexo;

	private String codtiposexo;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to AdmPersonaSistema
	@OneToMany(mappedBy="partipossexo")
	private List<AdmPersonaSistema> admpersonassistemas;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@OneToMany(mappedBy="partipossexo")
	private List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars;

	//bi-directional many-to-one association to ParPersona
	@OneToMany(mappedBy="partipossexo")
	private List<ParPersona> parpersonas;

	public ParTipoSexo() {
	}

	public Long getIdtiposexo() {
		return this.idtiposexo;
	}

	public void setIdtiposexo(Long idtiposexo) {
		this.idtiposexo = idtiposexo;
	}

	public String getCodtiposexo() {
		return this.codtiposexo;
	}

	public void setCodtiposexo(String codtiposexo) {
		this.codtiposexo = codtiposexo;
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
		admpersonassistema.setPartipossexo(this);

		return admpersonassistema;
	}

	public AdmPersonaSistema removeAdmpersonassistema(AdmPersonaSistema admpersonassistema) {
		getAdmpersonassistemas().remove(admpersonassistema);
		admpersonassistema.setPartipossexo(null);

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
		ffapersonasfichafamiliar.setPartipossexo(this);

		return ffapersonasfichafamiliar;
	}

	public FfaPersonaFichaFamiliar removeFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().remove(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setPartipossexo(null);

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
		parpersona.setPartipossexo(this);

		return parpersona;
	}

	public ParPersona removeParpersona(ParPersona parpersona) {
		getParpersonas().remove(parpersona);
		parpersona.setPartipossexo(null);

		return parpersona;
	}

}