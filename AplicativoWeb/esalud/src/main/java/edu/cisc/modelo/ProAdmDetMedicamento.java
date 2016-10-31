package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the proadmdetmedicamentos database table.
 * 
 */
@Entity
@Table(name="proadmdetmedicamentos")
@NamedQuery(name="ProAdmDetMedicamento.findAll", query="SELECT p FROM ProAdmDetMedicamento p")
public class ProAdmDetMedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddetadminmedic;

	@Temporal(TemporalType.DATE)
	private Date fechaprescripcion;

	private String funcion;

	private String horaprescripcion;

	private String responsable;

	//bi-directional many-to-one association to ProAdmMedicamento
	@ManyToOne
	@JoinColumn(name="idadminmedic")
	private ProAdmMedicamento proadmmedicamento;

	public ProAdmDetMedicamento() {
	}

	public Long getIddetadminmedic() {
		return this.iddetadminmedic;
	}

	public void setIddetadminmedic(Long iddetadminmedic) {
		this.iddetadminmedic = iddetadminmedic;
	}

	public Date getFechaprescripcion() {
		return this.fechaprescripcion;
	}

	public void setFechaprescripcion(Date fechaprescripcion) {
		this.fechaprescripcion = fechaprescripcion;
	}

	public String getFuncion() {
		return this.funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getHoraprescripcion() {
		return this.horaprescripcion;
	}

	public void setHoraprescripcion(String horaprescripcion) {
		this.horaprescripcion = horaprescripcion;
	}

	public String getResponsable() {
		return this.responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public ProAdmMedicamento getProadmmedicamento() {
		return this.proadmmedicamento;
	}

	public void setProadmmedicamento(ProAdmMedicamento proadmmedicamento) {
		this.proadmmedicamento = proadmmedicamento;
	}

}