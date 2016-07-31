package rest.module.Movieflix.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rest.module.Movieflix.Entity.Users;
import rest.module.Movieflix.Exception.AlreadyExistsException;
import rest.module.Movieflix.Exception.NotFoundException;
import rest.module.Movieflix.Repository.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService{

	@Autowired
	UsersRepository repository;
	
	@Override
	public List<Users> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Users findOne(String id) {
		Users existing = repository.findOne(id);
		if(existing == null) {
			
			throw new NotFoundException("User with id:" + id + "not found");
		}
		else {
		return existing;
		}
	}

	@Override
	@Transactional
	public Users findByEmail(String email) {
		Users existing = repository.findByEmail(email);
		if(existing == null) {
			
			throw new NotFoundException("User with email: " + email + " not found");
		}
		else {
		return existing;
		}
	}
	
	@Override
	@Transactional
	public Users create(Users user) {
		Users existing = repository.findByEmail(user.getEmail());
		if(existing != null) {
			throw new AlreadyExistsException("User email already in use:" + user.getEmail());
		}
		else {
		return repository.create(user);
		}
	}

	@Override
	@Transactional
	public Users update(String id, Users user) {
		Users existing = repository.findOne(id);
		if(existing == null) {
			
			throw new NotFoundException("User with id:" + id + "not found");
		}
		else {
		return repository.update(user);
		}
	}

	@Override
	@Transactional
	public void delete(String id) {
		Users existing = repository.findOne(id);
		if(existing == null) {
			throw new NotFoundException("User with id:" + id + "not found");
		}
		else {
		repository.delete(existing);
		}
	}
 }
