package rankingproject.repository;

import org.springframework.stereotype.Repository;
import rankingproject.domain.Player;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class PlayerRepository {

    private List<Player> players =  new ArrayList<>();

    public PlayerRepository() {

        players.add(new Player("Lisiane", "123",3));
        players.add(new Player("Carol", "345",5));
        players.add(new Player("Rafael", "567",4));
        players.add(new Player("Eduardo", "789",2));
        players.add(new Player("Nilta", "555",6));
        players.add(new Player("Neiva", "777",1));

    }



    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player findPlayerById(String id) {

        String playerId;
        for(int i = 0; i < getPlayers().size(); i++) {
            if (getPlayers().get(i).getId().equals(id)) {
                return getPlayers().get(i);
            }
        }
        return null;
    }
}
