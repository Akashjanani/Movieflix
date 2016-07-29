package rest.module.Movieflix.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rest.module.Movieflix.Entity.Movies;
import rest.module.Movieflix.Exception.AlreadyExistsException;
import rest.module.Movieflix.Exception.NotFoundException;
import rest.module.Movieflix.Repository.MoviesRepository;

@Service
public class MoviesServiceImp implements MoviesService{

	@Autowired
	MoviesRepository repository;
	
	@Override
	public List<Movies> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Movies findOne(String id) {
		Movies existing = repository.findOne(id);
		if(existing == null) {
			
			throw new NotFoundException("Movie with id: " + id + " not found");
		}
		return existing;
	}
	
	@Override
	public List<Movies> findByType(String type) {
		List<Movies> existing = repository.findByType(type);
		if(existing.isEmpty()) {
			
			throw new NotFoundException("Movie with type: " + type + " not found");
		}
		return existing;
	}

	@Override
	public List<Movies> findByYear(String year) {
		List<Movies> existing = repository.findByYear(year);
		if(existing.isEmpty()) {
			
			throw new NotFoundException("Movie in the year: " + year + " does not exist");
		}
		return existing;
	}
		
	@Override
	public List<Movies> findByGenre(String genre) {
		List<Movies> existing = repository.findByGenre(genre);
		if(existing.isEmpty()) {
			
			throw new NotFoundException("Movie in the specified genre: " + genre + " not found");
		}
		return existing;
	}
	
	@Override
	public Movies findByTitle(String title) {
		Movies existing = repository.findByTitle(title);
		if(existing == null) {
	
			throw new NotFoundException("Movie title: " + title + " not found");
		}
		return existing;
	}
	
	@Override
	public List<Movies> sortByYear() {
		return repository.sortByYear();
	}
	
	@Override
	public List<Movies> sortByimdbRatings() {
		return repository.sortByimdbRatings();
	}
	
	@Override
	public List<Movies> sortByimdbVotes() {
		return repository.sortByimdbVotes();
	}
	
	@Override
	public List<Movies> getTopRatedMovies() {
		return repository.getTopRatedMovies();
	}
	
	@Override
	public List<Movies> getTopRatedSeries() {
		return repository.getTopRatedSeries();
	}
		
	@Override
	@Transactional
	public Movies create(Movies movie) {
		Movies existing = repository.findByTitle(movie.getTitle());
		if(existing != null) {
			throw new AlreadyExistsException("Title name already in use: " + movie.getTitle());
		}
		return repository.create(movie);
	}

	@Override
	@Transactional
	public Movies update(String id, Movies movie) {
		Movies existing = repository.findOne(id);
		if(existing == null) {
			
			throw new NotFoundException("Movie with id: " + id + " not found");
		}
		return repository.update(movie);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Movies existing = repository.findOne(id);
		if(existing == null) {
			throw new NotFoundException("Movie with id: " + id + " not found");
		}
		repository.delete(existing);
	}
 }
