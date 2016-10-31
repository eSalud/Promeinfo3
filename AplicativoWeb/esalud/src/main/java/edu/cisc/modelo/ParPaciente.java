package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the parpacientes database table.
 * 
 */
@Entity
@Table(name="parpacientes")
@NamedQuery(name="ParPaciente.findAll", query="SELECT p FROM ParPaciente p")
public class ParPaciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpaciente;

	private String estado;

	private Timestamp fechaingreso;

	private String hcu;

	//bi-directional many-to-one association to AtmAgendaInterconsulta
	@OneToMany(mappedBy="parpaciente")
	private List<AtmAgendaInterconsulta> atmagendainterconsultas;

	//bi-directional many-to-one association to AtmAgenda
	@OneToMany(mappedBy="parpaciente")
	private List<AtmAgenda> atmagendas;

	//bi-directional many-to-one association to AtmAntecedenteFamiliar
	@OneToMany(mappedBy="parpaciente")
	private List<AtmAntecedenteFamiliar> atmantecedentesfamiliares;

	//bi-directional many-to-one association to AtmAntecedentePersonal
	@OneToMany(mappedBy="parpaciente")
	private List<AtmAntecedentePersonal> atmantecedentespersonales;

	//bi-directional many-to-one association to AtmAntFamRegistro
	@OneToMany(mappedBy="parpaciente")
	private List<AtmAntFamRegistro> atmantfamregistros;

	//bi-directional many-to-one association to AtmAntPerRegistro
	@OneToMany(mappedBy="parpaciente")
	private List<AtmAntPerRegistro> atmantperregistros;

	//bi-directional many-to-one association to AtmCancer
	@OneToMany(mappedBy="parpaciente")
	private List<AtmCancer> atmcancers;

	//bi-directional many-to-one association to AtmEncuentroPaciente
	@OneToMany(mappedBy="parpaciente")
	private List<AtmEncuentroPaciente> atmencuentrospacientes;

	//bi-directional many-to-one association to AtmOrden
	@OneToMany(mappedBy="parpaciente")
	private List<AtmOrden> atmordenes;

	//bi-directional many-to-one association to AtmOrdenInterconsulta
	@OneToMany(mappedBy="parpaciente")
	private List<AtmOrdenInterconsulta> atmordeninterconsultas;

	//bi-directional many-to-one association to AtmTipoConsultaExterna
	@OneToMany(mappedBy="parpaciente")
	private List<AtmTipoConsultaExterna> atmtipoconsultaexternas;

	//bi-directional many-to-one association to EmgIngresoEmergencia
	@OneToMany(mappedBy="parpaciente")
	private List<EmgIngresoEmergencia> emgingresosemergencias;

	//bi-directional many-to-one association to EpiCondicionEgreso
	@OneToMany(mappedBy="parpaciente")
	private List<EpiCondicionEgreso> epicondicionesegresos;

	//bi-directional many-to-one association to EpiCuadroClinico
	@OneToMany(mappedBy="parpaciente")
	private List<EpiCuadroClinico> epicuadrosclinicos;

	//bi-directional many-to-one association to EpiEvolucionComplicacion
	@OneToMany(mappedBy="parpaciente")
	private List<EpiEvolucionComplicacion> epievolucioncomplicaciones;

	//bi-directional many-to-one association to EpiHallazgoRelevanteExa
	@OneToMany(mappedBy="parpaciente")
	private List<EpiHallazgoRelevanteExa> epihallazgosrelevantesexas;

	//bi-directional many-to-one association to EpiResumenHallazgoClinico
	@OneToMany(mappedBy="parpaciente")
	private List<EpiResumenHallazgoClinico> epiresumenhallazgosclinicos;

	//bi-directional many-to-one association to LprExamen
	@OneToMany(mappedBy="parpaciente")
	private List<LprExamen> lprexamenes;

	//bi-directional many-to-one association to LprHistoriaClinicaProblema
	@OneToMany(mappedBy="parpaciente")
	private List<LprHistoriaClinicaProblema> lprhistoriaclinicaproblemas;

	//bi-directional many-to-one association to LprProfSaludPaciente
	@OneToMany(mappedBy="parpaciente")
	private List<LprProfSaludPaciente> lprprofsaludpacientes;

	//bi-directional many-to-one association to OdoRegistroOdontologico
	@OneToMany(mappedBy="parpaciente")
	private List<OdoRegistroOdontologico> odoregistroodontologicos;

	//bi-directional many-to-one association to ParPersona
	@ManyToOne
	@JoinColumn(name="idpersona")
	private ParPersona parpersona;

	//bi-directional many-to-one association to ProAdmMedicamento
	@OneToMany(mappedBy="parpaciente")
	private List<ProAdmMedicamento> proadmmedicamentos;

	//bi-directional many-to-one association to SviBalanceoHidrico
	@OneToMany(mappedBy="parpaciente")
	private List<SviBalanceoHidrico> svibalanceohidricos;

	//bi-directional many-to-one association to SviMedicionActividad
	@OneToMany(mappedBy="parpaciente")
	private List<SviMedicionActividad> svimedicionesactividades;

	//bi-directional many-to-one association to SviSignoVital
	@OneToMany(mappedBy="parpaciente")
	private List<SviSignoVital> svisignosvitales;

	public ParPaciente() {
	}

	public Long getIdpaciente() {
		return this.idpaciente;
	}

	public void setIdpaciente(Long idpaciente) {
		this.idpaciente = idpaciente;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFechaingreso() {
		return this.fechaingreso;
	}

	public void setFechaingreso(Timestamp fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public String getHcu() {
		return this.hcu;
	}

	public void setHcu(String hcu) {
		this.hcu = hcu;
	}

	public List<AtmAgendaInterconsulta> getAtmagendainterconsultas() {
		return this.atmagendainterconsultas;
	}

	public void setAtmagendainterconsultas(List<AtmAgendaInterconsulta> atmagendainterconsultas) {
		this.atmagendainterconsultas = atmagendainterconsultas;
	}

	public AtmAgendaInterconsulta addAtmagendainterconsulta(AtmAgendaInterconsulta atmagendainterconsulta) {
		getAtmagendainterconsultas().add(atmagendainterconsulta);
		atmagendainterconsulta.setParpaciente(this);

		return atmagendainterconsulta;
	}

	public AtmAgendaInterconsulta removeAtmagendainterconsulta(AtmAgendaInterconsulta atmagendainterconsulta) {
		getAtmagendainterconsultas().remove(atmagendainterconsulta);
		atmagendainterconsulta.setParpaciente(null);

		return atmagendainterconsulta;
	}

	public List<AtmAgenda> getAtmagendas() {
		return this.atmagendas;
	}

	public void setAtmagendas(List<AtmAgenda> atmagendas) {
		this.atmagendas = atmagendas;
	}

	public AtmAgenda addAtmagenda(AtmAgenda atmagenda) {
		getAtmagendas().add(atmagenda);
		atmagenda.setParpaciente(this);

		return atmagenda;
	}

	public AtmAgenda removeAtmagenda(AtmAgenda atmagenda) {
		getAtmagendas().remove(atmagenda);
		atmagenda.setParpaciente(null);

		return atmagenda;
	}

	public List<AtmAntecedenteFamiliar> getAtmantecedentesfamiliares() {
		return this.atmantecedentesfamiliares;
	}

	public void setAtmantecedentesfamiliares(List<AtmAntecedenteFamiliar> atmantecedentesfamiliares) {
		this.atmantecedentesfamiliares = atmantecedentesfamiliares;
	}

	public AtmAntecedenteFamiliar addAtmantecedentesfamiliare(AtmAntecedenteFamiliar atmantecedentesfamiliare) {
		getAtmantecedentesfamiliares().add(atmantecedentesfamiliare);
		atmantecedentesfamiliare.setParpaciente(this);

		return atmantecedentesfamiliare;
	}

	public AtmAntecedenteFamiliar removeAtmantecedentesfamiliare(AtmAntecedenteFamiliar atmantecedentesfamiliare) {
		getAtmantecedentesfamiliares().remove(atmantecedentesfamiliare);
		atmantecedentesfamiliare.setParpaciente(null);

		return atmantecedentesfamiliare;
	}

	public List<AtmAntecedentePersonal> getAtmantecedentespersonales() {
		return this.atmantecedentespersonales;
	}

	public void setAtmantecedentespersonales(List<AtmAntecedentePersonal> atmantecedentespersonales) {
		this.atmantecedentespersonales = atmantecedentespersonales;
	}

	public AtmAntecedentePersonal addAtmantecedentespersonale(AtmAntecedentePersonal atmantecedentespersonale) {
		getAtmantecedentespersonales().add(atmantecedentespersonale);
		atmantecedentespersonale.setParpaciente(this);

		return atmantecedentespersonale;
	}

	public AtmAntecedentePersonal removeAtmantecedentespersonale(AtmAntecedentePersonal atmantecedentespersonale) {
		getAtmantecedentespersonales().remove(atmantecedentespersonale);
		atmantecedentespersonale.setParpaciente(null);

		return atmantecedentespersonale;
	}

	public List<AtmAntFamRegistro> getAtmantfamregistros() {
		return this.atmantfamregistros;
	}

	public void setAtmantfamregistros(List<AtmAntFamRegistro> atmantfamregistros) {
		this.atmantfamregistros = atmantfamregistros;
	}

	public AtmAntFamRegistro addAtmantfamregistro(AtmAntFamRegistro atmantfamregistro) {
		getAtmantfamregistros().add(atmantfamregistro);
		atmantfamregistro.setParpaciente(this);

		return atmantfamregistro;
	}

	public AtmAntFamRegistro removeAtmantfamregistro(AtmAntFamRegistro atmantfamregistro) {
		getAtmantfamregistros().remove(atmantfamregistro);
		atmantfamregistro.setParpaciente(null);

		return atmantfamregistro;
	}

	public List<AtmAntPerRegistro> getAtmantperregistros() {
		return this.atmantperregistros;
	}

	public void setAtmantperregistros(List<AtmAntPerRegistro> atmantperregistros) {
		this.atmantperregistros = atmantperregistros;
	}

	public AtmAntPerRegistro addAtmantperregistro(AtmAntPerRegistro atmantperregistro) {
		getAtmantperregistros().add(atmantperregistro);
		atmantperregistro.setParpaciente(this);

		return atmantperregistro;
	}

	public AtmAntPerRegistro removeAtmantperregistro(AtmAntPerRegistro atmantperregistro) {
		getAtmantperregistros().remove(atmantperregistro);
		atmantperregistro.setParpaciente(null);

		return atmantperregistro;
	}

	public List<AtmCancer> getAtmcancers() {
		return this.atmcancers;
	}

	public void setAtmcancers(List<AtmCancer> atmcancers) {
		this.atmcancers = atmcancers;
	}

	public AtmCancer addAtmcancer(AtmCancer atmcancer) {
		getAtmcancers().add(atmcancer);
		atmcancer.setParpaciente(this);

		return atmcancer;
	}

	public AtmCancer removeAtmcancer(AtmCancer atmcancer) {
		getAtmcancers().remove(atmcancer);
		atmcancer.setParpaciente(null);

		return atmcancer;
	}

	public List<AtmEncuentroPaciente> getAtmencuentrospacientes() {
		return this.atmencuentrospacientes;
	}

	public void setAtmencuentrospacientes(List<AtmEncuentroPaciente> atmencuentrospacientes) {
		this.atmencuentrospacientes = atmencuentrospacientes;
	}

	public AtmEncuentroPaciente addAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		getAtmencuentrospacientes().add(atmencuentrospaciente);
		atmencuentrospaciente.setParpaciente(this);

		return atmencuentrospaciente;
	}

	public AtmEncuentroPaciente removeAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		getAtmencuentrospacientes().remove(atmencuentrospaciente);
		atmencuentrospaciente.setParpaciente(null);

		return atmencuentrospaciente;
	}

	public List<AtmOrden> getAtmordenes() {
		return this.atmordenes;
	}

	public void setAtmordenes(List<AtmOrden> atmordenes) {
		this.atmordenes = atmordenes;
	}

	public AtmOrden addAtmordene(AtmOrden atmordene) {
		getAtmordenes().add(atmordene);
		atmordene.setParpaciente(this);

		return atmordene;
	}

	public AtmOrden removeAtmordene(AtmOrden atmordene) {
		getAtmordenes().remove(atmordene);
		atmordene.setParpaciente(null);

		return atmordene;
	}

	public List<AtmOrdenInterconsulta> getAtmordeninterconsultas() {
		return this.atmordeninterconsultas;
	}

	public void setAtmordeninterconsultas(List<AtmOrdenInterconsulta> atmordeninterconsultas) {
		this.atmordeninterconsultas = atmordeninterconsultas;
	}

	public AtmOrdenInterconsulta addAtmordeninterconsulta(AtmOrdenInterconsulta atmordeninterconsulta) {
		getAtmordeninterconsultas().add(atmordeninterconsulta);
		atmordeninterconsulta.setParpaciente(this);

		return atmordeninterconsulta;
	}

	public AtmOrdenInterconsulta removeAtmordeninterconsulta(AtmOrdenInterconsulta atmordeninterconsulta) {
		getAtmordeninterconsultas().remove(atmordeninterconsulta);
		atmordeninterconsulta.setParpaciente(null);

		return atmordeninterconsulta;
	}

	public List<AtmTipoConsultaExterna> getAtmtipoconsultaexternas() {
		return this.atmtipoconsultaexternas;
	}

	public void setAtmtipoconsultaexternas(List<AtmTipoConsultaExterna> atmtipoconsultaexternas) {
		this.atmtipoconsultaexternas = atmtipoconsultaexternas;
	}

	public AtmTipoConsultaExterna addAtmtipoconsultaexterna(AtmTipoConsultaExterna atmtipoconsultaexterna) {
		getAtmtipoconsultaexternas().add(atmtipoconsultaexterna);
		atmtipoconsultaexterna.setParpaciente(this);

		return atmtipoconsultaexterna;
	}

	public AtmTipoConsultaExterna removeAtmtipoconsultaexterna(AtmTipoConsultaExterna atmtipoconsultaexterna) {
		getAtmtipoconsultaexternas().remove(atmtipoconsultaexterna);
		atmtipoconsultaexterna.setParpaciente(null);

		return atmtipoconsultaexterna;
	}

	public List<EmgIngresoEmergencia> getEmgingresosemergencias() {
		return this.emgingresosemergencias;
	}

	public void setEmgingresosemergencias(List<EmgIngresoEmergencia> emgingresosemergencias) {
		this.emgingresosemergencias = emgingresosemergencias;
	}

	public EmgIngresoEmergencia addEmgingresosemergencia(EmgIngresoEmergencia emgingresosemergencia) {
		getEmgingresosemergencias().add(emgingresosemergencia);
		emgingresosemergencia.setParpaciente(this);

		return emgingresosemergencia;
	}

	public EmgIngresoEmergencia removeEmgingresosemergencia(EmgIngresoEmergencia emgingresosemergencia) {
		getEmgingresosemergencias().remove(emgingresosemergencia);
		emgingresosemergencia.setParpaciente(null);

		return emgingresosemergencia;
	}

	public List<EpiCondicionEgreso> getEpicondicionesegresos() {
		return this.epicondicionesegresos;
	}

	public void setEpicondicionesegresos(List<EpiCondicionEgreso> epicondicionesegresos) {
		this.epicondicionesegresos = epicondicionesegresos;
	}

	public EpiCondicionEgreso addEpicondicionesegreso(EpiCondicionEgreso epicondicionesegreso) {
		getEpicondicionesegresos().add(epicondicionesegreso);
		epicondicionesegreso.setParpaciente(this);

		return epicondicionesegreso;
	}

	public EpiCondicionEgreso removeEpicondicionesegreso(EpiCondicionEgreso epicondicionesegreso) {
		getEpicondicionesegresos().remove(epicondicionesegreso);
		epicondicionesegreso.setParpaciente(null);

		return epicondicionesegreso;
	}

	public List<EpiCuadroClinico> getEpicuadrosclinicos() {
		return this.epicuadrosclinicos;
	}

	public void setEpicuadrosclinicos(List<EpiCuadroClinico> epicuadrosclinicos) {
		this.epicuadrosclinicos = epicuadrosclinicos;
	}

	public EpiCuadroClinico addEpicuadrosclinico(EpiCuadroClinico epicuadrosclinico) {
		getEpicuadrosclinicos().add(epicuadrosclinico);
		epicuadrosclinico.setParpaciente(this);

		return epicuadrosclinico;
	}

	public EpiCuadroClinico removeEpicuadrosclinico(EpiCuadroClinico epicuadrosclinico) {
		getEpicuadrosclinicos().remove(epicuadrosclinico);
		epicuadrosclinico.setParpaciente(null);

		return epicuadrosclinico;
	}

	public List<EpiEvolucionComplicacion> getEpievolucioncomplicaciones() {
		return this.epievolucioncomplicaciones;
	}

	public void setEpievolucioncomplicaciones(List<EpiEvolucionComplicacion> epievolucioncomplicaciones) {
		this.epievolucioncomplicaciones = epievolucioncomplicaciones;
	}

	public EpiEvolucionComplicacion addEpievolucioncomplicacione(EpiEvolucionComplicacion epievolucioncomplicacione) {
		getEpievolucioncomplicaciones().add(epievolucioncomplicacione);
		epievolucioncomplicacione.setParpaciente(this);

		return epievolucioncomplicacione;
	}

	public EpiEvolucionComplicacion removeEpievolucioncomplicacione(EpiEvolucionComplicacion epievolucioncomplicacione) {
		getEpievolucioncomplicaciones().remove(epievolucioncomplicacione);
		epievolucioncomplicacione.setParpaciente(null);

		return epievolucioncomplicacione;
	}

	public List<EpiHallazgoRelevanteExa> getEpihallazgosrelevantesexas() {
		return this.epihallazgosrelevantesexas;
	}

	public void setEpihallazgosrelevantesexas(List<EpiHallazgoRelevanteExa> epihallazgosrelevantesexas) {
		this.epihallazgosrelevantesexas = epihallazgosrelevantesexas;
	}

	public EpiHallazgoRelevanteExa addEpihallazgosrelevantesexa(EpiHallazgoRelevanteExa epihallazgosrelevantesexa) {
		getEpihallazgosrelevantesexas().add(epihallazgosrelevantesexa);
		epihallazgosrelevantesexa.setParpaciente(this);

		return epihallazgosrelevantesexa;
	}

	public EpiHallazgoRelevanteExa removeEpihallazgosrelevantesexa(EpiHallazgoRelevanteExa epihallazgosrelevantesexa) {
		getEpihallazgosrelevantesexas().remove(epihallazgosrelevantesexa);
		epihallazgosrelevantesexa.setParpaciente(null);

		return epihallazgosrelevantesexa;
	}

	public List<EpiResumenHallazgoClinico> getEpiresumenhallazgosclinicos() {
		return this.epiresumenhallazgosclinicos;
	}

	public void setEpiresumenhallazgosclinicos(List<EpiResumenHallazgoClinico> epiresumenhallazgosclinicos) {
		this.epiresumenhallazgosclinicos = epiresumenhallazgosclinicos;
	}

	public EpiResumenHallazgoClinico addEpiresumenhallazgosclinico(EpiResumenHallazgoClinico epiresumenhallazgosclinico) {
		getEpiresumenhallazgosclinicos().add(epiresumenhallazgosclinico);
		epiresumenhallazgosclinico.setParpaciente(this);

		return epiresumenhallazgosclinico;
	}

	public EpiResumenHallazgoClinico removeEpiresumenhallazgosclinico(EpiResumenHallazgoClinico epiresumenhallazgosclinico) {
		getEpiresumenhallazgosclinicos().remove(epiresumenhallazgosclinico);
		epiresumenhallazgosclinico.setParpaciente(null);

		return epiresumenhallazgosclinico;
	}

	public List<LprExamen> getLprexamenes() {
		return this.lprexamenes;
	}

	public void setLprexamenes(List<LprExamen> lprexamenes) {
		this.lprexamenes = lprexamenes;
	}

	public LprExamen addLprexamene(LprExamen lprexamene) {
		getLprexamenes().add(lprexamene);
		lprexamene.setParpaciente(this);

		return lprexamene;
	}

	public LprExamen removeLprexamene(LprExamen lprexamene) {
		getLprexamenes().remove(lprexamene);
		lprexamene.setParpaciente(null);

		return lprexamene;
	}

	public List<LprHistoriaClinicaProblema> getLprhistoriaclinicaproblemas() {
		return this.lprhistoriaclinicaproblemas;
	}

	public void setLprhistoriaclinicaproblemas(List<LprHistoriaClinicaProblema> lprhistoriaclinicaproblemas) {
		this.lprhistoriaclinicaproblemas = lprhistoriaclinicaproblemas;
	}

	public LprHistoriaClinicaProblema addLprhistoriaclinicaproblema(LprHistoriaClinicaProblema lprhistoriaclinicaproblema) {
		getLprhistoriaclinicaproblemas().add(lprhistoriaclinicaproblema);
		lprhistoriaclinicaproblema.setParpaciente(this);

		return lprhistoriaclinicaproblema;
	}

	public LprHistoriaClinicaProblema removeLprhistoriaclinicaproblema(LprHistoriaClinicaProblema lprhistoriaclinicaproblema) {
		getLprhistoriaclinicaproblemas().remove(lprhistoriaclinicaproblema);
		lprhistoriaclinicaproblema.setParpaciente(null);

		return lprhistoriaclinicaproblema;
	}

	public List<LprProfSaludPaciente> getLprprofsaludpacientes() {
		return this.lprprofsaludpacientes;
	}

	public void setLprprofsaludpacientes(List<LprProfSaludPaciente> lprprofsaludpacientes) {
		this.lprprofsaludpacientes = lprprofsaludpacientes;
	}

	public LprProfSaludPaciente addLprprofsaludpaciente(LprProfSaludPaciente lprprofsaludpaciente) {
		getLprprofsaludpacientes().add(lprprofsaludpaciente);
		lprprofsaludpaciente.setParpaciente(this);

		return lprprofsaludpaciente;
	}

	public LprProfSaludPaciente removeLprprofsaludpaciente(LprProfSaludPaciente lprprofsaludpaciente) {
		getLprprofsaludpacientes().remove(lprprofsaludpaciente);
		lprprofsaludpaciente.setParpaciente(null);

		return lprprofsaludpaciente;
	}

	public List<OdoRegistroOdontologico> getOdoregistroodontologicos() {
		return this.odoregistroodontologicos;
	}

	public void setOdoregistroodontologicos(List<OdoRegistroOdontologico> odoregistroodontologicos) {
		this.odoregistroodontologicos = odoregistroodontologicos;
	}

	public OdoRegistroOdontologico addOdoregistroodontologico(OdoRegistroOdontologico odoregistroodontologico) {
		getOdoregistroodontologicos().add(odoregistroodontologico);
		odoregistroodontologico.setParpaciente(this);

		return odoregistroodontologico;
	}

	public OdoRegistroOdontologico removeOdoregistroodontologico(OdoRegistroOdontologico odoregistroodontologico) {
		getOdoregistroodontologicos().remove(odoregistroodontologico);
		odoregistroodontologico.setParpaciente(null);

		return odoregistroodontologico;
	}

	public ParPersona getParpersona() {
		return this.parpersona;
	}

	public void setParpersona(ParPersona parpersona) {
		this.parpersona = parpersona;
	}

	public List<ProAdmMedicamento> getProadmmedicamentos() {
		return this.proadmmedicamentos;
	}

	public void setProadmmedicamentos(List<ProAdmMedicamento> proadmmedicamentos) {
		this.proadmmedicamentos = proadmmedicamentos;
	}

	public ProAdmMedicamento addProadmmedicamento(ProAdmMedicamento proadmmedicamento) {
		getProadmmedicamentos().add(proadmmedicamento);
		proadmmedicamento.setParpaciente(this);

		return proadmmedicamento;
	}

	public ProAdmMedicamento removeProadmmedicamento(ProAdmMedicamento proadmmedicamento) {
		getProadmmedicamentos().remove(proadmmedicamento);
		proadmmedicamento.setParpaciente(null);

		return proadmmedicamento;
	}

	public List<SviBalanceoHidrico> getSvibalanceohidricos() {
		return this.svibalanceohidricos;
	}

	public void setSvibalanceohidricos(List<SviBalanceoHidrico> svibalanceohidricos) {
		this.svibalanceohidricos = svibalanceohidricos;
	}

	public SviBalanceoHidrico addSvibalanceohidrico(SviBalanceoHidrico svibalanceohidrico) {
		getSvibalanceohidricos().add(svibalanceohidrico);
		svibalanceohidrico.setParpaciente(this);

		return svibalanceohidrico;
	}

	public SviBalanceoHidrico removeSvibalanceohidrico(SviBalanceoHidrico svibalanceohidrico) {
		getSvibalanceohidricos().remove(svibalanceohidrico);
		svibalanceohidrico.setParpaciente(null);

		return svibalanceohidrico;
	}

	public List<SviMedicionActividad> getSvimedicionesactividades() {
		return this.svimedicionesactividades;
	}

	public void setSvimedicionesactividades(List<SviMedicionActividad> svimedicionesactividades) {
		this.svimedicionesactividades = svimedicionesactividades;
	}

	public SviMedicionActividad addSvimedicionesactividade(SviMedicionActividad svimedicionesactividade) {
		getSvimedicionesactividades().add(svimedicionesactividade);
		svimedicionesactividade.setParpaciente(this);

		return svimedicionesactividade;
	}

	public SviMedicionActividad removeSvimedicionesactividade(SviMedicionActividad svimedicionesactividade) {
		getSvimedicionesactividades().remove(svimedicionesactividade);
		svimedicionesactividade.setParpaciente(null);

		return svimedicionesactividade;
	}

	public List<SviSignoVital> getSvisignosvitales() {
		return this.svisignosvitales;
	}

	public void setSvisignosvitales(List<SviSignoVital> svisignosvitales) {
		this.svisignosvitales = svisignosvitales;
	}

	public SviSignoVital addSvisignosvitale(SviSignoVital svisignosvitale) {
		getSvisignosvitales().add(svisignosvitale);
		svisignosvitale.setParpaciente(this);

		return svisignosvitale;
	}

	public SviSignoVital removeSvisignosvitale(SviSignoVital svisignosvitale) {
		getSvisignosvitales().remove(svisignosvitale);
		svisignosvitale.setParpaciente(null);

		return svisignosvitale;
	}

}