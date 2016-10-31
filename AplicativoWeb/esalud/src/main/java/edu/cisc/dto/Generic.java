package edu.cisc.dto;

import java.io.Serializable;

public class Generic implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 private Boolean status;
	 private String mensaje;
	 
	 public Generic () {	 
	 }
	 
	 public Boolean getStatus() {
		return status;
	 }
	 public void setStatus(Boolean status) {
		this.status = status;
	 }
	 public String getMensaje() {
		return mensaje;
	 }
	 public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	 }

}
