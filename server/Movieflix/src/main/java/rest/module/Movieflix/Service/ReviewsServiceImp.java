package rest.module.Movieflix.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rest.module.Movieflix.Entity.Movies;
import rest.module.Movieflix.Entity.Reviews;
import rest.module.Movieflix.Entity.Users;
import rest.module.Movieflix.Exception.NotFoundException;
import rest.module.Movieflix.Repository.ReviewsRepository;

@Service
public class ReviewsServiceImp implements ReviewsService {

	@Autowired
	ReviewsRepository repository;
	@Autowired
	MoviesService mService;
	@Autowired
	UsersService uService;
	
	@Override
	public List<Reviews> findReviewByMovieId(String movieid)  {
		
		List<Reviews> review = repository.findReviewByMovieId(movieid);
		if(review ==null) {
			throw new NotFoundException("Review with movie id: " + movieid +" not found");
		}
		else {
			return review;		
		}
	}
	
	@Override
	public Reviews findOne(String id) {
		Reviews review = repository.findOne(id);
		if(review == null) {
			throw new NotFoundException("Review with id: " + id +" not found");
		}
		else  {
			return review;
		}
	}

	@Override
	@Transactional
	public Reviews create(Reviews review) {
			String movieId = review.getMovie().getId();
			String userId = review.getUser().getId();
			
			if(movieId == null && userId == null) {
				return null;
			}
			else {
			Movies movie = mService.findOne(movieId);
			review.setMovie(movie);
			Users user = uService.findOne(userId);
			review.setUser(user);
			return repository.create(review);
		}
	}
	
	@Override	
	@Transactional
	public Reviews update(String id, Reviews review) {
		Reviews existing = repository.findOne(id);
		if(existing == null) {
			throw new NotFoundException("Review with id: " + id +" not found");
		}
		else {
			return repository.update(id, review);
		}
	}

	@Override
	@Transactional
	public void delete(String id) {
		Reviews existing = repository.findOne(id);
		if(existing == null) {
			throw new NotFoundException("Review with id: " + id +" not found");
		}
		else {
		repository.delete(existing);
		}
	}
}

