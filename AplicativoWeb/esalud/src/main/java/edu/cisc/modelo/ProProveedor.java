package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proproveedores database table.
 * 
 */
@Entity
@Table(name="proproveedores")
@NamedQuery(name="ProProveedor.findAll", query="SELECT p FROM ProProveedor p")
public class ProProveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idproveedor;

	private String correo;

	private String direccion;

	private String estado;

	private String nombre;

	private Integer personacontacto;

	private String telefono;

	//bi-directional many-to-one association to ProInsumoMedico
	@OneToMany(mappedBy="proproveedore")
	private List<ProInsumoMedico> proinsumosmedicos;

	public ProProveedor() {
	}

	public Long getIdproveedor() {
		return this.idproveedor;
	}

	public void setIdproveedor(Long idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	public Integer getPersonacontacto() {
		return this.personacontacto;
	}

	public void setPersonacontacto(Integer personacontacto) {
		this.personacontacto = personacontacto;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<ProInsumoMedico> getProinsumosmedicos() {
		return this.proinsumosmedicos;
	}

	public void setProinsumosmedicos(List<ProInsumoMedico> proinsumosmedicos) {
		this.proinsumosmedicos = proinsumosmedicos;
	}

	public ProInsumoMedico addProinsumosmedico(ProInsumoMedico proinsumosmedico) {
		getProinsumosmedicos().add(proinsumosmedico);
		proinsumosmedico.setProproveedore(this);

		return proinsumosmedico;
	}

	public ProInsumoMedico removeProinsumosmedico(ProInsumoMedico proinsumosmedico) {
		getProinsumosmedicos().remove(proinsumosmedico);
		proinsumosmedico.setProproveedore(null);

		return proinsumosmedico;
	}

}