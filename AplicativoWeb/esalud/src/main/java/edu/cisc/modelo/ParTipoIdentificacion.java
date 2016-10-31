package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the partiposidentificacion database table.
 * 
 */
@Entity
@Table(name="partiposidentificacion")
@NamedQuery(name="ParTipoIdentificacion.findAll", query="SELECT p FROM ParTipoIdentificacion p")
public class ParTipoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipoidentif;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to AdmPersonaSistema
	@OneToMany(mappedBy="partiposidentificacion")
	private List<AdmPersonaSistema> admpersonassistemas;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@OneToMany(mappedBy="partiposidentificacion")
	private List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars;

	//bi-directional many-to-one association to ParPersona
	@OneToMany(mappedBy="partiposidentificacion")
	private List<ParPersona> parpersonas;

	public ParTipoIdentificacion() {
	}

	public Long getIdtipoidentif() {
		return this.idtipoidentif;
	}

	public void setIdtipoidentif(Long idtipoidentif) {
		this.idtipoidentif = idtipoidentif;
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
		admpersonassistema.setPartiposidentificacion(this);

		return admpersonassistema;
	}

	public AdmPersonaSistema removeAdmpersonassistema(AdmPersonaSistema admpersonassistema) {
		getAdmpersonassistemas().remove(admpersonassistema);
		admpersonassistema.setPartiposidentificacion(null);

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
		ffapersonasfichafamiliar.setPartiposidentificacion(this);

		return ffapersonasfichafamiliar;
	}

	public FfaPersonaFichaFamiliar removeFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().remove(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setPartiposidentificacion(null);

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
		parpersona.setPartiposidentificacion(this);

		return parpersona;
	}

	public ParPersona removeParpersona(ParPersona parpersona) {
		getParpersonas().remove(parpersona);
		parpersona.setPartiposidentificacion(null);

		return parpersona;
	}

}