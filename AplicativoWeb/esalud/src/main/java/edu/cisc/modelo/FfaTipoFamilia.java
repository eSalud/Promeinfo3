package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ffatipofamilia database table.
 * 
 */
@Entity
@NamedQuery(name="FfaTipoFamilia.findAll", query="SELECT f FROM FfaTipoFamilia f")
public class FfaTipoFamilia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipofamilia;

	private String descripcion;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@OneToMany(mappedBy="ffatipofamilia")
	private List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars;

	public FfaTipoFamilia() {
	}

	public Long getIdtipofamilia() {
		return this.idtipofamilia;
	}

	public void setIdtipofamilia(Long idtipofamilia) {
		this.idtipofamilia = idtipofamilia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<FfaPersonaFichaFamiliar> getFfapersonasfichafamiliars() {
		return this.ffapersonasfichafamiliars;
	}

	public void setFfapersonasfichafamiliars(List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars) {
		this.ffapersonasfichafamiliars = ffapersonasfichafamiliars;
	}

	public FfaPersonaFichaFamiliar addFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().add(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setFfatipofamilia(this);

		return ffapersonasfichafamiliar;
	}

	public FfaPersonaFichaFamiliar removeFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().remove(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setFfatipofamilia(null);

		return ffapersonasfichafamiliar;
	}

}