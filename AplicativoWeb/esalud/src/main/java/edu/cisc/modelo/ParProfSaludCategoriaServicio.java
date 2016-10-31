package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parprofsaludcategoriaservicios database table.
 * 
 */
@Entity
@Table(name="parprofsaludcategoriaservicios")
@NamedQuery(name="ParProfSaludCategoriaServicio.findAll", query="SELECT p FROM ParProfSaludCategoriaServicio p")
public class ParProfSaludCategoriaServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String fechadesde;

	private String fechahasta;

	private Integer idactividad;

	private Integer idestado;

	//bi-directional many-to-one association to ParProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idprofesionalsalud")
	private ParProfesionalSalud parprofesionalsalud;

	//bi-directional many-to-one association to ProCategoriaServicio
	@ManyToOne
	@JoinColumn(name="idcategoriaservicio")
	private ProCategoriaServicio procategoriasservicio;

	public ParProfSaludCategoriaServicio() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFechadesde() {
		return this.fechadesde;
	}

	public void setFechadesde(String fechadesde) {
		this.fechadesde = fechadesde;
	}

	public String getFechahasta() {
		return this.fechahasta;
	}

	public void setFechahasta(String fechahasta) {
		this.fechahasta = fechahasta;
	}

	public Integer getIdactividad() {
		return this.idactividad;
	}

	public void setIdactividad(Integer idactividad) {
		this.idactividad = idactividad;
	}

	public Integer getIdestado() {
		return this.idestado;
	}

	public void setIdestado(Integer idestado) {
		this.idestado = idestado;
	}

	public ParProfesionalSalud getParprofesionalsalud() {
		return this.parprofesionalsalud;
	}

	public void setParprofesionalsalud(ParProfesionalSalud parprofesionalsalud) {
		this.parprofesionalsalud = parprofesionalsalud;
	}

	public ProCategoriaServicio getProcategoriasservicio() {
		return this.procategoriasservicio;
	}

	public void setProcategoriasservicio(ProCategoriaServicio procategoriasservicio) {
		this.procategoriasservicio = procategoriasservicio;
	}

}