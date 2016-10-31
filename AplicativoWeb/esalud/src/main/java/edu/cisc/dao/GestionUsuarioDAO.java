package edu.cisc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cisc.modelo.AdmPersonaSistema;
import edu.cisc.modelo.AdmRol;
import edu.cisc.modelo.AdmUsuario;
import edu.cisc.modelo.ParTipoEstadoCivil;
import edu.cisc.modelo.ParTipoIdentificacion;
import edu.cisc.modelo.ParTipoSexo;
import edu.cisc.servicio.GestionUsuarioService;

@Service
@Transactional
public class GestionUsuarioDAO implements GestionUsuarioService {

	@PersistenceContext(unitName="persistenceUnit")
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<ParTipoIdentificacion> obtieneTipoIdentificacion() {
		Query query = entityManager.createQuery("SELECT a FROM ParTipoIdentificacion a WHERE a.descripcion <> 'SIN DATOS'", ParTipoIdentificacion.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ParTipoEstadoCivil> obtieneTipoEstadoCivil() {
		Query query = entityManager.createQuery("SELECT a FROM ParTipoEstadoCivil a", ParTipoEstadoCivil.class);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ParTipoSexo> obtieneTipoSexo() {
		Query query = entityManager.createQuery("SELECT a FROM ParTipoSexo a", ParTipoSexo.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<AdmRol> obtieneRol() {
		Query query = entityManager.createQuery("SELECT a FROM AdmRol a", AdmRol.class);
		return query.getResultList();
	}

	public void registrarUsuario(AdmUsuario pUsuario) {
		entityManager.persist(pUsuario);
		entityManager.flush();
	}

	@Override
	public void registrarPersona(AdmPersonaSistema pPersona) {
		entityManager.persist(pPersona);
		entityManager.flush();
	}

	@Override
	public void actualizarUsuario(AdmUsuario pUsuario) {
		entityManager.merge(pUsuario);
		entityManager.flush();
	}

	@Override
	public void actualizarPersona(AdmPersonaSistema pPersona) {
		entityManager.merge(pPersona);
		entityManager.flush();
	}

	@Override
	public AdmUsuario consultarUsuario(String pUsuario) {
		Query query = entityManager.createQuery("SELECT a FROM AdmUsuario a WHERE a.usuario = :user", AdmUsuario.class);
		query.setParameter("user", pUsuario.toUpperCase());
		try {
			return (AdmUsuario) query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}

	@Override
	public AdmPersonaSistema consultarPersona(Integer pIdPersona) {
		Long idPersona = new Long(pIdPersona);
		Query query = entityManager.createQuery("SELECT a FROM AdmPersonaSistema a WHERE a.idpersona = :idpersona", AdmPersonaSistema.class);
		query.setParameter("idpersona", idPersona);
		return (AdmPersonaSistema) query.getSingleResult();
	}
	
}
