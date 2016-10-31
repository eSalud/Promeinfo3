package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the parpromotores database table.
 * 
 */
@Entity
@Table(name="parpromotores")
@NamedQuery(name="ParPromotor.findAll", query="SELECT p FROM ParPromotor p")
public class ParPromotor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpromotor;

	private String clave;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechaingreso;

	private String usuario;

	//bi-directional many-to-one association to AtmVisitaHCF
	@OneToMany(mappedBy="parpromotore")
	private List<AtmVisitaHCF> atmvisitashcfs;

	public ParPromotor() {
	}

	public Long getIdpromotor() {
		return this.idpromotor;
	}

	public void setIdpromotor(Long idpromotor) {
		this.idpromotor = idpromotor;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<AtmVisitaHCF> getAtmvisitashcfs() {
		return this.atmvisitashcfs;
	}

	public void setAtmvisitashcfs(List<AtmVisitaHCF> atmvisitashcfs) {
		this.atmvisitashcfs = atmvisitashcfs;
	}

	public AtmVisitaHCF addAtmvisitashcf(AtmVisitaHCF atmvisitashcf) {
		getAtmvisitashcfs().add(atmvisitashcf);
		atmvisitashcf.setParpromotore(this);

		return atmvisitashcf;
	}

	public AtmVisitaHCF removeAtmvisitashcf(AtmVisitaHCF atmvisitashcf) {
		getAtmvisitashcfs().remove(atmvisitashcf);
		atmvisitashcf.setParpromotore(null);

		return atmvisitashcf;
	}

}