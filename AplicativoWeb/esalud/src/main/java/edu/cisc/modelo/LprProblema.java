package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the lprproblemas database table.
 * 
 */
@Entity
@Table(name="lprproblemas")
@NamedQuery(name="LprProblema.findAll", query="SELECT l FROM LprProblema l")
public class LprProblema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlistaproblemas;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechadetencion;

	@Temporal(TemporalType.DATE)
	private Date fechainicio;

	//bi-directional many-to-one association to AtmNotaEvolucion
	@OneToMany(mappedBy="lprproblema1")
	private List<AtmNotaEvolucion> atmnotasevolucions1;

	//bi-directional many-to-one association to AtmNotaEvolucion
	@OneToMany(mappedBy="lprproblema2")
	private List<AtmNotaEvolucion> atmnotasevolucions2;

	//bi-directional many-to-one association to AtmDiagnosticoEncPaciente
	@ManyToOne
	@JoinColumn(name="iddiagencpaciente")
	private AtmDiagnosticoEncPaciente atmdiagnosticosencpaciente;

	public LprProblema() {
	}

	public Long getIdlistaproblemas() {
		return this.idlistaproblemas;
	}

	public void setIdlistaproblemas(Long idlistaproblemas) {
		this.idlistaproblemas = idlistaproblemas;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechadetencion() {
		return this.fechadetencion;
	}

	public void setFechadetencion(Date fechadetencion) {
		this.fechadetencion = fechadetencion;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public List<AtmNotaEvolucion> getAtmnotasevolucions1() {
		return this.atmnotasevolucions1;
	}

	public void setAtmnotasevolucions1(List<AtmNotaEvolucion> atmnotasevolucions1) {
		this.atmnotasevolucions1 = atmnotasevolucions1;
	}

	public AtmNotaEvolucion addAtmnotasevolucions1(AtmNotaEvolucion atmnotasevolucions1) {
		getAtmnotasevolucions1().add(atmnotasevolucions1);
		atmnotasevolucions1.setLprproblema1(this);

		return atmnotasevolucions1;
	}

	public AtmNotaEvolucion removeAtmnotasevolucions1(AtmNotaEvolucion atmnotasevolucions1) {
		getAtmnotasevolucions1().remove(atmnotasevolucions1);
		atmnotasevolucions1.setLprproblema1(null);

		return atmnotasevolucions1;
	}

	public List<AtmNotaEvolucion> getAtmnotasevolucions2() {
		return this.atmnotasevolucions2;
	}

	public void setAtmnotasevolucions2(List<AtmNotaEvolucion> atmnotasevolucions2) {
		this.atmnotasevolucions2 = atmnotasevolucions2;
	}

	public AtmNotaEvolucion addAtmnotasevolucions2(AtmNotaEvolucion atmnotasevolucions2) {
		getAtmnotasevolucions2().add(atmnotasevolucions2);
		atmnotasevolucions2.setLprproblema2(this);

		return atmnotasevolucions2;
	}

	public AtmNotaEvolucion removeAtmnotasevolucions2(AtmNotaEvolucion atmnotasevolucions2) {
		getAtmnotasevolucions2().remove(atmnotasevolucions2);
		atmnotasevolucions2.setLprproblema2(null);

		return atmnotasevolucions2;
	}

	public AtmDiagnosticoEncPaciente getAtmdiagnosticosencpaciente() {
		return this.atmdiagnosticosencpaciente;
	}

	public void setAtmdiagnosticosencpaciente(AtmDiagnosticoEncPaciente atmdiagnosticosencpaciente) {
		this.atmdiagnosticosencpaciente = atmdiagnosticosencpaciente;
	}

}