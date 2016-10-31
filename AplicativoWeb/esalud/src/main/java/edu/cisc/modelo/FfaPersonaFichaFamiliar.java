package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ffapersonasfichafamiliar database table.
 * 
 */
@Entity
@Table(name="ffapersonasfichafamiliar")
@NamedQuery(name="FfaPersonaFichaFamiliar.findAll", query="SELECT f FROM FfaPersonaFichaFamiliar f")
public class FfaPersonaFichaFamiliar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpersona;

	private String apellidomaterno;

	private String apellidopaterno;

	private String cedula;

	private String celular;

	private Integer edad;

	private String email;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechaelim;

	@Temporal(TemporalType.DATE)
	private Date fechaingreso;

	@Temporal(TemporalType.DATE)
	private Date fechamod;

	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;

	@Temporal(TemporalType.DATE)
	private Date fechareg;

	private String primernombre;

	private String segundonombre;

	private String usuarioelim;

	private String usuariomod;

	private String usuarioreg;

	//bi-directional many-to-one association to FfaAdulto
	@OneToMany(mappedBy="ffapersonasfichafamiliar")
	private List<FfaAdulto> ffaadultos;

	//bi-directional many-to-one association to FfaDiagnostico
	@OneToMany(mappedBy="ffapersonasfichafamiliar")
	private List<FfaDiagnostico> ffadiagnosticos;

	//bi-directional many-to-one association to FfaIntervencion
	@OneToMany(mappedBy="ffapersonasfichafamiliar")
	private List<FfaIntervencion> ffaintervenciones;

	//bi-directional many-to-one association to FfaActividadEconomica
	@ManyToOne
	@JoinColumn(name="idactividadeconom")
	private FfaActividadEconomica ffaactividadeconomica;

	//bi-directional many-to-one association to FfaAdulto
	@ManyToOne
	@JoinColumn(name="idadulto")
	private FfaAdulto ffaadulto;

	//bi-directional many-to-one association to FfaCicloVitalFamiliar
	@ManyToOne
	@JoinColumn(name="idciclovital")
	private FfaCicloVitalFamiliar ffaciclovitalfamiliar;

	//bi-directional many-to-one association to FfaNacionalidad
	@ManyToOne
	@JoinColumn(name="idnacionalidad")
	private FfaNacionalidad ffanacionalidad;

	//bi-directional many-to-one association to FfaNucleoFamiliar
	@ManyToOne
	@JoinColumn(name="idnucleofamiliar")
	private FfaNucleoFamiliar ffanucleofamiliar;

	//bi-directional many-to-one association to FfaOcupacion
	@ManyToOne
	@JoinColumn(name="idocupacion")
	private FfaOcupacion ffaocupacion;

	//bi-directional many-to-one association to FfaParentesco
	@ManyToOne
	@JoinColumn(name="idparentesco")
	private FfaParentesco ffaparentesco;

	//bi-directional many-to-one association to FfaParentescoNucleoFamiliar
	@ManyToOne
	@JoinColumn(name="idparentesconf")
	private FfaParentescoNucleoFamiliar ffaparentesconucleofamiliar;

	//bi-directional many-to-one association to FfaTipoDocumentacion
	@ManyToOne
	@JoinColumn(name="idtipodocument")
	private FfaTipoDocumentacion ffatipodocumentacion;

	//bi-directional many-to-one association to FfaTipoFamilia
	@ManyToOne
	@JoinColumn(name="idtipofamilia")
	private FfaTipoFamilia ffatipofamilia;

	//bi-directional many-to-one association to FfaTipoInstruccion
	@ManyToOne
	@JoinColumn(name="idtipoinstruccion")
	private FfaTipoInstruccion ffatiposinstruccione;

	//bi-directional many-to-one association to ParEscolaridad
	@ManyToOne
	@JoinColumn(name="idescolaridad")
	private ParEscolaridad parescolaridad;

	//bi-directional many-to-one association to ParFamilia
	@ManyToOne
	@JoinColumn(name="idfamilia")
	private ParFamilia parfamilia;

	//bi-directional many-to-one association to ParGrupoCultural
	@ManyToOne
	@JoinColumn(name="idgrupocultural")
	private ParGrupoCultural pargruposculturale;

	//bi-directional many-to-one association to ParTipoSeguro
	@ManyToOne
	@JoinColumn(name="idtiposeguro")
	private ParTipoSeguro partiposeguro;

	//bi-directional many-to-one association to ParTipoEstadoCivil
	@ManyToOne
	@JoinColumn(name="idtipoestcivil")
	private ParTipoEstadoCivil partiposestadocivil;

	//bi-directional many-to-one association to ParTipoIdentificacion
	@ManyToOne
	@JoinColumn(name="idtipoidentif")
	private ParTipoIdentificacion partiposidentificacion;

	//bi-directional many-to-one association to ParTipoSexo
	@ManyToOne
	@JoinColumn(name="idtiposexo")
	private ParTipoSexo partipossexo;

	public FfaPersonaFichaFamiliar() {
	}

	public Long getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(Long idpersona) {
		this.idpersona = idpersona;
	}

	public String getApellidomaterno() {
		return this.apellidomaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	public String getApellidopaterno() {
		return this.apellidopaterno;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaelim() {
		return this.fechaelim;
	}

	public void setFechaelim(Date fechaelim) {
		this.fechaelim = fechaelim;
	}

	public Date getFechaingreso() {
		return this.fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public Date getFechamod() {
		return this.fechamod;
	}

	public void setFechamod(Date fechamod) {
		this.fechamod = fechamod;
	}

	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public Date getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Date fechareg) {
		this.fechareg = fechareg;
	}

	public String getPrimernombre() {
		return this.primernombre;
	}

	public void setPrimernombre(String primernombre) {
		this.primernombre = primernombre;
	}

	public String getSegundonombre() {
		return this.segundonombre;
	}

	public void setSegundonombre(String segundonombre) {
		this.segundonombre = segundonombre;
	}

	public String getUsuarioelim() {
		return this.usuarioelim;
	}

	public void setUsuarioelim(String usuarioelim) {
		this.usuarioelim = usuarioelim;
	}

	public String getUsuariomod() {
		return this.usuariomod;
	}

	public void setUsuariomod(String usuariomod) {
		this.usuariomod = usuariomod;
	}

	public String getUsuarioreg() {
		return this.usuarioreg;
	}

	public void setUsuarioreg(String usuarioreg) {
		this.usuarioreg = usuarioreg;
	}

	public List<FfaAdulto> getFfaadultos() {
		return this.ffaadultos;
	}

	public void setFfaadultos(List<FfaAdulto> ffaadultos) {
		this.ffaadultos = ffaadultos;
	}

	public FfaAdulto addFfaadulto(FfaAdulto ffaadulto) {
		getFfaadultos().add(ffaadulto);
		ffaadulto.setFfapersonasfichafamiliar(this);

		return ffaadulto;
	}

	public FfaAdulto removeFfaadulto(FfaAdulto ffaadulto) {
		getFfaadultos().remove(ffaadulto);
		ffaadulto.setFfapersonasfichafamiliar(null);

		return ffaadulto;
	}

	public List<FfaDiagnostico> getFfadiagnosticos() {
		return this.ffadiagnosticos;
	}

	public void setFfadiagnosticos(List<FfaDiagnostico> ffadiagnosticos) {
		this.ffadiagnosticos = ffadiagnosticos;
	}

	public FfaDiagnostico addFfadiagnostico(FfaDiagnostico ffadiagnostico) {
		getFfadiagnosticos().add(ffadiagnostico);
		ffadiagnostico.setFfapersonasfichafamiliar(this);

		return ffadiagnostico;
	}

	public FfaDiagnostico removeFfadiagnostico(FfaDiagnostico ffadiagnostico) {
		getFfadiagnosticos().remove(ffadiagnostico);
		ffadiagnostico.setFfapersonasfichafamiliar(null);

		return ffadiagnostico;
	}

	public List<FfaIntervencion> getFfaintervenciones() {
		return this.ffaintervenciones;
	}

	public void setFfaintervenciones(List<FfaIntervencion> ffaintervenciones) {
		this.ffaintervenciones = ffaintervenciones;
	}

	public FfaIntervencion addFfaintervencione(FfaIntervencion ffaintervencione) {
		getFfaintervenciones().add(ffaintervencione);
		ffaintervencione.setFfapersonasfichafamiliar(this);

		return ffaintervencione;
	}

	public FfaIntervencion removeFfaintervencione(FfaIntervencion ffaintervencione) {
		getFfaintervenciones().remove(ffaintervencione);
		ffaintervencione.setFfapersonasfichafamiliar(null);

		return ffaintervencione;
	}

	public FfaActividadEconomica getFfaactividadeconomica() {
		return this.ffaactividadeconomica;
	}

	public void setFfaactividadeconomica(FfaActividadEconomica ffaactividadeconomica) {
		this.ffaactividadeconomica = ffaactividadeconomica;
	}

	public FfaAdulto getFfaadulto() {
		return this.ffaadulto;
	}

	public void setFfaadulto(FfaAdulto ffaadulto) {
		this.ffaadulto = ffaadulto;
	}

	public FfaCicloVitalFamiliar getFfaciclovitalfamiliar() {
		return this.ffaciclovitalfamiliar;
	}

	public void setFfaciclovitalfamiliar(FfaCicloVitalFamiliar ffaciclovitalfamiliar) {
		this.ffaciclovitalfamiliar = ffaciclovitalfamiliar;
	}

	public FfaNacionalidad getFfanacionalidad() {
		return this.ffanacionalidad;
	}

	public void setFfanacionalidad(FfaNacionalidad ffanacionalidad) {
		this.ffanacionalidad = ffanacionalidad;
	}

	public FfaNucleoFamiliar getFfanucleofamiliar() {
		return this.ffanucleofamiliar;
	}

	public void setFfanucleofamiliar(FfaNucleoFamiliar ffanucleofamiliar) {
		this.ffanucleofamiliar = ffanucleofamiliar;
	}

	public FfaOcupacion getFfaocupacion() {
		return this.ffaocupacion;
	}

	public void setFfaocupacion(FfaOcupacion ffaocupacion) {
		this.ffaocupacion = ffaocupacion;
	}

	public FfaParentesco getFfaparentesco() {
		return this.ffaparentesco;
	}

	public void setFfaparentesco(FfaParentesco ffaparentesco) {
		this.ffaparentesco = ffaparentesco;
	}

	public FfaParentescoNucleoFamiliar getFfaparentesconucleofamiliar() {
		return this.ffaparentesconucleofamiliar;
	}

	public void setFfaparentesconucleofamiliar(FfaParentescoNucleoFamiliar ffaparentesconucleofamiliar) {
		this.ffaparentesconucleofamiliar = ffaparentesconucleofamiliar;
	}

	public FfaTipoDocumentacion getFfatipodocumentacion() {
		return this.ffatipodocumentacion;
	}

	public void setFfatipodocumentacion(FfaTipoDocumentacion ffatipodocumentacion) {
		this.ffatipodocumentacion = ffatipodocumentacion;
	}

	public FfaTipoFamilia getFfatipofamilia() {
		return this.ffatipofamilia;
	}

	public void setFfatipofamilia(FfaTipoFamilia ffatipofamilia) {
		this.ffatipofamilia = ffatipofamilia;
	}

	public FfaTipoInstruccion getFfatiposinstruccione() {
		return this.ffatiposinstruccione;
	}

	public void setFfatiposinstruccione(FfaTipoInstruccion ffatiposinstruccione) {
		this.ffatiposinstruccione = ffatiposinstruccione;
	}

	public ParEscolaridad getParescolaridad() {
		return this.parescolaridad;
	}

	public void setParescolaridad(ParEscolaridad parescolaridad) {
		this.parescolaridad = parescolaridad;
	}

	public ParFamilia getParfamilia() {
		return this.parfamilia;
	}

	public void setParfamilia(ParFamilia parfamilia) {
		this.parfamilia = parfamilia;
	}

	public ParGrupoCultural getPargruposculturale() {
		return this.pargruposculturale;
	}

	public void setPargruposculturale(ParGrupoCultural pargruposculturale) {
		this.pargruposculturale = pargruposculturale;
	}

	public ParTipoSeguro getPartiposeguro() {
		return this.partiposeguro;
	}

	public void setPartiposeguro(ParTipoSeguro partiposeguro) {
		this.partiposeguro = partiposeguro;
	}

	public ParTipoEstadoCivil getPartiposestadocivil() {
		return this.partiposestadocivil;
	}

	public void setPartiposestadocivil(ParTipoEstadoCivil partiposestadocivil) {
		this.partiposestadocivil = partiposestadocivil;
	}

	public ParTipoIdentificacion getPartiposidentificacion() {
		return this.partiposidentificacion;
	}

	public void setPartiposidentificacion(ParTipoIdentificacion partiposidentificacion) {
		this.partiposidentificacion = partiposidentificacion;
	}

	public ParTipoSexo getPartipossexo() {
		return this.partipossexo;
	}

	public void setPartipossexo(ParTipoSexo partipossexo) {
		this.partipossexo = partipossexo;
	}

}