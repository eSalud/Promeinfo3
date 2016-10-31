package edu.cisc.convertidor;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import edu.cisc.controlador.NewUser;
import edu.cisc.modelo.ParTipoEstadoCivil;

@FacesConverter("estadoCivilConverter")
public class TipoEstadoCivilConverter implements Converter {
	
	private NewUser newUser;

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null && value.trim().length() > 0) {
			try { 
				newUser = (NewUser) context.getELContext().getELResolver().getValue(context.getELContext(), null, "newUser");
				ParTipoEstadoCivil tipoEstadoCivil = (ParTipoEstadoCivil) newUser.getHashMapEstadoCivil().get(value);
				return tipoEstadoCivil;
			} catch (Exception e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Error conversión listoBox Estado Civil"));
			}
		} else {
			return null;
		}
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {		
			ParTipoEstadoCivil tipoEstadoCivil = (ParTipoEstadoCivil) value;
			return String.valueOf(tipoEstadoCivil.getIdtipoestcivil());
		} else {
			return null;
		}		
	}		

}
