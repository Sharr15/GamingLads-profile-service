package gaminglads.profileservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name= "GameMode")
@Table(name = "gameMode")
public class GameMode {


    @Getter @Setter @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int gameModeId;

    @ManyToMany
    @JoinTable(
            name = "profile_gameMode",
            joinColumns = @JoinColumn(name = "profileId"),
            inverseJoinColumns = @JoinColumn(name = "gameModeId"))
    @Getter @Setter @Column
    private List<Profile> profiles;

    @Getter @Setter @Column
    private String name;


}
