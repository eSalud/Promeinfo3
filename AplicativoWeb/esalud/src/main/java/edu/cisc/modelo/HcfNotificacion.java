package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hcfnotificaciones database table.
 * 
 */
@Entity
@Table(name="hcfnotificaciones")
@NamedQuery(name="HcfNotificacion.findAll", query="SELECT h FROM HcfNotificacion h")
public class HcfNotificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idnotificacion;

	private String direccion;

	private String estado;

	private String nombre;

	private String parentesco;

	private String telefono;

	//bi-directional many-to-one association to HcfPrincipal
	@OneToMany(mappedBy="hcfnotificacione")
	private List<HcfPrincipal> hcfprincipals;

	public HcfNotificacion() {
	}

	public Long getIdnotificacion() {
		return this.idnotificacion;
	}

	public void setIdnotificacion(Long idnotificacion) {
		this.idnotificacion = idnotificacion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public String getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<HcfPrincipal> getHcfprincipals() {
		return this.hcfprincipals;
	}

	public void setHcfprincipals(List<HcfPrincipal> hcfprincipals) {
		this.hcfprincipals = hcfprincipals;
	}

	public HcfPrincipal addHcfprincipal(HcfPrincipal hcfprincipal) {
		getHcfprincipals().add(hcfprincipal);
		hcfprincipal.setHcfnotificacione(this);

		return hcfprincipal;
	}

	public HcfPrincipal removeHcfprincipal(HcfPrincipal hcfprincipal) {
		getHcfprincipals().remove(hcfprincipal);
		hcfprincipal.setHcfnotificacione(null);

		return hcfprincipal;
	}

}