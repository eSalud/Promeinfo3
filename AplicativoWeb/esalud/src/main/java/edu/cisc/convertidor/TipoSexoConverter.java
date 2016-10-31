package edu.cisc.convertidor;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import edu.cisc.controlador.NewUser;
import edu.cisc.modelo.ParTipoSexo;

@FacesConverter("sexoConverter")
public class TipoSexoConverter implements Converter {
	
	private NewUser newUser;

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null && value.trim().length() > 0) {
			try { 
				newUser = (NewUser) context.getELContext().getELResolver().getValue(context.getELContext(), null, "newUser");
				ParTipoSexo tipoSexo = (ParTipoSexo) newUser.getHashMapSexo().get(value);
				return tipoSexo;
			} catch (Exception e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Error conversión listoBox Sexo"));
			}
		} else {
			return null;
		}
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {		
			ParTipoSexo tipoSexo = (ParTipoSexo) value;
			return String.valueOf(tipoSexo.getIdtiposexo());
		} else {
			return null;
		}		
	}		
	
}
