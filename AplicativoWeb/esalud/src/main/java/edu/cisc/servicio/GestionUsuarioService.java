package edu.cisc.servicio;

import java.util.List;

import edu.cisc.modelo.AdmPersonaSistema;
import edu.cisc.modelo.AdmRol;
import edu.cisc.modelo.AdmUsuario;
import edu.cisc.modelo.ParTipoEstadoCivil;
import edu.cisc.modelo.ParTipoIdentificacion;
import edu.cisc.modelo.ParTipoSexo;

public interface GestionUsuarioService {
	
	void registrarUsuario (AdmUsuario pUsuario);
	
	void registrarPersona (AdmPersonaSistema pPersona);
	
	void actualizarUsuario (AdmUsuario pUsuario);
	
	void actualizarPersona (AdmPersonaSistema pPersona);
	
	AdmUsuario consultarUsuario(String pUsuario);
	
	AdmPersonaSistema consultarPersona(Integer pIdPersona);
	
	List<ParTipoIdentificacion> obtieneTipoIdentificacion();
	
	List<ParTipoEstadoCivil> obtieneTipoEstadoCivil();
	
	List<ParTipoSexo> obtieneTipoSexo();
	
	List<AdmRol> obtieneRol();

}
