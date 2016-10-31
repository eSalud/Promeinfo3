package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atmantperregistro database table.
 * 
 */
@Entity
@NamedQuery(name="AtmAntPerRegistro.findAll", query="SELECT a FROM AtmAntPerRegistro a")
public class AtmAntPerRegistro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idperreg;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to AtmAntPerItem
	@ManyToOne
	@JoinColumn(name="idenf")
	private AtmAntPerItem atmantperitem;

	//bi-directional many-to-one association to AtmVisitaHCU
	@ManyToOne
	@JoinColumn(name="idvisita")
	private AtmVisitaHCU atmvisitashcu;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	public AtmAntPerRegistro() {
	}

	public Long getIdperreg() {
		return this.idperreg;
	}

	public void setIdperreg(Long idperreg) {
		this.idperreg = idperreg;
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

	public AtmAntPerItem getAtmantperitem() {
		return this.atmantperitem;
	}

	public void setAtmantperitem(AtmAntPerItem atmantperitem) {
		this.atmantperitem = atmantperitem;
	}

	public AtmVisitaHCU getAtmvisitashcu() {
		return this.atmvisitashcu;
	}

	public void setAtmvisitashcu(AtmVisitaHCU atmvisitashcu) {
		this.atmvisitashcu = atmvisitashcu;
	}

	public ParPaciente getParpaciente() {
		return this.parpaciente;
	}

	public void setParpaciente(ParPaciente parpaciente) {
		this.parpaciente = parpaciente;
	}

}