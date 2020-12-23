package gamingLads.profileservice.repository;

import gamingLads.profileservice.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository @EnableJpaRepositories
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
