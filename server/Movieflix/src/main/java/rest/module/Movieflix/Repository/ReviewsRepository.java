package rest.module.Movieflix.Repository;

import java.util.List;

import rest.module.Movieflix.Entity.Reviews;

public interface ReviewsRepository {

		public List<Reviews> findReviewById(String id);
		public Reviews create(Reviews review);
		public Reviews findOne(String id);
		public Reviews update(String id, Reviews review);
		public void delete(Reviews review);
	}
