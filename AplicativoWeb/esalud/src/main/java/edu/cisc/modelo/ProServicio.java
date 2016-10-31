package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the proservicios database table.
 * 
 */
@Entity
@Table(name="proservicios")
@NamedQuery(name="ProServicio.findAll", query="SELECT p FROM ProServicio p")
public class ProServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idservicios;

	private Integer codservicio;

	private String estado;

	private Timestamp fechacreacion;

	private String nombre;

	//bi-directional many-to-one association to ProCategoriaServicio
	@ManyToOne
	@JoinColumn(name="idcatservicio")
	private ProCategoriaServicio procategoriasservicio;

	public ProServicio() {
	}

	public Long getIdservicios() {
		return this.idservicios;
	}

	public void setIdservicios(Long idservicios) {
		this.idservicios = idservicios;
	}

	public Integer getCodservicio() {
		return this.codservicio;
	}

	public void setCodservicio(Integer codservicio) {
		this.codservicio = codservicio;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ProCategoriaServicio getProcategoriasservicio() {
		return this.procategoriasservicio;
	}

	public void setProcategoriasservicio(ProCategoriaServicio procategoriasservicio) {
		this.procategoriasservicio = procategoriasservicio;
	}

}