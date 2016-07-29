package rest.module.Movieflix.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rest.module.Movieflix.Entity.Administrators;
import rest.module.Movieflix.Service.AdministratorsService;

@RestController
@Controller
@RequestMapping(path = "administrators")
public class AdministratorsController {

	@Autowired
	AdministratorsService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Administrators> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Administrators findOne(@PathVariable("id") String adminid) {
		return service.findOne(adminid);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Administrators create(@RequestBody Administrators admin) {
		return service.create(admin);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Administrators update(@PathVariable("id") String adminid, @RequestBody Administrators admin) {
		return service.update(adminid, admin);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") String adminid) {
		service.delete(adminid);
	}
	
}

