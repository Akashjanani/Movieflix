package rest.module.Movieflix.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import rest.module.Movieflix.Entity.Movies;

@Repository
public class MoviesRepositoryImp implements MoviesRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Movies> findAll() {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findAll", Movies.class);
		return query.getResultList();
	}

	@Override
	public Movies findOne(String id) {
		return em.find(Movies.class,  id);
	}
	
	@Override
	public List<Movies> findByType(String type) {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findByType", Movies.class);
		query.setParameter("pType", type);
		List<Movies> movies = query.getResultList();
		if(movies != null && movies.size() >= 1) {
			return query.getResultList();
		}
		return null;
	}
	
	@Override
	public List<Movies> findByYear(String year) {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findByYear", Movies.class);
		query.setParameter("pYear", year);
		List<Movies> movies = query.getResultList();
		if(movies != null && movies.size() >= 1) {
			return query.getResultList();
		}
		return null;
	}	
	@Override
	public List<Movies> findByGenre(String genre) {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findByGenre", Movies.class);
		query.setParameter("pGenre", genre);
		List<Movies> movies = query.getResultList();
		if(movies != null && movies.size() >= 1) {
			return query.getResultList();
		}
		return null;
	}
	
	@Override
	public Movies findByTitle(String title) {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findByTitle", Movies.class);
		query.setParameter("pTitle", title);
		List<Movies> movies = query.getResultList();
		if(movies != null && movies.size() == 1) {
			return movies.get(0);
		}
		return null;
	}
	
	@Override
	public List<Movies> sortByYear() {
		TypedQuery<Movies> query = em.createQuery("Movies.sortByYear", Movies.class);
		List<Movies> movies = query.getResultList();
		if(movies.isEmpty()) {
			System.out.println("List not available");
			return null;
		}
		else {
			return movies;
		}
	}
	
	@Override
	public List<Movies> sortByimdbRatings() {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.sortByimdbRatings", Movies.class);
		List<Movies> movies = query.getResultList();
		if(movies.isEmpty()){
			System.out.println("List not available");
			return null;
		}
			return movies;
	}
	
	@Override
	public List<Movies> sortByimdbVotes() {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.sortByimdbVotes", Movies.class);
		List<Movies> movies = query.getResultList();
		if(movies.isEmpty()){
			System.out.println("List not available");
			return null;
		}
			return movies;
	}
	
	@Override
	public List<Movies> getTopRatedMovies() {
		TypedQuery<Movies> query = em.createQuery("Select e from Movies e WHERE e.Type = :pType AND e.imdbRating > :pValue", Movies.class);
		query.setParameter("pType", "movie");
		query.setParameter("pValue", 7.7f);
		return query.getResultList();
	}

	@Override
	public List<Movies> getTopRatedSeries() {
		TypedQuery<Movies> query = em.createQuery("Select e from Movies e WHERE e.Type = :pType AND e.imdbRating > :pValue", Movies.class);
		query.setParameter("pType", "series");
		query.setParameter("pValue", 8.5f);
		return query.getResultList();
	}

	@Override
	public Movies create(Movies movie) {
		
		em.persist(movie);
		return movie;
	}

	@Override
	public Movies update(Movies movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(Movies movie) {
		em.remove(movie);
	}
}

