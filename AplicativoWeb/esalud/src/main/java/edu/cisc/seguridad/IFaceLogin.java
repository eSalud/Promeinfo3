package edu.cisc.seguridad;

import edu.cisc.dto.Login;

public interface IFaceLogin {
	
	Login validarLogin(Login obj) throws Exception;
	
}
