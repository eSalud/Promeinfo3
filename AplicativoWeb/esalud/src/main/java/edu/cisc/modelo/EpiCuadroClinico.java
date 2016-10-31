package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the epicuadrosclinicos database table.
 * 
 */
@Entity
@Table(name="epicuadrosclinicos")
@NamedQuery(name="EpiCuadroClinico.findAll", query="SELECT e FROM EpiCuadroClinico e")
public class EpiCuadroClinico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcuadroclinico;

	private Timestamp fecha;

	private String resumencuadclin;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	//bi-directional many-to-one association to ParProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idprofsalud")
	private ParProfesionalSalud parprofesionalsalud;

	public EpiCuadroClinico() {
	}

	public Long getIdcuadroclinico() {
		return this.idcuadroclinico;
	}

	public void setIdcuadroclinico(Long idcuadroclinico) {
		this.idcuadroclinico = idcuadroclinico;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getResumencuadclin() {
		return this.resumencuadclin;
	}

	public void setResumencuadclin(String resumencuadclin) {
		this.resumencuadclin = resumencuadclin;
	}

	public ParPaciente getParpaciente() {
		return this.parpaciente;
	}

	public void setParpaciente(ParPaciente parpaciente) {
		this.parpaciente = parpaciente;
	}

	public ParProfesionalSalud getParprofesionalsalud() {
		return this.parprofesionalsalud;
	}

	public void setParprofesionalsalud(ParProfesionalSalud parprofesionalsalud) {
		this.parprofesionalsalud = parprofesionalsalud;
	}

}