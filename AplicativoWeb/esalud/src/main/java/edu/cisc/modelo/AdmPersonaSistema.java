package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the admpersonassistema database table.
 * 
 */
@Entity
@Table(name="admpersonassistema")
@NamedQuery(name="AdmPersonaSistema.findAll", query="SELECT a FROM AdmPersonaSistema a")
public class AdmPersonaSistema implements Serializable {
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

	private Timestamp fechamod;

	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;

	private Timestamp fechareg;

	private String ocupacion;

	private String primernombre;

	private String segundonombre;

	private String usuariomod;

	private String usuarioreg;

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

	//bi-directional many-to-one association to AdmUsuario
	@OneToMany(mappedBy="admpersonassistema")
	private List<AdmUsuario> admusuarios;

	//bi-directional many-to-one association to ParProfesionalSalud
	@OneToMany(mappedBy="admpersonassistema")
	private List<ParProfesionalSalud> parprofesionalsaluds;

	public AdmPersonaSistema() {
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

	public List<AdmUsuario> getAdmusuarios() {
		return this.admusuarios;
	}

	public void setAdmusuarios(List<AdmUsuario> admusuarios) {
		this.admusuarios = admusuarios;
	}

	public AdmUsuario addAdmusuario(AdmUsuario admusuario) {
		getAdmusuarios().add(admusuario);
		admusuario.setAdmpersonassistema(this);

		return admusuario;
	}

	public AdmUsuario removeAdmusuario(AdmUsuario admusuario) {
		getAdmusuarios().remove(admusuario);
		admusuario.setAdmpersonassistema(null);

		return admusuario;
	}

	public List<ParProfesionalSalud> getParprofesionalsaluds() {
		return this.parprofesionalsaluds;
	}

	public void setParprofesionalsaluds(List<ParProfesionalSalud> parprofesionalsaluds) {
		this.parprofesionalsaluds = parprofesionalsaluds;
	}

	public ParProfesionalSalud addParprofesionalsalud(ParProfesionalSalud parprofesionalsalud) {
		getParprofesionalsaluds().add(parprofesionalsalud);
		parprofesionalsalud.setAdmpersonassistema(this);

		return parprofesionalsalud;
	}

	public ParProfesionalSalud removeParprofesionalsalud(ParProfesionalSalud parprofesionalsalud) {
		getParprofesionalsaluds().remove(parprofesionalsalud);
		parprofesionalsalud.setAdmpersonassistema(null);

		return parprofesionalsalud;
	}

}