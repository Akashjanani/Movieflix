package rest.module.Movieflix.Repository;

import java.util.List;

import rest.module.Movieflix.Entity.Administrators;


public interface AdministratorsRepository {

	public List<Administrators> findAll();
	
	public Administrators findOne(String id);
	
	public Administrators findByEmail(String email);
	
	public Administrators create(Administrators admin);
	
	public Administrators update(Administrators admin);
	
	public void delete(Administrators admin);

}
