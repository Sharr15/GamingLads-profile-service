package gaminglads.profileservice.serviceTest;

import gaminglads.profileservice.model.Profile;
import gaminglads.profileservice.model.User;
import gaminglads.profileservice.repository.ProfileRepository;
import gaminglads.profileservice.service.ProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
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
        user = new User(1, "Sharony");
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
        when(profileRepository.save(Mockito.any(Profile.class)))
                .thenAnswer(i -> i.getArguments()[0]);
        assertTrue(profileService.saveProfile(profile));
    }
}