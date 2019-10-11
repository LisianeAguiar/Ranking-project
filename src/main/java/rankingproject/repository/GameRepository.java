package rankingproject.repository;

import rankingproject.domain.Game;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class GameRepository {

    private List<Game> games = new ArrayList<>();

    public GameRepository() {

        games.add(new Game("123", "789", 0, 0));
     //   games.add(new Game("555", "567", 0, 0));

    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Game findGame(String id) {

        return games.stream()
                .filter(game -> game.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public void saveGame(Game game) {

        games.add(game);
    }
}
