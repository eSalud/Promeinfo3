package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ffaciclovitalfamiliar database table.
 * 
 */
@Entity
@NamedQuery(name="FfaCicloVitalFamiliar.findAll", query="SELECT f FROM FfaCicloVitalFamiliar f")
public class FfaCicloVitalFamiliar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idciclovitalfam;

	private String descripcion;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@OneToMany(mappedBy="ffaciclovitalfamiliar")
	private List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars;

	public FfaCicloVitalFamiliar() {
	}

	public Long getIdciclovitalfam() {
		return this.idciclovitalfam;
	}

	public void setIdciclovitalfam(Long idciclovitalfam) {
		this.idciclovitalfam = idciclovitalfam;
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
		ffapersonasfichafamiliar.setFfaciclovitalfamiliar(this);

		return ffapersonasfichafamiliar;
	}

	public FfaPersonaFichaFamiliar removeFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().remove(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setFfaciclovitalfamiliar(null);

		return ffapersonasfichafamiliar;
	}

}