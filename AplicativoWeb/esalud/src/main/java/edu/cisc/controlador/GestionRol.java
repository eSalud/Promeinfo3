package edu.cisc.controlador;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.cisc.modelo.AdmRol;
import edu.cisc.servicio.GestionRolService;
import edu.cisc.servicio.GestionUsuarioService;

@Component(value="gestionRol")
@ViewScoped
public class GestionRol implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<AdmRol> listaRoles;
	private AdmRol rol;
	private Boolean estadoRol;
	private String varNombre;
	private String varDescripcion;
	private String VarNombreTmp;	
	
	@Autowired
	private GestionUsuarioService usuarioService;
	
	@Autowired
	private GestionRolService rolService; 
	
	@Autowired(required=true)
	@Qualifier(value="sesionUsuario")
	private SesionUsuario sesionUsuario;
	
	@PostConstruct
	public void inicializar () {
		listaRoles = new ArrayList<AdmRol>();
		listaRoles = usuarioService.obtieneRol();
		estadoRol = false;
		varNombre = "";
		varDescripcion = "";
		VarNombreTmp = "";		
	}

	public List<AdmRol> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<AdmRol> listaRoles) {
		this.listaRoles = listaRoles;
	}

	public AdmRol getRol() {
		return rol;
	}

	public void setRol(AdmRol rol) {
		this.rol = rol;
	}
	
	public Boolean getEstadoRol() {
		return estadoRol;
	}

	public void setEstadoRol(Boolean estadoRol) {
		this.estadoRol = estadoRol;
	}

	public String getVarNombre() {
		return varNombre;
	}

	public void setVarNombre(String varNombre) {
		this.varNombre = varNombre;
	}

	public String getVarDescripcion() {
		return varDescripcion;
	}

	public void setVarDescripcion(String varDescripcion) {
		this.varDescripcion = varDescripcion;
	}

	public void seleccionarRol (ActionEvent actionEvent) {
		//Carga la información del rol seleccionado en la tabla
		rol = (AdmRol) actionEvent.getComponent().getAttributes().get("EDITAR_SELECCION");
		VarNombreTmp = rol.getNombre().toUpperCase();
		if (rol.getEstado().equals("A"))
			estadoRol = true;
		else
			estadoRol = false;
		System.out.println("-- Rol a editar: " + rol.getNombre());
	}
	
	public void actualizarRol (ActionEvent actionEvent) {
		//Actualiza el rol seleccionado
		FacesContext lContexto= FacesContext.getCurrentInstance();
		Boolean validaProceso = true;
		try {
			if (rol.getModificable().equals("S")) {
				if (!VarNombreTmp.equals(rol.getNombre().toUpperCase())) {
					if (rolService.getRol(rol.getNombre().toUpperCase()) == null) {
						validaProceso = true;
					} else {
						validaProceso = false;
					}
				}
				if (validaProceso) {
					if (estadoRol) { rol.setEstado("A"); } else { rol.setEstado("I"); }
					rol.setNombre(rol.getNombre().toUpperCase());
					rolService.actualizarRol(rol);
					lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Información ","Rol actualizado exitosamente"));					
				} else {
					rol.setNombre(VarNombreTmp);
					VarNombreTmp = "";
					lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Advertencia ","El nombre que ingreso del rol que desea actualizar ya existe"));
				}
			} else {
				lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Advertencia","No se puede actualizar la información del rol seleccionado porque se encuentra protegido"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		    lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No se pudo actualizar el rol"));
		}
	}
	
	public void ingresarRol (ActionEvent actionEvent) {
		
		FacesContext lContexto= FacesContext.getCurrentInstance();
		
		if (varNombre == null || varNombre.equals("")) {
			lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error","Debe ingresar el nombre del rol"));
		}
		else if (varDescripcion == null || varDescripcion.equals("")) {
			lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error","Debe ingresar la descripción del rol"));
		} else {
			try {
				if (rolService.getRol(varNombre.toUpperCase()) == null) {
					Calendar calendar = Calendar.getInstance();
					Timestamp fechaRegistro = new java.sql.Timestamp(calendar.getTime().getTime());
					
					AdmRol rolTmp = new AdmRol();
					rolTmp.setNombre(varNombre.toUpperCase());
					rolTmp.setDescripcion(varDescripcion);
					rolTmp.setUsuariocreacion(sesionUsuario.getUsuario());
					rolTmp.setFechacreacion(fechaRegistro);
					rolTmp.setEstado("A");
					rolTmp.setModificable("S");
					rolService.ingresarRol(rolTmp);
					
					rolTmp = new AdmRol();
					varNombre = "";
					varDescripcion = "";
					
					System.out.println("-- Se ha creado un nuevo rol");
					lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Transacción ","Rol registrado exitosamente"));					
				} else {
					lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Transacción ","El nombre del rol que desea ingresar ya existe"));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			    lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No se pudo ingresar el nuevo rol"));
			}			
		}
		varNombre = "";
		varDescripcion = "";
	}
	
	public void refrescarPantalla (ActionEvent actionEvent) {
		FacesContext lContexto= FacesContext.getCurrentInstance();
		try {
			listaRoles = new ArrayList<AdmRol>();
			listaRoles = usuarioService.obtieneRol();
			estadoRol = false;
			varNombre = "";
			varDescripcion = "";
			lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Transacción","La pantalla ha sido refrescada"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		    lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error inesperado refrescando la pantalla"));
		}
	}	

}
