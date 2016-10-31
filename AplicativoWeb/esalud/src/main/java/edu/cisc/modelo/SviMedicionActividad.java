package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the svimedicionesactividades database table.
 * 
 */
@Entity
@Table(name="svimedicionesactividades")
@NamedQuery(name="SviMedicionActividad.findAll", query="SELECT s FROM SviMedicionActividad s")
public class SviMedicionActividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idmedicionesact;

	@Column(name="actividad_fisica")
	private String actividadFisica;

	private String aseo;

	private String cambiosonda;

	private String dietaadministrada;

	private Integer numerocomidas;

	private Integer numerodeposiciones;

	private Integer numeromicciones;

	private BigDecimal peso;

	private String recanalizacionvia;

	private String responsable;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	public SviMedicionActividad() {
	}

	public Long getIdmedicionesact() {
		return this.idmedicionesact;
	}

	public void setIdmedicionesact(Long idmedicionesact) {
		this.idmedicionesact = idmedicionesact;
	}

	public String getActividadFisica() {
		return this.actividadFisica;
	}

	public void setActividadFisica(String actividadFisica) {
		this.actividadFisica = actividadFisica;
	}

	public String getAseo() {
		return this.aseo;
	}

	public void setAseo(String aseo) {
		this.aseo = aseo;
	}

	public String getCambiosonda() {
		return this.cambiosonda;
	}

	public void setCambiosonda(String cambiosonda) {
		this.cambiosonda = cambiosonda;
	}

	public String getDietaadministrada() {
		return this.dietaadministrada;
	}

	public void setDietaadministrada(String dietaadministrada) {
		this.dietaadministrada = dietaadministrada;
	}

	public Integer getNumerocomidas() {
		return this.numerocomidas;
	}

	public void setNumerocomidas(Integer numerocomidas) {
		this.numerocomidas = numerocomidas;
	}

	public Integer getNumerodeposiciones() {
		return this.numerodeposiciones;
	}

	public void setNumerodeposiciones(Integer numerodeposiciones) {
		this.numerodeposiciones = numerodeposiciones;
	}

	public Integer getNumeromicciones() {
		return this.numeromicciones;
	}

	public void setNumeromicciones(Integer numeromicciones) {
		this.numeromicciones = numeromicciones;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getRecanalizacionvia() {
		return this.recanalizacionvia;
	}

	public void setRecanalizacionvia(String recanalizacionvia) {
		this.recanalizacionvia = recanalizacionvia;
	}

	public String getResponsable() {
		return this.responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public ParPaciente getParpaciente() {
		return this.parpaciente;
	}

	public void setParpaciente(ParPaciente parpaciente) {
		this.parpaciente = parpaciente;
	}

}