package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atmedifgeoubicacion database table.
 * 
 */
@Entity
@NamedQuery(name="AtmEdifGeoUbicacion.findAll", query="SELECT a FROM AtmEdifGeoUbicacion a")
public class AtmEdifGeoUbicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idedifgeoub;

	private String descripcion;

	private String estado;

	@Column(name="id_tc")
	private Integer idTc;

	private String latitud;

	private String longitud;

	private String nombre;

	//bi-directional many-to-one association to ParFamilia
	@OneToMany(mappedBy="atmedifgeoubicacion")
	private List<ParFamilia> parfamilias;

	public AtmEdifGeoUbicacion() {
	}

	public Long getIdedifgeoub() {
		return this.idedifgeoub;
	}

	public void setIdedifgeoub(Long idedifgeoub) {
		this.idedifgeoub = idedifgeoub;
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

	public Integer getIdTc() {
		return this.idTc;
	}

	public void setIdTc(Integer idTc) {
		this.idTc = idTc;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ParFamilia> getParfamilias() {
		return this.parfamilias;
	}

	public void setParfamilias(List<ParFamilia> parfamilias) {
		this.parfamilias = parfamilias;
	}

	public ParFamilia addParfamilia(ParFamilia parfamilia) {
		getParfamilias().add(parfamilia);
		parfamilia.setAtmedifgeoubicacion(this);

		return parfamilia;
	}

	public ParFamilia removeParfamilia(ParFamilia parfamilia) {
		getParfamilias().remove(parfamilia);
		parfamilia.setAtmedifgeoubicacion(null);

		return parfamilia;
	}

}