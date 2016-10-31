package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the parpersonas database table.
 * 
 */
@Entity
@Table(name="parpersonas")
@NamedQuery(name="ParPersona.findAll", query="SELECT p FROM ParPersona p")
public class ParPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpersona;

	private String apellidomaterno;

	private String apellidopaterno;

	private String cedula;

	private String celular;

	private String email;

	private String estado;

	private Timestamp fechaelim;

	private Timestamp fechamod;

	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;

	private Timestamp fechareg;

	private String ocupacion;

	private String primernombre;

	private String segundonombre;

	private String usuarioelim;

	private String usuariomod;

	private String usuarioreg;

	//bi-directional many-to-one association to AtmNotaEvolucion
	@OneToMany(mappedBy="parpersona")
	private List<AtmNotaEvolucion> atmnotasevolucions;

	//bi-directional many-to-one association to AtmRegistroAdmision
	@OneToMany(mappedBy="parpersona")
	private List<AtmRegistroAdmision> atmregistroadmisions;

	//bi-directional many-to-one association to AtmRegistroAdmisionFicha
	@OneToMany(mappedBy="parpersona")
	private List<AtmRegistroAdmisionFicha> atmregistroadmisionfichas;

	//bi-directional many-to-one association to ParPaciente
	@OneToMany(mappedBy="parpersona")
	private List<ParPaciente> parpacientes;

	//bi-directional many-to-one association to ParFamilia
	@ManyToOne
	@JoinColumn(name="idfamilia")
	private ParFamilia parfamilia;

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

	public ParPersona() {
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

	public Timestamp getFechaelim() {
		return this.fechaelim;
	}

	public void setFechaelim(Timestamp fechaelim) {
		this.fechaelim = fechaelim;
	}

	public Timestamp getFechamod() {
		return this.fechamod;
	}

	public void setFechamod(Timestamp fechamod) {
		this.fechamod = fechamod;
	}

	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
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

	public List<AtmNotaEvolucion> getAtmnotasevolucions() {
		return this.atmnotasevolucions;
	}

	public void setAtmnotasevolucions(List<AtmNotaEvolucion> atmnotasevolucions) {
		this.atmnotasevolucions = atmnotasevolucions;
	}

	public AtmNotaEvolucion addAtmnotasevolucion(AtmNotaEvolucion atmnotasevolucion) {
		getAtmnotasevolucions().add(atmnotasevolucion);
		atmnotasevolucion.setParpersona(this);

		return atmnotasevolucion;
	}

	public AtmNotaEvolucion removeAtmnotasevolucion(AtmNotaEvolucion atmnotasevolucion) {
		getAtmnotasevolucions().remove(atmnotasevolucion);
		atmnotasevolucion.setParpersona(null);

		return atmnotasevolucion;
	}

	public List<AtmRegistroAdmision> getAtmregistroadmisions() {
		return this.atmregistroadmisions;
	}

	public void setAtmregistroadmisions(List<AtmRegistroAdmision> atmregistroadmisions) {
		this.atmregistroadmisions = atmregistroadmisions;
	}

	public AtmRegistroAdmision addAtmregistroadmision(AtmRegistroAdmision atmregistroadmision) {
		getAtmregistroadmisions().add(atmregistroadmision);
		atmregistroadmision.setParpersona(this);

		return atmregistroadmision;
	}

	public AtmRegistroAdmision removeAtmregistroadmision(AtmRegistroAdmision atmregistroadmision) {
		getAtmregistroadmisions().remove(atmregistroadmision);
		atmregistroadmision.setParpersona(null);

		return atmregistroadmision;
	}

	public List<AtmRegistroAdmisionFicha> getAtmregistroadmisionfichas() {
		return this.atmregistroadmisionfichas;
	}

	public void setAtmregistroadmisionfichas(List<AtmRegistroAdmisionFicha> atmregistroadmisionfichas) {
		this.atmregistroadmisionfichas = atmregistroadmisionfichas;
	}

	public AtmRegistroAdmisionFicha addAtmregistroadmisionficha(AtmRegistroAdmisionFicha atmregistroadmisionficha) {
		getAtmregistroadmisionfichas().add(atmregistroadmisionficha);
		atmregistroadmisionficha.setParpersona(this);

		return atmregistroadmisionficha;
	}

	public AtmRegistroAdmisionFicha removeAtmregistroadmisionficha(AtmRegistroAdmisionFicha atmregistroadmisionficha) {
		getAtmregistroadmisionfichas().remove(atmregistroadmisionficha);
		atmregistroadmisionficha.setParpersona(null);

		return atmregistroadmisionficha;
	}

	public List<ParPaciente> getParpacientes() {
		return this.parpacientes;
	}

	public void setParpacientes(List<ParPaciente> parpacientes) {
		this.parpacientes = parpacientes;
	}

	public ParPaciente addParpaciente(ParPaciente parpaciente) {
		getParpacientes().add(parpaciente);
		parpaciente.setParpersona(this);

		return parpaciente;
	}

	public ParPaciente removeParpaciente(ParPaciente parpaciente) {
		getParpacientes().remove(parpaciente);
		parpaciente.setParpersona(null);

		return parpaciente;
	}

	public ParFamilia getParfamilia() {
		return this.parfamilia;
	}

	public void setParfamilia(ParFamilia parfamilia) {
		this.parfamilia = parfamilia;
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