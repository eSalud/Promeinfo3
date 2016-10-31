package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atmencuentrospacientes database table.
 * 
 */
@Entity
@Table(name="atmencuentrospacientes")
@NamedQuery(name="AtmEncuentroPaciente.findAll", query="SELECT a FROM AtmEncuentroPaciente a")
public class AtmEncuentroPaciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idencpaciente;

	private String fechaencpaciente;

	private String horaencpaciente;

	private Integer idencpacientepadre;

	//bi-directional many-to-one association to AtmDiagnosticoEncPaciente
	@OneToMany(mappedBy="atmencuentrospaciente")
	private List<AtmDiagnosticoEncPaciente> atmdiagnosticosencpacientes;

	//bi-directional many-to-one association to ActActividad
	@ManyToOne
	@JoinColumn(name="idactividad")
	private ActActividad actactividade;

	//bi-directional many-to-one association to AtmAgenda
	@ManyToOne
	@JoinColumn(name="idagenda")
	private AtmAgenda atmagenda;

	//bi-directional many-to-one association to ParFacilidad
	@ManyToOne
	@JoinColumn(name="idfacilidad")
	private ParFacilidad parfacilidade;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	//bi-directional many-to-one association to ParProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idprofsalud")
	private ParProfesionalSalud parprofesionalsalud;

	//bi-directional many-to-one association to SisProcesoHospitalario
	@ManyToOne
	@JoinColumn(name="idprocesohosp")
	private SisProcesoHospitalario sisprocesoshospitalario;

	//bi-directional many-to-one association to AtmInterconsulta
	@OneToMany(mappedBy="atmencuentrospaciente")
	private List<AtmInterconsulta> atminterconsultas;

	//bi-directional many-to-one association to AtmOrden
	@OneToMany(mappedBy="atmencuentrospaciente")
	private List<AtmOrden> atmordenes;

	//bi-directional many-to-one association to AtmResultadoBinario
	@OneToMany(mappedBy="atmencuentrospaciente")
	private List<AtmResultadoBinario> atmresultadosbinarios;

	//bi-directional many-to-one association to AtmResultadoCodificado
	@OneToMany(mappedBy="atmencuentrospaciente")
	private List<AtmResultadoCodificado> atmresultadoscodificados;

	//bi-directional many-to-one association to AtmResultadoNumerico
	@OneToMany(mappedBy="atmencuentrospaciente")
	private List<AtmResultadoNumerico> atmresultadosnumericos;

	//bi-directional many-to-one association to AtmResultadoTextoLibre
	@OneToMany(mappedBy="atmencuentrospaciente")
	private List<AtmResultadoTextoLibre> atmresultadostextoslibres;

	//bi-directional many-to-one association to AtmTipoConsultaExterna
	@OneToMany(mappedBy="atmencuentrospaciente")
	private List<AtmTipoConsultaExterna> atmtipoconsultaexternas;

	//bi-directional many-to-one association to SviSignoVital
	@OneToMany(mappedBy="atmencuentrospaciente")
	private List<SviSignoVital> svisignosvitales;

	public AtmEncuentroPaciente() {
	}

	public Long getIdencpaciente() {
		return this.idencpaciente;
	}

	public void setIdencpaciente(Long idencpaciente) {
		this.idencpaciente = idencpaciente;
	}

	public String getFechaencpaciente() {
		return this.fechaencpaciente;
	}

	public void setFechaencpaciente(String fechaencpaciente) {
		this.fechaencpaciente = fechaencpaciente;
	}

	public String getHoraencpaciente() {
		return this.horaencpaciente;
	}

	public void setHoraencpaciente(String horaencpaciente) {
		this.horaencpaciente = horaencpaciente;
	}

	public Integer getIdencpacientepadre() {
		return this.idencpacientepadre;
	}

	public void setIdencpacientepadre(Integer idencpacientepadre) {
		this.idencpacientepadre = idencpacientepadre;
	}

	public List<AtmDiagnosticoEncPaciente> getAtmdiagnosticosencpacientes() {
		return this.atmdiagnosticosencpacientes;
	}

	public void setAtmdiagnosticosencpacientes(List<AtmDiagnosticoEncPaciente> atmdiagnosticosencpacientes) {
		this.atmdiagnosticosencpacientes = atmdiagnosticosencpacientes;
	}

	public AtmDiagnosticoEncPaciente addAtmdiagnosticosencpaciente(AtmDiagnosticoEncPaciente atmdiagnosticosencpaciente) {
		getAtmdiagnosticosencpacientes().add(atmdiagnosticosencpaciente);
		atmdiagnosticosencpaciente.setAtmencuentrospaciente(this);

		return atmdiagnosticosencpaciente;
	}

	public AtmDiagnosticoEncPaciente removeAtmdiagnosticosencpaciente(AtmDiagnosticoEncPaciente atmdiagnosticosencpaciente) {
		getAtmdiagnosticosencpacientes().remove(atmdiagnosticosencpaciente);
		atmdiagnosticosencpaciente.setAtmencuentrospaciente(null);

		return atmdiagnosticosencpaciente;
	}

	public ActActividad getActactividade() {
		return this.actactividade;
	}

	public void setActactividade(ActActividad actactividade) {
		this.actactividade = actactividade;
	}

	public AtmAgenda getAtmagenda() {
		return this.atmagenda;
	}

	public void setAtmagenda(AtmAgenda atmagenda) {
		this.atmagenda = atmagenda;
	}

	public ParFacilidad getParfacilidade() {
		return this.parfacilidade;
	}

	public void setParfacilidade(ParFacilidad parfacilidade) {
		this.parfacilidade = parfacilidade;
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

	public SisProcesoHospitalario getSisprocesoshospitalario() {
		return this.sisprocesoshospitalario;
	}

	public void setSisprocesoshospitalario(SisProcesoHospitalario sisprocesoshospitalario) {
		this.sisprocesoshospitalario = sisprocesoshospitalario;
	}

	public List<AtmInterconsulta> getAtminterconsultas() {
		return this.atminterconsultas;
	}

	public void setAtminterconsultas(List<AtmInterconsulta> atminterconsultas) {
		this.atminterconsultas = atminterconsultas;
	}

	public AtmInterconsulta addAtminterconsulta(AtmInterconsulta atminterconsulta) {
		getAtminterconsultas().add(atminterconsulta);
		atminterconsulta.setAtmencuentrospaciente(this);

		return atminterconsulta;
	}

	public AtmInterconsulta removeAtminterconsulta(AtmInterconsulta atminterconsulta) {
		getAtminterconsultas().remove(atminterconsulta);
		atminterconsulta.setAtmencuentrospaciente(null);

		return atminterconsulta;
	}

	public List<AtmOrden> getAtmordenes() {
		return this.atmordenes;
	}

	public void setAtmordenes(List<AtmOrden> atmordenes) {
		this.atmordenes = atmordenes;
	}

	public AtmOrden addAtmordene(AtmOrden atmordene) {
		getAtmordenes().add(atmordene);
		atmordene.setAtmencuentrospaciente(this);

		return atmordene;
	}

	public AtmOrden removeAtmordene(AtmOrden atmordene) {
		getAtmordenes().remove(atmordene);
		atmordene.setAtmencuentrospaciente(null);

		return atmordene;
	}

	public List<AtmResultadoBinario> getAtmresultadosbinarios() {
		return this.atmresultadosbinarios;
	}

	public void setAtmresultadosbinarios(List<AtmResultadoBinario> atmresultadosbinarios) {
		this.atmresultadosbinarios = atmresultadosbinarios;
	}

	public AtmResultadoBinario addAtmresultadosbinario(AtmResultadoBinario atmresultadosbinario) {
		getAtmresultadosbinarios().add(atmresultadosbinario);
		atmresultadosbinario.setAtmencuentrospaciente(this);

		return atmresultadosbinario;
	}

	public AtmResultadoBinario removeAtmresultadosbinario(AtmResultadoBinario atmresultadosbinario) {
		getAtmresultadosbinarios().remove(atmresultadosbinario);
		atmresultadosbinario.setAtmencuentrospaciente(null);

		return atmresultadosbinario;
	}

	public List<AtmResultadoCodificado> getAtmresultadoscodificados() {
		return this.atmresultadoscodificados;
	}

	public void setAtmresultadoscodificados(List<AtmResultadoCodificado> atmresultadoscodificados) {
		this.atmresultadoscodificados = atmresultadoscodificados;
	}

	public AtmResultadoCodificado addAtmresultadoscodificado(AtmResultadoCodificado atmresultadoscodificado) {
		getAtmresultadoscodificados().add(atmresultadoscodificado);
		atmresultadoscodificado.setAtmencuentrospaciente(this);

		return atmresultadoscodificado;
	}

	public AtmResultadoCodificado removeAtmresultadoscodificado(AtmResultadoCodificado atmresultadoscodificado) {
		getAtmresultadoscodificados().remove(atmresultadoscodificado);
		atmresultadoscodificado.setAtmencuentrospaciente(null);

		return atmresultadoscodificado;
	}

	public List<AtmResultadoNumerico> getAtmresultadosnumericos() {
		return this.atmresultadosnumericos;
	}

	public void setAtmresultadosnumericos(List<AtmResultadoNumerico> atmresultadosnumericos) {
		this.atmresultadosnumericos = atmresultadosnumericos;
	}

	public AtmResultadoNumerico addAtmresultadosnumerico(AtmResultadoNumerico atmresultadosnumerico) {
		getAtmresultadosnumericos().add(atmresultadosnumerico);
		atmresultadosnumerico.setAtmencuentrospaciente(this);

		return atmresultadosnumerico;
	}

	public AtmResultadoNumerico removeAtmresultadosnumerico(AtmResultadoNumerico atmresultadosnumerico) {
		getAtmresultadosnumericos().remove(atmresultadosnumerico);
		atmresultadosnumerico.setAtmencuentrospaciente(null);

		return atmresultadosnumerico;
	}

	public List<AtmResultadoTextoLibre> getAtmresultadostextoslibres() {
		return this.atmresultadostextoslibres;
	}

	public void setAtmresultadostextoslibres(List<AtmResultadoTextoLibre> atmresultadostextoslibres) {
		this.atmresultadostextoslibres = atmresultadostextoslibres;
	}

	public AtmResultadoTextoLibre addAtmresultadostextoslibre(AtmResultadoTextoLibre atmresultadostextoslibre) {
		getAtmresultadostextoslibres().add(atmresultadostextoslibre);
		atmresultadostextoslibre.setAtmencuentrospaciente(this);

		return atmresultadostextoslibre;
	}

	public AtmResultadoTextoLibre removeAtmresultadostextoslibre(AtmResultadoTextoLibre atmresultadostextoslibre) {
		getAtmresultadostextoslibres().remove(atmresultadostextoslibre);
		atmresultadostextoslibre.setAtmencuentrospaciente(null);

		return atmresultadostextoslibre;
	}

	public List<AtmTipoConsultaExterna> getAtmtipoconsultaexternas() {
		return this.atmtipoconsultaexternas;
	}

	public void setAtmtipoconsultaexternas(List<AtmTipoConsultaExterna> atmtipoconsultaexternas) {
		this.atmtipoconsultaexternas = atmtipoconsultaexternas;
	}

	public AtmTipoConsultaExterna addAtmtipoconsultaexterna(AtmTipoConsultaExterna atmtipoconsultaexterna) {
		getAtmtipoconsultaexternas().add(atmtipoconsultaexterna);
		atmtipoconsultaexterna.setAtmencuentrospaciente(this);

		return atmtipoconsultaexterna;
	}

	public AtmTipoConsultaExterna removeAtmtipoconsultaexterna(AtmTipoConsultaExterna atmtipoconsultaexterna) {
		getAtmtipoconsultaexternas().remove(atmtipoconsultaexterna);
		atmtipoconsultaexterna.setAtmencuentrospaciente(null);

		return atmtipoconsultaexterna;
	}

	public List<SviSignoVital> getSvisignosvitales() {
		return this.svisignosvitales;
	}

	public void setSvisignosvitales(List<SviSignoVital> svisignosvitales) {
		this.svisignosvitales = svisignosvitales;
	}

	public SviSignoVital addSvisignosvitale(SviSignoVital svisignosvitale) {
		getSvisignosvitales().add(svisignosvitale);
		svisignosvitale.setAtmencuentrospaciente(this);

		return svisignosvitale;
	}

	public SviSignoVital removeSvisignosvitale(SviSignoVital svisignosvitale) {
		getSvisignosvitales().remove(svisignosvitale);
		svisignosvitale.setAtmencuentrospaciente(null);

		return svisignosvitale;
	}

}