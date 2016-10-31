package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the odoregistroodontologico database table.
 * 
 */
@Entity
@NamedQuery(name="OdoRegistroOdontologico.findAll", query="SELECT o FROM OdoRegistroOdontologico o")
public class OdoRegistroOdontologico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idregistro;

	private String embarazada;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechaapertura;

	@Temporal(TemporalType.DATE)
	private Date fechacontrol;

	private String firma;

	private String motivoconsulta;

	private Integer numhc;

	private Integer numhoja;

	private String problemaactual;

	private String rangoedad;

	//bi-directional many-to-one association to OdoAntecedentePer
	@OneToMany(mappedBy="odoregistroodontologico")
	private List<OdoAntecedentePer> odoantecedentespers;

	//bi-directional many-to-one association to OdoDiagnostico
	@OneToMany(mappedBy="odoregistroodontologico")
	private List<OdoDiagnostico> ododiagnosticos;

	//bi-directional many-to-one association to OdoExaSisEstomatognatico
	@OneToMany(mappedBy="odoregistroodontologico")
	private List<OdoExaSisEstomatognatico> odoexasisestomatognaticos;

	//bi-directional many-to-one association to OdoOdontograma
	@OneToMany(mappedBy="odoregistroodontologico")
	private List<OdoOdontograma> odoodontogramas;

	//bi-directional many-to-one association to OdoPiezaDental
	@OneToMany(mappedBy="odoregistroodontologico")
	private List<OdoPiezaDental> odopiezasdentales;

	//bi-directional many-to-one association to OdoPlanDiagnostico
	@OneToMany(mappedBy="odoregistroodontologico")
	private List<OdoPlanDiagnostico> odoplandiagnosticos;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	//bi-directional many-to-one association to ParProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idprofsalud")
	private ParProfesionalSalud parprofesionalsalud;

	//bi-directional many-to-one association to ProEstablecimientoSalud
	@ManyToOne
	@JoinColumn(name="idestablecimiento")
	private ProEstablecimientoSalud proestablecimientosalud;

	//bi-directional many-to-one association to OdoSignoVital
	@OneToMany(mappedBy="odoregistroodontologico")
	private List<OdoSignoVital> odosignosvitales;

	//bi-directional many-to-one association to OdoTratamiento
	@OneToMany(mappedBy="odoregistroodontologico")
	private List<OdoTratamiento> odotratamientos;

	public OdoRegistroOdontologico() {
	}

	public Long getIdregistro() {
		return this.idregistro;
	}

	public void setIdregistro(Long idregistro) {
		this.idregistro = idregistro;
	}

	public String getEmbarazada() {
		return this.embarazada;
	}

	public void setEmbarazada(String embarazada) {
		this.embarazada = embarazada;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaapertura() {
		return this.fechaapertura;
	}

	public void setFechaapertura(Date fechaapertura) {
		this.fechaapertura = fechaapertura;
	}

	public Date getFechacontrol() {
		return this.fechacontrol;
	}

	public void setFechacontrol(Date fechacontrol) {
		this.fechacontrol = fechacontrol;
	}

	public String getFirma() {
		return this.firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getMotivoconsulta() {
		return this.motivoconsulta;
	}

	public void setMotivoconsulta(String motivoconsulta) {
		this.motivoconsulta = motivoconsulta;
	}

	public Integer getNumhc() {
		return this.numhc;
	}

	public void setNumhc(Integer numhc) {
		this.numhc = numhc;
	}

	public Integer getNumhoja() {
		return this.numhoja;
	}

	public void setNumhoja(Integer numhoja) {
		this.numhoja = numhoja;
	}

	public String getProblemaactual() {
		return this.problemaactual;
	}

	public void setProblemaactual(String problemaactual) {
		this.problemaactual = problemaactual;
	}

	public String getRangoedad() {
		return this.rangoedad;
	}

	public void setRangoedad(String rangoedad) {
		this.rangoedad = rangoedad;
	}

	public List<OdoAntecedentePer> getOdoantecedentespers() {
		return this.odoantecedentespers;
	}

	public void setOdoantecedentespers(List<OdoAntecedentePer> odoantecedentespers) {
		this.odoantecedentespers = odoantecedentespers;
	}

	public OdoAntecedentePer addOdoantecedentesper(OdoAntecedentePer odoantecedentesper) {
		getOdoantecedentespers().add(odoantecedentesper);
		odoantecedentesper.setOdoregistroodontologico(this);

		return odoantecedentesper;
	}

	public OdoAntecedentePer removeOdoantecedentesper(OdoAntecedentePer odoantecedentesper) {
		getOdoantecedentespers().remove(odoantecedentesper);
		odoantecedentesper.setOdoregistroodontologico(null);

		return odoantecedentesper;
	}

	public List<OdoDiagnostico> getOdodiagnosticos() {
		return this.ododiagnosticos;
	}

	public void setOdodiagnosticos(List<OdoDiagnostico> ododiagnosticos) {
		this.ododiagnosticos = ododiagnosticos;
	}

	public OdoDiagnostico addOdodiagnostico(OdoDiagnostico ododiagnostico) {
		getOdodiagnosticos().add(ododiagnostico);
		ododiagnostico.setOdoregistroodontologico(this);

		return ododiagnostico;
	}

	public OdoDiagnostico removeOdodiagnostico(OdoDiagnostico ododiagnostico) {
		getOdodiagnosticos().remove(ododiagnostico);
		ododiagnostico.setOdoregistroodontologico(null);

		return ododiagnostico;
	}

	public List<OdoExaSisEstomatognatico> getOdoexasisestomatognaticos() {
		return this.odoexasisestomatognaticos;
	}

	public void setOdoexasisestomatognaticos(List<OdoExaSisEstomatognatico> odoexasisestomatognaticos) {
		this.odoexasisestomatognaticos = odoexasisestomatognaticos;
	}

	public OdoExaSisEstomatognatico addOdoexasisestomatognatico(OdoExaSisEstomatognatico odoexasisestomatognatico) {
		getOdoexasisestomatognaticos().add(odoexasisestomatognatico);
		odoexasisestomatognatico.setOdoregistroodontologico(this);

		return odoexasisestomatognatico;
	}

	public OdoExaSisEstomatognatico removeOdoexasisestomatognatico(OdoExaSisEstomatognatico odoexasisestomatognatico) {
		getOdoexasisestomatognaticos().remove(odoexasisestomatognatico);
		odoexasisestomatognatico.setOdoregistroodontologico(null);

		return odoexasisestomatognatico;
	}

	public List<OdoOdontograma> getOdoodontogramas() {
		return this.odoodontogramas;
	}

	public void setOdoodontogramas(List<OdoOdontograma> odoodontogramas) {
		this.odoodontogramas = odoodontogramas;
	}

	public OdoOdontograma addOdoodontograma(OdoOdontograma odoodontograma) {
		getOdoodontogramas().add(odoodontograma);
		odoodontograma.setOdoregistroodontologico(this);

		return odoodontograma;
	}

	public OdoOdontograma removeOdoodontograma(OdoOdontograma odoodontograma) {
		getOdoodontogramas().remove(odoodontograma);
		odoodontograma.setOdoregistroodontologico(null);

		return odoodontograma;
	}

	public List<OdoPiezaDental> getOdopiezasdentales() {
		return this.odopiezasdentales;
	}

	public void setOdopiezasdentales(List<OdoPiezaDental> odopiezasdentales) {
		this.odopiezasdentales = odopiezasdentales;
	}

	public OdoPiezaDental addOdopiezasdentale(OdoPiezaDental odopiezasdentale) {
		getOdopiezasdentales().add(odopiezasdentale);
		odopiezasdentale.setOdoregistroodontologico(this);

		return odopiezasdentale;
	}

	public OdoPiezaDental removeOdopiezasdentale(OdoPiezaDental odopiezasdentale) {
		getOdopiezasdentales().remove(odopiezasdentale);
		odopiezasdentale.setOdoregistroodontologico(null);

		return odopiezasdentale;
	}

	public List<OdoPlanDiagnostico> getOdoplandiagnosticos() {
		return this.odoplandiagnosticos;
	}

	public void setOdoplandiagnosticos(List<OdoPlanDiagnostico> odoplandiagnosticos) {
		this.odoplandiagnosticos = odoplandiagnosticos;
	}

	public OdoPlanDiagnostico addOdoplandiagnostico(OdoPlanDiagnostico odoplandiagnostico) {
		getOdoplandiagnosticos().add(odoplandiagnostico);
		odoplandiagnostico.setOdoregistroodontologico(this);

		return odoplandiagnostico;
	}

	public OdoPlanDiagnostico removeOdoplandiagnostico(OdoPlanDiagnostico odoplandiagnostico) {
		getOdoplandiagnosticos().remove(odoplandiagnostico);
		odoplandiagnostico.setOdoregistroodontologico(null);

		return odoplandiagnostico;
	}

	public ParPaciente getParpaciente() {
		return this.parpaciente;
	}

	public void setParpaciente(ParPaciente parpaciente) {
		this.parpaciente = parpaciente;
	}

	public ParProfesionalSalud getParprofesionalsalud() {
		return this.parprofesionalsalud;
	}

	public void setParprofesionalsalud(ParProfesionalSalud parprofesionalsalud) {
		this.parprofesionalsalud = parprofesionalsalud;
	}

	public ProEstablecimientoSalud getProestablecimientosalud() {
		return this.proestablecimientosalud;
	}

	public void setProestablecimientosalud(ProEstablecimientoSalud proestablecimientosalud) {
		this.proestablecimientosalud = proestablecimientosalud;
	}

	public List<OdoSignoVital> getOdosignosvitales() {
		return this.odosignosvitales;
	}

	public void setOdosignosvitales(List<OdoSignoVital> odosignosvitales) {
		this.odosignosvitales = odosignosvitales;
	}

	public OdoSignoVital addOdosignosvitale(OdoSignoVital odosignosvitale) {
		getOdosignosvitales().add(odosignosvitale);
		odosignosvitale.setOdoregistroodontologico(this);

		return odosignosvitale;
	}

	public OdoSignoVital removeOdosignosvitale(OdoSignoVital odosignosvitale) {
		getOdosignosvitales().remove(odosignosvitale);
		odosignosvitale.setOdoregistroodontologico(null);

		return odosignosvitale;
	}

	public List<OdoTratamiento> getOdotratamientos() {
		return this.odotratamientos;
	}

	public void setOdotratamientos(List<OdoTratamiento> odotratamientos) {
		this.odotratamientos = odotratamientos;
	}

	public OdoTratamiento addOdotratamiento(OdoTratamiento odotratamiento) {
		getOdotratamientos().add(odotratamiento);
		odotratamiento.setOdoregistroodontologico(this);

		return odotratamiento;
	}

	public OdoTratamiento removeOdotratamiento(OdoTratamiento odotratamiento) {
		getOdotratamientos().remove(odotratamiento);
		odotratamiento.setOdoregistroodontologico(null);

		return odotratamiento;
	}

}