package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ffatareasagenda database table.
 * 
 */
@Entity
@Table(name="ffatareasagenda")
@NamedQuery(name="FfaTareaAgenda.findAll", query="SELECT f FROM FfaTareaAgenda f")
public class FfaTareaAgenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtareaagenda;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fechainicioplazo;

	//bi-directional many-to-one association to FfaAgenda
	@OneToMany(mappedBy="ffatareasagenda")
	private List<FfaAgenda> ffaagendas;

	//bi-directional many-to-one association to FfaParticipante
	@ManyToOne
	@JoinColumn(name="idparticipante")
	private FfaParticipante ffaparticipante;

	public FfaTareaAgenda() {
	}

	public Long getIdtareaagenda() {
		return this.idtareaagenda;
	}

	public void setIdtareaagenda(Long idtareaagenda) {
		this.idtareaagenda = idtareaagenda;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechainicioplazo() {
		return this.fechainicioplazo;
	}

	public void setFechainicioplazo(Date fechainicioplazo) {
		this.fechainicioplazo = fechainicioplazo;
	}

	public List<FfaAgenda> getFfaagendas() {
		return this.ffaagendas;
	}

	public void setFfaagendas(List<FfaAgenda> ffaagendas) {
		this.ffaagendas = ffaagendas;
	}

	public FfaAgenda addFfaagenda(FfaAgenda ffaagenda) {
		getFfaagendas().add(ffaagenda);
		ffaagenda.setFfatareasagenda(this);

		return ffaagenda;
	}

	public FfaAgenda removeFfaagenda(FfaAgenda ffaagenda) {
		getFfaagendas().remove(ffaagenda);
		ffaagenda.setFfatareasagenda(null);

		return ffaagenda;
	}

	public FfaParticipante getFfaparticipante() {
		return this.ffaparticipante;
	}

	public void setFfaparticipante(FfaParticipante ffaparticipante) {
		this.ffaparticipante = ffaparticipante;
	}

}