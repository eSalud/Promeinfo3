package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ffatipodocumentacion database table.
 * 
 */
@Entity
@NamedQuery(name="FfaTipoDocumentacion.findAll", query="SELECT f FROM FfaTipoDocumentacion f")
public class FfaTipoDocumentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipodocumento;

	private String descripcion;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@OneToMany(mappedBy="ffatipodocumentacion")
	private List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars;

	public FfaTipoDocumentacion() {
	}

	public Long getIdtipodocumento() {
		return this.idtipodocumento;
	}

	public void setIdtipodocumento(Long idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
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
		ffapersonasfichafamiliar.setFfatipodocumentacion(this);

		return ffapersonasfichafamiliar;
	}

	public FfaPersonaFichaFamiliar removeFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().remove(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setFfatipodocumentacion(null);

		return ffapersonasfichafamiliar;
	}

}