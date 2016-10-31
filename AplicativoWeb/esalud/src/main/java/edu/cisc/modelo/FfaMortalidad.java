package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ffamortalidad database table.
 * 
 */
@Entity
@NamedQuery(name="FfaMortalidad.findAll", query="SELECT f FROM FfaMortalidad f")
public class FfaMortalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idmortalidad;

	private String apellidos;

	private String causa;

	private String documentacion;

	private Integer edad;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechamuerte;

	private String identificacion;

	private String muerteinfantil;

	private String muertematerna;

	private String muerteneonatal;

	private String nombres;

	private String parentesco;

	private Integer sexo;

	//bi-directional many-to-one association to FfaVivienda
	@ManyToOne
	@JoinColumn(name="idvivienda")
	private FfaVivienda ffavivienda;

	public FfaMortalidad() {
	}

	public Long getIdmortalidad() {
		return this.idmortalidad;
	}

	public void setIdmortalidad(Long idmortalidad) {
		this.idmortalidad = idmortalidad;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCausa() {
		return this.causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getDocumentacion() {
		return this.documentacion;
	}

	public void setDocumentacion(String documentacion) {
		this.documentacion = documentacion;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechamuerte() {
		return this.fechamuerte;
	}

	public void setFechamuerte(Date fechamuerte) {
		this.fechamuerte = fechamuerte;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getMuerteinfantil() {
		return this.muerteinfantil;
	}

	public void setMuerteinfantil(String muerteinfantil) {
		this.muerteinfantil = muerteinfantil;
	}

	public String getMuertematerna() {
		return this.muertematerna;
	}

	public void setMuertematerna(String muertematerna) {
		this.muertematerna = muertematerna;
	}

	public String getMuerteneonatal() {
		return this.muerteneonatal;
	}

	public void setMuerteneonatal(String muerteneonatal) {
		this.muerteneonatal = muerteneonatal;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public Integer getSexo() {
		return this.sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public FfaVivienda getFfavivienda() {
		return this.ffavivienda;
	}

	public void setFfavivienda(FfaVivienda ffavivienda) {
		this.ffavivienda = ffavivienda;
	}

}