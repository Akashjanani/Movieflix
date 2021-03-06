package rest.module.Movieflix.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import rest.module.Movieflix.Entity.Reviews;

@Repository
public class ReviewsRepositoryImp implements ReviewsRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Reviews> findReviewByMovieId(String movieid) {
		TypedQuery<Reviews> query = em.createNamedQuery("Reviews.findReviewByMovieId", Reviews.class);
		query.setParameter("Id", movieid);
		List<Reviews> reviews = query.getResultList();
		if(reviews!= null) {
			return reviews;
		}
		else {
			return null;
		}
	}
	
	@Override
	public Reviews findOne(String id) {
		return em.find(Reviews.class, id);
	}

	@Override
	public Reviews create(Reviews review) {
		em.persist(review);
		return review;
	}

	@Override
	public Reviews update(String id, Reviews review) {
		em.merge(review);
		return review;
	}

	@Override
	public void delete(Reviews review) {
		em.remove(review);
	}
}
