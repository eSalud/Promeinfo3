package edu.cisc.servicio;

import java.util.List;

import edu.cisc.modelo.AdmAplicacion;
import edu.cisc.modelo.AdmModulo;

public interface GestionModuloService {
	
	void actualizarModulo (AdmModulo modulo) throws Exception;
	
	void ingresarModulo (AdmModulo modulo) throws Exception;
	
	List<AdmModulo> listarModulos () throws Exception;
	
	AdmModulo getModulo (String modulo) throws Exception;
	
	AdmAplicacion getAplicacion (String pIdAplicacion) throws Exception;

}
