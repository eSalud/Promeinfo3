package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the imgdatossolicitud database table.
 * 
 */
@Entity
@Table(name="imgdatossolicitud")
@NamedQuery(name="ImgDatoSolicitud.findAll", query="SELECT i FROM ImgDatoSolicitud i")
public class ImgDatoSolicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddatosolicitud;

	private String apellidomaterno;

	private String apellidopaterno;

	private String cama;

	private String canton;

	private String cedula;

	private String codunidadoper;

	private Integer edad;

	@Temporal(TemporalType.DATE)
	private Date fechatoma;

	private String institucion;

	private String numhistoriaclinica;

	private String parroquia;

	private String primernombre;

	private Integer prioridad;

	private String provincia;

	private String sala;

	private String segundonombre;

	private String servicio;

	private String unidadoperativa;

	//bi-directional many-to-one association to ImgDatoInforme
	@OneToMany(mappedBy="imgdatossolicitud")
	private List<ImgDatoInforme> imgdatosinformes;

	//bi-directional many-to-one association to ImgSolicitud
	@OneToMany(mappedBy="imgdatossolicitud")
	private List<ImgSolicitud> imgsolicituds;

	public ImgDatoSolicitud() {
	}

	public Long getIddatosolicitud() {
		return this.iddatosolicitud;
	}

	public void setIddatosolicitud(Long iddatosolicitud) {
		this.iddatosolicitud = iddatosolicitud;
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

	public Date getFechatoma() {
		return this.fechatoma;
	}

	public void setFechatoma(Date fechatoma) {
		this.fechatoma = fechatoma;
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

	public String getUnidadoperativa() {
		return this.unidadoperativa;
	}

	public void setUnidadoperativa(String unidadoperativa) {
		this.unidadoperativa = unidadoperativa;
	}

	public List<ImgDatoInforme> getImgdatosinformes() {
		return this.imgdatosinformes;
	}

	public void setImgdatosinformes(List<ImgDatoInforme> imgdatosinformes) {
		this.imgdatosinformes = imgdatosinformes;
	}

	public ImgDatoInforme addImgdatosinforme(ImgDatoInforme imgdatosinforme) {
		getImgdatosinformes().add(imgdatosinforme);
		imgdatosinforme.setImgdatossolicitud(this);

		return imgdatosinforme;
	}

	public ImgDatoInforme removeImgdatosinforme(ImgDatoInforme imgdatosinforme) {
		getImgdatosinformes().remove(imgdatosinforme);
		imgdatosinforme.setImgdatossolicitud(null);

		return imgdatosinforme;
	}

	public List<ImgSolicitud> getImgsolicituds() {
		return this.imgsolicituds;
	}

	public void setImgsolicituds(List<ImgSolicitud> imgsolicituds) {
		this.imgsolicituds = imgsolicituds;
	}

	public ImgSolicitud addImgsolicitud(ImgSolicitud imgsolicitud) {
		getImgsolicituds().add(imgsolicitud);
		imgsolicitud.setImgdatossolicitud(this);

		return imgsolicitud;
	}

	public ImgSolicitud removeImgsolicitud(ImgSolicitud imgsolicitud) {
		getImgsolicituds().remove(imgsolicitud);
		imgsolicitud.setImgdatossolicitud(null);

		return imgsolicitud;
	}

}