package edu.cisc.controlador;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.cisc.dto.AdmUsuarioDTO;
import edu.cisc.modelo.AdmPersonaSistema;
import edu.cisc.modelo.AdmRol;
import edu.cisc.modelo.AdmUsuario;
import edu.cisc.servicio.AdmListaUsuarioService;
import edu.cisc.servicio.GestionUsuarioService;

@Component(value="consultaUsuario")
@ViewScoped
public class ListaUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<AdmUsuarioDTO> listaUsuarios;
	private List<AdmRol> rolUsuario = new ArrayList<AdmRol>();
	private HashMap<String, AdmRol> hashMapRol;
	private AdmUsuarioDTO usuarioEditar;
	private AdmRol rol;
	private Boolean estadoUsuario;
	
	@Autowired
	private AdmListaUsuarioService viewUsuario;
	
	@Autowired
	private GestionUsuarioService usuarioService;	
	
	@Autowired(required=true)
	@Qualifier(value="sesionUsuario")
	private SesionUsuario sesionUsuario;	
	
	@PostConstruct
	public void inicializar () {
		listaUsuarios = new ArrayList<AdmUsuarioDTO>();
		listaUsuarios = viewUsuario.getListaUsuario();
		usuarioEditar = new AdmUsuarioDTO(null, "", "", null, "", "", "", "", "");
		estadoUsuario = false;
		rolUsuario    = new ArrayList<AdmRol>();
	}

	public List<AdmUsuarioDTO> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<AdmUsuarioDTO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public AdmUsuarioDTO getUsuarioEditar() {
		return usuarioEditar;
	}

	public void setUsuarioEditar(AdmUsuarioDTO usuarioEditar) {
		this.usuarioEditar = usuarioEditar;
	}

	public Boolean getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(Boolean estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public List<AdmRol> getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(List<AdmRol> rolUsuario) {
		this.rolUsuario = rolUsuario;
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

	public void llenarItemsRol(){
		this.hashMapRol = new HashMap<String,AdmRol>();
		for(AdmRol id: rolUsuario){
			hashMapRol.put(String.valueOf(id.getIdrol()), id);		
		}
	}
	
	public List<AdmRol> ordenarLista (List<AdmRol> lista, String rolActual) {
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

	public void seleccionarUsuario (ActionEvent actionEvent) {
		usuarioEditar = (AdmUsuarioDTO) actionEvent.getComponent().getAttributes().get("EDITAR_USUARIO");
		rolUsuario = ordenarLista(usuarioService.obtieneRol(), usuarioEditar.getRol());
		llenarItemsRol();
		if (usuarioEditar.getEstado().equals("A"))
			estadoUsuario = true;
		else
			estadoUsuario = false;
		System.out.println("-- Usuario a editar: " + usuarioEditar.getUserName());
	}
	
	public void actualizarUsuario (ActionEvent actionEvent) {
		FacesContext lContexto= FacesContext.getCurrentInstance();
		try {
			
			Calendar calendar = Calendar.getInstance();
			Timestamp fechaRegistro = new java.sql.Timestamp(calendar.getTime().getTime());
			
			AdmUsuario usuario = usuarioService.consultarUsuario(usuarioEditar.getUserName());
			AdmPersonaSistema persona = usuarioService.consultarPersona(usuarioEditar.getIdPersona());
			
			persona.setPrimernombre(usuarioEditar.getNombre());
			persona.setApellidopaterno(usuarioEditar.getApellido());
			persona.setEmail(usuarioEditar.getEmail());
			persona.setFechamod(fechaRegistro);
			persona.setUsuariomod(sesionUsuario.getUsuario());
			usuario.setAdmrole(rol);			
			if (estadoUsuario)
				usuario.setEstado("A");
			else
				usuario.setEstado("I");
			usuario.setUsuariomodificion(sesionUsuario.getUsuario());
			usuario.setFechamodificacion(fechaRegistro);
			
			//Actualiza la información del usuario en la base de datos
			usuarioService.actualizarUsuario(usuario);
			usuarioService.actualizarPersona(persona);
			
			System.out.println("Usuario modificado: " + usuarioEditar.getUserName());
			
			lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Transacción ","Usuario actualizado exitosamente"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		    lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","No se pudo actualizar la información del usuario"));
		}
	}
	
	public void refrescarPantalla (ActionEvent actionEvent) {
		FacesContext lContexto= FacesContext.getCurrentInstance();
		try {
			listaUsuarios = new ArrayList<AdmUsuarioDTO>();
			listaUsuarios = viewUsuario.getListaUsuario();
			usuarioEditar = new AdmUsuarioDTO(null, "", "", null, "", "", "", "", "");	
			lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Transacción","La pantalla ha sido refrescada"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		    lContexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error inesperado refrescando la pantalla"));
		}
	}

}
