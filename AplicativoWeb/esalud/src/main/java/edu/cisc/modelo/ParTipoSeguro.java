package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the partiposeguro database table.
 * 
 */
@Entity
@NamedQuery(name="ParTipoSeguro.findAll", query="SELECT p FROM ParTipoSeguro p")
public class ParTipoSeguro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtiposeguro;

	private String codseguro;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@OneToMany(mappedBy="partiposeguro")
	private List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars;

	public ParTipoSeguro() {
	}

	public Long getIdtiposeguro() {
		return this.idtiposeguro;
	}

	public void setIdtiposeguro(Long idtiposeguro) {
		this.idtiposeguro = idtiposeguro;
	}

	public String getCodseguro() {
		return this.codseguro;
	}

	public void setCodseguro(String codseguro) {
		this.codseguro = codseguro;
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

	public List<FfaPersonaFichaFamiliar> getFfapersonasfichafamiliars() {
		return this.ffapersonasfichafamiliars;
	}

	public void setFfapersonasfichafamiliars(List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars) {
		this.ffapersonasfichafamiliars = ffapersonasfichafamiliars;
	}

	public FfaPersonaFichaFamiliar addFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().add(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setPartiposeguro(this);

		return ffapersonasfichafamiliar;
	}

	public FfaPersonaFichaFamiliar removeFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().remove(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setPartiposeguro(null);

		return ffapersonasfichafamiliar;
	}

}