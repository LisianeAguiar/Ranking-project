package rankingproject.service;

import org.springframework.stereotype.Service;
import rankingproject.domain.Game;
import rankingproject.domain.GenerateId;
import rankingproject.repository.GameRepository;

import java.util.List;

@Service
public class GameService {

    private GameRepository games;
    private PlayerService playerService;
    private GenerateId generateId;

    public GameService(GameRepository games, PlayerService playerService, GenerateId generateId) {

        this.games = games;
        this.playerService = playerService;
        this.generateId = generateId;
    }

    public Game getGame(String id) {

        return games.findGame(id);
    }

    public List<Game> get() {

        return games.getGames();
    }

    public void createGame(String challenger, String challenged) {

        Game game = new Game(generateId.generateId(), challenger, challenged, 0, 0);
        games.saveGame(game);

    }

    public void updateChallengerScore(String gameId, String playerId) {

        Game game = games.findGame(gameId);

        if (game == null) {
            throw new NullPointerException();
        }

        int score = 0;
        String loserId = "";

        if (game.getResult() == null) {

            if (game.getChallenger().equals(playerId)) {
                if (game.getChallengerScore() >= 10) {
                    game.setResult(playerId);
                    loserId = game.getChallenged();
                    playerService.changePositions(playerId, loserId);

                }
                else {

                    score = game.getChallengerScore();
                    score++;
                    game.setChallengerScore(score);


                }
            }
        }
    }

    public void updateChallengedScore(String gameId, String playerId) {

        Game game = games.findGame(gameId);

        if (game == null) {
            throw new NullPointerException();
        }

        int score = 0;
        String loserId = "";

        if (game.getResult() == null) {

            if (game.getChallenged().equals(playerId)) {

                if (game.getChallengedScore() >= 10) {
                    game.setResult(playerId);

                }
                else {
                    score = game.getChallengedScore();
                    score++;
                    game.setChallengedScore(score);

                }
            }
        }
    }



}
