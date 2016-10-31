package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the imginforme database table.
 * 
 */
@Entity
@NamedQuery(name="ImgInforme.findAll", query="SELECT i FROM ImgInforme i")
public class ImgInforme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idinforme;

	private String codigo;

	private String descripcion;

	private String estudiorealizado;

	private String fecha;

	private String firma;

	private String gmadurezplacenta;

	private String hora;

	private String informe;

	private String liquidoamniotico;

	private String multiple;

	private String nombreprofesional;

	private Integer numhoja;

	private String pesofetal;

	private String placenta;

	private String recomendaciones;

	private String sexo;

	private String unico;

	//bi-directional many-to-one association to ImgEcografiaObstetrica
	@OneToMany(mappedBy="imginforme")
	private List<ImgEcografiaObstetrica> imgecografiaobstetricas;

	//bi-directional many-to-one association to ImgDatoInforme
	@ManyToOne
	@JoinColumn(name="iddatosinforme")
	private ImgDatoInforme imgdatosinforme;

	//bi-directional many-to-one association to ImgInformeDiagnostico
	@OneToMany(mappedBy="imginforme")
	private List<ImgInformeDiagnostico> imginformediagnosticos;

	public ImgInforme() {
	}

	public Long getIdinforme() {
		return this.idinforme;
	}

	public void setIdinforme(Long idinforme) {
		this.idinforme = idinforme;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstudiorealizado() {
		return this.estudiorealizado;
	}

	public void setEstudiorealizado(String estudiorealizado) {
		this.estudiorealizado = estudiorealizado;
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

	public String getGmadurezplacenta() {
		return this.gmadurezplacenta;
	}

	public void setGmadurezplacenta(String gmadurezplacenta) {
		this.gmadurezplacenta = gmadurezplacenta;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getInforme() {
		return this.informe;
	}

	public void setInforme(String informe) {
		this.informe = informe;
	}

	public String getLiquidoamniotico() {
		return this.liquidoamniotico;
	}

	public void setLiquidoamniotico(String liquidoamniotico) {
		this.liquidoamniotico = liquidoamniotico;
	}

	public String getMultiple() {
		return this.multiple;
	}

	public void setMultiple(String multiple) {
		this.multiple = multiple;
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

	public String getPesofetal() {
		return this.pesofetal;
	}

	public void setPesofetal(String pesofetal) {
		this.pesofetal = pesofetal;
	}

	public String getPlacenta() {
		return this.placenta;
	}

	public void setPlacenta(String placenta) {
		this.placenta = placenta;
	}

	public String getRecomendaciones() {
		return this.recomendaciones;
	}

	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUnico() {
		return this.unico;
	}

	public void setUnico(String unico) {
		this.unico = unico;
	}

	public List<ImgEcografiaObstetrica> getImgecografiaobstetricas() {
		return this.imgecografiaobstetricas;
	}

	public void setImgecografiaobstetricas(List<ImgEcografiaObstetrica> imgecografiaobstetricas) {
		this.imgecografiaobstetricas = imgecografiaobstetricas;
	}

	public ImgEcografiaObstetrica addImgecografiaobstetrica(ImgEcografiaObstetrica imgecografiaobstetrica) {
		getImgecografiaobstetricas().add(imgecografiaobstetrica);
		imgecografiaobstetrica.setImginforme(this);

		return imgecografiaobstetrica;
	}

	public ImgEcografiaObstetrica removeImgecografiaobstetrica(ImgEcografiaObstetrica imgecografiaobstetrica) {
		getImgecografiaobstetricas().remove(imgecografiaobstetrica);
		imgecografiaobstetrica.setImginforme(null);

		return imgecografiaobstetrica;
	}

	public ImgDatoInforme getImgdatosinforme() {
		return this.imgdatosinforme;
	}

	public void setImgdatosinforme(ImgDatoInforme imgdatosinforme) {
		this.imgdatosinforme = imgdatosinforme;
	}

	public List<ImgInformeDiagnostico> getImginformediagnosticos() {
		return this.imginformediagnosticos;
	}

	public void setImginformediagnosticos(List<ImgInformeDiagnostico> imginformediagnosticos) {
		this.imginformediagnosticos = imginformediagnosticos;
	}

	public ImgInformeDiagnostico addImginformediagnostico(ImgInformeDiagnostico imginformediagnostico) {
		getImginformediagnosticos().add(imginformediagnostico);
		imginformediagnostico.setImginforme(this);

		return imginformediagnostico;
	}

	public ImgInformeDiagnostico removeImginformediagnostico(ImgInformeDiagnostico imginformediagnostico) {
		getImginformediagnosticos().remove(imginformediagnostico);
		imginformediagnostico.setImginforme(null);

		return imginformediagnostico;
	}

}