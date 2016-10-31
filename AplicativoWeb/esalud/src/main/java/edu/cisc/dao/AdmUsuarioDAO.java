package edu.cisc.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cisc.modelo.AdmUsuario;
import edu.cisc.servicio.AdmUsuarioService;

@Service(value="serviceManager")
@Transactional
public class AdmUsuarioDAO implements AdmUsuarioService{
	
	@PersistenceContext(unitName="persistenceUnit")
	protected EntityManager entityManager;

	@Override
	public AdmUsuario iniciarSesion(String usuario) throws Exception {
		Query query = entityManager.createQuery("SELECT d FROM AdmUsuario d WHERE d.usuario = :user");
		query.setParameter("user", usuario.toUpperCase());
		try {
			return (AdmUsuario) query.getSingleResult();
		} catch (NoResultException ex) {
			System.out.println("-- Error: No se encontró el usuario");
			return null;
		}
	}
	
}
