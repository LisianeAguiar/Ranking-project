package rankingproject;

import org.mockito.InjectMocks;
import rankingproject.domain.Ranking;
import rankingproject.repository.ChallengeRepository;
import rankingproject.repository.PlayerRepository;
import rankingproject.service.ChallengeService;
import rankingproject.service.GameService;

import static org.mockito.Mockito.mock;

public class GameServiceTest {

    @InjectMocks
    private ChallengeService service = mock(ChallengeService.class);

    private ChallengeRepository repository = mock(ChallengeRepository.class);

    private PlayerRepository playerRepository = mock(PlayerRepository.class);

    private Ranking ranking = mock(Ranking.class);

    private GameService gameService = mock(GameService.class);
}
