package gaminglads.profileservice.controller;

import gaminglads.profileservice.model.Profile;
import gaminglads.profileservice.model.User;
import gaminglads.profileservice.service.ProfileService;
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
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        if (profiles != null) {
            return new ResponseEntity<>(profiles, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateProfile(@RequestBody Profile profile) {
        boolean succeeded = profileService.updateProfile(profile);
        if (succeeded) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    //post to database
    @PostMapping("/create")
    public ResponseEntity<Void> createProfile(@RequestBody User user) {
        boolean succeeded = profileService.addProfile(user);
        if (succeeded) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
