package gaminglads.profileservice.controller;

import gaminglads.profileservice.exceptions.ProfileNotSavedException;
import gaminglads.profileservice.model.User;
import gaminglads.profileservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    //post to database
    @PostMapping("/create")
    public ResponseEntity<Void> createProfile(@RequestBody User user) throws ProfileNotSavedException {
        profileService.addProfile(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
