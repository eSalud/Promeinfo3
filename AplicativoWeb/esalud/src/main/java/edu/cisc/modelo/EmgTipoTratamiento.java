package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the emgtipostratamiento database table.
 * 
 */
@Entity
@Table(name="emgtipostratamiento")
@NamedQuery(name="EmgTipoTratamiento.findAll", query="SELECT e FROM EmgTipoTratamiento e")
public class EmgTipoTratamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipotratamiento;

	private String estado;

	private String nombre;

	private String observacion;

	//bi-directional many-to-one association to EmgIngresoEmergencia
	@OneToMany(mappedBy="emgtipostratamiento")
	private List<EmgIngresoEmergencia> emgingresosemergencias;

	public EmgTipoTratamiento() {
	}

	public Long getIdtipotratamiento() {
		return this.idtipotratamiento;
	}

	public void setIdtipotratamiento(Long idtipotratamiento) {
		this.idtipotratamiento = idtipotratamiento;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<EmgIngresoEmergencia> getEmgingresosemergencias() {
		return this.emgingresosemergencias;
	}

	public void setEmgingresosemergencias(List<EmgIngresoEmergencia> emgingresosemergencias) {
		this.emgingresosemergencias = emgingresosemergencias;
	}

	public EmgIngresoEmergencia addEmgingresosemergencia(EmgIngresoEmergencia emgingresosemergencia) {
		getEmgingresosemergencias().add(emgingresosemergencia);
		emgingresosemergencia.setEmgtipostratamiento(this);

		return emgingresosemergencia;
	}

	public EmgIngresoEmergencia removeEmgingresosemergencia(EmgIngresoEmergencia emgingresosemergencia) {
		getEmgingresosemergencias().remove(emgingresosemergencia);
		emgingresosemergencia.setEmgtipostratamiento(null);

		return emgingresosemergencia;
	}

}