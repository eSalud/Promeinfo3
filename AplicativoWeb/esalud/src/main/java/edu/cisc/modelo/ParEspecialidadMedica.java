package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parespecialidadesmedicas database table.
 * 
 */
@Entity
@Table(name="parespecialidadesmedicas")
@NamedQuery(name="ParEspecialidadMedica.findAll", query="SELECT p FROM ParEspecialidadMedica p")
public class ParEspecialidadMedica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idespecialidad;

	private String area;

	private String descripcion;

	private String estado;

	//bi-directional many-to-one association to ParProfesionalSalud
	@OneToMany(mappedBy="parespecialidadesmedica")
	private List<ParProfesionalSalud> parprofesionalsaluds;

	public ParEspecialidadMedica() {
	}

	public Long getIdespecialidad() {
		return this.idespecialidad;
	}

	public void setIdespecialidad(Long idespecialidad) {
		this.idespecialidad = idespecialidad;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public List<ParProfesionalSalud> getParprofesionalsaluds() {
		return this.parprofesionalsaluds;
	}

	public void setParprofesionalsaluds(List<ParProfesionalSalud> parprofesionalsaluds) {
		this.parprofesionalsaluds = parprofesionalsaluds;
	}

	public ParProfesionalSalud addParprofesionalsalud(ParProfesionalSalud parprofesionalsalud) {
		getParprofesionalsaluds().add(parprofesionalsalud);
		parprofesionalsalud.setParespecialidadesmedica(this);

		return parprofesionalsalud;
	}

	public ParProfesionalSalud removeParprofesionalsalud(ParProfesionalSalud parprofesionalsalud) {
		getParprofesionalsaluds().remove(parprofesionalsalud);
		parprofesionalsalud.setParespecialidadesmedica(null);

		return parprofesionalsalud;
	}

}