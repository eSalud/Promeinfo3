package edu.cisc.controlador;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import edu.cisc.modelo.AdmPersonaSistema;
import edu.cisc.modelo.AdmRol;
import edu.cisc.modelo.AdmUsuario;
import edu.cisc.modelo.ParTipoEstadoCivil;
import edu.cisc.modelo.ParTipoIdentificacion;
import edu.cisc.modelo.ParTipoSexo;
import edu.cisc.servicio.GestionUsuarioService;

@Component(value="newUser")
@ViewScoped
public class NewUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ParTipoIdentificacion> listaTipoIden;
	private List<ParTipoEstadoCivil> listaTipoEstCivil;
	private List<ParTipoSexo> listaTipoSexo;
	private List<AdmRol> listaRolUser;
	private HashMap<String,ParTipoIdentificacion> hashMapIdentificacion;
	private HashMap<String, ParTipoEstadoCivil> hashMapEstadoCivil;
	private HashMap<String, ParTipoSexo> hashMapSexo;
	private HashMap<String, AdmRol> hashMapRol;
	private ParTipoIdentificacion tipoIdenticacion;
	private ParTipoEstadoCivil estadoCivil;
	private ParTipoSexo sexo;
	private AdmRol rol;
	private AdmPersonaSistema persona;
	private AdmUsuario usuario;
	private String varNombreUno;
	private String varNombreDos;
	private String varApellidoUno;
	private String varApellidoDos;
	private String varUsuario;
	private String varClave;
	
	@Autowired
	private GestionUsuarioService usuarioService;
	
	@Autowired(required=true)
	@Qualifier(value="sesionUsuario")
	private SesionUsuario sesionUsuario;
	
	@PostConstruct
	public void inicializar () {
		
		//Inicialización de los array para los selectOneMenu
		listaTipoIden 	  = new ArrayList<ParTipoIdentificacion>();
		listaTipoIden 	  = usuarioService.obtieneTipoIdentificacion();
		listaTipoEstCivil = new ArrayList<ParTipoEstadoCivil>();
		listaTipoEstCivil = usuarioService.obtieneTipoEstadoCivil();
		listaTipoSexo	  = new ArrayList<ParTipoSexo>();
		listaTipoSexo	  = usuarioService.obtieneTipoSexo();
		listaRolUser	  = new ArrayList<AdmRol>();
		listaRolUser	  = usuarioService.obtieneRol();
		
		//Inicialización variables 
		varNombreUno = "";
		varNombreDos = "";
		varApellidoUno = "";
		varApellidoDos = "";
		varUsuario = "";
		varClave   = "";
		
		//Instanciación de los objetos en donde se guarda la información del formulario
		persona = new AdmPersonaSistema();
		usuario = new AdmUsuario();
		
		//Llenado de los HashMap para pasarlos al FacesConverter 
		llenarItemsIdentificacion();
		llenarItemsEstadoCivil();
		llenarItemsSexo();
		llenarItemsRol();
		
	}

	public List<ParTipoIdentificacion> getListaTipoIden() {
		return listaTipoIden;
	}

	public void setListaTipoIden(List<ParTipoIdentificacion> listaTipoIden) {
		this.listaTipoIden = listaTipoIden;
	}

	public List<ParTipoEstadoCivil> getListaTipoEstCivil() {
		return listaTipoEstCivil;
	}

	public void setListaTipoEstCivil(List<ParTipoEstadoCivil> listaTipoEstCivil) {
		this.listaTipoEstCivil = listaTipoEstCivil;
	}

	public List<ParTipoSexo> getListaTipoSexo() {
		return listaTipoSexo;
	}

	public void setListaTipoSexo(List<ParTipoSexo> listaTipoSexo) {
		this.listaTipoSexo = listaTipoSexo;
	}

	public List<AdmRol> getListaRolUser() {
		return listaRolUser;
	}

	public void setListaRolUser(List<AdmRol> listaRolUser) {
		this.listaRolUser = listaRolUser;
	}

	public HashMap<String, ParTipoIdentificacion> getHashMapIdentificacion() {
		return hashMapIdentificacion;
	}

	public void setHashMapIdentificacion(HashMap<String, ParTipoIdentificacion> hashMapIdentificacion) {
		this.hashMapIdentificacion = hashMapIdentificacion;
	}

	public HashMap<String, ParTipoEstadoCivil> getHashMapEstadoCivil() {
		return hashMapEstadoCivil;
	}

	public void setHashMapEstadoCivil(HashMap<String, ParTipoEstadoCivil> hashMapEstadoCivil) {
		this.hashMapEstadoCivil = hashMapEstadoCivil;
	}

	public HashMap<String, ParTipoSexo> getHashMapSexo() {
		return hashMapSexo;
	}

	public void setHashMapSexo(HashMap<String, ParTipoSexo> hashMapSexo) {
		this.hashMapSexo = hashMapSexo;
	}

	public HashMap<String, AdmRol> getHashMapRol() {
		return hashMapRol;
	}

	public void setHashMapRol(HashMap<String, AdmRol> hashMapRol) {
		this.hashMapRol = hashMapRol;
	}

	public ParTipoIdentificacion getTipoIdenticacion() {
		return tipoIdenticacion;
	}

	public void setTipoIdenticacion(ParTipoIdentificacion tipoIdenticacion) {
		this.tipoIdenticacion = tipoIdenticacion;
	}

	public ParTipoEstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(ParTipoEstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public ParTipoSexo getSexo() {
		return sexo;
	}

	public void setSexo(ParTipoSexo sexo) {
		this.sexo = sexo;
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

	public String getVarNombreUno() {
		return varNombreUno;
	}

	public void setVarNombreUno(String varNombreUno) {
		this.varNombreUno = varNombreUno;
	}

	public String getVarNombreDos() {
		return varNombreDos;
	}

	public void setVarNombreDos(String varNombreDos) {
		this.varNombreDos = varNombreDos;
	}

	public String getVarApellidoUno() {
		return varApellidoUno;
	}

	public void setVarApellidoUno(String varApellidoUno) {
		this.varApellidoUno = varApellidoUno;
	}

	public String getVarApellidoDos() {
		return varApellidoDos;
	}

	public void setVarApellidoDos(String varApellidoDos) {
		this.varApellidoDos = varApellidoDos;
	}

	public String getVarUsuario() {
		return varUsuario;
	}

	public void setVarUsuario(String varUsuario) {
		this.varUsuario = varUsuario;
	}

	public String getVarClave() {
		return varClave;
	}

	public void setVarClave(String varClave) {
		this.varClave = varClave;
	}

	public GestionUsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(GestionUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public SesionUsuario getSesionUsuario() {
		return sesionUsuario;
	}

	public void setSesionUsuario(SesionUsuario sesionUsuario) {
		this.sesionUsuario = sesionUsuario;
	}
	
	public void llenarItemsIdentificacion(){
		this.hashMapIdentificacion = new HashMap<String,ParTipoIdentificacion>();
		for(ParTipoIdentificacion id: listaTipoIden){
			hashMapIdentificacion.put(String.valueOf(id.getIdtipoidentif()), id);		
		}		
	}	
	
	public void llenarItemsEstadoCivil(){
		this.hashMapEstadoCivil = new HashMap<String,ParTipoEstadoCivil>();
		for(ParTipoEstadoCivil id: listaTipoEstCivil){
			hashMapEstadoCivil.put(String.valueOf(id.getIdtipoestcivil()), id);		
		}		
	}	
	
	public void llenarItemsSexo(){
		this.hashMapSexo = new HashMap<String,ParTipoSexo>();
		for(ParTipoSexo id: listaTipoSexo){
			hashMapSexo.put(String.valueOf(id.getIdtiposexo()), id);		
		}		
	}		
	
	public void llenarItemsRol(){
		this.hashMapRol = new HashMap<String,AdmRol>();
		for(AdmRol id: listaRolUser){
			hashMapRol.put(String.valueOf(id.getIdrol()), id);		
		}		
	}	
	
	public void nuevoUsuario (ActionEvent actionEvent) {
		//Método para crear un nuevo usuario
		FacesContext lContexto= FacesContext.getCurrentInstance();
		try {			
			if (usuarioService.consultarUsuario(varUsuario.toUpperCase()) == null ) {
				
				Calendar calendar = Calendar.getInstance();
				Timestamp fechaRegistro = new java.sql.Timestamp(calendar.getTime().getTime());
				
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String hashedPassword = passwordEncoder.encode(varClave);
				
				//Clase ParPersona
				persona.setPartiposidentificacion(tipoIdenticacion);
				persona.setPrimernombre((varNombreUno == null)?"":varNombreUno.toUpperCase());
				persona.setSegundonombre((varNombreDos == null)?"":varNombreDos.toUpperCase());
				persona.setApellidopaterno((varApellidoUno == null)?"":varApellidoUno.toUpperCase());
				persona.setApellidomaterno((varApellidoDos == null)?"":varApellidoDos.toUpperCase());
				persona.setEmail((persona.getEmail() == null)?"":persona.getEmail().toLowerCase());
				persona.setPartiposestadocivil(estadoCivil);
				persona.setPartipossexo(sexo);
				persona.setEstado("A");
				persona.setUsuarioreg(sesionUsuario.getUsuario());
				persona.setFechareg(fechaRegistro);
				
				//Clase AdmUsuario
				usuario.setAdmrole(rol);
				usuario.setAdmpersonassistema(persona);
				usuario.setUsuario(varUsuario.toUpperCase());
				usuario.setClave(hashedPassword);
				usuario.setUsuariocreacion(sesionUsuario.getUsuario());
				usuario.setFechacreacion(fechaRegistro);
				usuario.setEstado("A");
				
				//Inserta el nuevo usuario en la base de datos
				usuarioService.registrarPersona(persona);
				usuarioService.registrarUsuario(usuario);
				
				System.out.println("-- Usuario " + varUsuario + " ingresado exitosamente");
				
				//Limpia formulario			
				varNombreUno = "";		
				varNombreDos = "";
				varApellidoUno = "";
				varApellidoDos = "";
				varUsuario = "";
				varClave = "";
				inicializar();
				inicializarPersona();
				inicializarUsuario();
				refresh();
				
				lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Información ","Usuario registrado exitosamente"));	
			} else {
				lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Advertencia ","El nombre del usuario que desea ingresar ya existe"));
			}
		} catch (Exception e) {
			inicializar();
			inicializarPersona ();
			inicializarUsuario();
			refresh();
			System.out.println(e.getMessage());
		    lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No se pudo registrar el nuevo usuario"));	
		}
	}
	
	public void limpiarPantalla () {
		//Método que limpia el formulario en pantalla
		inicializar();
		inicializarPersona();
		inicializarUsuario();
		varNombreUno = "";		
		varNombreDos = "";
		varApellidoUno = "";
		varApellidoDos = "";
		varUsuario = "";
		varClave = "";
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
