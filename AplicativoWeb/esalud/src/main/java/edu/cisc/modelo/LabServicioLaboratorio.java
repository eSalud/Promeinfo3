package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the labserviciolaboratorio database table.
 * 
 */
@Entity
@NamedQuery(name="LabServicioLaboratorio.findAll", query="SELECT l FROM LabServicioLaboratorio l")
public class LabServicioLaboratorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idservlab;

	private String estado;

	private String tipoexamen;

	//bi-directional many-to-one association to LabDescripcionResExamen
	@OneToMany(mappedBy="labserviciolaboratorio")
	private List<LabDescripcionResExamen> labdescripcionresexamenes;

	//bi-directional many-to-one association to LabDetalleExamen
	@OneToMany(mappedBy="labserviciolaboratorio")
	private List<LabDetalleExamen> labdetalleexamens;

	public LabServicioLaboratorio() {
	}

	public Long getIdservlab() {
		return this.idservlab;
	}

	public void setIdservlab(Long idservlab) {
		this.idservlab = idservlab;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoexamen() {
		return this.tipoexamen;
	}

	public void setTipoexamen(String tipoexamen) {
		this.tipoexamen = tipoexamen;
	}

	public List<LabDescripcionResExamen> getLabdescripcionresexamenes() {
		return this.labdescripcionresexamenes;
	}

	public void setLabdescripcionresexamenes(List<LabDescripcionResExamen> labdescripcionresexamenes) {
		this.labdescripcionresexamenes = labdescripcionresexamenes;
	}

	public LabDescripcionResExamen addLabdescripcionresexamene(LabDescripcionResExamen labdescripcionresexamene) {
		getLabdescripcionresexamenes().add(labdescripcionresexamene);
		labdescripcionresexamene.setLabserviciolaboratorio(this);

		return labdescripcionresexamene;
	}

	public LabDescripcionResExamen removeLabdescripcionresexamene(LabDescripcionResExamen labdescripcionresexamene) {
		getLabdescripcionresexamenes().remove(labdescripcionresexamene);
		labdescripcionresexamene.setLabserviciolaboratorio(null);

		return labdescripcionresexamene;
	}

	public List<LabDetalleExamen> getLabdetalleexamens() {
		return this.labdetalleexamens;
	}

	public void setLabdetalleexamens(List<LabDetalleExamen> labdetalleexamens) {
		this.labdetalleexamens = labdetalleexamens;
	}

	public LabDetalleExamen addLabdetalleexamen(LabDetalleExamen labdetalleexamen) {
		getLabdetalleexamens().add(labdetalleexamen);
		labdetalleexamen.setLabserviciolaboratorio(this);

		return labdetalleexamen;
	}

	public LabDetalleExamen removeLabdetalleexamen(LabDetalleExamen labdetalleexamen) {
		getLabdetalleexamens().remove(labdetalleexamen);
		labdetalleexamen.setLabserviciolaboratorio(null);

		return labdetalleexamen;
	}

}