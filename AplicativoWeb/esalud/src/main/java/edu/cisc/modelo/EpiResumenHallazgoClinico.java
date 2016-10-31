package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the epiresumenhallazgosclinicos database table.
 * 
 */
@Entity
@Table(name="epiresumenhallazgosclinicos")
@NamedQuery(name="EpiResumenHallazgoClinico.findAll", query="SELECT e FROM EpiResumenHallazgoClinico e")
public class EpiResumenHallazgoClinico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idresumenhc;

	private Timestamp fechaactualizacion;

	private Timestamp fechaingreso;

	private String hallazgosrelevantes;

	private Integer idprofsaludactualizado;

	private String resumencuadroclinico;

	private String resumenevolucioncomp;

	private String resumentratamientoprod;

	//bi-directional many-to-one association to EpiCondicionEgreso
	@OneToMany(mappedBy="epiresumenhallazgosclinico")
	private List<EpiCondicionEgreso> epicondicionesegresos;

	//bi-directional many-to-one association to EpiDiagnostico
	@OneToMany(mappedBy="epiresumenhallazgosclinico")
	private List<EpiDiagnostico> epidiagnosticos;

	//bi-directional many-to-one association to EpiEgreso
	@OneToMany(mappedBy="epiresumenhallazgosclinico")
	private List<EpiEgreso> epiegresos;

	//bi-directional many-to-one association to EpiMedicoTratante
	@OneToMany(mappedBy="epiresumenhallazgosclinico")
	private List<EpiMedicoTratante> epimedicostratantes;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	//bi-directional many-to-one association to ParProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idprofsalud")
	private ParProfesionalSalud parprofesionalsalud;

	public EpiResumenHallazgoClinico() {
	}

	public Long getIdresumenhc() {
		return this.idresumenhc;
	}

	public void setIdresumenhc(Long idresumenhc) {
		this.idresumenhc = idresumenhc;
	}

	public Timestamp getFechaactualizacion() {
		return this.fechaactualizacion;
	}

	public void setFechaactualizacion(Timestamp fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}

	public Timestamp getFechaingreso() {
		return this.fechaingreso;
	}

	public void setFechaingreso(Timestamp fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public String getHallazgosrelevantes() {
		return this.hallazgosrelevantes;
	}

	public void setHallazgosrelevantes(String hallazgosrelevantes) {
		this.hallazgosrelevantes = hallazgosrelevantes;
	}

	public Integer getIdprofsaludactualizado() {
		return this.idprofsaludactualizado;
	}

	public void setIdprofsaludactualizado(Integer idprofsaludactualizado) {
		this.idprofsaludactualizado = idprofsaludactualizado;
	}

	public String getResumencuadroclinico() {
		return this.resumencuadroclinico;
	}

	public void setResumencuadroclinico(String resumencuadroclinico) {
		this.resumencuadroclinico = resumencuadroclinico;
	}

	public String getResumenevolucioncomp() {
		return this.resumenevolucioncomp;
	}

	public void setResumenevolucioncomp(String resumenevolucioncomp) {
		this.resumenevolucioncomp = resumenevolucioncomp;
	}

	public String getResumentratamientoprod() {
		return this.resumentratamientoprod;
	}

	public void setResumentratamientoprod(String resumentratamientoprod) {
		this.resumentratamientoprod = resumentratamientoprod;
	}

	public List<EpiCondicionEgreso> getEpicondicionesegresos() {
		return this.epicondicionesegresos;
	}

	public void setEpicondicionesegresos(List<EpiCondicionEgreso> epicondicionesegresos) {
		this.epicondicionesegresos = epicondicionesegresos;
	}

	public EpiCondicionEgreso addEpicondicionesegreso(EpiCondicionEgreso epicondicionesegreso) {
		getEpicondicionesegresos().add(epicondicionesegreso);
		epicondicionesegreso.setEpiresumenhallazgosclinico(this);

		return epicondicionesegreso;
	}

	public EpiCondicionEgreso removeEpicondicionesegreso(EpiCondicionEgreso epicondicionesegreso) {
		getEpicondicionesegresos().remove(epicondicionesegreso);
		epicondicionesegreso.setEpiresumenhallazgosclinico(null);

		return epicondicionesegreso;
	}

	public List<EpiDiagnostico> getEpidiagnosticos() {
		return this.epidiagnosticos;
	}

	public void setEpidiagnosticos(List<EpiDiagnostico> epidiagnosticos) {
		this.epidiagnosticos = epidiagnosticos;
	}

	public EpiDiagnostico addEpidiagnostico(EpiDiagnostico epidiagnostico) {
		getEpidiagnosticos().add(epidiagnostico);
		epidiagnostico.setEpiresumenhallazgosclinico(this);

		return epidiagnostico;
	}

	public EpiDiagnostico removeEpidiagnostico(EpiDiagnostico epidiagnostico) {
		getEpidiagnosticos().remove(epidiagnostico);
		epidiagnostico.setEpiresumenhallazgosclinico(null);

		return epidiagnostico;
	}

	public List<EpiEgreso> getEpiegresos() {
		return this.epiegresos;
	}

	public void setEpiegresos(List<EpiEgreso> epiegresos) {
		this.epiegresos = epiegresos;
	}

	public EpiEgreso addEpiegreso(EpiEgreso epiegreso) {
		getEpiegresos().add(epiegreso);
		epiegreso.setEpiresumenhallazgosclinico(this);

		return epiegreso;
	}

	public EpiEgreso removeEpiegreso(EpiEgreso epiegreso) {
		getEpiegresos().remove(epiegreso);
		epiegreso.setEpiresumenhallazgosclinico(null);

		return epiegreso;
	}

	public List<EpiMedicoTratante> getEpimedicostratantes() {
		return this.epimedicostratantes;
	}

	public void setEpimedicostratantes(List<EpiMedicoTratante> epimedicostratantes) {
		this.epimedicostratantes = epimedicostratantes;
	}

	public EpiMedicoTratante addEpimedicostratante(EpiMedicoTratante epimedicostratante) {
		getEpimedicostratantes().add(epimedicostratante);
		epimedicostratante.setEpiresumenhallazgosclinico(this);

		return epimedicostratante;
	}

	public EpiMedicoTratante removeEpimedicostratante(EpiMedicoTratante epimedicostratante) {
		getEpimedicostratantes().remove(epimedicostratante);
		epimedicostratante.setEpiresumenhallazgosclinico(null);

		return epimedicostratante;
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