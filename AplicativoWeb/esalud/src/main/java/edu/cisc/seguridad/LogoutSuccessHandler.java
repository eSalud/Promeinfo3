package edu.cisc.seguridad;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import edu.cisc.controlador.GestionHistorial;
import edu.cisc.controlador.GestionUsuario;
import edu.cisc.controlador.SesionUsuario;
import edu.cisc.modelo.AdmHistorialConexion;
import edu.cisc.servicio.HistorialConexionService;

public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
	
	@Autowired
	private SesionUsuario sesion;
	
	@Autowired
	private HistorialConexionService histConexion;
	
	@Autowired
	private GestionHistorial gestionHistorial;
	
	@Autowired
    private GestionUsuario gestionUsario;
	
    public LogoutSuccessHandler (String defaultTargetURL) {
    	this.setDefaultTargetUrl(defaultTargetURL);
    }

    public void onLogoutSuccess (HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    	try {
    		Calendar calendar = Calendar.getInstance();
    		Timestamp fechaLogout = new java.sql.Timestamp(calendar.getTime().getTime());  
        	AdmHistorialConexion histCon = histConexion.obtenerSesion(sesion.getUsuario(), sesion.getFechaLogin());
        	histCon.setFechafin(fechaLogout);
			histConexion.actualizarHistorial(histCon);
			gestionUsario.limpiarPantalla();
			gestionHistorial.limpiarPantalla();
			System.out.println("-- El usuario " + sesion.getUsuario() + " ha cerrado su sesión");
		} catch (Exception e) {
			System.out.println("-- Error al actualizar el registro de cierre de sesión del usuario " + sesion.getUsuario());
			e.printStackTrace();
		}
        super.onLogoutSuccess(request, response, authentication);
   } 

}
