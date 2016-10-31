package edu.cisc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cisc.dto.AdmMenuDTO;
import edu.cisc.servicio.AdmMenuService;

@Service(value="serviceMenu")
@Transactional
public class AdmMenuDAO implements AdmMenuService {
	
	@PersistenceContext(unitName="persistenceUnit")
	protected EntityManager entityManager;

	public List<AdmMenuDTO> getMenuUsuario (String pIdRol) {
		
		List<AdmMenuDTO> menu = new ArrayList<AdmMenuDTO>();
		AdmMenuDTO admMenu = new AdmMenuDTO(null,"",null,"","",null);
		Long idRol = null;
		
		if (pIdRol != null) {
			idRol = new Long (pIdRol);
		}
		
		String sentencia = "SELECT a.idmenu, a.nombre, a.nivel, a.urldestino, a.icono, a.idmenupadre " + 
  		   "FROM AdmMenu a, AdmModuloRol b, AdmRol c, AdmModulo d " +
  		   "WHERE b.admrole.idrol = c.idrol AND b.admmenus.idmenu = a.idmenu AND b.admmodulo.idmodulo = d.idmodulo AND a.estado = 'A' AND c.estado = 'A' AND d.estado = 'A' AND c.idrol = :idrol " +
  		   "ORDER BY a.orden";
		
		TypedQuery<Object[]> query = entityManager.createQuery(sentencia,Object[].class);
		query.setParameter("idrol", idRol);

		for (Object[] result : query.getResultList()) {
			admMenu.setIdmenu(Integer.parseInt(result[0]!=null?result[0].toString():"0"));
			admMenu.setNombre(result[1]!=null?result[1].toString():"");
			admMenu.setNivel(Integer.parseInt(result[2]!=null?result[2].toString():"0"));
			admMenu.setUrldestino(result[3]!= null?result[3].toString():"");
			admMenu.setIcono(result[4]!= null?result[4].toString():"");
			admMenu.setIdmenupadre(Integer.parseInt(result[5]!=null?result[5].toString():"0"));
			menu.add(admMenu);
			admMenu = new AdmMenuDTO(null,"", null,"","",null);
		}

		return menu;
	}

}
