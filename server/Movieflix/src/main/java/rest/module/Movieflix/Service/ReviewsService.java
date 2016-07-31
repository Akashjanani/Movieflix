package rest.module.Movieflix.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import rest.module.Movieflix.Entity.Reviews;

@Component
public interface ReviewsService {

	public List<Reviews> findReviewByMovieId(String movieid);
	public Reviews findOne(String id);
	public Reviews create(Reviews review);
	public Reviews update(String id, Reviews review);
	public void delete(String id);
}
