package edu.cisc.controlador;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.cisc.dto.AdmMenuDTO;
import edu.cisc.modelo.AdmHistorialConexion;
import edu.cisc.servicio.AdmMenuService;
import edu.cisc.servicio.HistorialConexionService;

@Component(value="Menu")
@Scope("session")
public class MenuPrincipal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private MenuModel lModeloMenu;
	List<AdmMenuDTO> menu = new ArrayList<AdmMenuDTO>();
	private String nombre;
	private String nameRol;
	private String idSexo;
	private String user;
	private StreamedContent myImage;
	private AdmHistorialConexion historial;

	@Autowired
	private SesionUsuario sesion;
	
	@Autowired
	private HistorialConexionService histConexion;
	
	@Autowired(required=true)
	@Qualifier(value="serviceMenu")
	private AdmMenuService menuService;	
	
	@PostConstruct
	public void inicializar() {
		
		if (sesion.getSesion()) {
			try {
				
				historial = new AdmHistorialConexion();
				
				historial.setUsuario(sesion.getUsuario());
				historial.setNombre(sesion.getNameUser());
				historial.setIp(sesion.getIpRemota());
				historial.setFechaini((Timestamp) sesion.getFechaLogin());
				System.out.println("-- Fecha Login: " + ((Timestamp) sesion.getFechaLogin()).toString());
				histConexion.registraHistorial(historial);
				sesion.setSesion(false);
				System.out.println("-- Historial de acceso al sistema guardado con éxito");
			} catch (Exception e) {
				System.out.println("-- ERROR: " + e.getMessage().toString());
			}			
		}
				
		lModeloMenu = new DefaultMenuModel();

		try {
			
			//Construye menú dinámico
		    
			nombre = sesion.getNameUser();
			nameRol = sesion.getNameRol();
			idSexo = sesion.getIdSexo();
			user = sesion.getUsuario();
			
			menu = menuService.getMenuUsuario(sesion.getIdRol());

			for (AdmMenuDTO m : menu) {
			   
			   if (m.getNivel() == 1) {
				   DefaultSubMenu fisrtSubMenu = new DefaultSubMenu(m.getNombre());				   				   					
				   for (AdmMenuDTO s : menu) {
					   if (s.getNivel() == 2 && s.getIdmenupadre() == m.getIdmenu()) {
						   DefaultMenuItem item = new DefaultMenuItem();
						   item.setValue(s.getNombre());
						   item.setUrl(s.getUrldestino());
						   item.setIcon(s.getIcono());	
						   fisrtSubMenu.addElement(item);
					   }
				   }
				   lModeloMenu.addElement(fisrtSubMenu);
			   }			   	   
			}	
			
		} catch (Exception e) {
			System.out.println("ERROR" + e.getMessage().toString());
		}
		
	}
	
	public MenuModel getlModeloMenu() {
		return lModeloMenu;
	}

	public void setlModeloMenu(MenuModel lModeloMenu) {
		this.lModeloMenu = lModeloMenu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getnameRol() {
		return nameRol;
	}

	public void setnameRol(String nameRol) {
		this.nameRol = nameRol;
	}

	public String getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(String idSexo) {
		this.idSexo = idSexo;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}	
	
	public void setMyImage(StreamedContent myImage) {
		this.myImage = myImage;
	}

	public StreamedContent getMyImage() throws IOException {
		
		FacesContext context = FacesContext.getCurrentInstance();
		String pathUser;
		
		try {
			if (idSexo.equals("1")) 
				pathUser = "/images/user-male.png";
			else if (idSexo.equals("2"))
				pathUser = "/images/user-female.png";
			else
				pathUser = null;
	 
			if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
				myImage = new DefaultStreamedContent();
			} else {
	 
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				BufferedImage img = ImageIO.read(context.getExternalContext().getResourceAsStream(pathUser));
				int w = img.getWidth(null);
				int h = img.getHeight(null);
	 
				int scale = 2;
	 
				BufferedImage bi = new BufferedImage(w * scale, h * scale, BufferedImage.TYPE_INT_ARGB);
				Graphics g = bi.getGraphics();
	 
				g.drawImage(img, 10, 10, w * scale, h * scale, null);
	 
				ImageIO.write(bi, "png", bos);
	 
				myImage = new DefaultStreamedContent(new ByteArrayInputStream(bos.toByteArray()), "image/png");
	 
			}			
		} catch (Exception e) {
			System.out.println("-- Error cargando imagen, el path es nulo");
		}
		return myImage;
	}

	public void presentarMensaje(String severity, String title, String aplicacion) {
        FacesContext context = FacesContext.getCurrentInstance();
        if(severity.equals("I"))
        	context.addMessage("somekey", new FacesMessage(FacesMessage.SEVERITY_INFO,title, aplicacion));
        if(severity.equals("W"))
        	context.addMessage("somekey", new FacesMessage(FacesMessage.SEVERITY_WARN,title, aplicacion));
        if(severity.equals("E"))
        	context.addMessage("somekey", new FacesMessage(FacesMessage.SEVERITY_ERROR,title, aplicacion));
        if(severity.equals("F"))
        	context.addMessage("somekey", new FacesMessage(FacesMessage.SEVERITY_FATAL,title, aplicacion));
    }		
	
	public void logout() {
	    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	    session.invalidate();
	    System.out.println("-- Sesión terminada");
	}

	public AdmHistorialConexion getHistorial() {
		return historial;
	}

	public void setHistorial(AdmHistorialConexion historial) {
		this.historial = historial;
	}	

}
