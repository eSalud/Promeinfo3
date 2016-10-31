package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the labordenexamen database table.
 * 
 */
@Entity
@NamedQuery(name="LabOrdenExamen.findAll", query="SELECT l FROM LabOrdenExamen l")
public class LabOrdenExamen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idorden;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Integer idpaciente;

	private Integer idprofsalud;

	//bi-directional many-to-one association to LabDetalleExamen
	@OneToMany(mappedBy="labordenexamen")
	private List<LabDetalleExamen> labdetalleexamens;

	//bi-directional many-to-one association to LabResultadoExamen
	@OneToMany(mappedBy="labordenexamen")
	private List<LabResultadoExamen> labresultadosexamenes;

	public LabOrdenExamen() {
	}

	public Long getIdorden() {
		return this.idorden;
	}

	public void setIdorden(Long idorden) {
		this.idorden = idorden;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIdpaciente() {
		return this.idpaciente;
	}

	public void setIdpaciente(Integer idpaciente) {
		this.idpaciente = idpaciente;
	}

	public Integer getIdprofsalud() {
		return this.idprofsalud;
	}

	public void setIdprofsalud(Integer idprofsalud) {
		this.idprofsalud = idprofsalud;
	}

	public List<LabDetalleExamen> getLabdetalleexamens() {
		return this.labdetalleexamens;
	}

	public void setLabdetalleexamens(List<LabDetalleExamen> labdetalleexamens) {
		this.labdetalleexamens = labdetalleexamens;
	}

	public LabDetalleExamen addLabdetalleexamen(LabDetalleExamen labdetalleexamen) {
		getLabdetalleexamens().add(labdetalleexamen);
		labdetalleexamen.setLabordenexamen(this);

		return labdetalleexamen;
	}

	public LabDetalleExamen removeLabdetalleexamen(LabDetalleExamen labdetalleexamen) {
		getLabdetalleexamens().remove(labdetalleexamen);
		labdetalleexamen.setLabordenexamen(null);

		return labdetalleexamen;
	}

	public List<LabResultadoExamen> getLabresultadosexamenes() {
		return this.labresultadosexamenes;
	}

	public void setLabresultadosexamenes(List<LabResultadoExamen> labresultadosexamenes) {
		this.labresultadosexamenes = labresultadosexamenes;
	}

	public LabResultadoExamen addLabresultadosexamene(LabResultadoExamen labresultadosexamene) {
		getLabresultadosexamenes().add(labresultadosexamene);
		labresultadosexamene.setLabordenexamen(this);

		return labresultadosexamene;
	}

	public LabResultadoExamen removeLabresultadosexamene(LabResultadoExamen labresultadosexamene) {
		getLabresultadosexamenes().remove(labresultadosexamene);
		labresultadosexamene.setLabordenexamen(null);

		return labresultadosexamene;
	}

}