package c0836335_Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Schedule {
	
	@Autowired
	private UserDataCache userDataCache;
	
	public void counterMethod() {
		System.out.println("System current has " + userDataCache.getAllUsers().size() + " users");
		System.out.println(userDataCache.getAllUsers());
	}

}
