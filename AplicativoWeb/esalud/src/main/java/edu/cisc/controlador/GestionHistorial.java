package edu.cisc.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.cisc.modelo.AdmHistorialConexion;
import edu.cisc.modelo.AdmUsuario;
import edu.cisc.servicio.HistorialConexionService;

@Component(value="consultaHistorial")
@ViewScoped
public class GestionHistorial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<AdmHistorialConexion> listaHistorial;
	public List<AdmUsuario> lListaUsuarios;
	public Date varFechaIni;
	public Date varFechaFin;
	public String varUsuario;
	
	@Autowired
	private HistorialConexionService viewHistorial;
	
	@PostConstruct
	public void inicializar () {
		listaHistorial = new ArrayList<AdmHistorialConexion>();
		lListaUsuarios = new ArrayList<AdmUsuario>();
		lListaUsuarios = viewHistorial.obtieneUsuarios();
		varFechaIni = null;
		varFechaFin = null;
		varUsuario = "";
	}

	public List<AdmHistorialConexion> getListaHistorial() {
		return listaHistorial;
	}

	public void setListaHistorial(List<AdmHistorialConexion> listaHistorial) {
		this.listaHistorial = listaHistorial;
	}
	
	public String getVarUsuario() {
		return varUsuario;
	}

	public void setVarUsuario(String varUsuario) {
		this.varUsuario = varUsuario;
	}

	public Date getVarFechaIni() {
		return varFechaIni;
	}

	public void setVarFechaIni(Date varFechaIni) {
		this.varFechaIni = varFechaIni;
	}

	public Date getVarFechaFin() {
		return varFechaFin;
	}

	public void setVarFechaFin(Date varFechaFin) {
		this.varFechaFin = varFechaFin;
	}
	
	public List<AdmUsuario> getlListaUsuarios() {
		return lListaUsuarios;
	}

	public void setlListaUsuarios(List<AdmUsuario> lListaUsuarios) {
		this.lListaUsuarios = lListaUsuarios;
	}

	public void buscarHistorial (ActionEvent actionEvent) {
		FacesContext lContexto= FacesContext.getCurrentInstance();
		try {
			if (varUsuario == null || varUsuario.equals("")) {
				lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Advertencia","Ingrese un usuario para realizar la búsqueda"));
			} else {
				if (varFechaIni == null || varFechaFin == null) {
					lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Advertencia","Ingrese un rango de fecha para realizar la búsqueda"));
				} else {
					listaHistorial = new ArrayList<AdmHistorialConexion>();
					listaHistorial = viewHistorial.obtieneHistorial(varUsuario, varFechaIni, sumarFecha(varFechaFin,1));
					System.out.println("-- Búsqueda historial de conexión usuario " + varUsuario);		
					lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Información","Búsqueda procesada"));
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		    lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error inesperado realizando la búsqueda"));
		}
		
	}
	
	public Date sumarFecha (Date fecha, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		return calendar.getTime();
	}
	
	public void limpiarPantalla () {
		listaHistorial = null;
		varFechaIni = null;
		varFechaFin = null;
		varUsuario = "";
	}

}
