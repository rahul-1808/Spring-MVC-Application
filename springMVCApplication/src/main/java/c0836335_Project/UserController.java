package c0836335_Project;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	 
	@Autowired
	private UserDataCache userdatacache;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/createuser")
	public String userForm(Model model) {
		model.addAttribute("user", new UserClass());
		return "userform";
	}
	
	@PostMapping("/createuser")
	public String createUser(@Valid @ModelAttribute("user") UserClass toSave, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "userform";
		} else {
			this.userRepo.save(toSave);
			this.userdatacache.storeData(toSave);
			return "saved";
		}
	}
	
	
	
	@GetMapping("/allusers")
	public String listAllUsers(Model model) {
		model.addAttribute("users", this.userRepo.findAll());
		return "listusers";
	}

}
