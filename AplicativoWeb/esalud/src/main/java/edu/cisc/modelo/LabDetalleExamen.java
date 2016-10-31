package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the labdetalleexamen database table.
 * 
 */
@Entity
@NamedQuery(name="LabDetalleExamen.findAll", query="SELECT l FROM LabDetalleExamen l")
public class LabDetalleExamen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddetexamen;

	private String examen;

	private Integer idservlabdet;

	//bi-directional many-to-one association to LabOrdenExamen
	@ManyToOne
	@JoinColumn(name="idorden")
	private LabOrdenExamen labordenexamen;

	//bi-directional many-to-one association to LabServicioLaboratorio
	@ManyToOne
	@JoinColumn(name="idserviciolab")
	private LabServicioLaboratorio labserviciolaboratorio;

	//bi-directional many-to-one association to ProEstablecimientoSalud
	@ManyToOne
	@JoinColumn(name="idestablecimiento")
	private ProEstablecimientoSalud proestablecimientosalud;

	public LabDetalleExamen() {
	}

	public Long getIddetexamen() {
		return this.iddetexamen;
	}

	public void setIddetexamen(Long iddetexamen) {
		this.iddetexamen = iddetexamen;
	}

	public String getExamen() {
		return this.examen;
	}

	public void setExamen(String examen) {
		this.examen = examen;
	}

	public Integer getIdservlabdet() {
		return this.idservlabdet;
	}

	public void setIdservlabdet(Integer idservlabdet) {
		this.idservlabdet = idservlabdet;
	}

	public LabOrdenExamen getLabordenexamen() {
		return this.labordenexamen;
	}

	public void setLabordenexamen(LabOrdenExamen labordenexamen) {
		this.labordenexamen = labordenexamen;
	}

	public LabServicioLaboratorio getLabserviciolaboratorio() {
		return this.labserviciolaboratorio;
	}

	public void setLabserviciolaboratorio(LabServicioLaboratorio labserviciolaboratorio) {
		this.labserviciolaboratorio = labserviciolaboratorio;
	}

	public ProEstablecimientoSalud getProestablecimientosalud() {
		return this.proestablecimientosalud;
	}

	public void setProestablecimientosalud(ProEstablecimientoSalud proestablecimientosalud) {
		this.proestablecimientosalud = proestablecimientosalud;
	}

}