package gamingLads.profileservice.controller;

import gamingLads.profileservice.model.Profile;
import gamingLads.profileservice.model.User;
import gamingLads.profileservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/all")
    public List<Profile> getAllProfiles(){
        return profileService.getAllProfiles();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateProfile(@RequestBody Profile profile){
        boolean succeeded = profileService.updateProfile(profile);
        if(succeeded){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    //post to database
    @PostMapping("/create")
    public ResponseEntity<Void> createProfile(@RequestBody User user){
        boolean succeeded = profileService.addProfile(user);
        if(succeeded){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }
}
