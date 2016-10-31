package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the procategoriasmedicamentos database table.
 * 
 */
@Entity
@Table(name="procategoriasmedicamentos")
@NamedQuery(name="ProCategoriaMedicamento.findAll", query="SELECT p FROM ProCategoriaMedicamento p")
public class ProCategoriaMedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcatmedicamento;

	private String codcatmedicamento;

	private Integer idcatmedicmrec;

	private Integer idtipogrupo;

	private String nombre;

	//bi-directional many-to-one association to ProMedicamento
	@OneToMany(mappedBy="procategoriasmedicamento")
	private List<ProMedicamento> promedicamentos;

	public ProCategoriaMedicamento() {
	}

	public Long getIdcatmedicamento() {
		return this.idcatmedicamento;
	}

	public void setIdcatmedicamento(Long idcatmedicamento) {
		this.idcatmedicamento = idcatmedicamento;
	}

	public String getCodcatmedicamento() {
		return this.codcatmedicamento;
	}

	public void setCodcatmedicamento(String codcatmedicamento) {
		this.codcatmedicamento = codcatmedicamento;
	}

	public Integer getIdcatmedicmrec() {
		return this.idcatmedicmrec;
	}

	public void setIdcatmedicmrec(Integer idcatmedicmrec) {
		this.idcatmedicmrec = idcatmedicmrec;
	}

	public Integer getIdtipogrupo() {
		return this.idtipogrupo;
	}

	public void setIdtipogrupo(Integer idtipogrupo) {
		this.idtipogrupo = idtipogrupo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ProMedicamento> getPromedicamentos() {
		return this.promedicamentos;
	}

	public void setPromedicamentos(List<ProMedicamento> promedicamentos) {
		this.promedicamentos = promedicamentos;
	}

	public ProMedicamento addPromedicamento(ProMedicamento promedicamento) {
		getPromedicamentos().add(promedicamento);
		promedicamento.setProcategoriasmedicamento(this);

		return promedicamento;
	}

	public ProMedicamento removePromedicamento(ProMedicamento promedicamento) {
		getPromedicamentos().remove(promedicamento);
		promedicamento.setProcategoriasmedicamento(null);

		return promedicamento;
	}

}