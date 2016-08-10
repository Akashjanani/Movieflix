package rest.module.Movieflix.Repository;

import java.util.List;

import rest.module.Movieflix.Entity.Movies;

	public interface MoviesRepository {

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

		public Movies update(Movies movie);

		public void delete(Movies movie);
	}
