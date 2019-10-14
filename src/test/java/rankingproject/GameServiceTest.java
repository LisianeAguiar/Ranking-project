package rankingproject;

import org.junit.Test;
import org.mockito.InjectMocks;
import rankingproject.domain.Game;
import rankingproject.domain.Player;
import rankingproject.domain.Ranking;
import rankingproject.repository.ChallengeRepository;
import rankingproject.repository.GameRepository;
import rankingproject.repository.PlayerRepository;
import rankingproject.service.ChallengeService;
import rankingproject.service.GameService;
import rankingproject.service.PlayerService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameServiceTest {

    @InjectMocks

    private GameRepository gameRepository = mock(GameRepository.class);

    private PlayerService playerService = mock(PlayerService.class);

    private GameService gameService = new GameService(gameRepository,playerService );

    @Test
    public void shouldPass_challengerScoreUpdates() {

        Player challenger = new Player("Lis", "666", 2);
        Player challenged = new Player("Gui", "999", 1);

        Game game = new Game("666","999", 0, 0);

        when(gameRepository.findGame(anyString())).thenReturn(game);

        int scoreBeforeUpdate = game.getChallengerScore();
        gameService.updateChallengerScore(game.getId(), challenger.getId());

        assertThat(game.getChallengerScore(), is(scoreBeforeUpdate+1));

    }

    @Test
    public void shouldFail_challengerScoreDoesntUpdate() {

        Player challenger = new Player("Lis", "666", 2);
        Player challenged = new Player("Gui", "999", 1);

        Game game = new Game("666","999", 0, 0);

        when(gameRepository.findGame(anyString())).thenReturn(game);

        int scoreBeforeUpdate = game.getChallengerScore();
        gameService.updateChallengerScore(game.getId(), challenger.getId());

        assertThat(game.getChallengerScore(), is(scoreBeforeUpdate));

    }

    @Test
    public void shouldPass_challengedScoreUpdates() {

        Player challenger = new Player("Lis", "666", 2);
        Player challenged = new Player("Gui", "999", 1);

        Game game = new Game("666","999", 0, 0);

        when(gameRepository.findGame(anyString())).thenReturn(game);

        int scoreBeforeUpdate = game.getChallengedScore();
        gameService.updateChallengedScore(game.getId(), challenged.getId());

        assertThat(game.getChallengedScore(), is(scoreBeforeUpdate+1));

    }

    @Test
    public void shouldFail_challengedScoreDoesntUpdate() {

        Player challenger = new Player("Lis", "666", 2);
        Player challenged = new Player("Gui", "999", 1);

        Game game = new Game("666","999", 0, 0);

        when(gameRepository.findGame(anyString())).thenReturn(game);

        int scoreBeforeUpdate = game.getChallengedScore();
        gameService.updateChallengedScore(game.getId(), challenged.getId());

        assertThat(game.getChallengedScore(), is(scoreBeforeUpdate));

    }
}
