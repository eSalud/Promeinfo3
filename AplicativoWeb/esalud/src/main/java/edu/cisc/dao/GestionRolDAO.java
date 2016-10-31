package edu.cisc.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cisc.modelo.AdmRol;
import edu.cisc.servicio.GestionRolService;

@Service
@Transactional
public class GestionRolDAO implements GestionRolService{
	
	@PersistenceContext(unitName="persistenceUnit")
	protected EntityManager entityManager;	

	public void actualizarRol(AdmRol rol) throws Exception {
		entityManager.merge(rol);
		entityManager.flush();		
	}

	public void ingresarRol(AdmRol rol) throws Exception {
		entityManager.persist(rol);
		entityManager.flush();
	}

	public AdmRol getRol(String rol) throws Exception {
		Query query = entityManager.createQuery("SELECT a FROM AdmRol a WHERE a.nombre = :rol");
		query.setParameter("rol", rol.toUpperCase());
		try {
			return (AdmRol) query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}

}
