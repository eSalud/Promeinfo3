package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the promedicamentos database table.
 * 
 */
@Entity
@Table(name="promedicamentos")
@NamedQuery(name="ProMedicamento.findAll", query="SELECT p FROM ProMedicamento p")
public class ProMedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idmedicamento;

	private String administracion;

	private String codmedicamento;

	private BigDecimal dosificacion;

	private String estado;

	private String forma;

	private String indicaciones;

	private String nombregenerico;

	private BigDecimal precio;

	private Integer presentacion;

	//bi-directional many-to-one association to ProAdmMedicamento
	@OneToMany(mappedBy="promedicamento")
	private List<ProAdmMedicamento> proadmmedicamentos;

	//bi-directional many-to-one association to ProCategoriaMedicamento
	@ManyToOne
	@JoinColumn(name="idcatmedicamento")
	private ProCategoriaMedicamento procategoriasmedicamento;

	//bi-directional many-to-one association to ProMedicamentoSustituto
	@OneToMany(mappedBy="promedicamento1")
	private List<ProMedicamentoSustituto> promedicamentossustitutos1;

	//bi-directional many-to-one association to ProMedicamentoSustituto
	@OneToMany(mappedBy="promedicamento2")
	private List<ProMedicamentoSustituto> promedicamentossustitutos2;

	public ProMedicamento() {
	}

	public Long getIdmedicamento() {
		return this.idmedicamento;
	}

	public void setIdmedicamento(Long idmedicamento) {
		this.idmedicamento = idmedicamento;
	}

	public String getAdministracion() {
		return this.administracion;
	}

	public void setAdministracion(String administracion) {
		this.administracion = administracion;
	}

	public String getCodmedicamento() {
		return this.codmedicamento;
	}

	public void setCodmedicamento(String codmedicamento) {
		this.codmedicamento = codmedicamento;
	}

	public BigDecimal getDosificacion() {
		return this.dosificacion;
	}

	public void setDosificacion(BigDecimal dosificacion) {
		this.dosificacion = dosificacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getForma() {
		return this.forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public String getIndicaciones() {
		return this.indicaciones;
	}

	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}

	public String getNombregenerico() {
		return this.nombregenerico;
	}

	public void setNombregenerico(String nombregenerico) {
		this.nombregenerico = nombregenerico;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(Integer presentacion) {
		this.presentacion = presentacion;
	}

	public List<ProAdmMedicamento> getProadmmedicamentos() {
		return this.proadmmedicamentos;
	}

	public void setProadmmedicamentos(List<ProAdmMedicamento> proadmmedicamentos) {
		this.proadmmedicamentos = proadmmedicamentos;
	}

	public ProAdmMedicamento addProadmmedicamento(ProAdmMedicamento proadmmedicamento) {
		getProadmmedicamentos().add(proadmmedicamento);
		proadmmedicamento.setPromedicamento(this);

		return proadmmedicamento;
	}

	public ProAdmMedicamento removeProadmmedicamento(ProAdmMedicamento proadmmedicamento) {
		getProadmmedicamentos().remove(proadmmedicamento);
		proadmmedicamento.setPromedicamento(null);

		return proadmmedicamento;
	}

	public ProCategoriaMedicamento getProcategoriasmedicamento() {
		return this.procategoriasmedicamento;
	}

	public void setProcategoriasmedicamento(ProCategoriaMedicamento procategoriasmedicamento) {
		this.procategoriasmedicamento = procategoriasmedicamento;
	}

	public List<ProMedicamentoSustituto> getPromedicamentossustitutos1() {
		return this.promedicamentossustitutos1;
	}

	public void setPromedicamentossustitutos1(List<ProMedicamentoSustituto> promedicamentossustitutos1) {
		this.promedicamentossustitutos1 = promedicamentossustitutos1;
	}

	public ProMedicamentoSustituto addPromedicamentossustitutos1(ProMedicamentoSustituto promedicamentossustitutos1) {
		getPromedicamentossustitutos1().add(promedicamentossustitutos1);
		promedicamentossustitutos1.setPromedicamento1(this);

		return promedicamentossustitutos1;
	}

	public ProMedicamentoSustituto removePromedicamentossustitutos1(ProMedicamentoSustituto promedicamentossustitutos1) {
		getPromedicamentossustitutos1().remove(promedicamentossustitutos1);
		promedicamentossustitutos1.setPromedicamento1(null);

		return promedicamentossustitutos1;
	}

	public List<ProMedicamentoSustituto> getPromedicamentossustitutos2() {
		return this.promedicamentossustitutos2;
	}

	public void setPromedicamentossustitutos2(List<ProMedicamentoSustituto> promedicamentossustitutos2) {
		this.promedicamentossustitutos2 = promedicamentossustitutos2;
	}

	public ProMedicamentoSustituto addPromedicamentossustitutos2(ProMedicamentoSustituto promedicamentossustitutos2) {
		getPromedicamentossustitutos2().add(promedicamentossustitutos2);
		promedicamentossustitutos2.setPromedicamento2(this);

		return promedicamentossustitutos2;
	}

	public ProMedicamentoSustituto removePromedicamentossustitutos2(ProMedicamentoSustituto promedicamentossustitutos2) {
		getPromedicamentossustitutos2().remove(promedicamentossustitutos2);
		promedicamentossustitutos2.setPromedicamento2(null);

		return promedicamentossustitutos2;
	}

}