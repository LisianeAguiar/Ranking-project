package rankingproject;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import rankingproject.domain.Player;
import rankingproject.domain.Ranking;
import rankingproject.repository.ChallengeRepository;
import rankingproject.repository.PlayerRepository;
import rankingproject.service.ChallengeService;
import rankingproject.service.GameService;
import rankingproject.service.PlayerService;


import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerServiceTest {

    @InjectMocks
    //private ChallengeService service = mock(ChallengeService.class);

    private ChallengeRepository repository = mock(ChallengeRepository.class);

    private PlayerRepository playerRepository = mock(PlayerRepository.class);

    private Ranking ranking = mock(Ranking.class);

    private GameService gameService = mock(GameService.class);

    private PlayerService playerService = mock(PlayerService.class);

    @Test
    public void shouldPass_newPlayerPositionEqualsLastPosition() {

        PlayerService service = new PlayerService(playerRepository);
        Player player = new Player("Lezi", "999", 8);

         List<Player> players =  new ArrayList<>();

         players.add(new Player("Lisiane", "123",3));
         players.add(new Player("Carol", "345",5));
         players.add(new Player("Rafael", "567",4));
         players.add(new Player("Eduardo", "789",2));
         players.add(new Player("Nilta", "555",6));
         players.add(new Player("Neiva", "777",1));

        when(playerRepository.getPlayers()).thenReturn(players);

        service.createPlayer(player);
        List<Player> ranking = service.showRanking();
        Player newPlayer = ranking.get(ranking.size()-1);

        assertThat(player.getPosition(), is(ranking.size()));

    }
}
