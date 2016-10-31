package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the imginformediagnostico database table.
 * 
 */
@Entity
@NamedQuery(name="ImgInformeDiagnostico.findAll", query="SELECT i FROM ImgInformeDiagnostico i")
public class ImgInformeDiagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idinformediag;

	private String descripcion;

	private String tipodiagnostico;

	//bi-directional many-to-one association to ImgInforme
	@ManyToOne
	@JoinColumn(name="idinforme")
	private ImgInforme imginforme;

	public ImgInformeDiagnostico() {
	}

	public Long getIdinformediag() {
		return this.idinformediag;
	}

	public void setIdinformediag(Long idinformediag) {
		this.idinformediag = idinformediag;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipodiagnostico() {
		return this.tipodiagnostico;
	}

	public void setTipodiagnostico(String tipodiagnostico) {
		this.tipodiagnostico = tipodiagnostico;
	}

	public ImgInforme getImginforme() {
		return this.imginforme;
	}

	public void setImginforme(ImgInforme imginforme) {
		this.imginforme = imginforme;
	}

}