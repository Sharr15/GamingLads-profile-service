package gaminglads.profileservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name= "Game")
@Table(name = "game")
public class Game {

    @Getter @Setter @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int gameId;

    @ManyToMany
    @JoinTable(
            name = "profile_game",
            joinColumns = @JoinColumn(name = "profileId"),
            inverseJoinColumns = @JoinColumn(name = "gameId"))
    @Getter @Setter @Column
    private List<Profile> profiles;

    @Getter @Setter @Column
    private String name;


}
