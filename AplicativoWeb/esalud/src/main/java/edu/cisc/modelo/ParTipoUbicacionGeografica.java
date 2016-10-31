package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the partiposubicacionesgeograficas database table.
 * 
 */
@Entity
@Table(name="partiposubicacionesgeograficas")
@NamedQuery(name="ParTipoUbicacionGeografica.findAll", query="SELECT p FROM ParTipoUbicacionGeografica p")
public class ParTipoUbicacionGeografica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipoubgeo;

	private String descripcion;

	//bi-directional many-to-one association to ParUbicacionGeografica
	@OneToMany(mappedBy="partiposubicacionesgeografica")
	private List<ParUbicacionGeografica> parubicacionesgeograficas;

	public ParTipoUbicacionGeografica() {
	}

	public Long getIdtipoubgeo() {
		return this.idtipoubgeo;
	}

	public void setIdtipoubgeo(Long idtipoubgeo) {
		this.idtipoubgeo = idtipoubgeo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ParUbicacionGeografica> getParubicacionesgeograficas() {
		return this.parubicacionesgeograficas;
	}

	public void setParubicacionesgeograficas(List<ParUbicacionGeografica> parubicacionesgeograficas) {
		this.parubicacionesgeograficas = parubicacionesgeograficas;
	}

	public ParUbicacionGeografica addParubicacionesgeografica(ParUbicacionGeografica parubicacionesgeografica) {
		getParubicacionesgeograficas().add(parubicacionesgeografica);
		parubicacionesgeografica.setPartiposubicacionesgeografica(this);

		return parubicacionesgeografica;
	}

	public ParUbicacionGeografica removeParubicacionesgeografica(ParUbicacionGeografica parubicacionesgeografica) {
		getParubicacionesgeograficas().remove(parubicacionesgeografica);
		parubicacionesgeografica.setPartiposubicacionesgeografica(null);

		return parubicacionesgeografica;
	}

}