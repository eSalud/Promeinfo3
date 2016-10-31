package edu.cisc.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cisc.modelo.AdmHistorialConexion;
import edu.cisc.modelo.AdmUsuario;
import edu.cisc.servicio.HistorialConexionService;

@Service
@Transactional
public class HistorialConexionDAO implements HistorialConexionService {
	
	@PersistenceContext(unitName="persistenceUnit")
	protected EntityManager entityManager;		

	@SuppressWarnings("unchecked")
	public List<AdmHistorialConexion> obtieneHistorial(String pUsuario, Date pFechaIni, Date pFechaFin) {
		Query query = entityManager.createQuery("SELECT a FROM AdmHistorialConexion a WHERE a.usuario = :user AND a.fechaini BETWEEN :dateIni AND :dateFin ORDER BY a.fechaini DESC", AdmHistorialConexion.class);
		query.setParameter("user", pUsuario.toUpperCase());
		query.setParameter("dateIni", pFechaIni);
		query.setParameter("dateFin", pFechaFin);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<AdmUsuario> obtieneUsuarios() {
		Query query = entityManager.createQuery("SELECT a FROM AdmUsuario a", AdmUsuario.class);
		return query.getResultList();
	}
	
	@Override
	public AdmHistorialConexion obtenerSesion(String pUsuario, Date pFecha) {
		Query query = entityManager.createQuery("SELECT a FROM AdmHistorialConexion a WHERE a.usuario = :user AND a.fechaini = :dateIni", AdmHistorialConexion.class);
		query.setParameter("user", pUsuario.toUpperCase());
		query.setParameter("dateIni", pFecha);
		try {
			return (AdmHistorialConexion) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("-- Error: No se encontró el historial de sesión del Usuario");
			return null;
		}
	}		
	
	@Override
	public void registraHistorial(AdmHistorialConexion pHistorial) {
		entityManager.persist(pHistorial);
		entityManager.flush();
	}

	@Override
	public void actualizarHistorial(AdmHistorialConexion pHistorial) throws Exception {
		entityManager.merge(pHistorial);
		entityManager.flush();
	}

}
