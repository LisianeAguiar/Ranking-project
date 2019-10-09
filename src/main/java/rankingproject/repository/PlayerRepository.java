package rankingproject.repository;

import rankingproject.domain.Player;

import java.util.List;

import static java.util.Arrays.asList;

public class PlayerRepository {

    private List<Player> players =  asList (

           new Player("Lisiane", "123",0),
           new Player("Carol", "345",1)

    );

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player findPlayerById(String id) {

        return getPlayers()
                .stream()
                .filter(player -> player.getId().equals(id))
                .findAny()
                .orElse(null);
    }
}
