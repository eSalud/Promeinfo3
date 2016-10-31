package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ododiagnosticos database table.
 * 
 */
@Entity
@Table(name="ododiagnosticos")
@NamedQuery(name="OdoDiagnostico.findAll", query="SELECT o FROM OdoDiagnostico o")
public class OdoDiagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddiagnostico;

	private Integer cie;

	private String definitivo;

	private String descripcion;

	private String estado;

	private String presuntivo;

	private String tipodiagnostico;

	//bi-directional many-to-one association to OdoRegistroOdontologico
	@ManyToOne
	@JoinColumn(name="idregistro")
	private OdoRegistroOdontologico odoregistroodontologico;

	public OdoDiagnostico() {
	}

	public Long getIddiagnostico() {
		return this.iddiagnostico;
	}

	public void setIddiagnostico(Long iddiagnostico) {
		this.iddiagnostico = iddiagnostico;
	}

	public Integer getCie() {
		return this.cie;
	}

	public void setCie(Integer cie) {
		this.cie = cie;
	}

	public String getDefinitivo() {
		return this.definitivo;
	}

	public void setDefinitivo(String definitivo) {
		this.definitivo = definitivo;
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

	public String getPresuntivo() {
		return this.presuntivo;
	}

	public void setPresuntivo(String presuntivo) {
		this.presuntivo = presuntivo;
	}

	public String getTipodiagnostico() {
		return this.tipodiagnostico;
	}

	public void setTipodiagnostico(String tipodiagnostico) {
		this.tipodiagnostico = tipodiagnostico;
	}

	public OdoRegistroOdontologico getOdoregistroodontologico() {
		return this.odoregistroodontologico;
	}

	public void setOdoregistroodontologico(OdoRegistroOdontologico odoregistroodontologico) {
		this.odoregistroodontologico = odoregistroodontologico;
	}

}