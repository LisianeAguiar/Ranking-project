package rankingproject;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import rankingproject.domain.GenerateId;
import rankingproject.domain.Player;
import rankingproject.domain.Ranking;
import rankingproject.repository.PlayerRepository;
import rankingproject.service.PlayerService;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class PlayerServiceTest {

    private PlayerRepository playerRepository = mock(PlayerRepository.class);

    private GenerateId generateId = mock(GenerateId.class);

    private PlayerService playerService = new PlayerService(playerRepository,generateId);

    private List<Player> players = new ArrayList<>();

    public PlayerServiceTest() {
        players.add(new Player("Lisiane", "123",3));
        players.add(new Player("Carol", "345",5));
        players.add(new Player("Rafael", "567",4));
        players.add(new Player("Eduardo", "789",2));
        players.add(new Player("Nilta", "555",6));
        players.add(new Player("Neiva", "777",1));

    }

    @Test
    public void shouldPass_newPlayerPositionEqualsLastPosition() {

        when(playerRepository.getPlayers()).thenReturn(players);
        Player player = new Player("Osman", "688", 0);

        int currentRankingSize = players.size();
        playerService.createPlayer(player);
        int newRankingSize = currentRankingSize + 1;

        assertThat(player.getPosition(), is(newRankingSize));

    }

    @Test
    public void shouldFail_newPlayerPositionDifferentFromLastPosition() {

        when(playerRepository.getPlayers()).thenReturn(players);
        Player player = new Player("Osman", "688", 0);
        playerService.createPlayer(player);

        int currentRankingSize = players.size();
        playerService.createPlayer(player);
       // int newRankingSize = currentRankingSize + 1;

        assertThat(player.getPosition(), is(currentRankingSize));

    }

    @Test
    public void shouldPass_changePositionWhenPlayerWins() {

        Player winner = players.get(2);
        Player loser = players.get(3);

        when(playerRepository.findPlayerById(winner.getId())).thenReturn(winner);
        when(playerRepository.findPlayerById(loser.getId())).thenReturn(loser);
        when(playerRepository.getPlayers()).thenReturn(players);

        int newWinnerPosition = loser.getPosition();
        int newLoserPosition = loser.getPosition()+1;

        playerService.changePositions(winner.getId(), loser.getId());

        assertThat(winner.getPosition(), is(newWinnerPosition));
    }

    @Test
    public void shouldPass_newPlayerIsAddedToList() {

        Player player = new Player("Osman", "688", 0);
        when(playerRepository.getPlayers()).thenReturn(players);
        playerService.createPlayer(player);
        verify(playerRepository).save(any(Player.class));

    }

}
