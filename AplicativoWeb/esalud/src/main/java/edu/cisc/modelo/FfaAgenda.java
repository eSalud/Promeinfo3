package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ffaagendas database table.
 * 
 */
@Entity
@Table(name="ffaagendas")
@NamedQuery(name="FfaAgenda.findAll", query="SELECT f FROM FfaAgenda f")
public class FfaAgenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idagenda;

	private String descripcion;

	//bi-directional many-to-one association to FfaParticipante
	@ManyToOne
	@JoinColumn(name="idparticipante")
	private FfaParticipante ffaparticipante;

	//bi-directional many-to-one association to FfaTareaAgenda
	@ManyToOne
	@JoinColumn(name="idtareaagenda")
	private FfaTareaAgenda ffatareasagenda;

	public FfaAgenda() {
	}

	public Long getIdagenda() {
		return this.idagenda;
	}

	public void setIdagenda(Long idagenda) {
		this.idagenda = idagenda;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public FfaParticipante getFfaparticipante() {
		return this.ffaparticipante;
	}

	public void setFfaparticipante(FfaParticipante ffaparticipante) {
		this.ffaparticipante = ffaparticipante;
	}

	public FfaTareaAgenda getFfatareasagenda() {
		return this.ffatareasagenda;
	}

	public void setFfatareasagenda(FfaTareaAgenda ffatareasagenda) {
		this.ffatareasagenda = ffatareasagenda;
	}

}