package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ffacategoriaocupacion database table.
 * 
 */
@Entity
@NamedQuery(name="FfaCategoriaOcupacion.findAll", query="SELECT f FROM FfaCategoriaOcupacion f")
public class FfaCategoriaOcupacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcatocupacion;

	private String descripcion;

	//bi-directional many-to-one association to FfaActividadEconomica
	@OneToMany(mappedBy="ffacategoriaocupacion")
	private List<FfaActividadEconomica> ffaactividadeconomicas;

	public FfaCategoriaOcupacion() {
	}

	public Long getIdcatocupacion() {
		return this.idcatocupacion;
	}

	public void setIdcatocupacion(Long idcatocupacion) {
		this.idcatocupacion = idcatocupacion;
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
		ffaactividadeconomica.setFfacategoriaocupacion(this);

		return ffaactividadeconomica;
	}

	public FfaActividadEconomica removeFfaactividadeconomica(FfaActividadEconomica ffaactividadeconomica) {
		getFfaactividadeconomicas().remove(ffaactividadeconomica);
		ffaactividadeconomica.setFfacategoriaocupacion(null);

		return ffaactividadeconomica;
	}

}