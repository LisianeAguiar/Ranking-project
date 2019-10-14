package rankingproject.repository;

import org.springframework.stereotype.Repository;
import rankingproject.domain.Game;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class GameRepository {

    private List<Game> games = new ArrayList<>();

    public GameRepository() {

        games.add(new Game("123", "789", 0, 0));


    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Game findGame(String id) {

        for (int i = 0; i < games.size(); i++) {
            if(games.get(i).getId().equals(id)){
                return games.get(i);
            }
        }
       return null;
    }

    public void saveGame(Game game) {

        games.add(game);
    }
}
