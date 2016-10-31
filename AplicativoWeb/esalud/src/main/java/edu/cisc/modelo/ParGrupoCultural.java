package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pargruposculturales database table.
 * 
 */
@Entity
@Table(name="pargruposculturales")
@NamedQuery(name="ParGrupoCultural.findAll", query="SELECT p FROM ParGrupoCultural p")
public class ParGrupoCultural implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idgrupocultural;

	private String codgrupocultural;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@OneToMany(mappedBy="pargruposculturale")
	private List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars;

	//bi-directional many-to-one association to ParFamilia
	@OneToMany(mappedBy="pargruposculturale")
	private List<ParFamilia> parfamilias;

	public ParGrupoCultural() {
	}

	public Long getIdgrupocultural() {
		return this.idgrupocultural;
	}

	public void setIdgrupocultural(Long idgrupocultural) {
		this.idgrupocultural = idgrupocultural;
	}

	public String getCodgrupocultural() {
		return this.codgrupocultural;
	}

	public void setCodgrupocultural(String codgrupocultural) {
		this.codgrupocultural = codgrupocultural;
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
		ffapersonasfichafamiliar.setPargruposculturale(this);

		return ffapersonasfichafamiliar;
	}

	public FfaPersonaFichaFamiliar removeFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().remove(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setPargruposculturale(null);

		return ffapersonasfichafamiliar;
	}

	public List<ParFamilia> getParfamilias() {
		return this.parfamilias;
	}

	public void setParfamilias(List<ParFamilia> parfamilias) {
		this.parfamilias = parfamilias;
	}

	public ParFamilia addParfamilia(ParFamilia parfamilia) {
		getParfamilias().add(parfamilia);
		parfamilia.setPargruposculturale(this);

		return parfamilia;
	}

	public ParFamilia removeParfamilia(ParFamilia parfamilia) {
		getParfamilias().remove(parfamilia);
		parfamilia.setPargruposculturale(null);

		return parfamilia;
	}

}