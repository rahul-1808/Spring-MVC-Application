package c0836335_Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
	
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/usercount")
	public Long listAllUser() {
		return userRepo.count();
		
	}
	
	@GetMapping("/findbyfirstname")
	public UserClass FindByFirstName(@RequestParam String firstName) {
		return this.userRepo.findByFirstName(firstName);
	}
}


