package edu.cisc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cisc.modelo.AdmAplicacion;
import edu.cisc.modelo.AdmModulo;
import edu.cisc.servicio.GestionModuloService;

@Service
@Transactional
public class GestionModuloDAO implements GestionModuloService {
	
	@PersistenceContext(unitName="persistenceUnit")
	protected EntityManager entityManager;		

	public void actualizarModulo(AdmModulo modulo) throws Exception {
		entityManager.merge(modulo);
		entityManager.flush();
	}

	public void ingresarModulo(AdmModulo modulo) throws Exception {
		entityManager.persist(modulo);
		entityManager.flush();		
	}

	@SuppressWarnings("unchecked")
	public List<AdmModulo> listarModulos() throws Exception {
		Query query = entityManager.createQuery("SELECT a FROM AdmModulo a", AdmModulo.class);
		return query.getResultList();
	}

	public AdmModulo getModulo(String modulo) throws Exception {
		Query query = entityManager.createQuery("SELECT a FROM AdmModulo a WHERE a.nombre = :modulo");
		query.setParameter("modulo", modulo.toUpperCase());
		try {
			return (AdmModulo) query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}

	public AdmAplicacion getAplicacion(String pIdAplicacion) throws Exception {
		Long idAplicacion = null;
		if (pIdAplicacion != null) {
			idAplicacion = new Long (pIdAplicacion);
		}		
		Query query = entityManager.createQuery("SELECT a FROM AdmAplicacion a WHERE a.idaplicacion = :idAplicacion");
		query.setParameter("idAplicacion", idAplicacion);
		try {
			return (AdmAplicacion) query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}

}
