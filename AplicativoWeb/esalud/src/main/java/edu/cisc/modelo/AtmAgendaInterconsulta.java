package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atmagendainterconsulta database table.
 * 
 */
@Entity
@NamedQuery(name="AtmAgendaInterconsulta.findAll", query="SELECT a FROM AtmAgendaInterconsulta a")
public class AtmAgendaInterconsulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idagendainterc;

	private String estado;

	private String fechaagenda;

	private String horaagenda;

	//bi-directional many-to-one association to ActActividad
	@ManyToOne
	@JoinColumn(name="idactividad")
	private ActActividad actactividade;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	//bi-directional many-to-one association to ParProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idprofsalud")
	private ParProfesionalSalud parprofesionalsalud;

	//bi-directional many-to-one association to ProCategoriaServicio
	@ManyToOne
	@JoinColumn(name="idcatservicio")
	private ProCategoriaServicio procategoriasservicio;

	public AtmAgendaInterconsulta() {
	}

	public Long getIdagendainterc() {
		return this.idagendainterc;
	}

	public void setIdagendainterc(Long idagendainterc) {
		this.idagendainterc = idagendainterc;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaagenda() {
		return this.fechaagenda;
	}

	public void setFechaagenda(String fechaagenda) {
		this.fechaagenda = fechaagenda;
	}

	public String getHoraagenda() {
		return this.horaagenda;
	}

	public void setHoraagenda(String horaagenda) {
		this.horaagenda = horaagenda;
	}

	public ActActividad getActactividade() {
		return this.actactividade;
	}

	public void setActactividade(ActActividad actactividade) {
		this.actactividade = actactividade;
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

	public ProCategoriaServicio getProcategoriasservicio() {
		return this.procategoriasservicio;
	}

	public void setProcategoriasservicio(ProCategoriaServicio procategoriasservicio) {
		this.procategoriasservicio = procategoriasservicio;
	}

}