package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parhorarioslaborales database table.
 * 
 */
@Entity
@Table(name="parhorarioslaborales")
@NamedQuery(name="ParHorarioLaboral.findAll", query="SELECT p FROM ParHorarioLaboral p")
public class ParHorarioLaboral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idhorariolaboral;

	private String dia;

	private String horafin;

	private String horainicio;

	private Integer idempleado;

	private Integer idorganizacion;

	private Integer idprofsaludprochosp;

	private Integer idtipohorariolaboral;

	public ParHorarioLaboral() {
	}

	public Long getIdhorariolaboral() {
		return this.idhorariolaboral;
	}

	public void setIdhorariolaboral(Long idhorariolaboral) {
		this.idhorariolaboral = idhorariolaboral;
	}

	public String getDia() {
		return this.dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorafin() {
		return this.horafin;
	}

	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}

	public String getHorainicio() {
		return this.horainicio;
	}

	public void setHorainicio(String horainicio) {
		this.horainicio = horainicio;
	}

	public Integer getIdempleado() {
		return this.idempleado;
	}

	public void setIdempleado(Integer idempleado) {
		this.idempleado = idempleado;
	}

	public Integer getIdorganizacion() {
		return this.idorganizacion;
	}

	public void setIdorganizacion(Integer idorganizacion) {
		this.idorganizacion = idorganizacion;
	}

	public Integer getIdprofsaludprochosp() {
		return this.idprofsaludprochosp;
	}

	public void setIdprofsaludprochosp(Integer idprofsaludprochosp) {
		this.idprofsaludprochosp = idprofsaludprochosp;
	}

	public Integer getIdtipohorariolaboral() {
		return this.idtipohorariolaboral;
	}

	public void setIdtipohorariolaboral(Integer idtipohorariolaboral) {
		this.idtipohorariolaboral = idtipohorariolaboral;
	}

}