package rankingproject.service;

import rankingproject.domain.Game;
import rankingproject.domain.Player;
import rankingproject.repository.GameRepository;

public class GameService {

    private static GameRepository games = new GameRepository();

    public static void createGame(String challenger, String challenged) {

        String id = Double.toString(Math.random());
        Game game = new Game(id, challenger, challenged, 0, 0);
        games.saveGame(game);

    }

    public void updateScore(String gameId, String playerId) {

        Game game = games.findGame(gameId);
        int score = 0;

        if (game.getChallenged().equals(playerId)) {
            score = game.getChallengedScore();
            game.setChallengedScore(score++);
        }
        score = game.getChallengerScore();
        game.setChallengerScore(score++);

    }

}
