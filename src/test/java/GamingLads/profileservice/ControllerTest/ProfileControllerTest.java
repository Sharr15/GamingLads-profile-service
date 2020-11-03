package GamingLads.profileservice.ControllerTest;

import GamingLads.profileservice.Controller.ProfileController;
import GamingLads.profileservice.Model.Profile;
import GamingLads.profileservice.Model.User;
import GamingLads.profileservice.Repository.ProfileRepository;
import GamingLads.profileservice.Service.ProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.ribbon.proxy.annotation.Http;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.function.BooleanSupplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
