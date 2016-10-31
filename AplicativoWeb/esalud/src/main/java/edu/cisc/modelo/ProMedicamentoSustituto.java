package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the promedicamentossustitutos database table.
 * 
 */
@Entity
@Table(name="promedicamentossustitutos")
@NamedQuery(name="ProMedicamentoSustituto.findAll", query="SELECT p FROM ProMedicamentoSustituto p")
public class ProMedicamentoSustituto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idmedicamentosust;

	//bi-directional many-to-one association to ProMedicamento
	@ManyToOne
	@JoinColumn(name="idmedicamento1")
	private ProMedicamento promedicamento1;

	//bi-directional many-to-one association to ProMedicamento
	@ManyToOne
	@JoinColumn(name="idmedicamento2")
	private ProMedicamento promedicamento2;

	public ProMedicamentoSustituto() {
	}

	public Long getIdmedicamentosust() {
		return this.idmedicamentosust;
	}

	public void setIdmedicamentosust(Long idmedicamentosust) {
		this.idmedicamentosust = idmedicamentosust;
	}

	public ProMedicamento getPromedicamento1() {
		return this.promedicamento1;
	}

	public void setPromedicamento1(ProMedicamento promedicamento1) {
		this.promedicamento1 = promedicamento1;
	}

	public ProMedicamento getPromedicamento2() {
		return this.promedicamento2;
	}

	public void setPromedicamento2(ProMedicamento promedicamento2) {
		this.promedicamento2 = promedicamento2;
	}

}