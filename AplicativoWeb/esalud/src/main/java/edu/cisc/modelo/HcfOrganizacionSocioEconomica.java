package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hcforganizacionsocioeconomica database table.
 * 
 */
@Entity
@NamedQuery(name="HcfOrganizacionSocioEconomica.findAll", query="SELECT h FROM HcfOrganizacionSocioEconomica h")
public class HcfOrganizacionSocioEconomica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idclasificacion;

	private String estado;

	private String nombre;

	public HcfOrganizacionSocioEconomica() {
	}

	public Long getIdclasificacion() {
		return this.idclasificacion;
	}

	public void setIdclasificacion(Long idclasificacion) {
		this.idclasificacion = idclasificacion;
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

}