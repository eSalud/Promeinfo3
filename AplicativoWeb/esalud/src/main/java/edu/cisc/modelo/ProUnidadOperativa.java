package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prounidadoperativa database table.
 * 
 */
@Entity
@NamedQuery(name="ProUnidadOperativa.findAll", query="SELECT p FROM ProUnidadOperativa p")
public class ProUnidadOperativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idunidadop;

	private String codunitop;

	private String estado;

	private Integer idestablecimiento;

	private String nombre;

	//bi-directional many-to-one association to AtmVisitaHCF
	@OneToMany(mappedBy="prounidadoperativa")
	private List<AtmVisitaHCF> atmvisitashcfs;

	//bi-directional many-to-one association to AtmVisitaHCU
	@OneToMany(mappedBy="prounidadoperativa")
	private List<AtmVisitaHCU> atmvisitashcus;

	//bi-directional many-to-one association to ParFamilia
	@OneToMany(mappedBy="prounidadoperativa")
	private List<ParFamilia> parfamilias;

	public ProUnidadOperativa() {
	}

	public Long getIdunidadop() {
		return this.idunidadop;
	}

	public void setIdunidadop(Long idunidadop) {
		this.idunidadop = idunidadop;
	}

	public String getCodunitop() {
		return this.codunitop;
	}

	public void setCodunitop(String codunitop) {
		this.codunitop = codunitop;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdestablecimiento() {
		return this.idestablecimiento;
	}

	public void setIdestablecimiento(Integer idestablecimiento) {
		this.idestablecimiento = idestablecimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AtmVisitaHCF> getAtmvisitashcfs() {
		return this.atmvisitashcfs;
	}

	public void setAtmvisitashcfs(List<AtmVisitaHCF> atmvisitashcfs) {
		this.atmvisitashcfs = atmvisitashcfs;
	}

	public AtmVisitaHCF addAtmvisitashcf(AtmVisitaHCF atmvisitashcf) {
		getAtmvisitashcfs().add(atmvisitashcf);
		atmvisitashcf.setProunidadoperativa(this);

		return atmvisitashcf;
	}

	public AtmVisitaHCF removeAtmvisitashcf(AtmVisitaHCF atmvisitashcf) {
		getAtmvisitashcfs().remove(atmvisitashcf);
		atmvisitashcf.setProunidadoperativa(null);

		return atmvisitashcf;
	}

	public List<AtmVisitaHCU> getAtmvisitashcus() {
		return this.atmvisitashcus;
	}

	public void setAtmvisitashcus(List<AtmVisitaHCU> atmvisitashcus) {
		this.atmvisitashcus = atmvisitashcus;
	}

	public AtmVisitaHCU addAtmvisitashcus(AtmVisitaHCU atmvisitashcus) {
		getAtmvisitashcus().add(atmvisitashcus);
		atmvisitashcus.setProunidadoperativa(this);

		return atmvisitashcus;
	}

	public AtmVisitaHCU removeAtmvisitashcus(AtmVisitaHCU atmvisitashcus) {
		getAtmvisitashcus().remove(atmvisitashcus);
		atmvisitashcus.setProunidadoperativa(null);

		return atmvisitashcus;
	}

	public List<ParFamilia> getParfamilias() {
		return this.parfamilias;
	}

	public void setParfamilias(List<ParFamilia> parfamilias) {
		this.parfamilias = parfamilias;
	}

	public ParFamilia addParfamilia(ParFamilia parfamilia) {
		getParfamilias().add(parfamilia);
		parfamilia.setProunidadoperativa(this);

		return parfamilia;
	}

	public ParFamilia removeParfamilia(ParFamilia parfamilia) {
		getParfamilias().remove(parfamilia);
		parfamilia.setProunidadoperativa(null);

		return parfamilia;
	}

}