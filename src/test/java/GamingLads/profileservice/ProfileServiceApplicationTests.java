package GamingLads.profileservice;

import GamingLads.profileservice.model.Profile;
import GamingLads.profileservice.model.User;
import GamingLads.profileservice.repository.ProfileRepository;
import GamingLads.profileservice.service.ProfileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProfileServiceApplicationTests {

	@MockBean
	private ProfileRepository profileRepository;

	@Autowired
	private ProfileService profileService;


	@Test
	void testCreateProfile() throws Exception{
		User user = new User(1, "Sharony");
		Profile profile = new Profile();
		profile.setUserId(user.getUserId());
		profile.setUsername(user.getUsername());

		Profile mockProfile = profileService.createProfile(user);

		Assertions.assertEquals(profile, mockProfile);
	}


	@Test
	void testUpdateProfile() throws Exception{

	}


	@Test
	void testGetAllProfiles() throws Exception{

	}

}
