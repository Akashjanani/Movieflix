package rest.module.Movieflix.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import rest.module.Movieflix.Entity.Users;

@Component
public interface UsersService {

		public List<Users> findAll();
	
		public Users findOne(String id);
	
		public Users findByEmail(String email);
		
		public Users create(Users user);
	
		public Users update(String id, Users user);
	
		public void delete(String id);
}
