package edu.cisc.servicio;

import java.util.List;

import edu.cisc.dto.AdmMenuDTO;

public interface AdmMenuService {
	
	public List<AdmMenuDTO> getMenuUsuario (String pIdRol) throws Exception;

}
