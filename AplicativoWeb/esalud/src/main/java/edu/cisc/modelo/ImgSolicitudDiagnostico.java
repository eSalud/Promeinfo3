package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the imgsolicituddiagnostico database table.
 * 
 */
@Entity
@NamedQuery(name="ImgSolicitudDiagnostico.findAll", query="SELECT i FROM ImgSolicitudDiagnostico i")
public class ImgSolicitudDiagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idsolicdiag;

	private Integer cie;

	private String definitivo;

	private String descripcion;

	private String estado;

	private String presuntivo;

	private String tipodiagnostico;

	//bi-directional many-to-one association to ImgSolicitud
	@ManyToOne
	@JoinColumn(name="idsolicitud")
	private ImgSolicitud imgsolicitud;

	public ImgSolicitudDiagnostico() {
	}

	public Long getIdsolicdiag() {
		return this.idsolicdiag;
	}

	public void setIdsolicdiag(Long idsolicdiag) {
		this.idsolicdiag = idsolicdiag;
	}

	public Integer getCie() {
		return this.cie;
	}

	public void setCie(Integer cie) {
		this.cie = cie;
	}

	public String getDefinitivo() {
		return this.definitivo;
	}

	public void setDefinitivo(String definitivo) {
		this.definitivo = definitivo;
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

	public String getPresuntivo() {
		return this.presuntivo;
	}

	public void setPresuntivo(String presuntivo) {
		this.presuntivo = presuntivo;
	}

	public String getTipodiagnostico() {
		return this.tipodiagnostico;
	}

	public void setTipodiagnostico(String tipodiagnostico) {
		this.tipodiagnostico = tipodiagnostico;
	}

	public ImgSolicitud getImgsolicitud() {
		return this.imgsolicitud;
	}

	public void setImgsolicitud(ImgSolicitud imgsolicitud) {
		this.imgsolicitud = imgsolicitud;
	}

}