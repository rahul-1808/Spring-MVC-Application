package c0836335_Project;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserClass, Integer>{
	
	public UserClass findByFirstName(String firstName);

}
