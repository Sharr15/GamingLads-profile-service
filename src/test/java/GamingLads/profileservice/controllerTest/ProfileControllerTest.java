package GamingLads.profileservice.controllerTest;

import GamingLads.profileservice.controller.ProfileController;
import GamingLads.profileservice.model.Profile;
import GamingLads.profileservice.model.User;
import GamingLads.profileservice.repository.ProfileRepository;
import GamingLads.profileservice.service.ProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ProfileControllerTest {

    @MockBean
    private ProfileRepository profileRepository;

    private ProfileController profileController;
    private ProfileService profileService;
    private User user;
    private Profile profile;

    @Autowired
    private MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    public void setup() {
        profileService = new ProfileService(profileRepository);
        profileController = new ProfileController(profileService);
        user = new User("1", "Sharony");
        profile = new Profile();
        profile.setUserId(user.getUserId());
        profile.setUsername(user.getUsername());
    }

    @Test
    void testCreateProfile() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/profile/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user));
        MvcResult response = mockMvc.perform(request).andReturn();


        // ResponseEntity<Void> response = profileController.createProfile(user);
        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getResponse().getStatus());
    }

    @Test
    void testGetAllProfiles(){
        //TODO:
    }

    @Test
    void testUpdateProfile(){
        //TODO:
    }
}
