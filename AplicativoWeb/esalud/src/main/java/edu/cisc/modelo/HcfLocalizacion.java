package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hcflocalizacion database table.
 * 
 */
@Entity
@NamedQuery(name="HcfLocalizacion.findAll", query="SELECT h FROM HcfLocalizacion h")
public class HcfLocalizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idhfclocalizacion;

	private String estado;

	private String tipo;

	private String ubicacion;

	//bi-directional many-to-one association to AtmSector
	@OneToMany(mappedBy="hcflocalizacion")
	private List<AtmSector> atmsectores;

	//bi-directional many-to-one association to HcfLocalizacion
	@ManyToOne
	@JoinColumn(name="idpadre")
	private HcfLocalizacion hcflocalizacion;

	//bi-directional many-to-one association to HcfLocalizacion
	@OneToMany(mappedBy="hcflocalizacion")
	private List<HcfLocalizacion> hcflocalizacions;

	public HcfLocalizacion() {
	}

	public Long getIdhfclocalizacion() {
		return this.idhfclocalizacion;
	}

	public void setIdhfclocalizacion(Long idhfclocalizacion) {
		this.idhfclocalizacion = idhfclocalizacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<AtmSector> getAtmsectores() {
		return this.atmsectores;
	}

	public void setAtmsectores(List<AtmSector> atmsectores) {
		this.atmsectores = atmsectores;
	}

	public AtmSector addAtmsectore(AtmSector atmsectore) {
		getAtmsectores().add(atmsectore);
		atmsectore.setHcflocalizacion(this);

		return atmsectore;
	}

	public AtmSector removeAtmsectore(AtmSector atmsectore) {
		getAtmsectores().remove(atmsectore);
		atmsectore.setHcflocalizacion(null);

		return atmsectore;
	}

	public HcfLocalizacion getHcflocalizacion() {
		return this.hcflocalizacion;
	}

	public void setHcflocalizacion(HcfLocalizacion hcflocalizacion) {
		this.hcflocalizacion = hcflocalizacion;
	}

	public List<HcfLocalizacion> getHcflocalizacions() {
		return this.hcflocalizacions;
	}

	public void setHcflocalizacions(List<HcfLocalizacion> hcflocalizacions) {
		this.hcflocalizacions = hcflocalizacions;
	}

	public HcfLocalizacion addHcflocalizacion(HcfLocalizacion hcflocalizacion) {
		getHcflocalizacions().add(hcflocalizacion);
		hcflocalizacion.setHcflocalizacion(this);

		return hcflocalizacion;
	}

	public HcfLocalizacion removeHcflocalizacion(HcfLocalizacion hcflocalizacion) {
		getHcflocalizacions().remove(hcflocalizacion);
		hcflocalizacion.setHcflocalizacion(null);

		return hcflocalizacion;
	}

}