package c0836335_Project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDataCacheConfig {
	
	@Bean
	public UserDataCache getUserDataCache() {
		return new UserDataCache();
	}

}
