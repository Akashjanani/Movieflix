package rest.module.Movieflix.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import rest.module.Movieflix.Entity.Movies;

@Component
public interface MoviesService {

	public List<Movies> findAll();
	
	public Movies findOne(String id);
	
	public List<Movies> findByType(String type);
	
	public List<Movies> findByYear(String year);
	
	public List<Movies> findByGenre(String genre);
	
	public Movies findByTitle(String title);
	
	public List<Movies> sortByYear();
	
	public List<Movies> sortByimdbRatings();
	
	public List<Movies> sortByimdbVotes();

	public List<Movies> getTopRatedMovies();
	
	public List<Movies> getTopRatedSeries();
	
	public Movies create(Movies movie);

	public Movies update(String id, Movies movie);

	public void delete(String id);
}
