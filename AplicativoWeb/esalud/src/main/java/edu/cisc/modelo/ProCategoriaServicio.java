package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the procategoriasservicios database table.
 * 
 */
@Entity
@Table(name="procategoriasservicios")
@NamedQuery(name="ProCategoriaServicio.findAll", query="SELECT p FROM ProCategoriaServicio p")
public class ProCategoriaServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcatservicio;

	private String estado;

	private Timestamp fechacreacion;

	private Integer idcatserviciorec;

	private String interconsulta;

	private String nombre;

	//bi-directional many-to-one association to AtmAgendaInterconsulta
	@OneToMany(mappedBy="procategoriasservicio")
	private List<AtmAgendaInterconsulta> atmagendainterconsultas;

	//bi-directional many-to-one association to ParProfSaludCategoriaServicio
	@OneToMany(mappedBy="procategoriasservicio")
	private List<ParProfSaludCategoriaServicio> parprofsaludcategoriaservicios;

	//bi-directional many-to-one association to ProServicio
	@OneToMany(mappedBy="procategoriasservicio")
	private List<ProServicio> proservicios;

	public ProCategoriaServicio() {
	}

	public Long getIdcatservicio() {
		return this.idcatservicio;
	}

	public void setIdcatservicio(Long idcatservicio) {
		this.idcatservicio = idcatservicio;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Timestamp fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Integer getIdcatserviciorec() {
		return this.idcatserviciorec;
	}

	public void setIdcatserviciorec(Integer idcatserviciorec) {
		this.idcatserviciorec = idcatserviciorec;
	}

	public String getInterconsulta() {
		return this.interconsulta;
	}

	public void setInterconsulta(String interconsulta) {
		this.interconsulta = interconsulta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AtmAgendaInterconsulta> getAtmagendainterconsultas() {
		return this.atmagendainterconsultas;
	}

	public void setAtmagendainterconsultas(List<AtmAgendaInterconsulta> atmagendainterconsultas) {
		this.atmagendainterconsultas = atmagendainterconsultas;
	}

	public AtmAgendaInterconsulta addAtmagendainterconsulta(AtmAgendaInterconsulta atmagendainterconsulta) {
		getAtmagendainterconsultas().add(atmagendainterconsulta);
		atmagendainterconsulta.setProcategoriasservicio(this);

		return atmagendainterconsulta;
	}

	public AtmAgendaInterconsulta removeAtmagendainterconsulta(AtmAgendaInterconsulta atmagendainterconsulta) {
		getAtmagendainterconsultas().remove(atmagendainterconsulta);
		atmagendainterconsulta.setProcategoriasservicio(null);

		return atmagendainterconsulta;
	}

	public List<ParProfSaludCategoriaServicio> getParprofsaludcategoriaservicios() {
		return this.parprofsaludcategoriaservicios;
	}

	public void setParprofsaludcategoriaservicios(List<ParProfSaludCategoriaServicio> parprofsaludcategoriaservicios) {
		this.parprofsaludcategoriaservicios = parprofsaludcategoriaservicios;
	}

	public ParProfSaludCategoriaServicio addParprofsaludcategoriaservicio(ParProfSaludCategoriaServicio parprofsaludcategoriaservicio) {
		getParprofsaludcategoriaservicios().add(parprofsaludcategoriaservicio);
		parprofsaludcategoriaservicio.setProcategoriasservicio(this);

		return parprofsaludcategoriaservicio;
	}

	public ParProfSaludCategoriaServicio removeParprofsaludcategoriaservicio(ParProfSaludCategoriaServicio parprofsaludcategoriaservicio) {
		getParprofsaludcategoriaservicios().remove(parprofsaludcategoriaservicio);
		parprofsaludcategoriaservicio.setProcategoriasservicio(null);

		return parprofsaludcategoriaservicio;
	}

	public List<ProServicio> getProservicios() {
		return this.proservicios;
	}

	public void setProservicios(List<ProServicio> proservicios) {
		this.proservicios = proservicios;
	}

	public ProServicio addProservicio(ProServicio proservicio) {
		getProservicios().add(proservicio);
		proservicio.setProcategoriasservicio(this);

		return proservicio;
	}

	public ProServicio removeProservicio(ProServicio proservicio) {
		getProservicios().remove(proservicio);
		proservicio.setProcategoriasservicio(null);

		return proservicio;
	}

}