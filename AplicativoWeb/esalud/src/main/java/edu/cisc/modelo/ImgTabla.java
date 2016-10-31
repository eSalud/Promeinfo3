package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the imgtabla database table.
 * 
 */
@Entity
@NamedQuery(name="ImgTabla.findAll", query="SELECT i FROM ImgTabla i")
public class ImgTabla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtabla;

	private String tabla;

	//bi-directional many-to-one association to ImgCatalogo
	@OneToMany(mappedBy="imgtabla")
	private List<ImgCatalogo> imgcatalogos;

	public ImgTabla() {
	}

	public Long getIdtabla() {
		return this.idtabla;
	}

	public void setIdtabla(Long idtabla) {
		this.idtabla = idtabla;
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public List<ImgCatalogo> getImgcatalogos() {
		return this.imgcatalogos;
	}

	public void setImgcatalogos(List<ImgCatalogo> imgcatalogos) {
		this.imgcatalogos = imgcatalogos;
	}

	public ImgCatalogo addImgcatalogo(ImgCatalogo imgcatalogo) {
		getImgcatalogos().add(imgcatalogo);
		imgcatalogo.setImgtabla(this);

		return imgcatalogo;
	}

	public ImgCatalogo removeImgcatalogo(ImgCatalogo imgcatalogo) {
		getImgcatalogos().remove(imgcatalogo);
		imgcatalogo.setImgtabla(null);

		return imgcatalogo;
	}

}