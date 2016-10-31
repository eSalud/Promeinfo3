package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atmtipoconsultaexterna database table.
 * 
 */
@Entity
@NamedQuery(name="AtmTipoConsultaExterna.findAll", query="SELECT a FROM AtmTipoConsultaExterna a")
public class AtmTipoConsultaExterna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idconsexterna;

	private String descripcion;

	private String estado;

	private Integer idagenda;

	//bi-directional many-to-one association to AtmEncuentroPaciente
	@ManyToOne
	@JoinColumn(name="idencpaciente")
	private AtmEncuentroPaciente atmencuentrospaciente;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	public AtmTipoConsultaExterna() {
	}

	public Long getIdconsexterna() {
		return this.idconsexterna;
	}

	public void setIdconsexterna(Long idconsexterna) {
		this.idconsexterna = idconsexterna;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdagenda() {
		return this.idagenda;
	}

	public void setIdagenda(Integer idagenda) {
		this.idagenda = idagenda;
	}

	public AtmEncuentroPaciente getAtmencuentrospaciente() {
		return this.atmencuentrospaciente;
	}

	public void setAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		this.atmencuentrospaciente = atmencuentrospaciente;
	}

	public ParPaciente getParpaciente() {
		return this.parpaciente;
	}

	public void setParpaciente(ParPaciente parpaciente) {
		this.parpaciente = parpaciente;
	}

}