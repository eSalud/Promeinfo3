package edu.cisc.servicio;

import java.util.Date;
import java.util.List;

import edu.cisc.modelo.AdmHistorialConexion;
import edu.cisc.modelo.AdmUsuario;

public interface HistorialConexionService {
	
	List<AdmHistorialConexion> obtieneHistorial (String pUsuario, Date pFechaIni, Date pFechaFin);
	
	List<AdmUsuario> obtieneUsuarios ();
	
	public AdmHistorialConexion obtenerSesion (String pUsuario, Date pFecha);
	
	void registraHistorial (AdmHistorialConexion pHistorial) throws Exception;
	
	void actualizarHistorial (AdmHistorialConexion pHistorial) throws Exception;

}
