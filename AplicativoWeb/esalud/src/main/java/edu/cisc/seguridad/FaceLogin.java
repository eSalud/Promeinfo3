package edu.cisc.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cisc.dto.Login;
import edu.cisc.modelo.AdmUsuario;
import edu.cisc.servicio.AdmUsuarioService;

@Service(value="loginService")
public class FaceLogin implements IFaceLogin {
	
	@Autowired (required=true)
	@Qualifier(value="serviceManager")
	AdmUsuarioService usuario;		
	
	public Login validarLogin(Login obj) throws Exception {
		AdmUsuario usuarioLogueado = usuario.iniciarSesion(obj.getUsername().toUpperCase());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (usuarioLogueado == null) {
        	obj.setStatus(false);
            obj.setMensaje("El Usuario no fue encontrado. . .");			
		} else{
			System.out.println("-- Usuario: " + usuarioLogueado.getUsuario());
			System.out.println("-- Password: " + usuarioLogueado.getClave());
			System.out.println("-- Rol: " + usuarioLogueado.getAdmrole().getNombre());
			System.out.println("-- idPersona: " + usuarioLogueado.getAdmpersonassistema().getIdpersona().toString());
			if (encoder.matches(obj.getPassword(), usuarioLogueado.getClave())) {
				if (usuarioLogueado.getEstado().equals("I")) {
		        	obj.setStatus(false);
		            obj.setMensaje("El Usuario se encuentra inactivo. . .");
		            System.out.println("-- El Usuario se encuentra inactivo. . .");
				} else {
		        	obj.setIdRol(usuarioLogueado.getAdmrole().getIdrol().toString());
		        	obj.setIdSexo(usuarioLogueado.getAdmpersonassistema().getPartipossexo().getIdtiposexo().toString());
		        	obj.setIdPersona(usuarioLogueado.getAdmpersonassistema().getIdpersona().toString());
		        	obj.setNameUser(usuarioLogueado.getAdmpersonassistema().getPrimernombre().toUpperCase() + " " + usuarioLogueado.getAdmpersonassistema().getApellidopaterno().toUpperCase());
		        	obj.setNameRol("(" + usuarioLogueado.getAdmrole().getNombre().toString().toUpperCase() + ")");
		        	obj.setStatus(true);
		            obj.setMensaje("Usuario encontrado. . .");		            
				}
			} else {
	        	obj.setStatus(false);
	            obj.setMensaje("La contraseña ingresada es incorrecta. . .");
	            System.out.println("-- La contraseña ingresada es incorrecta. . .");
			}
		}
        return obj;
    }

}
