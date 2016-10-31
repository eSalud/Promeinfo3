package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the parfamilias database table.
 * 
 */
@Entity
@Table(name="parfamilias")
@NamedQuery(name="ParFamilia.findAll", query="SELECT p FROM ParFamilia p")
public class ParFamilia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idfamilia;

	private String apellido1;

	private String apellido2;

	private String barrio;

	private String comunidad;

	private String direccion;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechaingreso;

	private Integer hcf;

	private Integer idjefefamiliar;

	private String manzana;

	private Integer ncarpetafamiliar;

	private Integer ncasa;

	private String telefono;

	//bi-directional many-to-one association to AtmVisitaHCF
	@OneToMany(mappedBy="parfamilia")
	private List<AtmVisitaHCF> atmvisitashcfs;

	//bi-directional many-to-one association to FfaPersonaFichaFamiliar
	@OneToMany(mappedBy="parfamilia")
	private List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars;

	//bi-directional many-to-one association to AtmEdifGeoUbicacion
	@ManyToOne
	@JoinColumn(name="idedifgeoub")
	private AtmEdifGeoUbicacion atmedifgeoubicacion;

	//bi-directional many-to-one association to AtmSector
	@ManyToOne
	@JoinColumn(name="idsector")
	private AtmSector atmsectore;

	//bi-directional many-to-one association to ParFamilia
	@ManyToOne
	@JoinColumn(name="idfamiliapadre")
	private ParFamilia parfamilia;

	//bi-directional many-to-one association to ParFamilia
	@OneToMany(mappedBy="parfamilia")
	private List<ParFamilia> parfamilias;

	//bi-directional many-to-one association to ParGrupoCultural
	@ManyToOne
	@JoinColumn(name="idgrupocultural")
	private ParGrupoCultural pargruposculturale;

	//bi-directional many-to-one association to ProEstablecimientoSalud
	@ManyToOne
	@JoinColumn(name="idestablecimiento")
	private ProEstablecimientoSalud proestablecimientosalud;

	//bi-directional many-to-one association to ProUnidadOperativa
	@ManyToOne
	@JoinColumn(name="idunidadop")
	private ProUnidadOperativa prounidadoperativa;

	//bi-directional many-to-one association to ParPersona
	@OneToMany(mappedBy="parfamilia")
	private List<ParPersona> parpersonas;

	public ParFamilia() {
	}

	public Long getIdfamilia() {
		return this.idfamilia;
	}

	public void setIdfamilia(Long idfamilia) {
		this.idfamilia = idfamilia;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getBarrio() {
		return this.barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getComunidad() {
		return this.comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
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

	public Date getFechaingreso() {
		return this.fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public Integer getHcf() {
		return this.hcf;
	}

	public void setHcf(Integer hcf) {
		this.hcf = hcf;
	}

	public Integer getIdjefefamiliar() {
		return this.idjefefamiliar;
	}

	public void setIdjefefamiliar(Integer idjefefamiliar) {
		this.idjefefamiliar = idjefefamiliar;
	}

	public String getManzana() {
		return this.manzana;
	}

	public void setManzana(String manzana) {
		this.manzana = manzana;
	}

	public Integer getNcarpetafamiliar() {
		return this.ncarpetafamiliar;
	}

	public void setNcarpetafamiliar(Integer ncarpetafamiliar) {
		this.ncarpetafamiliar = ncarpetafamiliar;
	}

	public Integer getNcasa() {
		return this.ncasa;
	}

	public void setNcasa(Integer ncasa) {
		this.ncasa = ncasa;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<AtmVisitaHCF> getAtmvisitashcfs() {
		return this.atmvisitashcfs;
	}

	public void setAtmvisitashcfs(List<AtmVisitaHCF> atmvisitashcfs) {
		this.atmvisitashcfs = atmvisitashcfs;
	}

	public AtmVisitaHCF addAtmvisitashcf(AtmVisitaHCF atmvisitashcf) {
		getAtmvisitashcfs().add(atmvisitashcf);
		atmvisitashcf.setParfamilia(this);

		return atmvisitashcf;
	}

	public AtmVisitaHCF removeAtmvisitashcf(AtmVisitaHCF atmvisitashcf) {
		getAtmvisitashcfs().remove(atmvisitashcf);
		atmvisitashcf.setParfamilia(null);

		return atmvisitashcf;
	}

	public List<FfaPersonaFichaFamiliar> getFfapersonasfichafamiliars() {
		return this.ffapersonasfichafamiliars;
	}

	public void setFfapersonasfichafamiliars(List<FfaPersonaFichaFamiliar> ffapersonasfichafamiliars) {
		this.ffapersonasfichafamiliars = ffapersonasfichafamiliars;
	}

	public FfaPersonaFichaFamiliar addFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().add(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setParfamilia(this);

		return ffapersonasfichafamiliar;
	}

	public FfaPersonaFichaFamiliar removeFfapersonasfichafamiliar(FfaPersonaFichaFamiliar ffapersonasfichafamiliar) {
		getFfapersonasfichafamiliars().remove(ffapersonasfichafamiliar);
		ffapersonasfichafamiliar.setParfamilia(null);

		return ffapersonasfichafamiliar;
	}

	public AtmEdifGeoUbicacion getAtmedifgeoubicacion() {
		return this.atmedifgeoubicacion;
	}

	public void setAtmedifgeoubicacion(AtmEdifGeoUbicacion atmedifgeoubicacion) {
		this.atmedifgeoubicacion = atmedifgeoubicacion;
	}

	public AtmSector getAtmsectore() {
		return this.atmsectore;
	}

	public void setAtmsectore(AtmSector atmsectore) {
		this.atmsectore = atmsectore;
	}

	public ParFamilia getParfamilia() {
		return this.parfamilia;
	}

	public void setParfamilia(ParFamilia parfamilia) {
		this.parfamilia = parfamilia;
	}

	public List<ParFamilia> getParfamilias() {
		return this.parfamilias;
	}

	public void setParfamilias(List<ParFamilia> parfamilias) {
		this.parfamilias = parfamilias;
	}

	public ParFamilia addParfamilia(ParFamilia parfamilia) {
		getParfamilias().add(parfamilia);
		parfamilia.setParfamilia(this);

		return parfamilia;
	}

	public ParFamilia removeParfamilia(ParFamilia parfamilia) {
		getParfamilias().remove(parfamilia);
		parfamilia.setParfamilia(null);

		return parfamilia;
	}

	public ParGrupoCultural getPargruposculturale() {
		return this.pargruposculturale;
	}

	public void setPargruposculturale(ParGrupoCultural pargruposculturale) {
		this.pargruposculturale = pargruposculturale;
	}

	public ProEstablecimientoSalud getProestablecimientosalud() {
		return this.proestablecimientosalud;
	}

	public void setProestablecimientosalud(ProEstablecimientoSalud proestablecimientosalud) {
		this.proestablecimientosalud = proestablecimientosalud;
	}

	public ProUnidadOperativa getProunidadoperativa() {
		return this.prounidadoperativa;
	}

	public void setProunidadoperativa(ProUnidadOperativa prounidadoperativa) {
		this.prounidadoperativa = prounidadoperativa;
	}

	public List<ParPersona> getParpersonas() {
		return this.parpersonas;
	}

	public void setParpersonas(List<ParPersona> parpersonas) {
		this.parpersonas = parpersonas;
	}

	public ParPersona addParpersona(ParPersona parpersona) {
		getParpersonas().add(parpersona);
		parpersona.setParfamilia(this);

		return parpersona;
	}

	public ParPersona removeParpersona(ParPersona parpersona) {
		getParpersonas().remove(parpersona);
		parpersona.setParfamilia(null);

		return parpersona;
	}

}