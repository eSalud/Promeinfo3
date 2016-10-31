package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ffaactividadeconomica database table.
 * 
 */
@Entity
@NamedQuery(name="FfaActividadEconomica.findAll", query="SELECT f FROM FfaActividadEconomica f")
public class FfaActividadEconomica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idacteconomica;

	private String descripcion;

	//bi-directional many-to-one association to FfaActividadNoTrabajo
	@ManyToOne
	@JoinColumn(name="idactnotrabajo")
	private FfaActividadNoTrabajo ffaactividadnotrabajo;

	//bi-directional many-to-one association to FfaActividadSemPasada
	@ManyToOne
	@JoinColumn(name="idactsemanapasada")
	private FfaActividadSemPasada ffaactividadsempasada;

	//bi-directional many-to-one association to FfaCategoriaOcupacion
	@ManyToOne
	@JoinColumn(name="idcatocupacion")
	private FfaCategoriaOcupacion ffacategoriaocupacion;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@OneToMany(mappedBy="ffaactividadeconomica")
	private List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars;

	public FfaActividadEconomica() {
	}

	public Long getIdacteconomica() {
		return this.idacteconomica;
	}

	public void setIdacteconomica(Long idacteconomica) {
		this.idacteconomica = idacteconomica;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public FfaActividadNoTrabajo getFfaactividadnotrabajo() {
		return this.ffaactividadnotrabajo;
	}

	public void setFfaactividadnotrabajo(FfaActividadNoTrabajo ffaactividadnotrabajo) {
		this.ffaactividadnotrabajo = ffaactividadnotrabajo;
	}

	public FfaActividadSemPasada getFfaactividadsempasada() {
		return this.ffaactividadsempasada;
	}

	public void setFfaactividadsempasada(FfaActividadSemPasada ffaactividadsempasada) {
		this.ffaactividadsempasada = ffaactividadsempasada;
	}

	public FfaCategoriaOcupacion getFfacategoriaocupacion() {
		return this.ffacategoriaocupacion;
	}

	public void setFfacategoriaocupacion(FfaCategoriaOcupacion ffacategoriaocupacion) {
		this.ffacategoriaocupacion = ffacategoriaocupacion;
	}

	public List<FfaPersonaFichaFamiliar> getFfapersonasfichafamiliars() {
		return this.ffapersonasfichafamiliars;
	}

	public void setFfapersonasfichafamiliars(List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars) {
		this.ffapersonasfichafamiliars = ffapersonasfichafamiliars;
	}

	public FfaPersonaFichaFamiliar addFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().add(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setFfaactividadeconomica(this);

		return ffapersonasfichafamiliar;
	}

	public FfaPersonaFichaFamiliar removeFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().remove(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setFfaactividadeconomica(null);

		return ffapersonasfichafamiliar;
	}

}