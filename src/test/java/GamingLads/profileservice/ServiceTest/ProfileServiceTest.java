package GamingLads.profileservice.ServiceTest;

import GamingLads.profileservice.Model.Profile;
import GamingLads.profileservice.Model.User;
import GamingLads.profileservice.Repository.ProfileRepository;
import GamingLads.profileservice.Service.ProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class ProfileServiceTest {

    @MockBean
    private ProfileRepository profileRepository;

    private ProfileService profileService;
    private User user;
    private Profile profile;

    @BeforeEach
    public void setup() {
        profileService = new ProfileService(profileRepository);
        user = new User("1", "Sharony");
        profile = new Profile();
        profile.setUserId(user.getUserId());
        profile.setUsername(user.getUsername());
    }

    @Test
    void testCreateProfile() throws Exception{
        Profile mockProfile = profileService.createProfile(user);
        assertThat(profile).isEqualToComparingFieldByField(mockProfile);
    }

    @Test
    void testSaveProfile() throws Exception{
        //boolean mockSaved = true;
        //when(profileRepository.save(Mockito.any(Profile.class))).thenReturn(profile);
        //when(profileRepository.save(Mockito.any(Profile.class))).thenAnswer(i -> i.getArguments()[0]);
        //when(profileService.saveProfile(profile)).thenReturn(true);
        //boolean saved = profileService.saveProfile(profile);
        //assertThat(saved).isTrue();

        assertTrue(profileService.saveProfile(profile));
    }


    @Test
    void testUpdateProfile() throws Exception{
    //TODO
    }


    @Test
    void testGetAllProfiles() throws Exception{
    //TODO
    }

}