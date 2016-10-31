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

import edu.cisc.modelo.AdmModulo;
import edu.cisc.servicio.GestionModuloService;

@Component(value="gestionModulo")
@ViewScoped
public class GestionModulo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<AdmModulo> listaModulos;
	private AdmModulo modulo;
	private Boolean estadoModulo;
	private String varNombre;
	private String varDescripcion;
	private String VarNombreTmp;
	
	@Autowired
	private GestionModuloService moduloService;
	
	@Autowired(required=true)
	@Qualifier(value="sesionUsuario")
	private SesionUsuario sesionUsuario;	
	
	@PostConstruct
	public void inicializar () throws Exception {
		listaModulos = new ArrayList<AdmModulo>();
		listaModulos = moduloService.listarModulos();
		estadoModulo = false;
		varNombre = "";
		varDescripcion = "";
		VarNombreTmp = "";
	}

	public List<AdmModulo> getListaModulos() {
		return listaModulos;
	}

	public void setListaModulos(List<AdmModulo> listaModulos) {
		this.listaModulos = listaModulos;
	}

	public AdmModulo getModulo() {
		return modulo;
	}

	public void setModulo(AdmModulo modulo) {
		this.modulo = modulo;
	}

	public Boolean getEstadoModulo() {
		return estadoModulo;
	}

	public void setEstadoModulo(Boolean estadoModulo) {
		this.estadoModulo = estadoModulo;
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

	public void seleccionarModulo (ActionEvent actionEvent) {
		//Carga la información del módulo seleccionado en la tabla
		modulo = (AdmModulo) actionEvent.getComponent().getAttributes().get("EDITAR_SELECCION");
		VarNombreTmp = modulo.getNombre().toUpperCase();
		if (modulo.getEstado().equals("A"))
			estadoModulo = true;
		else
			estadoModulo = false;		
		System.out.println("-- Módulo a editar: " + modulo.getNombre());
	}
	
	public void actualizarModulo (ActionEvent actionEvent) {
		//Actualiza el módulo seleccionado
		FacesContext lContexto= FacesContext.getCurrentInstance();
		Boolean validaProceso = true;
		try {
			if (modulo.getModificable().equals("S")) {
				if (!VarNombreTmp.equals(modulo.getNombre().toUpperCase())) {
					if (moduloService.getModulo(modulo.getNombre().toUpperCase()) == null) {
						validaProceso = true;
					} else {
						validaProceso = false;
					}
				}
				if (validaProceso) {
					if (estadoModulo) { modulo.setEstado("A"); } else { modulo.setEstado("I"); }
					modulo.setNombre(modulo.getNombre().toUpperCase());
					moduloService.actualizarModulo(modulo);
					lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Información","Módulo actualizado exitosamente"));
				} else {
					modulo.setNombre(VarNombreTmp);
					VarNombreTmp = "";
					lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Advertencia ","El nombre que ingreso del módulo que desea actualizar ya existe"));
				}
			} else {
				lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Advertencia","No se puede actualizar la información del módulo seleccionado porque se encuentra protegido"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		    lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No se pudo actualizar el módulo"));
		}
	}	
	
	public void ingresarModulo (ActionEvent actionEvent) {
		
		FacesContext lContexto= FacesContext.getCurrentInstance();
		
		if (varNombre == null || varNombre.equals("")) {
			lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Advertencia","Debe ingresar el nombre del módulo"));
		}
		else if (varDescripcion == null || varDescripcion.equals("")) {
			lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Advertencia","Debe ingresar la descripción del módulo"));
		} else {
			try {
				if (moduloService.getModulo(varNombre.toUpperCase()) == null) {
					Calendar calendar = Calendar.getInstance();
					Timestamp fechaRegistro = new java.sql.Timestamp(calendar.getTime().getTime());
					
					AdmModulo moduloTmp = new AdmModulo();
					moduloTmp.setAdmaplicacione(moduloService.getAplicacion("1"));
					moduloTmp.setNombre(varNombre.toUpperCase());
					moduloTmp.setDescripcion(varDescripcion);
					moduloTmp.setUsuariocreacion(sesionUsuario.getUsuario());
					moduloTmp.setFechacreacion(fechaRegistro);
					moduloTmp.setEstado("A");
					moduloTmp.setModificable("S");
					moduloService.ingresarModulo(moduloTmp);
					
					moduloTmp = new AdmModulo();
					varNombre = "";
					varDescripcion = "";
					
					System.out.println("-- Se ha creado un nuevo módulo");
					lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Información ","Módulo registrado exitosamente"));					
				} else {
					lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Advertencia ","El nombre del módulo que desea ingresar ya existe"));
				}
							
			} catch (Exception e) {
				System.out.println(e.getMessage());
			    lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No se pudo ingresar el nuevo módulo"));
			}			
		}
		varNombre = "";
		varDescripcion = "";
	}
	
	public void refrescarPantalla (ActionEvent actionEvent) {
		FacesContext lContexto= FacesContext.getCurrentInstance();
		try {
			listaModulos = new ArrayList<AdmModulo>();
			listaModulos = moduloService.listarModulos();
			estadoModulo = false;
			varNombre = "";
			varDescripcion = "";		
			lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Información","La pantalla ha sido refrescada"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		    lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error inesperado refrescando la pantalla"));
		}
	}	
	
	
}
