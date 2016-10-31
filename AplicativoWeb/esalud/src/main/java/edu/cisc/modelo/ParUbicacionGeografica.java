package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parubicacionesgeograficas database table.
 * 
 */
@Entity
@Table(name="parubicacionesgeograficas")
@NamedQuery(name="ParUbicacionGeografica.findAll", query="SELECT p FROM ParUbicacionGeografica p")
public class ParUbicacionGeografica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idubgeo;

	private String circuito;

	private String codigo;

	private String codigopadre;

	private String distrito;

	private String nombre;

	//bi-directional many-to-one association to ParTipoUbicacionGeografica
	@ManyToOne
	@JoinColumn(name="idtipoubgeo")
	private ParTipoUbicacionGeografica partiposubicacionesgeografica;

	public ParUbicacionGeografica() {
	}

	public Long getIdubgeo() {
		return this.idubgeo;
	}

	public void setIdubgeo(Long idubgeo) {
		this.idubgeo = idubgeo;
	}

	public String getCircuito() {
		return this.circuito;
	}

	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigopadre() {
		return this.codigopadre;
	}

	public void setCodigopadre(String codigopadre) {
		this.codigopadre = codigopadre;
	}

	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ParTipoUbicacionGeografica getPartiposubicacionesgeografica() {
		return this.partiposubicacionesgeografica;
	}

	public void setPartiposubicacionesgeografica(ParTipoUbicacionGeografica partiposubicacionesgeografica) {
		this.partiposubicacionesgeografica = partiposubicacionesgeografica;
	}

}