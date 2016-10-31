package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atmantperitem database table.
 * 
 */
@Entity
@NamedQuery(name="AtmAntPerItem.findAll", query="SELECT a FROM AtmAntPerItem a")
public class AtmAntPerItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpersitem;

	private String codenf;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to AtmAntPerRegistro
	@OneToMany(mappedBy="atmantperitem")
	private List<AtmAntPerRegistro> atmantperregistros;

	public AtmAntPerItem() {
	}

	public Long getIdpersitem() {
		return this.idpersitem;
	}

	public void setIdpersitem(Long idpersitem) {
		this.idpersitem = idpersitem;
	}

	public String getCodenf() {
		return this.codenf;
	}

	public void setCodenf(String codenf) {
		this.codenf = codenf;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AtmAntPerRegistro> getAtmantperregistros() {
		return this.atmantperregistros;
	}

	public void setAtmantperregistros(List<AtmAntPerRegistro> atmantperregistros) {
		this.atmantperregistros = atmantperregistros;
	}

	public AtmAntPerRegistro addAtmantperregistro(AtmAntPerRegistro atmantperregistro) {
		getAtmantperregistros().add(atmantperregistro);
		atmantperregistro.setAtmantperitem(this);

		return atmantperregistro;
	}

	public AtmAntPerRegistro removeAtmantperregistro(AtmAntPerRegistro atmantperregistro) {
		getAtmantperregistros().remove(atmantperregistro);
		atmantperregistro.setAtmantperitem(null);

		return atmantperregistro;
	}

}