package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the odopiezasdentales database table.
 * 
 */
@Entity
@Table(name="odopiezasdentales")
@NamedQuery(name="OdoPiezaDental.findAll", query="SELECT o FROM OdoPiezaDental o")
public class OdoPiezaDental implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpiezadental;

	private String cara1;

	private String cara2;

	private String cara3;

	private String cara4;

	private String cara5;

	private String estado;

	private Integer idpaciente;

	//bi-directional many-to-one association to OdoRegistroOdontologico
	@ManyToOne
	@JoinColumn(name="idregistro")
	private OdoRegistroOdontologico odoregistroodontologico;

	public OdoPiezaDental() {
	}

	public Long getIdpiezadental() {
		return this.idpiezadental;
	}

	public void setIdpiezadental(Long idpiezadental) {
		this.idpiezadental = idpiezadental;
	}

	public String getCara1() {
		return this.cara1;
	}

	public void setCara1(String cara1) {
		this.cara1 = cara1;
	}

	public String getCara2() {
		return this.cara2;
	}

	public void setCara2(String cara2) {
		this.cara2 = cara2;
	}

	public String getCara3() {
		return this.cara3;
	}

	public void setCara3(String cara3) {
		this.cara3 = cara3;
	}

	public String getCara4() {
		return this.cara4;
	}

	public void setCara4(String cara4) {
		this.cara4 = cara4;
	}

	public String getCara5() {
		return this.cara5;
	}

	public void setCara5(String cara5) {
		this.cara5 = cara5;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdpaciente() {
		return this.idpaciente;
	}

	public void setIdpaciente(Integer idpaciente) {
		this.idpaciente = idpaciente;
	}

	public OdoRegistroOdontologico getOdoregistroodontologico() {
		return this.odoregistroodontologico;
	}

	public void setOdoregistroodontologico(OdoRegistroOdontologico odoregistroodontologico) {
		this.odoregistroodontologico = odoregistroodontologico;
	}

}