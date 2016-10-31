package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the labserviciolaboratoriodet database table.
 * 
 */
@Entity
@NamedQuery(name="LabServicioLaboratorioDet.findAll", query="SELECT l FROM LabServicioLaboratorioDet l")
public class LabServicioLaboratorioDet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idservlabdet;

	private String estado;

	private Integer idservlab;

	private String tipodato;

	private String tipoexamen;

	public LabServicioLaboratorioDet() {
	}

	public Long getIdservlabdet() {
		return this.idservlabdet;
	}

	public void setIdservlabdet(Long idservlabdet) {
		this.idservlabdet = idservlabdet;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdservlab() {
		return this.idservlab;
	}

	public void setIdservlab(Integer idservlab) {
		this.idservlab = idservlab;
	}

	public String getTipodato() {
		return this.tipodato;
	}

	public void setTipodato(String tipodato) {
		this.tipodato = tipodato;
	}

	public String getTipoexamen() {
		return this.tipoexamen;
	}

	public void setTipoexamen(String tipoexamen) {
		this.tipoexamen = tipoexamen;
	}

}