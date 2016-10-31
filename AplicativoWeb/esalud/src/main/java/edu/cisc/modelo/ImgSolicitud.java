package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the imgsolicitud database table.
 * 
 */
@Entity
@NamedQuery(name="ImgSolicitud.findAll", query="SELECT i FROM ImgSolicitud i")
public class ImgSolicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idsolicitud;

	private String codigo;

	private String descripadicional;

	private String descripestudio;

	private String estudiosolicitado;

	private String fecha;

	private String firma;

	private String hora;

	private String motivo;

	private String nombreprofesional;

	private Integer numhoja;

	private String resumenclinico;

	//bi-directional many-to-one association to ImgDatoSolicitud
	@ManyToOne
	@JoinColumn(name="iddatosolicitud")
	private ImgDatoSolicitud imgdatossolicitud;

	//bi-directional many-to-one association to ImgSolicitudDiagnostico
	@OneToMany(mappedBy="imgsolicitud")
	private List<ImgSolicitudDiagnostico> imgsolicituddiagnosticos;

	public ImgSolicitud() {
	}

	public Long getIdsolicitud() {
		return this.idsolicitud;
	}

	public void setIdsolicitud(Long idsolicitud) {
		this.idsolicitud = idsolicitud;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripadicional() {
		return this.descripadicional;
	}

	public void setDescripadicional(String descripadicional) {
		this.descripadicional = descripadicional;
	}

	public String getDescripestudio() {
		return this.descripestudio;
	}

	public void setDescripestudio(String descripestudio) {
		this.descripestudio = descripestudio;
	}

	public String getEstudiosolicitado() {
		return this.estudiosolicitado;
	}

	public void setEstudiosolicitado(String estudiosolicitado) {
		this.estudiosolicitado = estudiosolicitado;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFirma() {
		return this.firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getNombreprofesional() {
		return this.nombreprofesional;
	}

	public void setNombreprofesional(String nombreprofesional) {
		this.nombreprofesional = nombreprofesional;
	}

	public Integer getNumhoja() {
		return this.numhoja;
	}

	public void setNumhoja(Integer numhoja) {
		this.numhoja = numhoja;
	}

	public String getResumenclinico() {
		return this.resumenclinico;
	}

	public void setResumenclinico(String resumenclinico) {
		this.resumenclinico = resumenclinico;
	}

	public ImgDatoSolicitud getImgdatossolicitud() {
		return this.imgdatossolicitud;
	}

	public void setImgdatossolicitud(ImgDatoSolicitud imgdatossolicitud) {
		this.imgdatossolicitud = imgdatossolicitud;
	}

	public List<ImgSolicitudDiagnostico> getImgsolicituddiagnosticos() {
		return this.imgsolicituddiagnosticos;
	}

	public void setImgsolicituddiagnosticos(List<ImgSolicitudDiagnostico> imgsolicituddiagnosticos) {
		this.imgsolicituddiagnosticos = imgsolicituddiagnosticos;
	}

	public ImgSolicitudDiagnostico addImgsolicituddiagnostico(ImgSolicitudDiagnostico imgsolicituddiagnostico) {
		getImgsolicituddiagnosticos().add(imgsolicituddiagnostico);
		imgsolicituddiagnostico.setImgsolicitud(this);

		return imgsolicituddiagnostico;
	}

	public ImgSolicitudDiagnostico removeImgsolicituddiagnostico(ImgSolicitudDiagnostico imgsolicituddiagnostico) {
		getImgsolicituddiagnosticos().remove(imgsolicituddiagnostico);
		imgsolicituddiagnostico.setImgsolicitud(null);

		return imgsolicituddiagnostico;
	}

}