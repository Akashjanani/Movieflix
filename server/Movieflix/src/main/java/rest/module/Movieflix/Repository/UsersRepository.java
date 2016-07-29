package rest.module.Movieflix.Repository;

import java.util.List;

import rest.module.Movieflix.Entity.Users;

public interface UsersRepository {

		public List<Users> findAll();
		
		public Users findOne(String id);
		
		public Users findByEmail(String email);
		
		public Users create(Users user);
		
		public Users update(Users user);
		
		public void delete(Users user);
	
}
