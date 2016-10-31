package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the imgcatalogo database table.
 * 
 */
@Entity
@NamedQuery(name="ImgCatalogo.findAll", query="SELECT i FROM ImgCatalogo i")
public class ImgCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcatalogo;

	private String codigo;

	private String valor;

	//bi-directional many-to-one association to ImgTabla
	@ManyToOne
	@JoinColumn(name="idtabla")
	private ImgTabla imgtabla;

	public ImgCatalogo() {
	}

	public Long getIdcatalogo() {
		return this.idcatalogo;
	}

	public void setIdcatalogo(Long idcatalogo) {
		this.idcatalogo = idcatalogo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public ImgTabla getImgtabla() {
		return this.imgtabla;
	}

	public void setImgtabla(ImgTabla imgtabla) {
		this.imgtabla = imgtabla;
	}

}