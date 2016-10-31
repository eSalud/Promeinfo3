package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atmsectores database table.
 * 
 */
@Entity
@Table(name="atmsectores")
@NamedQuery(name="AtmSector.findAll", query="SELECT a FROM AtmSector a")
public class AtmSector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idsector;

	private String barrio;

	private String codsector;

	private String estado;

	private String link;

	private String nombre;

	private String urlimg1;

	private String urlimg2;

	private String zona;

	//bi-directional many-to-one association to HcfLocalizacion
	@ManyToOne
	@JoinColumn(name="idubicacion")
	private HcfLocalizacion hcflocalizacion;

	//bi-directional many-to-one association to AtmVisitaHCF
	@OneToMany(mappedBy="atmsectore")
	private List<AtmVisitaHCF> atmvisitashcfs;

	//bi-directional many-to-one association to ParFamilia
	@OneToMany(mappedBy="atmsectore")
	private List<ParFamilia> parfamilias;

	//bi-directional many-to-one association to ProEstablecimientoSalud
	@OneToMany(mappedBy="atmsectore")
	private List<ProEstablecimientoSalud> proestablecimientosaluds;

	public AtmSector() {
	}

	public Long getIdsector() {
		return this.idsector;
	}

	public void setIdsector(Long idsector) {
		this.idsector = idsector;
	}

	public String getBarrio() {
		return this.barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCodsector() {
		return this.codsector;
	}

	public void setCodsector(String codsector) {
		this.codsector = codsector;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrlimg1() {
		return this.urlimg1;
	}

	public void setUrlimg1(String urlimg1) {
		this.urlimg1 = urlimg1;
	}

	public String getUrlimg2() {
		return this.urlimg2;
	}

	public void setUrlimg2(String urlimg2) {
		this.urlimg2 = urlimg2;
	}

	public String getZona() {
		return this.zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public HcfLocalizacion getHcflocalizacion() {
		return this.hcflocalizacion;
	}

	public void setHcflocalizacion(HcfLocalizacion hcflocalizacion) {
		this.hcflocalizacion = hcflocalizacion;
	}

	public List<AtmVisitaHCF> getAtmvisitashcfs() {
		return this.atmvisitashcfs;
	}

	public void setAtmvisitashcfs(List<AtmVisitaHCF> atmvisitashcfs) {
		this.atmvisitashcfs = atmvisitashcfs;
	}

	public AtmVisitaHCF addAtmvisitashcf(AtmVisitaHCF atmvisitashcf) {
		getAtmvisitashcfs().add(atmvisitashcf);
		atmvisitashcf.setAtmsectore(this);

		return atmvisitashcf;
	}

	public AtmVisitaHCF removeAtmvisitashcf(AtmVisitaHCF atmvisitashcf) {
		getAtmvisitashcfs().remove(atmvisitashcf);
		atmvisitashcf.setAtmsectore(null);

		return atmvisitashcf;
	}

	public List<ParFamilia> getParfamilias() {
		return this.parfamilias;
	}

	public void setParfamilias(List<ParFamilia> parfamilias) {
		this.parfamilias = parfamilias;
	}

	public ParFamilia addParfamilia(ParFamilia parfamilia) {
		getParfamilias().add(parfamilia);
		parfamilia.setAtmsectore(this);

		return parfamilia;
	}

	public ParFamilia removeParfamilia(ParFamilia parfamilia) {
		getParfamilias().remove(parfamilia);
		parfamilia.setAtmsectore(null);

		return parfamilia;
	}

	public List<ProEstablecimientoSalud> getProestablecimientosaluds() {
		return this.proestablecimientosaluds;
	}

	public void setProestablecimientosaluds(List<ProEstablecimientoSalud> proestablecimientosaluds) {
		this.proestablecimientosaluds = proestablecimientosaluds;
	}

	public ProEstablecimientoSalud addProestablecimientosalud(ProEstablecimientoSalud proestablecimientosalud) {
		getProestablecimientosaluds().add(proestablecimientosalud);
		proestablecimientosalud.setAtmsectore(this);

		return proestablecimientosalud;
	}

	public ProEstablecimientoSalud removeProestablecimientosalud(ProEstablecimientoSalud proestablecimientosalud) {
		getProestablecimientosaluds().remove(proestablecimientosalud);
		proestablecimientosalud.setAtmsectore(null);

		return proestablecimientosalud;
	}

}