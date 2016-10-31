package edu.cisc.convertidor;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import edu.cisc.controlador.GestionUsuario;
import edu.cisc.modelo.AdmRol;

@FacesConverter("rolConverter")
public class RolConverter implements Converter {
	
	private GestionUsuario gestionUsuario;

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null && value.trim().length() > 0) {
			try { 
				gestionUsuario = (GestionUsuario) context.getELContext().getELResolver().getValue(context.getELContext(), null, "gestionUsuario");
				AdmRol tipoRol = (AdmRol) gestionUsuario.getHashMapRol().get(value);
				return tipoRol;
			} catch (Exception e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Error conversión listoBox Rol"));
			}
		} else {
			return null;
		}
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {		
			AdmRol tipoRol = (AdmRol) value;
			return String.valueOf(tipoRol.getIdrol());
		} else {
			return null;
		}		
	}

}
