package rest.module.Movieflix.Controller;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.MediaType;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

	import rest.module.Movieflix.Entity.Movies;
	import rest.module.Movieflix.Service.MoviesService;

@RestController
@RequestMapping(path = "movies")
public class MoviesController {

		@Autowired
		MoviesService service;
		
		@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movies> findAll() {
			return service.findAll();
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Movies findOne(@PathVariable("id") String movieid) {
			return service.findOne(movieid);
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "/type/{type}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movies> findByType(@PathVariable("type") String movietype) {
			return service.findByType(movietype);
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "/year/{year}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movies> findByYear(@PathVariable("year") String movieyear) {
			return service.findByYear(movieyear);
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "/genre/{genre}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movies> findByGenre(@PathVariable("genre") String moviegenre) {
			return service.findByGenre(moviegenre);
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "/title/{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Movies findByTitle(@PathVariable("title") String movietitle) {
			return service.findByTitle(movietitle);
		}
		
		@RequestMapping(method = RequestMethod.GET, value= "/sortYear", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movies> sortByYear() {
			return service.sortByYear();
		}
		
		@RequestMapping(method = RequestMethod.GET, value= "/imdbRatings", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movies> sortByimdbRatings() {
			return service.sortByimdbRatings();
		}
		
		@RequestMapping(method = RequestMethod.GET, value= "/imdbVotes", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movies> sortByimdbVotes() {
			return service.sortByimdbVotes();
		}
		
		@RequestMapping(method = RequestMethod.GET, value= "/topMovies", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movies> getTopRatedMovies() {
			return service.getTopRatedMovies();
		}
		
		@RequestMapping(method = RequestMethod.GET, value= "/topSeries", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movies> getTopRatedSeries() {
			return service.getTopRatedSeries();
		}
		
		@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Movies create(@RequestBody Movies movie) {
			return service.create(movie);
		}

		@RequestMapping(method = RequestMethod.PUT, value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Movies update(@PathVariable("id") String movieid, @RequestBody Movies movie) {
			return service.update(movieid, movie);
		}

		@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
		public void delete(@PathVariable("id") String movieid) {
			service.delete(movieid);
		}
		
	}

