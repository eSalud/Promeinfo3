package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ffanucleofamiliar database table.
 * 
 */
@Entity
@NamedQuery(name="FfaNucleoFamiliar.findAll", query="SELECT f FROM FfaNucleoFamiliar f")
public class FfaNucleoFamiliar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idnucleofamiliar;

	private String descripcion;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@OneToMany(mappedBy="ffanucleofamiliar")
	private List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars;

	public FfaNucleoFamiliar() {
	}

	public Long getIdnucleofamiliar() {
		return this.idnucleofamiliar;
	}

	public void setIdnucleofamiliar(Long idnucleofamiliar) {
		this.idnucleofamiliar = idnucleofamiliar;
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
		ffapersonasfichafamiliar.setFfanucleofamiliar(this);

		return ffapersonasfichafamiliar;
	}

	public FfaPersonaFichaFamiliar removeFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().remove(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setFfanucleofamiliar(null);

		return ffapersonasfichafamiliar;
	}

}