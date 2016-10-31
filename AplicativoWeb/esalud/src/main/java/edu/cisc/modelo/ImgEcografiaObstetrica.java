package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the imgecografiaobstetrica database table.
 * 
 */
@Entity
@NamedQuery(name="ImgEcografiaObstetrica.findAll", query="SELECT i FROM ImgEcografiaObstetrica i")
public class ImgEcografiaObstetrica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idecoobstetricia;

	private Integer edadgestacion;

	private String medida;

	private BigDecimal valor;

	//bi-directional many-to-one association to ImgInforme
	@ManyToOne
	@JoinColumn(name="idinforme")
	private ImgInforme imginforme;

	public ImgEcografiaObstetrica() {
	}

	public Long getIdecoobstetricia() {
		return this.idecoobstetricia;
	}

	public void setIdecoobstetricia(Long idecoobstetricia) {
		this.idecoobstetricia = idecoobstetricia;
	}

	public Integer getEdadgestacion() {
		return this.edadgestacion;
	}

	public void setEdadgestacion(Integer edadgestacion) {
		this.edadgestacion = edadgestacion;
	}

	public String getMedida() {
		return this.medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public ImgInforme getImginforme() {
		return this.imginforme;
	}

	public void setImginforme(ImgInforme imginforme) {
		this.imginforme = imginforme;
	}

}