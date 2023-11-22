package c0836335_Project;

import java.util.ArrayList;
import java.util.List;

public class UserDataCache {
	
	private List <UserClass> storedUserData;
	
	public UserDataCache() {
		storedUserData = new ArrayList<>();
	}
	
	public void storeData (UserClass userclass) {
		this.storedUserData.add(userclass);
	}
	
	public List<UserClass> getAllUsers(){
		return this.storedUserData;
		
	}

}
