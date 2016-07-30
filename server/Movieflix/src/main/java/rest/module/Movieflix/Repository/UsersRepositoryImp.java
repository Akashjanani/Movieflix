package rest.module.Movieflix.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rest.module.Movieflix.Entity.Users;

@Repository
public class UsersRepositoryImp implements UsersRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Users> findAll() {
		TypedQuery<Users> query = em.createNamedQuery("Users.findAll", Users.class);
		return query.getResultList();
	}

	@Override
	public Users findOne(String id) {
		return em.find(Users.class,  id);
	}
	
	@Override
	public Users findByEmail(String email) {
		TypedQuery<Users> query = em.createNamedQuery("Users.findByEmail", Users.class);
		query.setParameter("pEmail", email);
		List<Users> users = query.getResultList();
		if(users != null && users.size() == 1) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public Users create(Users user) {
		em.persist(user);
		return user;
	}

	@Override
	public Users update(Users user) {
		return em.merge(user);
	}

	@Override
	public void delete(Users user) {
		em.remove(user);
	}

}
