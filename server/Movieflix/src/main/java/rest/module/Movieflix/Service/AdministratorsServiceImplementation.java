package rest.module.Movieflix.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rest.module.Movieflix.Entity.Administrators;
import rest.module.Movieflix.Exception.AlreadyExistsException;
import rest.module.Movieflix.Exception.NotFoundException;
import rest.module.Movieflix.Repository.AdministratorsRepository;

@Service
public class AdministratorsServiceImplementation implements AdministratorsService{

	@Autowired
	AdministratorsRepository repository;
	
	@Override
	public List<Administrators> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Administrators findOne(String id) {
		Administrators existing = repository.findOne(id);
		if(existing == null) {
			
			throw new NotFoundException("Administrator with id:" + id + "not found");
		}
		else {
		return existing;
		}
	}

	@Override
	@Transactional
	public Administrators create(Administrators admin) {
		Administrators existing = repository.findByEmail(admin.getEmail());
		if(existing != null) {
			throw new AlreadyExistsException("Admin email already in use:" + admin.getEmail());
		}
		else {
		return repository.create(admin);
		}
	}

	@Override
	@Transactional
	public Administrators update(String id, Administrators admin) {
		Administrators existing = repository.findOne(id);
		if(existing == null) {
			
			throw new NotFoundException("User with id:" + id + "not found");
		}
		else {
		return repository.update(admin);
		}
	}

	@Override
	@Transactional
	public void delete(String id) {
		Administrators existing = repository.findOne(id);
		if(existing == null) {
			throw new NotFoundException("User with id:" + id + "not found");
		}
		else {
		repository.delete(existing);
		}
	}
 }

