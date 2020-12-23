package gamingLads.profileservice.service;

import gamingLads.profileservice.model.Profile;
import gamingLads.profileservice.model.User;
import gamingLads.profileservice.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public boolean addProfile(User user){
        Profile profile = createProfile(user);
        return saveProfile(profile);
    }

    public Profile createProfile(User user){
            Profile profile = new Profile();
            profile.setUserId(user.getUserId());
            profile.setUsername(user.getUsername());
            return profile;


    }
    public boolean saveProfile(Profile profile){
        try{
            profileRepository.save(profile);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    public boolean updateProfile(Profile profile){
        try{
            Profile newProfile = new Profile();
            newProfile.setGames(profile.getGames());
            newProfile.setGameModes(profile.getGameModes());
            profileRepository.save(newProfile);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    public List<Profile> getAllProfiles(){
        List<Profile> profiles;
        profiles = profileRepository.findAll();
        return profiles;
    }
}
