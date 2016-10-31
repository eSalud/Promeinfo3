package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the imgdatosinforme database table.
 * 
 */
@Entity
@Table(name="imgdatosinforme")
@NamedQuery(name="ImgDatoInforme.findAll", query="SELECT i FROM ImgDatoInforme i")
public class ImgDatoInforme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddatoinforme;

	private String apellidomaterno;

	private String apellidopaterno;

	private String cama;

	private String canton;

	private String cedula;

	private String codunidadoper;

	private Integer edad;

	@Temporal(TemporalType.DATE)
	private Date fechaentrega;

	private String institucion;

	private String numhistoriaclinica;

	private String parroquia;

	private String primernombre;

	private Integer prioridad;

	private String provincia;

	private String receptor;

	private String sala;

	private String segundonombre;

	private String servicio;

	private String solicitante;

	private String unidadoperativa;

	//bi-directional many-to-one association to ImgDatoSolicitud
	@ManyToOne
	@JoinColumn(name="iddatossolicitud")
	private ImgDatoSolicitud imgdatossolicitud;

	//bi-directional many-to-one association to ImgInforme
	@OneToMany(mappedBy="imgdatosinforme")
	private List<ImgInforme> imginformes;

	public ImgDatoInforme() {
	}

	public Long getIddatoinforme() {
		return this.iddatoinforme;
	}

	public void setIddatoinforme(Long iddatoinforme) {
		this.iddatoinforme = iddatoinforme;
	}

	public String getApellidomaterno() {
		return this.apellidomaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	public String getApellidopaterno() {
		return this.apellidopaterno;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	public String getCama() {
		return this.cama;
	}

	public void setCama(String cama) {
		this.cama = cama;
	}

	public String getCanton() {
		return this.canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodunidadoper() {
		return this.codunidadoper;
	}

	public void setCodunidadoper(String codunidadoper) {
		this.codunidadoper = codunidadoper;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechaentrega() {
		return this.fechaentrega;
	}

	public void setFechaentrega(Date fechaentrega) {
		this.fechaentrega = fechaentrega;
	}

	public String getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getNumhistoriaclinica() {
		return this.numhistoriaclinica;
	}

	public void setNumhistoriaclinica(String numhistoriaclinica) {
		this.numhistoriaclinica = numhistoriaclinica;
	}

	public String getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	public String getPrimernombre() {
		return this.primernombre;
	}

	public void setPrimernombre(String primernombre) {
		this.primernombre = primernombre;
	}

	public Integer getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getReceptor() {
		return this.receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public String getSala() {
		return this.sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getSegundonombre() {
		return this.segundonombre;
	}

	public void setSegundonombre(String segundonombre) {
		this.segundonombre = segundonombre;
	}

	public String getServicio() {
		return this.servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getSolicitante() {
		return this.solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getUnidadoperativa() {
		return this.unidadoperativa;
	}

	public void setUnidadoperativa(String unidadoperativa) {
		this.unidadoperativa = unidadoperativa;
	}

	public ImgDatoSolicitud getImgdatossolicitud() {
		return this.imgdatossolicitud;
	}

	public void setImgdatossolicitud(ImgDatoSolicitud imgdatossolicitud) {
		this.imgdatossolicitud = imgdatossolicitud;
	}

	public List<ImgInforme> getImginformes() {
		return this.imginformes;
	}

	public void setImginformes(List<ImgInforme> imginformes) {
		this.imginformes = imginformes;
	}

	public ImgInforme addImginforme(ImgInforme imginforme) {
		getImginformes().add(imginforme);
		imginforme.setImgdatosinforme(this);

		return imginforme;
	}

	public ImgInforme removeImginforme(ImgInforme imginforme) {
		getImginformes().remove(imginforme);
		imginforme.setImgdatosinforme(null);

		return imginforme;
	}

}