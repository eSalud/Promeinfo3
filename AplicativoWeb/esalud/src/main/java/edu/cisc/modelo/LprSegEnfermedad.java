package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the lprsegenfermedad database table.
 * 
 */
@Entity
@NamedQuery(name="LprSegEnfermedad.findAll", query="SELECT l FROM LprSegEnfermedad l")
public class LprSegEnfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idsegenfermedad;

	@Temporal(TemporalType.DATE)
	private Date fechahallazgo;

	//bi-directional many-to-one association to LprEnfermedad
	@ManyToOne
	@JoinColumn(name="idenfermedad")
	private LprEnfermedad lprenfermedade;

	//bi-directional many-to-one association to LprHistoriaClinicaProblema
	@ManyToOne
	@JoinColumn(name="idhistproblemas")
	private LprHistoriaClinicaProblema lprhistoriaclinicaproblema;

	public LprSegEnfermedad() {
	}

	public Long getIdsegenfermedad() {
		return this.idsegenfermedad;
	}

	public void setIdsegenfermedad(Long idsegenfermedad) {
		this.idsegenfermedad = idsegenfermedad;
	}

	public Date getFechahallazgo() {
		return this.fechahallazgo;
	}

	public void setFechahallazgo(Date fechahallazgo) {
		this.fechahallazgo = fechahallazgo;
	}

	public LprEnfermedad getLprenfermedade() {
		return this.lprenfermedade;
	}

	public void setLprenfermedade(LprEnfermedad lprenfermedade) {
		this.lprenfermedade = lprenfermedade;
	}

	public LprHistoriaClinicaProblema getLprhistoriaclinicaproblema() {
		return this.lprhistoriaclinicaproblema;
	}

	public void setLprhistoriaclinicaproblema(LprHistoriaClinicaProblema lprhistoriaclinicaproblema) {
		this.lprhistoriaclinicaproblema = lprhistoriaclinicaproblema;
	}

}