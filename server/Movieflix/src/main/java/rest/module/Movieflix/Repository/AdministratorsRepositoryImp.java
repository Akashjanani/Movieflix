package rest.module.Movieflix.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import rest.module.Movieflix.Entity.Administrators;


@Repository
public class AdministratorsRepositoryImp implements AdministratorsRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Administrators> findAll() {
		TypedQuery<Administrators> query = em.createNamedQuery("Administrators.findAll", Administrators.class);
		return query.getResultList();
	}

	@Override
	public Administrators findOne(String id) {
		return em.find(Administrators.class,  id);
	}
	
	@Override
	public Administrators findByEmail(String email) {
		TypedQuery<Administrators> query = em.createNamedQuery("Administrators.findByEmail", Administrators.class);
		query.setParameter("pEmail", email);
		List<Administrators> administrators = query.getResultList();
		if(administrators != null && administrators.size() == 1) {
			return administrators.get(0);
		}
		return null;
	}

	@Override
	public Administrators create(Administrators administrators) {
		em.persist(administrators);
		return administrators;
	}

	@Override
	public Administrators update(Administrators administrators) {
		return em.merge(administrators);
	}

	@Override
	public void delete(Administrators administrators) {
		em.remove(administrators);
	}
}

