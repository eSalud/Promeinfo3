package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the epimedicostratantes database table.
 * 
 */
@Entity
@Table(name="epimedicostratantes")
@NamedQuery(name="EpiMedicoTratante.findAll", query="SELECT e FROM EpiMedicoTratante e")
public class EpiMedicoTratante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idmedicostratantes;

	private Integer idcodigomedico;

	private Integer idespecialidad;

	private Integer idprofsalud;

	private Timestamp periodoresponsabilidad;

	//bi-directional many-to-one association to EpiResumenHallazgoClinico
	@ManyToOne
	@JoinColumn(name="idresumenhc")
	private EpiResumenHallazgoClinico epiresumenhallazgosclinico;

	public EpiMedicoTratante() {
	}

	public Long getIdmedicostratantes() {
		return this.idmedicostratantes;
	}

	public void setIdmedicostratantes(Long idmedicostratantes) {
		this.idmedicostratantes = idmedicostratantes;
	}

	public Integer getIdcodigomedico() {
		return this.idcodigomedico;
	}

	public void setIdcodigomedico(Integer idcodigomedico) {
		this.idcodigomedico = idcodigomedico;
	}

	public Integer getIdespecialidad() {
		return this.idespecialidad;
	}

	public void setIdespecialidad(Integer idespecialidad) {
		this.idespecialidad = idespecialidad;
	}

	public Integer getIdprofsalud() {
		return this.idprofsalud;
	}

	public void setIdprofsalud(Integer idprofsalud) {
		this.idprofsalud = idprofsalud;
	}

	public Timestamp getPeriodoresponsabilidad() {
		return this.periodoresponsabilidad;
	}

	public void setPeriodoresponsabilidad(Timestamp periodoresponsabilidad) {
		this.periodoresponsabilidad = periodoresponsabilidad;
	}

	public EpiResumenHallazgoClinico getEpiresumenhallazgosclinico() {
		return this.epiresumenhallazgosclinico;
	}

	public void setEpiresumenhallazgosclinico(EpiResumenHallazgoClinico epiresumenhallazgosclinico) {
		this.epiresumenhallazgosclinico = epiresumenhallazgosclinico;
	}

}