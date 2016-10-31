package edu.cisc.servicio;

import edu.cisc.modelo.AdmRol;

public interface GestionRolService {
	
	void actualizarRol (AdmRol rol) throws Exception;
	
	void ingresarRol (AdmRol rol) throws Exception;
	
	AdmRol getRol (String rol) throws Exception;

}
