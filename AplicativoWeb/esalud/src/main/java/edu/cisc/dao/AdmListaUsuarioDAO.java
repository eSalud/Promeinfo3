package edu.cisc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cisc.dto.AdmUsuarioDTO;
import edu.cisc.servicio.AdmListaUsuarioService;

@Service(value="serviceListUser")
@Transactional
public class AdmListaUsuarioDAO implements AdmListaUsuarioService {

	@PersistenceContext(unitName="persistenceUnit")
	protected EntityManager entityManager;
	
	public List<AdmUsuarioDTO> getListaUsuario() {
		
		List<AdmUsuarioDTO> usuarios = new ArrayList<AdmUsuarioDTO>();
		AdmUsuarioDTO admUsuarioDTO = new AdmUsuarioDTO(null, "", "", null, "", "", "", "","");
		
		String sentencia = "SELECT a.idusuario, a.usuario, a.estado, b.idpersona, b.cedula, b.primernombre, b.apellidopaterno, b.email, c.nombre " +
				" FROM AdmUsuario a, AdmPersonaSistema b, AdmRol c " +
				" WHERE a.admpersonassistema.idpersona = b.idpersona AND a.admrole.idrol = c.idrol " +
				" ORDER BY a.idusuario";
		
		TypedQuery<Object[]> query = entityManager.createQuery(sentencia,Object[].class);
		
		for (Object[] result : query.getResultList()) {
			admUsuarioDTO.setIdUsuario(Integer.parseInt(result[0]!=null?result[0].toString():"0"));
			admUsuarioDTO.setUserName(result[1]!=null?result[1].toString():"");
			admUsuarioDTO.setEstado(result[2]!=null?result[2].toString():"");
			admUsuarioDTO.setIdPersona(Integer.parseInt(result[3]!=null?result[3].toString():"0"));
			admUsuarioDTO.setIdentificacion(result[4]!=null?result[4].toString():"");
			admUsuarioDTO.setNombre(result[5]!=null?result[5].toString():"");
			admUsuarioDTO.setApellido(result[6]!=null?result[6].toString():"");
			admUsuarioDTO.setEmail(result[7]!=null?result[7].toString():"");
			admUsuarioDTO.setRol(result[8]!=null?result[8].toString():"");
			usuarios.add(admUsuarioDTO);
			admUsuarioDTO = new AdmUsuarioDTO(null, "", "", null, "", "", "", "","");
		}
		
		return usuarios;
	}

}
