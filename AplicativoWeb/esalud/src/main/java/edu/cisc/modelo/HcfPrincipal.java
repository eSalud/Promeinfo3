package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the hcfprincipal database table.
 * 
 */
@Entity
@NamedQuery(name="HcfPrincipal.findAll", query="SELECT h FROM HcfPrincipal h")
public class HcfPrincipal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idprincipal;

	private String codigo;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechaingreso;

	private Integer grupo;

	private Integer hcf;

	private Integer idunidadop;

	private String institucionsis;

	//bi-directional many-to-one association to AtmVisitaHCU
	@ManyToOne
	@JoinColumn(name="idvisita")
	private AtmVisitaHCU atmvisitashcu;

	//bi-directional many-to-one association to HcfNotificacion
	@ManyToOne
	@JoinColumn(name="idnotificacion")
	private HcfNotificacion hcfnotificacione;

	//bi-directional many-to-one association to HcfRiesgoFamiliar
	@OneToMany(mappedBy="hcfprincipal")
	private List<HcfRiesgoFamiliar> hcfriesgofamiliars;

	//bi-directional many-to-one association to HcfViviendaServicio
	@OneToMany(mappedBy="hcfprincipal")
	private List<HcfViviendaServicio> hcfviviendaservicios;

	public HcfPrincipal() {
	}

	public Long getIdprincipal() {
		return this.idprincipal;
	}

	public void setIdprincipal(Long idprincipal) {
		this.idprincipal = idprincipal;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public Integer getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}

	public Integer getHcf() {
		return this.hcf;
	}

	public void setHcf(Integer hcf) {
		this.hcf = hcf;
	}

	public Integer getIdunidadop() {
		return this.idunidadop;
	}

	public void setIdunidadop(Integer idunidadop) {
		this.idunidadop = idunidadop;
	}

	public String getInstitucionsis() {
		return this.institucionsis;
	}

	public void setInstitucionsis(String institucionsis) {
		this.institucionsis = institucionsis;
	}

	public AtmVisitaHCU getAtmvisitashcu() {
		return this.atmvisitashcu;
	}

	public void setAtmvisitashcu(AtmVisitaHCU atmvisitashcu) {
		this.atmvisitashcu = atmvisitashcu;
	}

	public HcfNotificacion getHcfnotificacione() {
		return this.hcfnotificacione;
	}

	public void setHcfnotificacione(HcfNotificacion hcfnotificacione) {
		this.hcfnotificacione = hcfnotificacione;
	}

	public List<HcfRiesgoFamiliar> getHcfriesgofamiliars() {
		return this.hcfriesgofamiliars;
	}

	public void setHcfriesgofamiliars(List<HcfRiesgoFamiliar> hcfriesgofamiliars) {
		this.hcfriesgofamiliars = hcfriesgofamiliars;
	}

	public HcfRiesgoFamiliar addHcfriesgofamiliar(HcfRiesgoFamiliar hcfriesgofamiliar) {
		getHcfriesgofamiliars().add(hcfriesgofamiliar);
		hcfriesgofamiliar.setHcfprincipal(this);

		return hcfriesgofamiliar;
	}

	public HcfRiesgoFamiliar removeHcfriesgofamiliar(HcfRiesgoFamiliar hcfriesgofamiliar) {
		getHcfriesgofamiliars().remove(hcfriesgofamiliar);
		hcfriesgofamiliar.setHcfprincipal(null);

		return hcfriesgofamiliar;
	}

	public List<HcfViviendaServicio> getHcfviviendaservicios() {
		return this.hcfviviendaservicios;
	}

	public void setHcfviviendaservicios(List<HcfViviendaServicio> hcfviviendaservicios) {
		this.hcfviviendaservicios = hcfviviendaservicios;
	}

	public HcfViviendaServicio addHcfviviendaservicio(HcfViviendaServicio hcfviviendaservicio) {
		getHcfviviendaservicios().add(hcfviviendaservicio);
		hcfviviendaservicio.setHcfprincipal(this);

		return hcfviviendaservicio;
	}

	public HcfViviendaServicio removeHcfviviendaservicio(HcfViviendaServicio hcfviviendaservicio) {
		getHcfviviendaservicios().remove(hcfviviendaservicio);
		hcfviviendaservicio.setHcfprincipal(null);

		return hcfviviendaservicio;
	}

}