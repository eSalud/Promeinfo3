package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the atmvisitashcf database table.
 * 
 */
@Entity
@Table(name="atmvisitashcf")
@NamedQuery(name="AtmVisitaHCF.findAll", query="SELECT a FROM AtmVisitaHCF a")
public class AtmVisitaHCF implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idvisitashcf;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechavisita;

	private Integer ncasa;

	//bi-directional many-to-one association to AtmSector
	@ManyToOne
	@JoinColumn(name="idsector")
	private AtmSector atmsectore;

	//bi-directional many-to-one association to ParFamilia
	@ManyToOne
	@JoinColumn(name="idfamilia")
	private ParFamilia parfamilia;

	//bi-directional many-to-one association to ParPromotor
	@ManyToOne
	@JoinColumn(name="idpromotor")
	private ParPromotor parpromotore;

	//bi-directional many-to-one association to ProUnidadOperativa
	@ManyToOne
	@JoinColumn(name="idunidadop")
	private ProUnidadOperativa prounidadoperativa;

	public AtmVisitaHCF() {
	}

	public Long getIdvisitashcf() {
		return this.idvisitashcf;
	}

	public void setIdvisitashcf(Long idvisitashcf) {
		this.idvisitashcf = idvisitashcf;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechavisita() {
		return this.fechavisita;
	}

	public void setFechavisita(Date fechavisita) {
		this.fechavisita = fechavisita;
	}

	public Integer getNcasa() {
		return this.ncasa;
	}

	public void setNcasa(Integer ncasa) {
		this.ncasa = ncasa;
	}

	public AtmSector getAtmsectore() {
		return this.atmsectore;
	}

	public void setAtmsectore(AtmSector atmsectore) {
		this.atmsectore = atmsectore;
	}

	public ParFamilia getParfamilia() {
		return this.parfamilia;
	}

	public void setParfamilia(ParFamilia parfamilia) {
		this.parfamilia = parfamilia;
	}

	public ParPromotor getParpromotore() {
		return this.parpromotore;
	}

	public void setParpromotore(ParPromotor parpromotore) {
		this.parpromotore = parpromotore;
	}

	public ProUnidadOperativa getProunidadoperativa() {
		return this.prounidadoperativa;
	}

	public void setProunidadoperativa(ProUnidadOperativa prounidadoperativa) {
		this.prounidadoperativa = prounidadoperativa;
	}

}