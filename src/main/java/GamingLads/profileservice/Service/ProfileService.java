package GamingLads.profileservice.Service;

import GamingLads.profileservice.Model.Profile;
import GamingLads.profileservice.Model.User;
import GamingLads.profileservice.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(final ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

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
        try{
            profiles = (List<Profile>) profileRepository.findAll();
        }
        catch(Exception e){
            return null;
        }
        return profiles;
    }
}
