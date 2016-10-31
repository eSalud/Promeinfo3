package edu.cisc.servicio;

import edu.cisc.modelo.AdmUsuario;

public interface AdmUsuarioService {
	
	public AdmUsuario iniciarSesion (String usuario) throws Exception;

}
