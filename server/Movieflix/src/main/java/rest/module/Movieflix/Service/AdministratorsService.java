package rest.module.Movieflix.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import rest.module.Movieflix.Entity.Administrators;

@Component
public interface AdministratorsService {

	public List<Administrators> findAll();
	
	public Administrators findOne(String id);

	public Administrators create(Administrators admin);

	public Administrators update(String id, Administrators admin);

	public void delete(String id);
}
