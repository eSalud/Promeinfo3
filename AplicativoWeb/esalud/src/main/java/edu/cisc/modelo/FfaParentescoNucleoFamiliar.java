package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ffaparentesconucleofamiliar database table.
 * 
 */
@Entity
@NamedQuery(name="FfaParentescoNucleoFamiliar.findAll", query="SELECT f FROM FfaParentescoNucleoFamiliar f")
public class FfaParentescoNucleoFamiliar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idparentesconucleo;

	private String descripcion;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@OneToMany(mappedBy="ffaparentesconucleofamiliar")
	private List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars;

	public FfaParentescoNucleoFamiliar() {
	}

	public Long getIdparentesconucleo() {
		return this.idparentesconucleo;
	}

	public void setIdparentesconucleo(Long idparentesconucleo) {
		this.idparentesconucleo = idparentesconucleo;
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
		ffapersonasfichafamiliar.setFfaparentesconucleofamiliar(this);

		return ffapersonasfichafamiliar;
	}

	public FfaPersonaFichaFamiliar removeFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().remove(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setFfaparentesconucleofamiliar(null);

		return ffapersonasfichafamiliar;
	}

}