package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the emgtiposemergencia database table.
 * 
 */
@Entity
@Table(name="emgtiposemergencia")
@NamedQuery(name="EmgTipoEmergencia.findAll", query="SELECT e FROM EmgTipoEmergencia e")
public class EmgTipoEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipoemergencia;

	private String estado;

	private String nombre;

	private String observacion;

	//bi-directional many-to-one association to EmgIngresoEmergencia
	@OneToMany(mappedBy="emgtiposemergencia")
	private List<EmgIngresoEmergencia> emgingresosemergencias;

	public EmgTipoEmergencia() {
	}

	public Long getIdtipoemergencia() {
		return this.idtipoemergencia;
	}

	public void setIdtipoemergencia(Long idtipoemergencia) {
		this.idtipoemergencia = idtipoemergencia;
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
		emgingresosemergencia.setEmgtiposemergencia(this);

		return emgingresosemergencia;
	}

	public EmgIngresoEmergencia removeEmgingresosemergencia(EmgIngresoEmergencia emgingresosemergencia) {
		getEmgingresosemergencias().remove(emgingresosemergencia);
		emgingresosemergencia.setEmgtiposemergencia(null);

		return emgingresosemergencia;
	}

}