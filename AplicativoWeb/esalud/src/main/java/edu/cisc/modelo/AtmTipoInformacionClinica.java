package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atmtiposinformacionclinica database table.
 * 
 */
@Entity
@Table(name="atmtiposinformacionclinica")
@NamedQuery(name="AtmTipoInformacionClinica.findAll", query="SELECT a FROM AtmTipoInformacionClinica a")
public class AtmTipoInformacionClinica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idtipoinfoclinica;

	private String descripcion;

	//bi-directional many-to-one association to AtmInformacionClinica
	@OneToMany(mappedBy="atmtiposinformacionclinica")
	private List<AtmInformacionClinica> atminformacionesclinicas;

	public AtmTipoInformacionClinica() {
	}

	public Long getIdtipoinfoclinica() {
		return this.idtipoinfoclinica;
	}

	public void setIdtipoinfoclinica(Long idtipoinfoclinica) {
		this.idtipoinfoclinica = idtipoinfoclinica;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<AtmInformacionClinica> getAtminformacionesclinicas() {
		return this.atminformacionesclinicas;
	}

	public void setAtminformacionesclinicas(List<AtmInformacionClinica> atminformacionesclinicas) {
		this.atminformacionesclinicas = atminformacionesclinicas;
	}

	public AtmInformacionClinica addAtminformacionesclinica(AtmInformacionClinica atminformacionesclinica) {
		getAtminformacionesclinicas().add(atminformacionesclinica);
		atminformacionesclinica.setAtmtiposinformacionclinica(this);

		return atminformacionesclinica;
	}

	public AtmInformacionClinica removeAtminformacionesclinica(AtmInformacionClinica atminformacionesclinica) {
		getAtminformacionesclinicas().remove(atminformacionesclinica);
		atminformacionesclinica.setAtmtiposinformacionclinica(null);

		return atminformacionesclinica;
	}

}