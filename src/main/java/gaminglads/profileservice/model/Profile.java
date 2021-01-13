package gaminglads.profileservice.model;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Profile")
@Table(name = "profile")
public class Profile {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileId;

    @Getter
    @Setter
    @Column
    private int userId;

    @Getter
    @Setter
    @Column
    private String username;

    @ManyToMany(mappedBy = "profiles")
    @Getter
    @Setter
    @Column
    @Nullable
    private List<Game> games;

    @ManyToMany(mappedBy = "profiles")
    @Getter
    @Setter
    @Column
    @Nullable
    private List<GameMode> gameModes;
}
