package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the labdescripcionresexamenes database table.
 * 
 */
@Entity
@Table(name="labdescripcionresexamenes")
@NamedQuery(name="LabDescripcionResExamen.findAll", query="SELECT l FROM LabDescripcionResExamen l")
public class LabDescripcionResExamen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddescresexamen;

	private String descresultado;

	private String estado;

	private String grupoexamen;

	private String unidadmedida;

	//bi-directional many-to-one association to LabServicioLaboratorio
	@ManyToOne
	@JoinColumn(name="idservlab")
	private LabServicioLaboratorio labserviciolaboratorio;

	//bi-directional many-to-one association to LabResultadoExamen
	@OneToMany(mappedBy="labdescripcionresexamene")
	private List<LabResultadoExamen> labresultadosexamenes;

	public LabDescripcionResExamen() {
	}

	public Long getIddescresexamen() {
		return this.iddescresexamen;
	}

	public void setIddescresexamen(Long iddescresexamen) {
		this.iddescresexamen = iddescresexamen;
	}

	public String getDescresultado() {
		return this.descresultado;
	}

	public void setDescresultado(String descresultado) {
		this.descresultado = descresultado;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getGrupoexamen() {
		return this.grupoexamen;
	}

	public void setGrupoexamen(String grupoexamen) {
		this.grupoexamen = grupoexamen;
	}

	public String getUnidadmedida() {
		return this.unidadmedida;
	}

	public void setUnidadmedida(String unidadmedida) {
		this.unidadmedida = unidadmedida;
	}

	public LabServicioLaboratorio getLabserviciolaboratorio() {
		return this.labserviciolaboratorio;
	}

	public void setLabserviciolaboratorio(LabServicioLaboratorio labserviciolaboratorio) {
		this.labserviciolaboratorio = labserviciolaboratorio;
	}

	public List<LabResultadoExamen> getLabresultadosexamenes() {
		return this.labresultadosexamenes;
	}

	public void setLabresultadosexamenes(List<LabResultadoExamen> labresultadosexamenes) {
		this.labresultadosexamenes = labresultadosexamenes;
	}

	public LabResultadoExamen addLabresultadosexamene(LabResultadoExamen labresultadosexamene) {
		getLabresultadosexamenes().add(labresultadosexamene);
		labresultadosexamene.setLabdescripcionresexamene(this);

		return labresultadosexamene;
	}

	public LabResultadoExamen removeLabresultadosexamene(LabResultadoExamen labresultadosexamene) {
		getLabresultadosexamenes().remove(labresultadosexamene);
		labresultadosexamene.setLabdescripcionresexamene(null);

		return labresultadosexamene;
	}

}