package c0836335_Project;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(UserController.class)
class UserControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserDataCache userdatacache;
	
	@MockBean
	private UserRepository userRepo;

	@Test
	public void createuserTest() throws Exception {
		mockMvc.perform(get("/createuser"))
		.andExpect(status().isOk())
		.andExpect(view().name("userform"))
		.andExpect(model().attribute("user", new UserClass()));
	}
	
	@Test
	public void createPostTest() throws Exception {
		UserClass expectedUser = new UserClass (null, "Rahul", "Murari","rahulmurari@gmail.com", 22);
		mockMvc.perform(post("/createuser").param("firstName", "Rahul").param("lastName", "Murari").param("Email","rahulmurari@gmail.com").param("age", "22"))
		.andExpect(status().isOk())
		.andExpect(view().name("saved"))
		.andExpect(model().attribute("user", expectedUser));
		
		Mockito.verify(userRepo).save(eq(expectedUser));
	}
	
	@Test
	public void createPostTest_InvalidUser() throws Exception {
		UserClass expectedUser = new UserClass(null, "", "Murari", "rahulmurari@gmail.com", -22);
		
		mockMvc.perform(post("/createuser").param("firstName", "").param("lastName", "Murari").param("Email","rahulmurari@gmail.com").param("age", "-22"))
		.andExpect(status().isOk())
		.andExpect(view().name("userform"))
		.andExpect(model().attribute("user", expectedUser));
		
		Mockito.verifyNoInteractions(userRepo);
	}
	
	@Test
	public void listUserTest() throws Exception {
		List<UserClass> expectedList = new ArrayList<>();
		expectedList.add(new UserClass(null, "Rahul", "Murari","rahulmurari@gmail.com", 22));
		
		Mockito.when(userRepo.findAll()).thenReturn(expectedList);
		
		mockMvc.perform(get("/allusers"))
		.andExpect(status().isOk())
		.andExpect(view().name("listusers"))
		.andExpect(model().attribute("users", expectedList));
	}
}
