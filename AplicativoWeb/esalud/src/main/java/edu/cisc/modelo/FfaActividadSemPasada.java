package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ffaactividadsempasada database table.
 * 
 */
@Entity
@NamedQuery(name="FfaActividadSemPasada.findAll", query="SELECT f FROM FfaActividadSemPasada f")
public class FfaActividadSemPasada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idactsemanapasada;

	private String descripcion;

	//bi-directional many-to-one association to FfaActividadEconomica
	@OneToMany(mappedBy="ffaactividadsempasada")
	private List<FfaActividadEconomica> ffaactividadeconomicas;

	public FfaActividadSemPasada() {
	}

	public Long getIdactsemanapasada() {
		return this.idactsemanapasada;
	}

	public void setIdactsemanapasada(Long idactsemanapasada) {
		this.idactsemanapasada = idactsemanapasada;
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
		ffaactividadeconomica.setFfaactividadsempasada(this);

		return ffaactividadeconomica;
	}

	public FfaActividadEconomica removeFfaactividadeconomica(FfaActividadEconomica ffaactividadeconomica) {
		getFfaactividadeconomicas().remove(ffaactividadeconomica);
		ffaactividadeconomica.setFfaactividadsempasada(null);

		return ffaactividadeconomica;
	}

}