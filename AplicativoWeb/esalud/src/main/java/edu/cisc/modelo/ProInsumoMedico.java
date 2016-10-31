package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proinsumosmedicos database table.
 * 
 */
@Entity
@Table(name="proinsumosmedicos")
@NamedQuery(name="ProInsumoMedico.findAll", query="SELECT p FROM ProInsumoMedico p")
public class ProInsumoMedico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idinsumo;

	private String descripcion;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to EmgInsumoIngresoEmergencia
	@OneToMany(mappedBy="proinsumosmedico")
	private List<EmgInsumoIngresoEmergencia> emginsumosingresosemergencias;

	//bi-directional many-to-one association to ProProveedor
	@ManyToOne
	@JoinColumn(name="idproveedor")
	private ProProveedor proproveedore;

	//bi-directional many-to-one association to ProTipoInsumo
	@ManyToOne
	@JoinColumn(name="idtipoinsumo")
	private ProTipoInsumo protiposinsumo;

	public ProInsumoMedico() {
	}

	public Long getIdinsumo() {
		return this.idinsumo;
	}

	public void setIdinsumo(Long idinsumo) {
		this.idinsumo = idinsumo;
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

	public List<EmgInsumoIngresoEmergencia> getEmginsumosingresosemergencias() {
		return this.emginsumosingresosemergencias;
	}

	public void setEmginsumosingresosemergencias(List<EmgInsumoIngresoEmergencia> emginsumosingresosemergencias) {
		this.emginsumosingresosemergencias = emginsumosingresosemergencias;
	}

	public EmgInsumoIngresoEmergencia addEmginsumosingresosemergencia(EmgInsumoIngresoEmergencia emginsumosingresosemergencia) {
		getEmginsumosingresosemergencias().add(emginsumosingresosemergencia);
		emginsumosingresosemergencia.setProinsumosmedico(this);

		return emginsumosingresosemergencia;
	}

	public EmgInsumoIngresoEmergencia removeEmginsumosingresosemergencia(EmgInsumoIngresoEmergencia emginsumosingresosemergencia) {
		getEmginsumosingresosemergencias().remove(emginsumosingresosemergencia);
		emginsumosingresosemergencia.setProinsumosmedico(null);

		return emginsumosingresosemergencia;
	}

	public ProProveedor getProproveedore() {
		return this.proproveedore;
	}

	public void setProproveedore(ProProveedor proproveedore) {
		this.proproveedore = proproveedore;
	}

	public ProTipoInsumo getProtiposinsumo() {
		return this.protiposinsumo;
	}

	public void setProtiposinsumo(ProTipoInsumo protiposinsumo) {
		this.protiposinsumo = protiposinsumo;
	}

}