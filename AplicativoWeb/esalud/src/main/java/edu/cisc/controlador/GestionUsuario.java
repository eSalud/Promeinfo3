package edu.cisc.controlador;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseId;
import javax.imageio.ImageIO;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import edu.cisc.modelo.AdmPersonaSistema;
import edu.cisc.modelo.AdmRol;
import edu.cisc.modelo.AdmUsuario;
import edu.cisc.servicio.GestionUsuarioService;

@Component(value="gestionUsuario")
@ViewScoped
public class GestionUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<AdmRol> lRol;
	private HashMap<String, AdmRol> hashMapRol;
	private AdmRol rol;
	private AdmPersonaSistema persona;
	private AdmUsuario usuario;
	private String varUsuarioFind;
	private String varClaveNew;
	private String varClaveTmp;
	private String varIdentificacion;
	private String varTelefono;
	private String varEmail;
	private String varNombreCompleto;
	private String varEstado;
	private Boolean varValidaBusqueda;
	private StreamedContent estadoImage;
	private String varBotonEstado;
	private	Date varFechaRegistro;
	
	@Autowired
	private GestionUsuarioService usuarioService;
	
	@Autowired(required=true)
	@Qualifier(value="sesionUsuario")
	private SesionUsuario sesionUsuario;
	
	@PostConstruct
	public void inicializar () {
		
		lRol = new ArrayList<AdmRol>();
		
		//Inicialización variables 
		varUsuarioFind = "";
		varClaveNew = "";
		varIdentificacion = "";
		varNombreCompleto = "";
		varTelefono = "";
		varEmail = "";
		varEstado = "";
		varValidaBusqueda = false;
		estadoImage = null;
		varBotonEstado = "Cambiar estado";
		varFechaRegistro = null;
		
		//Instanciación de los objetos en donde se guarda la información del formulario
		persona = new AdmPersonaSistema();
		usuario = new AdmUsuario();

	}

	public List<AdmRol> getlRol() {
		return lRol;
	}

	public void setlRol(List<AdmRol> lRol) {
		this.lRol = lRol;
	}

	public HashMap<String, AdmRol> getHashMapRol() {
		return hashMapRol;
	}

	public void setHashMapRol(HashMap<String, AdmRol> hashMapRol) {
		this.hashMapRol = hashMapRol;
	}

	public AdmRol getRol() {
		return rol;
	}

	public void setRol(AdmRol rol) {
		this.rol = rol;
	}

	public AdmPersonaSistema getPersona() {
		return persona;
	}

	public void setPersona(AdmPersonaSistema persona) {
		this.persona = persona;
	}

	public AdmUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(AdmUsuario usuario) {
		this.usuario = usuario;
	}	
	
	public String getVarNombreCompleto() {
		return varNombreCompleto;
	}

	public void setVarNombreCompleto(String varNombreCompleto) {
		this.varNombreCompleto = varNombreCompleto;
	}

	public String getVarIdentificacion() {
		return varIdentificacion;
	}

	public void setVarIdentificacion(String varIdentificacion) {
		this.varIdentificacion = varIdentificacion;
	}

	public String getVarTelefono() {
		return varTelefono;
	}

	public void setVarTelefono(String varTelefono) {
		this.varTelefono = varTelefono;
	}

	public String getVarEmail() {
		return varEmail;
	}

	public void setVarEmail(String varEmail) {
		this.varEmail = varEmail;
	}
	
	public String getVarUsuarioFind() {
		return varUsuarioFind;
	}

	public void setVarUsuarioFind(String varUsuarioFind) {
		this.varUsuarioFind = varUsuarioFind;
	}

	public String getVarClaveNew() {
		return varClaveNew;
	}

	public void setVarClaveNew(String varClaveNew) {
		this.varClaveNew = varClaveNew;
	}

	public String getVarEstado() {
		return varEstado;
	}

	public void setVarEstado(String varEstado) {
		this.varEstado = varEstado;
	}

	public String getVarBotonEstado() {
		return varBotonEstado;
	}

	public void setVarBotonEstado(String varBotonEstado) {
		this.varBotonEstado = varBotonEstado;
	}

	public Date getVarFechaRegistro() {
		return varFechaRegistro;
	}

	public void setVarFechaRegistro(Date varFechaRegistro) {
		this.varFechaRegistro = varFechaRegistro;
	}

	public List<AdmRol> ordenarLista (List<AdmRol> lista, String rolActual) {
		//Ordena lista Rol para poner en primera posición el rol actual del usuario
		List<AdmRol> listaRol = new ArrayList<AdmRol>();
		for (AdmRol x : lista) {
			if (x.getNombre().equals(rolActual)) {
				listaRol.add(x);
				for (AdmRol y : lista) {
					if (!y.getNombre().equals(rolActual)) {
						listaRol.add(y);
					}
				}
				return listaRol;
			}
		}
		return listaRol;
	}	

	public StreamedContent getEstadoImage() throws IOException {
		//Carga la imagen de activo/inactivo cuando se consulta el estado del usuario
		FacesContext context = FacesContext.getCurrentInstance();
		String pathUser;
		
		try {
			if (varEstado.equals("ACTIVO")) 
				pathUser = "/images/activo.png";
			else if (varEstado.equals("INACTIVO")) 
				pathUser = "/images/inactivo.png";
			else
				pathUser = null;
	 
			if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
				estadoImage = new DefaultStreamedContent();
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
	 
				estadoImage = new DefaultStreamedContent(new ByteArrayInputStream(bos.toByteArray()), "image/png");
	 
			}			
		} catch (Exception e) {
			System.out.println("-- Error cargando imagen, el path es nulo");
		}
	
		return estadoImage;
	}

	public void setEstadoImage(StreamedContent estadoImage) {
		this.estadoImage = estadoImage;
	}	
	
	public void llenarItemsRol(List<AdmRol> rol){
		this.hashMapRol = new HashMap<String,AdmRol>();
		for(AdmRol id: rol){
			hashMapRol.put(String.valueOf(id.getIdrol()), id);		
		}		
	}
	
	public void buscarUsuario (ActionEvent actionEvent) {
		//Método para buscar un usuario en el sistema
		FacesContext lContexto= FacesContext.getCurrentInstance();
		try {
					
			//Consulta la información del usuario
			usuario = new AdmUsuario();
			persona = new AdmPersonaSistema();

			AdmUsuario usuario = usuarioService.consultarUsuario(varUsuarioFind);
			AdmPersonaSistema persona = usuarioService.consultarPersona(Integer.parseInt(usuario.getAdmpersonassistema().getIdpersona().toString()));
			
			System.out.println("-- Usuario búsqueda: " + usuario.getUsuario());
			
			varIdentificacion = persona.getCedula();
			varNombreCompleto = persona.getPrimernombre().toUpperCase() + " " + persona.getSegundonombre().toUpperCase() + " " + persona.getApellidopaterno().toUpperCase() + " " + persona.getApellidomaterno().toUpperCase();
			varTelefono = persona.getCelular();
			varEmail = persona.getEmail();
			varClaveTmp = usuario.getClave();
			varFechaRegistro = usuario.getFechacreacion();
			
			if (usuario.getEstado().equals("A")) {
				varEstado = "ACTIVO";
				varBotonEstado = "Inactivar usuario";
			} else if (usuario.getEstado().equals("I")) {
				varEstado = "INACTIVO";
				varBotonEstado = "Activar usuario";
			} else {
				varEstado = "INACTIVO";
				varBotonEstado = "Cambiar estado";
			}
			
			lRol = usuarioService.obtieneRol();			
			lRol = ordenarLista(usuarioService.obtieneRol(), (usuario.getAdmrole().getNombre() == null)? "Administrador": usuario.getAdmrole().getNombre());
			llenarItemsRol(lRol);
			
			varValidaBusqueda = true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			varIdentificacion = "";
			varNombreCompleto = "";
			varTelefono = "";
			varEmail = "";
			varClaveNew = "";
			varEstado = "";
			varFechaRegistro = null;
			varValidaBusqueda = false;
		    lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No existe el usuario que intenta buscar"));
		}
	}
	
	public void actualizarUsuario (ActionEvent actionEvent) {
		//Método para actualizar el usuario seleccionado
		FacesContext lContexto= FacesContext.getCurrentInstance();
		try {
			
			if (varValidaBusqueda) {
				
				Calendar calendar = Calendar.getInstance();
				Timestamp fechaRegistro = new java.sql.Timestamp(calendar.getTime().getTime());
				
				//Consulta la información del usuario
				usuario = new AdmUsuario();
				persona = new AdmPersonaSistema();
				AdmUsuario usuario = usuarioService.consultarUsuario(varUsuarioFind);
				AdmPersonaSistema persona = usuarioService.consultarPersona(Integer.parseInt(usuario.getAdmpersonassistema().getIdpersona().toString()));

				//Setea los valores a actualizar
				if (varClaveNew == null) {
					usuario.setClave(varClaveTmp);
				}					
				else {
					BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
					String hashedPassword = passwordEncoder.encode(varClaveNew);
					usuario.setClave(hashedPassword);
				}
					
				usuario.setAdmrole(rol);
				usuario.setUsuariomodificion(sesionUsuario.getUsuario());
				usuario.setFechamodificacion(fechaRegistro);
				persona.setCelular(varTelefono);
				persona.setEmail((varEmail == null)?"":varEmail.toLowerCase());
				persona.setFechamod(fechaRegistro);
				persona.setUsuariomod(sesionUsuario.getUsuario());
				
				//Actualiza la información del usuario en la base de datos
				usuarioService.actualizarUsuario(usuario);
				usuarioService.actualizarPersona(persona);
				
				System.out.println("-- Usuario " + usuario.getUsuario() + " actualizado exitosamente");
						
				inicializar();
				inicializarPersona();
				inicializarUsuario();
				
				//Limpia formulario
				varIdentificacion = "";
				varNombreCompleto = "";
				varTelefono = "";
				varEmail = "";
				varClaveNew = "";
				varValidaBusqueda = false;
				
				refresh();
				
				lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Transacción ","Usuario actualizado exitosamente"));
								
			} else {
				lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Advertencia ","Debe hacer la búsqueda de un usuario para poder actualizar"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			inicializar();
			inicializarPersona ();
			inicializarUsuario();	
			refresh();
		    lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No se pudo actualizar la información del usuario"));
		}
	}
	
	public void inactivarUsuario (ActionEvent actionEvent) {
		//Método que inactiva el usuario seleccionado
		FacesContext lContexto= FacesContext.getCurrentInstance();
		try {
			
			if (varValidaBusqueda) {
				
				Calendar calendar = Calendar.getInstance();
				Timestamp fechaRegistro = new java.sql.Timestamp(calendar.getTime().getTime());							
				
				//Consulta la información del usuario
				usuario = new AdmUsuario();
				persona = new AdmPersonaSistema();
				AdmUsuario usuario = usuarioService.consultarUsuario(varUsuarioFind);
				
				//Setea los valores a actualizar
				if (varEstado.equals("ACTIVO")) 
					usuario.setEstado("I");
				else
					usuario.setEstado("A");
				usuario.setUsuariomodificion(sesionUsuario.getUsuario());
				usuario.setFechamodificacion(fechaRegistro);
				
				//Actualiza la información del usuario en la base de datos
				usuarioService.actualizarUsuario(usuario);
				
				System.out.println("-- Usuario " + usuario.getUsuario() + ", cambio de estado " + varEstado + " al nuevo estado");
				
				inicializar();
				inicializarPersona();
				inicializarUsuario();
				
				//Limpia formulario
				varNombreCompleto = "";
				varEstado = "";
				varFechaRegistro = null;
				estadoImage = null;
				varBotonEstado = "Cambiar estado";
				varValidaBusqueda = false;
				
				refresh();
				
				lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Información ","Usuario activado/inactivado exitosamente"));
								
			} else {
				lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Advertencia ","Debe hacer la búsqueda de un usuario para poder cambiar su estado"));
			}
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
			inicializar();
			inicializarPersona ();
			inicializarUsuario();
			refresh();
		    lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No se pudo actualizar la información del usuario"));
		}
	}	
	
	public void limpiarPantalla () {
		//Método que limpia el formulario en pantalla
		inicializar();
		inicializarPersona();
		inicializarUsuario();
		varIdentificacion = "";
		varNombreCompleto = "";
		varTelefono = "";
		varEmail = "";
		varUsuarioFind = "";
		varClaveNew = "";
		varEstado = "";
		varValidaBusqueda = false;
		varBotonEstado = "Cambiar estado";
		estadoImage = null;
		lRol = null;
		varFechaRegistro = null;
	}
	
	public void inicializarPersona () {
		persona.setIdpersona(null);
		persona.setCedula("");
		persona.setPrimernombre("");
		persona.setSegundonombre("");
		persona.setApellidomaterno("");
		persona.setApellidopaterno("");
		persona.setEmail("");
		persona.setEstado("");
		persona.setFechanacimiento(null);
		persona.setOcupacion("");
		persona.setCelular("");
		persona.setFechamod(null);
		persona.setFechareg(null);
		persona.setUsuariomod("");
		persona.setUsuarioreg("");
		persona.setPartiposestadocivil(null);
		persona.setPartiposidentificacion(null);
		persona.setPartipossexo(null);
	}
	
	public void inicializarUsuario () {
		usuario.setIdusuario(null);
		usuario.setClave("");
		usuario.setEstado("");
		usuario.setFechacreacion(null);
		usuario.setFechamodificacion(null);
		usuario.setUsuario("");
		usuario.setUsuariocreacion("");
		usuario.setUsuariomodificion("");
		usuario.setAdmpersonassistema(null);
		usuario.setAdmrole(null);
	}
	
	public void refresh() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    Application application = context.getApplication();
	    ViewHandler viewHandler = application.getViewHandler();
	    UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
	    context.setViewRoot(viewRoot);
	    context.renderResponse(); 
	 }
	
}
