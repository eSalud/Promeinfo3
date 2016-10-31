package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ffatiposinstrucciones database table.
 * 
 */
@Entity
@Table(name="ffatiposinstrucciones")
@NamedQuery(name="FfaTipoInstruccion.findAll", query="SELECT f FROM FfaTipoInstruccion f")
public class FfaTipoInstruccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipoinstruccion;

	private String anioaprobado;

	private String asiste;

	private String codtipoinstruccion;

	private String descripcion;

	private String estado;

	private String leeescribe;

	private String matricestabregular;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@OneToMany(mappedBy="ffatiposinstruccione")
	private List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars;

	//bi-directional many-to-one association to FfaEstablecimientoMatricula
	@ManyToOne
	@JoinColumn(name="idestabmatricula")
	private FfaEstablecimientoMatricula ffaestablecimientomatricula;

	//bi-directional many-to-one association to FfaMotivoNoMatricula
	@ManyToOne
	@JoinColumn(name="idmotivonomatric")
	private FfaMotivoNoMatricula ffamotivonomatricula;

	//bi-directional many-to-one association to ParNivelInstruccion
	@ManyToOne
	@JoinColumn(name="idnivelinstruccion")
	private ParNivelInstruccion parnivelinstruccion;

	public FfaTipoInstruccion() {
	}

	public Long getIdtipoinstruccion() {
		return this.idtipoinstruccion;
	}

	public void setIdtipoinstruccion(Long idtipoinstruccion) {
		this.idtipoinstruccion = idtipoinstruccion;
	}

	public String getAnioaprobado() {
		return this.anioaprobado;
	}

	public void setAnioaprobado(String anioaprobado) {
		this.anioaprobado = anioaprobado;
	}

	public String getAsiste() {
		return this.asiste;
	}

	public void setAsiste(String asiste) {
		this.asiste = asiste;
	}

	public String getCodtipoinstruccion() {
		return this.codtipoinstruccion;
	}

	public void setCodtipoinstruccion(String codtipoinstruccion) {
		this.codtipoinstruccion = codtipoinstruccion;
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

	public String getLeeescribe() {
		return this.leeescribe;
	}

	public void setLeeescribe(String leeescribe) {
		this.leeescribe = leeescribe;
	}

	public String getMatricestabregular() {
		return this.matricestabregular;
	}

	public void setMatricestabregular(String matricestabregular) {
		this.matricestabregular = matricestabregular;
	}

	public List<FfaPersonaFichaFamiliar> getFfapersonasfichafamiliars() {
		return this.ffapersonasfichafamiliars;
	}

	public void setFfapersonasfichafamiliars(List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars) {
		this.ffapersonasfichafamiliars = ffapersonasfichafamiliars;
	}

	public FfaPersonaFichaFamiliar addFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().add(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setFfatiposinstruccione(this);

		return ffapersonasfichafamiliar;
	}

	public FfaPersonaFichaFamiliar removeFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().remove(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setFfatiposinstruccione(null);

		return ffapersonasfichafamiliar;
	}

	public FfaEstablecimientoMatricula getFfaestablecimientomatricula() {
		return this.ffaestablecimientomatricula;
	}

	public void setFfaestablecimientomatricula(FfaEstablecimientoMatricula ffaestablecimientomatricula) {
		this.ffaestablecimientomatricula = ffaestablecimientomatricula;
	}

	public FfaMotivoNoMatricula getFfamotivonomatricula() {
		return this.ffamotivonomatricula;
	}

	public void setFfamotivonomatricula(FfaMotivoNoMatricula ffamotivonomatricula) {
		this.ffamotivonomatricula = ffamotivonomatricula;
	}

	public ParNivelInstruccion getParnivelinstruccion() {
		return this.parnivelinstruccion;
	}

	public void setParnivelinstruccion(ParNivelInstruccion parnivelinstruccion) {
		this.parnivelinstruccion = parnivelinstruccion;
	}

}