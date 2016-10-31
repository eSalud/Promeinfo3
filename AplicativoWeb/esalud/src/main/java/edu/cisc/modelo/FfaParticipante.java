package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ffaparticipantes database table.
 * 
 */
@Entity
@Table(name="ffaparticipantes")
@NamedQuery(name="FfaParticipante.findAll", query="SELECT f FROM FfaParticipante f")
public class FfaParticipante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idparticipante;

	private String descripcion;

	//bi-directional many-to-one association to FfaAgenda
	@OneToMany(mappedBy="ffaparticipante")
	private List<FfaAgenda> ffaagendas;

	//bi-directional many-to-one association to FfaTareaAgenda
	@OneToMany(mappedBy="ffaparticipante")
	private List<FfaTareaAgenda> ffatareasagendas;

	public FfaParticipante() {
	}

	public Long getIdparticipante() {
		return this.idparticipante;
	}

	public void setIdparticipante(Long idparticipante) {
		this.idparticipante = idparticipante;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<FfaAgenda> getFfaagendas() {
		return this.ffaagendas;
	}

	public void setFfaagendas(List<FfaAgenda> ffaagendas) {
		this.ffaagendas = ffaagendas;
	}

	public FfaAgenda addFfaagenda(FfaAgenda ffaagenda) {
		getFfaagendas().add(ffaagenda);
		ffaagenda.setFfaparticipante(this);

		return ffaagenda;
	}

	public FfaAgenda removeFfaagenda(FfaAgenda ffaagenda) {
		getFfaagendas().remove(ffaagenda);
		ffaagenda.setFfaparticipante(null);

		return ffaagenda;
	}

	public List<FfaTareaAgenda> getFfatareasagendas() {
		return this.ffatareasagendas;
	}

	public void setFfatareasagendas(List<FfaTareaAgenda> ffatareasagendas) {
		this.ffatareasagendas = ffatareasagendas;
	}

	public FfaTareaAgenda addFfatareasagenda(FfaTareaAgenda ffatareasagenda) {
		getFfatareasagendas().add(ffatareasagenda);
		ffatareasagenda.setFfaparticipante(this);

		return ffatareasagenda;
	}

	public FfaTareaAgenda removeFfatareasagenda(FfaTareaAgenda ffatareasagenda) {
		getFfatareasagendas().remove(ffatareasagenda);
		ffatareasagenda.setFfaparticipante(null);

		return ffatareasagenda;
	}

}