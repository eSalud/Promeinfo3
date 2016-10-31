package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the protiposinsumo database table.
 * 
 */
@Entity
@Table(name="protiposinsumo")
@NamedQuery(name="ProTipoInsumo.findAll", query="SELECT p FROM ProTipoInsumo p")
public class ProTipoInsumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipoinsumo;

	private String descripcion;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to ProInsumoMedico
	@OneToMany(mappedBy="protiposinsumo")
	private List<ProInsumoMedico> proinsumosmedicos;

	public ProTipoInsumo() {
	}

	public Long getIdtipoinsumo() {
		return this.idtipoinsumo;
	}

	public void setIdtipoinsumo(Long idtipoinsumo) {
		this.idtipoinsumo = idtipoinsumo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public List<ProInsumoMedico> getProinsumosmedicos() {
		return this.proinsumosmedicos;
	}

	public void setProinsumosmedicos(List<ProInsumoMedico> proinsumosmedicos) {
		this.proinsumosmedicos = proinsumosmedicos;
	}

	public ProInsumoMedico addProinsumosmedico(ProInsumoMedico proinsumosmedico) {
		getProinsumosmedicos().add(proinsumosmedico);
		proinsumosmedico.setProtiposinsumo(this);

		return proinsumosmedico;
	}

	public ProInsumoMedico removeProinsumosmedico(ProInsumoMedico proinsumosmedico) {
		getProinsumosmedicos().remove(proinsumosmedico);
		proinsumosmedico.setProtiposinsumo(null);

		return proinsumosmedico;
	}

}