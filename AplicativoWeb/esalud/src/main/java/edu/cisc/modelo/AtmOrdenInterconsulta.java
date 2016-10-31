package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atmordeninterconsulta database table.
 * 
 */
@Entity
@NamedQuery(name="AtmOrdenInterconsulta.findAll", query="SELECT a FROM AtmOrdenInterconsulta a")
public class AtmOrdenInterconsulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idordeninterc;

	private String fecha;

	private String hora;

	private Integer idencpaciente;

	//bi-directional many-to-one association to ParPaciente
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private ParPaciente parpaciente;

	public AtmOrdenInterconsulta() {
	}

	public Long getIdordeninterc() {
		return this.idordeninterc;
	}

	public void setIdordeninterc(Long idordeninterc) {
		this.idordeninterc = idordeninterc;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Integer getIdencpaciente() {
		return this.idencpaciente;
	}

	public void setIdencpaciente(Integer idencpaciente) {
		this.idencpaciente = idencpaciente;
	}

	public ParPaciente getParpaciente() {
		return this.parpaciente;
	}

	public void setParpaciente(ParPaciente parpaciente) {
		this.parpaciente = parpaciente;
	}

}