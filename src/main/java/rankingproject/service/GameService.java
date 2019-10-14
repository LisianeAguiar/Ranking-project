package rankingproject.service;

import org.springframework.stereotype.Service;
import rankingproject.domain.Game;
import rankingproject.domain.Player;
import rankingproject.repository.GameRepository;
import rankingproject.repository.PlayerRepository;

import java.util.List;

@Service
public class GameService {

    private GameRepository games;
    private PlayerService rankingService;

    public GameService(GameRepository games, PlayerService playerService) {

        this.games = games;
        this.rankingService = playerService;
    }
    public Game getGame(String id) {
       return games.findGame(id);
    }

    public List<Game> get() {

        return games.getGames();
    }

    public void createGame(String challenger, String challenged) {

        Game game = new Game(challenger, challenged, 0, 0);
        games.saveGame(game);

    }

    public void updateChallengerScore(String gameId, String playerId) {

        Game game = games.findGame(gameId);
        int score = 0;
        String loserId = "";

        if (game.getResult() == null) {

            if (game.getChallenger().equals(playerId)) {
                if (game.getChallengerScore() > 10) {
                    game.setResult(playerId);
                    //ganhou, atualiza o ranking
                    loserId = game.getChallenged();
                    rankingService.changePositions(playerId, loserId);

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
        int score = 0;
        String loserId = "";

        if (game.getResult() == null) {

            if (game.getChallenged().equals(playerId)) {

                if (game.getChallengedScore() > 10) {
                    game.setResult(playerId);
                    //ganhou, atualiza o ranking
                    loserId = game.getChallenger();
                    rankingService.changePositions(playerId, loserId);

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
