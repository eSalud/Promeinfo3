package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ffaactividadnotrabajo database table.
 * 
 */
@Entity
@NamedQuery(name="FfaActividadNoTrabajo.findAll", query="SELECT f FROM FfaActividadNoTrabajo f")
public class FfaActividadNoTrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idactnotrabajo;

	private String descripcion;

	//bi-directional many-to-one association to FfaActividadEconomica
	@OneToMany(mappedBy="ffaactividadnotrabajo")
	private List<FfaActividadEconomica> ffaactividadeconomicas;

	public FfaActividadNoTrabajo() {
	}

	public Long getIdactnotrabajo() {
		return this.idactnotrabajo;
	}

	public void setIdactnotrabajo(Long idactnotrabajo) {
		this.idactnotrabajo = idactnotrabajo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<FfaActividadEconomica> getFfaactividadeconomicas() {
		return this.ffaactividadeconomicas;
	}

	public void setFfaactividadeconomicas(List<FfaActividadEconomica> ffaactividadeconomicas) {
		this.ffaactividadeconomicas = ffaactividadeconomicas;
	}

	public FfaActividadEconomica addFfaactividadeconomica(FfaActividadEconomica ffaactividadeconomica) {
		getFfaactividadeconomicas().add(ffaactividadeconomica);
		ffaactividadeconomica.setFfaactividadnotrabajo(this);

		return ffaactividadeconomica;
	}

	public FfaActividadEconomica removeFfaactividadeconomica(FfaActividadEconomica ffaactividadeconomica) {
		getFfaactividadeconomicas().remove(ffaactividadeconomica);
		ffaactividadeconomica.setFfaactividadnotrabajo(null);

		return ffaactividadeconomica;
	}

}