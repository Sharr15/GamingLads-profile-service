package GamingLads.profileservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class User {

    @Getter @Setter
    private String userId;

    @Getter @Setter
    private String username;

}
