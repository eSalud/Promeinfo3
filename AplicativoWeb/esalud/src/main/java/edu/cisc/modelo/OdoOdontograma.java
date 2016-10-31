package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the odoodontogramas database table.
 * 
 */
@Entity
@Table(name="odoodontogramas")
@NamedQuery(name="OdoOdontograma.findAll", query="SELECT o FROM OdoOdontograma o")
public class OdoOdontograma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idodontograma;

	private String lingual;

	private String movilidad1;

	private String movilidad2;

	private String recesion;

	private String recesion1;

	private String vestibular1;

	private String vestibular2;

	//bi-directional many-to-one association to OdoRegistroOdontologico
	@ManyToOne
	@JoinColumn(name="idregistro")
	private OdoRegistroOdontologico odoregistroodontologico;

	public OdoOdontograma() {
	}

	public Long getIdodontograma() {
		return this.idodontograma;
	}

	public void setIdodontograma(Long idodontograma) {
		this.idodontograma = idodontograma;
	}

	public String getLingual() {
		return this.lingual;
	}

	public void setLingual(String lingual) {
		this.lingual = lingual;
	}

	public String getMovilidad1() {
		return this.movilidad1;
	}

	public void setMovilidad1(String movilidad1) {
		this.movilidad1 = movilidad1;
	}

	public String getMovilidad2() {
		return this.movilidad2;
	}

	public void setMovilidad2(String movilidad2) {
		this.movilidad2 = movilidad2;
	}

	public String getRecesion() {
		return this.recesion;
	}

	public void setRecesion(String recesion) {
		this.recesion = recesion;
	}

	public String getRecesion1() {
		return this.recesion1;
	}

	public void setRecesion1(String recesion1) {
		this.recesion1 = recesion1;
	}

	public String getVestibular1() {
		return this.vestibular1;
	}

	public void setVestibular1(String vestibular1) {
		this.vestibular1 = vestibular1;
	}

	public String getVestibular2() {
		return this.vestibular2;
	}

	public void setVestibular2(String vestibular2) {
		this.vestibular2 = vestibular2;
	}

	public OdoRegistroOdontologico getOdoregistroodontologico() {
		return this.odoregistroodontologico;
	}

	public void setOdoregistroodontologico(OdoRegistroOdontologico odoregistroodontologico) {
		this.odoregistroodontologico = odoregistroodontologico;
	}

}