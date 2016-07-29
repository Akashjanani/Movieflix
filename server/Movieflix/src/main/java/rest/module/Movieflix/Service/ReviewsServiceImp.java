package rest.module.Movieflix.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rest.module.Movieflix.Entity.Reviews;
import rest.module.Movieflix.Repository.ReviewsRepository;

@Service
public class ReviewsServiceImp implements ReviewsService {

	@Autowired
	ReviewsRepository repository;
	
	@Override
	public List<Reviews> findReviewById(String id)  {
		
		List<Reviews> reviews = repository.findReviewById(id);
		if(reviews !=null) {
			return reviews;
		}
		else {
			return null;		
		}
	}
	
	@Override
	public Reviews findOne(String id) {
		Reviews review = repository.findOne(id);
		if(review == null) {
			return null;
		}
		else  {
			return review;
		}
	}

	@Override
	@Transactional
	public Reviews create(Reviews review) {
		
			return repository.create(review);
	}
	
	@Override
	@Transactional
	public Reviews update(String id, Reviews review) {
		Reviews existing = repository.findOne(id);
		if(existing == null) {
			return null;
		}
		else {
			return repository.update(id, review);
		}
	}

	@Override
	@Transactional
	public void delete(String id) {
		Reviews existing = repository.findOne(id);
		repository.delete(existing);
	}
}
