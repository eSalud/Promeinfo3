package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proestablecimientosalud database table.
 * 
 */
@Entity
@NamedQuery(name="ProEstablecimientoSalud.findAll", query="SELECT p FROM ProEstablecimientoSalud p")
public class ProEstablecimientoSalud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idestablecimiento;

	private String codestablecimiento;

	private String direccion;

	private String director;

	private String estado;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to EmgIngresoEmergencia
	@OneToMany(mappedBy="proestablecimientosalud")
	private List<EmgIngresoEmergencia> emgingresosemergencias;

	//bi-directional many-to-one association to LabDetalleExamen
	@OneToMany(mappedBy="proestablecimientosalud")
	private List<LabDetalleExamen> labdetalleexamens;

	//bi-directional many-to-one association to OdoRegistroOdontologico
	@OneToMany(mappedBy="proestablecimientosalud")
	private List<OdoRegistroOdontologico> odoregistroodontologicos;

	//bi-directional many-to-one association to ParFamilia
	@OneToMany(mappedBy="proestablecimientosalud")
	private List<ParFamilia> parfamilias;

	//bi-directional many-to-one association to AtmSector
	@ManyToOne
	@JoinColumn(name="idsector")
	private AtmSector atmsectore;

	public ProEstablecimientoSalud() {
	}

	public Long getIdestablecimiento() {
		return this.idestablecimiento;
	}

	public void setIdestablecimiento(Long idestablecimiento) {
		this.idestablecimiento = idestablecimiento;
	}

	public String getCodestablecimiento() {
		return this.codestablecimiento;
	}

	public void setCodestablecimiento(String codestablecimiento) {
		this.codestablecimiento = codestablecimiento;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
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

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<EmgIngresoEmergencia> getEmgingresosemergencias() {
		return this.emgingresosemergencias;
	}

	public void setEmgingresosemergencias(List<EmgIngresoEmergencia> emgingresosemergencias) {
		this.emgingresosemergencias = emgingresosemergencias;
	}

	public EmgIngresoEmergencia addEmgingresosemergencia(EmgIngresoEmergencia emgingresosemergencia) {
		getEmgingresosemergencias().add(emgingresosemergencia);
		emgingresosemergencia.setProestablecimientosalud(this);

		return emgingresosemergencia;
	}

	public EmgIngresoEmergencia removeEmgingresosemergencia(EmgIngresoEmergencia emgingresosemergencia) {
		getEmgingresosemergencias().remove(emgingresosemergencia);
		emgingresosemergencia.setProestablecimientosalud(null);

		return emgingresosemergencia;
	}

	public List<LabDetalleExamen> getLabdetalleexamens() {
		return this.labdetalleexamens;
	}

	public void setLabdetalleexamens(List<LabDetalleExamen> labdetalleexamens) {
		this.labdetalleexamens = labdetalleexamens;
	}

	public LabDetalleExamen addLabdetalleexamen(LabDetalleExamen labdetalleexamen) {
		getLabdetalleexamens().add(labdetalleexamen);
		labdetalleexamen.setProestablecimientosalud(this);

		return labdetalleexamen;
	}

	public LabDetalleExamen removeLabdetalleexamen(LabDetalleExamen labdetalleexamen) {
		getLabdetalleexamens().remove(labdetalleexamen);
		labdetalleexamen.setProestablecimientosalud(null);

		return labdetalleexamen;
	}

	public List<OdoRegistroOdontologico> getOdoregistroodontologicos() {
		return this.odoregistroodontologicos;
	}

	public void setOdoregistroodontologicos(List<OdoRegistroOdontologico> odoregistroodontologicos) {
		this.odoregistroodontologicos = odoregistroodontologicos;
	}

	public OdoRegistroOdontologico addOdoregistroodontologico(OdoRegistroOdontologico odoregistroodontologico) {
		getOdoregistroodontologicos().add(odoregistroodontologico);
		odoregistroodontologico.setProestablecimientosalud(this);

		return odoregistroodontologico;
	}

	public OdoRegistroOdontologico removeOdoregistroodontologico(OdoRegistroOdontologico odoregistroodontologico) {
		getOdoregistroodontologicos().remove(odoregistroodontologico);
		odoregistroodontologico.setProestablecimientosalud(null);

		return odoregistroodontologico;
	}

	public List<ParFamilia> getParfamilias() {
		return this.parfamilias;
	}

	public void setParfamilias(List<ParFamilia> parfamilias) {
		this.parfamilias = parfamilias;
	}

	public ParFamilia addParfamilia(ParFamilia parfamilia) {
		getParfamilias().add(parfamilia);
		parfamilia.setProestablecimientosalud(this);

		return parfamilia;
	}

	public ParFamilia removeParfamilia(ParFamilia parfamilia) {
		getParfamilias().remove(parfamilia);
		parfamilia.setProestablecimientosalud(null);

		return parfamilia;
	}

	public AtmSector getAtmsectore() {
		return this.atmsectore;
	}

	public void setAtmsectore(AtmSector atmsectore) {
		this.atmsectore = atmsectore;
	}

}