package gaminglads.profileservice.service;

import gaminglads.profileservice.exceptions.ProfileNotSavedException;
import gaminglads.profileservice.model.Profile;
import gaminglads.profileservice.model.User;
import gaminglads.profileservice.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public void addProfile(User user) throws ProfileNotSavedException {
        Profile profile = createProfile(user);
        saveProfile(profile);
    }

    public Profile createProfile(User user) {
        Profile profile = new Profile();
        profile.setUserId(user.getUserId());
        profile.setUsername(user.getUsername());
        return profile;
    }

    public void saveProfile(Profile profile) throws ProfileNotSavedException {
        if (profile == null) {
            throw new ProfileNotSavedException();
        }
        profileRepository.save(profile);
    }
}
