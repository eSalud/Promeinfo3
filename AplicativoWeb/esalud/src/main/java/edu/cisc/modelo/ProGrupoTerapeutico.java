package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the progruposterapeuticos database table.
 * 
 */
@Entity
@Table(name="progruposterapeuticos")
@NamedQuery(name="ProGrupoTerapeutico.findAll", query="SELECT p FROM ProGrupoTerapeutico p")
public class ProGrupoTerapeutico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idgrupoterap;

	private String codgrupoterap;

	private Integer idgrupoteraphasta;

	private String nombre;

	public ProGrupoTerapeutico() {
	}

	public Long getIdgrupoterap() {
		return this.idgrupoterap;
	}

	public void setIdgrupoterap(Long idgrupoterap) {
		this.idgrupoterap = idgrupoterap;
	}

	public String getCodgrupoterap() {
		return this.codgrupoterap;
	}

	public void setCodgrupoterap(String codgrupoterap) {
		this.codgrupoterap = codgrupoterap;
	}

	public Integer getIdgrupoteraphasta() {
		return this.idgrupoteraphasta;
	}

	public void setIdgrupoteraphasta(Integer idgrupoteraphasta) {
		this.idgrupoteraphasta = idgrupoteraphasta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}