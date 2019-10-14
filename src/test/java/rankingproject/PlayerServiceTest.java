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
import rankingproject.service.RankingService;

import java.util.List;

import static org.mockito.Mockito.mock;

public class RankingServiceTest {

    @InjectMocks
    private ChallengeService service = mock(ChallengeService.class);

    private ChallengeRepository repository = mock(ChallengeRepository.class);

    private PlayerRepository playerRepository = mock(PlayerRepository.class);

    private Ranking ranking = mock(Ranking.class);

    private GameService gameService = mock(GameService.class);

    private RankingService rankingService = mock(RankingService.class);

    @Test
    public void shouldPass_newPlayerPositionEqualsLastPosition() {

        Player player = new Player("Lezi", "999", 8);

        rankingService.createPlayer(player);
        List<Player> ranking = rankingService.showRanking();
        Player newPlayer = ranking.get(ranking.size()-1);

       // assertThat(player.getPosition(), is(ranking.size()));
        Assert.assertEquals(ranking.size(), newPlayer.getPosition());

    }
}
