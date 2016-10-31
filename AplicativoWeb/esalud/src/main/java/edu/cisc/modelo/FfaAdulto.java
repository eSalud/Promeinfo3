package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ffaadultos database table.
 * 
 */
@Entity
@Table(name="ffaadultos")
@NamedQuery(name="FfaAdulto.findAll", query="SELECT f FROM FfaAdulto f")
public class FfaAdulto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idadulto;

	private String espadre;

	private String estaembarazada;

	private Integer hijosnacidosvivos;

	private Integer hijosvivosnv;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@ManyToOne
	@JoinColumn(name="idpersona")
	private FfaPersonaFichaFamiliar ffapersonasfichafamiliar;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@OneToMany(mappedBy="ffaadulto")
	private List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars;

	public FfaAdulto() {
	}

	public Long getIdadulto() {
		return this.idadulto;
	}

	public void setIdadulto(Long idadulto) {
		this.idadulto = idadulto;
	}

	public String getEspadre() {
		return this.espadre;
	}

	public void setEspadre(String espadre) {
		this.espadre = espadre;
	}

	public String getEstaembarazada() {
		return this.estaembarazada;
	}

	public void setEstaembarazada(String estaembarazada) {
		this.estaembarazada = estaembarazada;
	}

	public Integer getHijosnacidosvivos() {
		return this.hijosnacidosvivos;
	}

	public void setHijosnacidosvivos(Integer hijosnacidosvivos) {
		this.hijosnacidosvivos = hijosnacidosvivos;
	}

	public Integer getHijosvivosnv() {
		return this.hijosvivosnv;
	}

	public void setHijosvivosnv(Integer hijosvivosnv) {
		this.hijosvivosnv = hijosvivosnv;
	}

	public FfaPersonaFichaFamiliar getFfapersonasfichafamiliar() {
		return this.ffapersonasfichafamiliar;
	}

	public void setFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		this.ffapersonasfichafamiliar = ffapersonasfichafamiliar;
	}

	public List<FfaPersonaFichaFamiliar> getFfapersonasfichafamiliars() {
		return this.ffapersonasfichafamiliars;
	}

	public void setFfapersonasfichafamiliars(List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars) {
		this.ffapersonasfichafamiliars = ffapersonasfichafamiliars;
	}

	public FfaPersonaFichaFamiliar addFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().add(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setFfaadulto(this);

		return ffapersonasfichafamiliar;
	}

	public FfaPersonaFichaFamiliar removeFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().remove(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setFfaadulto(null);

		return ffapersonasfichafamiliar;
	}

}