package rest.module.Movieflix.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rest.module.Movieflix.Entity.Reviews;
import rest.module.Movieflix.Service.ReviewsService;

@RestController
@RequestMapping(path = "reviews")
public class ReviewsController {

	@Autowired
	ReviewsService service;
	
	@RequestMapping(method=RequestMethod.GET, value="/findByMovieId/{movieid}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Reviews> findReviewByMovieId(@PathVariable("movieid") String movieid) {
		return service.findReviewByMovieId(movieid);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Reviews findOne(@PathVariable("id") String id) {
		return service.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Reviews create(@RequestBody Reviews review) {
		return service.create(review);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="{id}",  consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Reviews update(@PathVariable("id") String id, @RequestBody Reviews review) {
		return service.update(id, review);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete( @PathVariable("id") String id) {
		service.delete(id);
	}
}

