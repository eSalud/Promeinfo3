package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atmdiagnosticosencpacientes database table.
 * 
 */
@Entity
@Table(name="atmdiagnosticosencpacientes")
@NamedQuery(name="AtmDiagnosticoEncPaciente.findAll", query="SELECT a FROM AtmDiagnosticoEncPaciente a")
public class AtmDiagnosticoEncPaciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddiagencpaciente;

	private String coddiagnostico;

	private String idinfoclinica;

	//bi-directional many-to-one association to AtmEncuentroPaciente
	@ManyToOne
	@JoinColumn(name="idencpaciente")
	private AtmEncuentroPaciente atmencuentrospaciente;

	//bi-directional many-to-one association to AtmTipoDiagnostico
	@ManyToOne
	@JoinColumn(name="idtipodiagnostico")
	private AtmTipoDiagnostico atmtiposdiagnostico;

	//bi-directional many-to-one association to LprProblema
	@OneToMany(mappedBy="atmdiagnosticosencpaciente")
	private List<LprProblema> lprproblemas;

	public AtmDiagnosticoEncPaciente() {
	}

	public Long getIddiagencpaciente() {
		return this.iddiagencpaciente;
	}

	public void setIddiagencpaciente(Long iddiagencpaciente) {
		this.iddiagencpaciente = iddiagencpaciente;
	}

	public String getCoddiagnostico() {
		return this.coddiagnostico;
	}

	public void setCoddiagnostico(String coddiagnostico) {
		this.coddiagnostico = coddiagnostico;
	}

	public String getIdinfoclinica() {
		return this.idinfoclinica;
	}

	public void setIdinfoclinica(String idinfoclinica) {
		this.idinfoclinica = idinfoclinica;
	}

	public AtmEncuentroPaciente getAtmencuentrospaciente() {
		return this.atmencuentrospaciente;
	}

	public void setAtmencuentrospaciente(AtmEncuentroPaciente atmencuentrospaciente) {
		this.atmencuentrospaciente = atmencuentrospaciente;
	}

	public AtmTipoDiagnostico getAtmtiposdiagnostico() {
		return this.atmtiposdiagnostico;
	}

	public void setAtmtiposdiagnostico(AtmTipoDiagnostico atmtiposdiagnostico) {
		this.atmtiposdiagnostico = atmtiposdiagnostico;
	}

	public List<LprProblema> getLprproblemas() {
		return this.lprproblemas;
	}

	public void setLprproblemas(List<LprProblema> lprproblemas) {
		this.lprproblemas = lprproblemas;
	}

	public LprProblema addLprproblema(LprProblema lprproblema) {
		getLprproblemas().add(lprproblema);
		lprproblema.setAtmdiagnosticosencpaciente(this);

		return lprproblema;
	}

	public LprProblema removeLprproblema(LprProblema lprproblema) {
		getLprproblemas().remove(lprproblema);
		lprproblema.setAtmdiagnosticosencpaciente(null);

		return lprproblema;
	}

}