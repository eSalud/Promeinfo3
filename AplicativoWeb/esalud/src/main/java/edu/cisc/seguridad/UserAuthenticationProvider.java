package edu.cisc.seguridad;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import edu.cisc.controlador.SesionUsuario;
import edu.cisc.dto.Login;
import edu.cisc.dto.Usuario;

public class UserAuthenticationProvider implements AuthenticationProvider {

    Login user = new Login();
	
	@Autowired(required=true)
	@Qualifier(value="loginService")	
	IFaceLogin serviceLogin;
	
	@Autowired(required=true)
	@Qualifier(value="sesionUsuario")
	SesionUsuario sesionUsuario;
	
	public UserAuthenticationProvider () {
		super();
	}
	
    public IFaceLogin getServiceLogin() {
        return serviceLogin;
    }	
    
    public void setServiceLogin(IFaceLogin serviceLogin) {
        this.serviceLogin = serviceLogin;
    }    

	public boolean userExist(Login user) {
        try {
            user = getServiceLogin().validarLogin(user);
            if(user.getStatus()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userLogin = authentication.getPrincipal().toString();
        String passwordLogin = authentication.getCredentials().toString(); 
		Calendar calendar = Calendar.getInstance();
		Timestamp fechaRegistro = new java.sql.Timestamp(calendar.getTime().getTime());        
        user.setUsername(userLogin);
        user.setPassword(passwordLogin);
        WebAuthenticationDetails wad = (WebAuthenticationDetails) authentication.getDetails();
        System.out.println("-- Dirección IP: " + wad.getRemoteAddress());
        if(userExist(user)) {
        	//Datos de sesión del usuario
        	sesionUsuario.setUsuario(user.getUsername().toUpperCase());
        	sesionUsuario.setIdRol(user.getIdRol());
        	sesionUsuario.setFechaLogin(fechaRegistro);
        	sesionUsuario.setIdSexo(user.getIdSexo());
        	sesionUsuario.setNameRol(user.getNameRol());
        	sesionUsuario.setNameUser(user.getNameUser());
        	sesionUsuario.setIpRemota(wad.getRemoteAddress().toString());
        	sesionUsuario.setSesion(true);
        	sesionUsuario.setIdPersona(user.getIdPersona());
        	//Válida autenticación
            List<GrantedAuthority> autoridades = new ArrayList<GrantedAuthority>();
            autoridades.add(new SimpleGrantedAuthority(user.getNameRol().toUpperCase()));
            Usuario userDetails = new Usuario();
            userDetails.setUsername(userLogin);
            userDetails.setPassword(passwordLogin);
            Authentication customAuthentication = new UsernamePasswordAuthenticationToken(userDetails, passwordLogin, autoridades);
            return customAuthentication;
        } else {
            throw new BadCredentialsException("Usuario o Contraseña Inválidos.");
        }
	}

	@Override
	public boolean supports(Class<?> type) {
		return true;
	}

}
