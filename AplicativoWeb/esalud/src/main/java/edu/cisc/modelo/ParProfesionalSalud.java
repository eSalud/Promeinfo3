package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parprofesionalsalud database table.
 * 
 */
@Entity
@NamedQuery(name="ParProfesionalSalud.findAll", query="SELECT p FROM ParProfesionalSalud p")
public class ParProfesionalSalud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idprofsalud;

	private String area;

	private String codprofsalud;

	private String descripcion;

	private String estado;

	private String iniciales;

	//bi-directional many-to-one association to AtmAgendaInterconsulta
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<AtmAgendaInterconsulta> atmagendainterconsultas;

	//bi-directional many-to-one association to AtmAgenda
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<AtmAgenda> atmagendas;

	//bi-directional many-to-one association to AtmAltaAmbulatoria
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<AtmAltaAmbulatoria> atmaltaambulatorias;

	//bi-directional many-to-one association to AtmEgresoHospitalario
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<AtmEgresoHospitalario> atmegresohospitalarios;

	//bi-directional many-to-one association to AtmEncuentroPaciente
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<AtmEncuentroPaciente> atmencuentrospacientes;

	//bi-directional many-to-one association to EmgIngresoEmergencia
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<EmgIngresoEmergencia> emgingresosemergencias;

	//bi-directional many-to-one association to EpiCondicionEgreso
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<EpiCondicionEgreso> epicondicionesegresos;

	//bi-directional many-to-one association to EpiCuadroClinico
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<EpiCuadroClinico> epicuadrosclinicos;

	//bi-directional many-to-one association to EpiEvolucionComplicacion
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<EpiEvolucionComplicacion> epievolucioncomplicaciones;

	//bi-directional many-to-one association to EpiHallazgoRelevanteExa
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<EpiHallazgoRelevanteExa> epihallazgosrelevantesexas;

	//bi-directional many-to-one association to EpiResumenHallazgoClinico
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<EpiResumenHallazgoClinico> epiresumenhallazgosclinicos;

	//bi-directional many-to-one association to LprExamen
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<LprExamen> lprexamenes;

	//bi-directional many-to-one association to LprProfSaludPaciente
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<LprProfSaludPaciente> lprprofsaludpacientes;

	//bi-directional many-to-one association to OdoRegistroOdontologico
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<OdoRegistroOdontologico> odoregistroodontologicos;

	//bi-directional many-to-one association to AdmPersonaSistema
	@ManyToOne
	@JoinColumn(name="idpersona")
	private AdmPersonaSistema admpersonassistema;

	//bi-directional many-to-one association to ParEspecialidadMedica
	@ManyToOne
	@JoinColumn(name="idespecialidad")
	private ParEspecialidadMedica parespecialidadesmedica;

	//bi-directional many-to-one association to ParTipoProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idtipoprofsalud")
	private ParTipoProfesionalSalud partiposprofesionalessalud;

	//bi-directional many-to-one association to ParProfSaludCategoriaServicio
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<ParProfSaludCategoriaServicio> parprofsaludcategoriaservicios;

	//bi-directional many-to-one association to ProAdmMedicamento
	@OneToMany(mappedBy="parprofesionalsalud")
	private List<ProAdmMedicamento> proadmmedicamentos;

	public ParProfesionalSalud() {
	}

	public Long getIdprofsalud() {
		return this.idprofsalud;
	}

	public void setIdprofsalud(Long idprofsalud) {
		this.idprofsalud = idprofsalud;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCodprofsalud() {
		return this.codprofsalud;
	}

	public void setCodprofsalud(String codprofsalud) {
		this.codprofsalud = codprofsalud;
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

	public String getIniciales() {
		return this.iniciales;
	}

	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}

	public List<AtmAgendaInterconsulta> getAtmagendainterconsultas() {
		return this.atmagendainterconsultas;
	}

	public void setAtmagendainterconsultas(List<AtmAgendaInterconsulta> atmagendainterconsultas) {
		this.atmagendainterconsultas = atmagendainterconsultas;
	}

	public AtmAgendaInterconsulta addAtmagendainterconsulta(AtmAgendaInterconsulta atmagendainterconsulta) {
		getAtmagendainterconsultas().add(atmagendainterconsulta);
		atmagendainterconsulta.setParprofesionalsalud(this);

		return atmagendainterconsulta;
	}

	public AtmAgendaInterconsulta removeAtmagendainterconsulta(AtmAgendaInterconsulta atmagendainterconsulta) {
		getAtmagendainterconsultas().remove(atmagendainterconsulta);
		atmagendainterconsulta.setParprofesionalsalud(null);

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
		atmagenda.setParprofesionalsalud(this);

		return atmagenda;
	}

	public AtmAgenda removeAtmagenda(AtmAgenda atmagenda) {
		getAtmagendas().remove(atmagenda);
		atmagenda.setParprofesionalsalud(null);

		return atmagenda;
	}

	public List<AtmAltaAmbulatoria> getAtmaltaambulatorias() {
		return this.atmaltaambulatorias;
	}

	public void setAtmaltaambulatorias(List<AtmAltaAmbulatoria> atmaltaambulatorias) {
		this.atmaltaambulatorias = atmaltaambulatorias;
	}

	public AtmAltaAmbulatoria addAtmaltaambulatoria(AtmAltaAmbulatoria atmaltaambulatoria) {
		getAtmaltaambulatorias().add(atmaltaambulatoria);
		atmaltaambulatoria.setParprofesionalsalud(this);

		return atmaltaambulatoria;
	}

	public AtmAltaAmbulatoria removeAtmaltaambulatoria(AtmAltaAmbulatoria atmaltaambulatoria) {
		getAtmaltaambulatorias().remove(atmaltaambulatoria);
		atmaltaambulatoria.setParprofesionalsalud(null);

		return atmaltaambulatoria;
	}

	public List<AtmEgresoHospitalario> getAtmegresohospitalarios() {
		return this.atmegresohospitalarios;
	}

	public void setAtmegresohospitalarios(List<AtmEgresoHospitalario> atmegresohospitalarios) {
		this.atmegresohospitalarios = atmegresohospitalarios;
	}

	public AtmEgresoHospitalario addAtmegresohospitalario(AtmEgresoHospitalario atmegresohospitalario) {
		getAtmegresohospitalarios().add(atmegresohospitalario);
		atmegresohospitalario.setParprofesionalsalud(this);

		return atmegresohospitalario;
	}

	public AtmEgresoHospitalario removeAtmegresohospitalario(AtmEgresoHospitalario atmegresohospitalario) {
		getAtmegresohospitalarios().remove(atmegresohospitalario);
		atmegresohospitalario.setParprofesionalsalud(null);

		return atmegresohospitalario;
	}

	public List<AtmEncuentroPaciente> getAtmencuentrospacientes() {
		return this.atmencuentrospacientes;
	}

	public void setAtmencuentrospacientes(List<AtmEncuentroPaciente> atmencuentrospacientes) {
		this.atmencuentrospacientes = atmencuentrospacientes;
	}

	public AtmEncuentroPaciente addAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		getAtmencuentrospacientes().add(atmencuentrospaciente);
		atmencuentrospaciente.setParprofesionalsalud(this);

		return atmencuentrospaciente;
	}

	public AtmEncuentroPaciente removeAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		getAtmencuentrospacientes().remove(atmencuentrospaciente);
		atmencuentrospaciente.setParprofesionalsalud(null);

		return atmencuentrospaciente;
	}

	public List<EmgIngresoEmergencia> getEmgingresosemergencias() {
		return this.emgingresosemergencias;
	}

	public void setEmgingresosemergencias(List<EmgIngresoEmergencia> emgingresosemergencias) {
		this.emgingresosemergencias = emgingresosemergencias;
	}

	public EmgIngresoEmergencia addEmgingresosemergencia(EmgIngresoEmergencia emgingresosemergencia) {
		getEmgingresosemergencias().add(emgingresosemergencia);
		emgingresosemergencia.setParprofesionalsalud(this);

		return emgingresosemergencia;
	}

	public EmgIngresoEmergencia removeEmgingresosemergencia(EmgIngresoEmergencia emgingresosemergencia) {
		getEmgingresosemergencias().remove(emgingresosemergencia);
		emgingresosemergencia.setParprofesionalsalud(null);

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
		epicondicionesegreso.setParprofesionalsalud(this);

		return epicondicionesegreso;
	}

	public EpiCondicionEgreso removeEpicondicionesegreso(EpiCondicionEgreso epicondicionesegreso) {
		getEpicondicionesegresos().remove(epicondicionesegreso);
		epicondicionesegreso.setParprofesionalsalud(null);

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
		epicuadrosclinico.setParprofesionalsalud(this);

		return epicuadrosclinico;
	}

	public EpiCuadroClinico removeEpicuadrosclinico(EpiCuadroClinico epicuadrosclinico) {
		getEpicuadrosclinicos().remove(epicuadrosclinico);
		epicuadrosclinico.setParprofesionalsalud(null);

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
		epievolucioncomplicacione.setParprofesionalsalud(this);

		return epievolucioncomplicacione;
	}

	public EpiEvolucionComplicacion removeEpievolucioncomplicacione(EpiEvolucionComplicacion epievolucioncomplicacione) {
		getEpievolucioncomplicaciones().remove(epievolucioncomplicacione);
		epievolucioncomplicacione.setParprofesionalsalud(null);

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
		epihallazgosrelevantesexa.setParprofesionalsalud(this);

		return epihallazgosrelevantesexa;
	}

	public EpiHallazgoRelevanteExa removeEpihallazgosrelevantesexa(EpiHallazgoRelevanteExa epihallazgosrelevantesexa) {
		getEpihallazgosrelevantesexas().remove(epihallazgosrelevantesexa);
		epihallazgosrelevantesexa.setParprofesionalsalud(null);

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
		epiresumenhallazgosclinico.setParprofesionalsalud(this);

		return epiresumenhallazgosclinico;
	}

	public EpiResumenHallazgoClinico removeEpiresumenhallazgosclinico(EpiResumenHallazgoClinico epiresumenhallazgosclinico) {
		getEpiresumenhallazgosclinicos().remove(epiresumenhallazgosclinico);
		epiresumenhallazgosclinico.setParprofesionalsalud(null);

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
		lprexamene.setParprofesionalsalud(this);

		return lprexamene;
	}

	public LprExamen removeLprexamene(LprExamen lprexamene) {
		getLprexamenes().remove(lprexamene);
		lprexamene.setParprofesionalsalud(null);

		return lprexamene;
	}

	public List<LprProfSaludPaciente> getLprprofsaludpacientes() {
		return this.lprprofsaludpacientes;
	}

	public void setLprprofsaludpacientes(List<LprProfSaludPaciente> lprprofsaludpacientes) {
		this.lprprofsaludpacientes = lprprofsaludpacientes;
	}

	public LprProfSaludPaciente addLprprofsaludpaciente(LprProfSaludPaciente lprprofsaludpaciente) {
		getLprprofsaludpacientes().add(lprprofsaludpaciente);
		lprprofsaludpaciente.setParprofesionalsalud(this);

		return lprprofsaludpaciente;
	}

	public LprProfSaludPaciente removeLprprofsaludpaciente(LprProfSaludPaciente lprprofsaludpaciente) {
		getLprprofsaludpacientes().remove(lprprofsaludpaciente);
		lprprofsaludpaciente.setParprofesionalsalud(null);

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
		odoregistroodontologico.setParprofesionalsalud(this);

		return odoregistroodontologico;
	}

	public OdoRegistroOdontologico removeOdoregistroodontologico(OdoRegistroOdontologico odoregistroodontologico) {
		getOdoregistroodontologicos().remove(odoregistroodontologico);
		odoregistroodontologico.setParprofesionalsalud(null);

		return odoregistroodontologico;
	}

	public AdmPersonaSistema getAdmpersonassistema() {
		return this.admpersonassistema;
	}

	public void setAdmpersonassistema(AdmPersonaSistema admpersonassistema) {
		this.admpersonassistema = admpersonassistema;
	}

	public ParEspecialidadMedica getParespecialidadesmedica() {
		return this.parespecialidadesmedica;
	}

	public void setParespecialidadesmedica(ParEspecialidadMedica parespecialidadesmedica) {
		this.parespecialidadesmedica = parespecialidadesmedica;
	}

	public ParTipoProfesionalSalud getPartiposprofesionalessalud() {
		return this.partiposprofesionalessalud;
	}

	public void setPartiposprofesionalessalud(ParTipoProfesionalSalud partiposprofesionalessalud) {
		this.partiposprofesionalessalud = partiposprofesionalessalud;
	}

	public List<ParProfSaludCategoriaServicio> getParprofsaludcategoriaservicios() {
		return this.parprofsaludcategoriaservicios;
	}

	public void setParprofsaludcategoriaservicios(List<ParProfSaludCategoriaServicio> parprofsaludcategoriaservicios) {
		this.parprofsaludcategoriaservicios = parprofsaludcategoriaservicios;
	}

	public ParProfSaludCategoriaServicio addParprofsaludcategoriaservicio(ParProfSaludCategoriaServicio parprofsaludcategoriaservicio) {
		getParprofsaludcategoriaservicios().add(parprofsaludcategoriaservicio);
		parprofsaludcategoriaservicio.setParprofesionalsalud(this);

		return parprofsaludcategoriaservicio;
	}

	public ParProfSaludCategoriaServicio removeParprofsaludcategoriaservicio(ParProfSaludCategoriaServicio parprofsaludcategoriaservicio) {
		getParprofsaludcategoriaservicios().remove(parprofsaludcategoriaservicio);
		parprofsaludcategoriaservicio.setParprofesionalsalud(null);

		return parprofsaludcategoriaservicio;
	}

	public List<ProAdmMedicamento> getProadmmedicamentos() {
		return this.proadmmedicamentos;
	}

	public void setProadmmedicamentos(List<ProAdmMedicamento> proadmmedicamentos) {
		this.proadmmedicamentos = proadmmedicamentos;
	}

	public ProAdmMedicamento addProadmmedicamento(ProAdmMedicamento proadmmedicamento) {
		getProadmmedicamentos().add(proadmmedicamento);
		proadmmedicamento.setParprofesionalsalud(this);

		return proadmmedicamento;
	}

	public ProAdmMedicamento removeProadmmedicamento(ProAdmMedicamento proadmmedicamento) {
		getProadmmedicamentos().remove(proadmmedicamento);
		proadmmedicamento.setParprofesionalsalud(null);

		return proadmmedicamento;
	}

}