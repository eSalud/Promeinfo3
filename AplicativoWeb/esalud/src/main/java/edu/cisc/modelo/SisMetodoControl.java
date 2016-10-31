package edu.cisc.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sismetodoscontroles database table.
 * 
 */
@Entity
@Table(name="sismetodoscontroles")
@NamedQuery(name="SisMetodoControl.findAll", query="SELECT s FROM SisMetodoControl s")
public class SisMetodoControl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idmetodocontrol;

	private String evento;

	private String metodo;

	public SisMetodoControl() {
	}

	public Long getIdmetodocontrol() {
		return this.idmetodocontrol;
	}

	public void setIdmetodocontrol(Long idmetodocontrol) {
		this.idmetodocontrol = idmetodocontrol;
	}

	public String getEvento() {
		return this.evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getMetodo() {
		return this.metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

}