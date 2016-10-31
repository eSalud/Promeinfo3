package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the proadmmedicamentos database table.
 * 
 */
@Entity
@Table(name="proadmmedicamentos")
@NamedQuery(name="ProAdmMedicamento.findAll", query="SELECT p FROM ProAdmMedicamento p")
public class ProAdmMedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idadminmedic;

	private BigDecimal dosisunitaria;

	private String estado;

	private Integer frecuencia;

	//bi-directional many-to-one association to ProAdmDetMedicamento
	@OneToMany(mappedBy="proadmmedicamento")
	private List<ProAdmDetMedicamento> proadmdetmedicamentos;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	//bi-directional many-to-one association to ParProfesionalSalud
	@ManyToOne
	@JoinColumn(name="idprofsalud")
	private ParProfesionalSalud parprofesionalsalud;

	//bi-directional many-to-one association to ProMedicamento
	@ManyToOne
	@JoinColumn(name="idmedicamento")
	private ProMedicamento promedicamento;

	public ProAdmMedicamento() {
	}

	public Long getIdadminmedic() {
		return this.idadminmedic;
	}

	public void setIdadminmedic(Long idadminmedic) {
		this.idadminmedic = idadminmedic;
	}

	public BigDecimal getDosisunitaria() {
		return this.dosisunitaria;
	}

	public void setDosisunitaria(BigDecimal dosisunitaria) {
		this.dosisunitaria = dosisunitaria;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getFrecuencia() {
		return this.frecuencia;
	}

	public void setFrecuencia(Integer frecuencia) {
		this.frecuencia = frecuencia;
	}

	public List<ProAdmDetMedicamento> getProadmdetmedicamentos() {
		return this.proadmdetmedicamentos;
	}

	public void setProadmdetmedicamentos(List<ProAdmDetMedicamento> proadmdetmedicamentos) {
		this.proadmdetmedicamentos = proadmdetmedicamentos;
	}

	public ProAdmDetMedicamento addProadmdetmedicamento(ProAdmDetMedicamento proadmdetmedicamento) {
		getProadmdetmedicamentos().add(proadmdetmedicamento);
		proadmdetmedicamento.setProadmmedicamento(this);

		return proadmdetmedicamento;
	}

	public ProAdmDetMedicamento removeProadmdetmedicamento(ProAdmDetMedicamento proadmdetmedicamento) {
		getProadmdetmedicamentos().remove(proadmdetmedicamento);
		proadmdetmedicamento.setProadmmedicamento(null);

		return proadmdetmedicamento;
	}

	public ParPaciente getParpaciente() {
		return this.parpaciente;
	}

	public void setParpaciente(ParPaciente parpaciente) {
		this.parpaciente = parpaciente;
	}

	public ParProfesionalSalud getParprofesionalsalud() {
		return this.parprofesionalsalud;
	}

	public void setParprofesionalsalud(ParProfesionalSalud parprofesionalsalud) {
		this.parprofesionalsalud = parprofesionalsalud;
	}

	public ProMedicamento getPromedicamento() {
		return this.promedicamento;
	}

	public void setPromedicamento(ProMedicamento promedicamento) {
		this.promedicamento = promedicamento;
	}

}