package rankingproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import rankingproject.domain.*;
import rankingproject.repository.ChallengeRepository;
import rankingproject.repository.PlayerRepository;
import rankingproject.service.ChallengeService;
import rankingproject.service.GameService;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
public class ChallengeServiceTest {

    @InjectMocks

    private ChallengeRepository challengeRepository = mock(ChallengeRepository.class);

    private PlayerRepository playerRepository = mock(PlayerRepository.class);

    private GameService gameService = mock(GameService.class);

    private ChallengeService challengeService = new ChallengeService(challengeRepository, playerRepository, gameService);

    private Challenge challenge;

    public ChallengeServiceTest() {

        challenge = new Challenge("555", Status.WAITING, "123", "345");

    }
    @Test
    public void accept_shouldFail_playerIdDifferentFromChallangedId() {

        when(challengeRepository.findChallenge(anyString())).thenReturn(challenge);

        challengeService.accept(challenge.getId(), "444");
        assertThat(challenge.getStatus(), is(Status.ACCEPTED));
    }

    @Test
    public void reject_shouldFail_playerIdDifferentFromChallangedId() {

        when(challengeRepository.findChallenge(anyString())).thenReturn(challenge);

        challengeService.accept(challenge.getId(), "444");
        assertThat(challenge.getStatus(), is(Status.REJECTED));
    }

    @Test
    public void accept_shouldPass_playerIdEqualsChallangedId() {

        when(challengeRepository.findChallenge("555")).thenReturn(challenge);

        challengeService.accept(challenge.getId(), "345");
        assertThat(challenge.getStatus(), is(Status.ACCEPTED));
    }

    @Test
    public void reject_shouldPass_playerIdEqualsFromChallangedId() {

        when(challengeRepository.findChallenge(anyString())).thenReturn(challenge);

        challengeService.accept(challenge.getId(), "345");
        assertThat(challenge.getStatus(), is(Status.ACCEPTED));
    }

    @Test
    public void challengeCanChallenge_shouldPass_ChallengerPositionGreaterThanChallenged() {

        Player challenger = new Player("Lis", "666", 3);
        Player challenged = new Player("Gui", "999", 1);

        boolean result = challengeService.challengerCanChallenge(challenger,challenged);
        assertTrue(result);
    }

    @Test
    public void challengeCanChallenge_shouldFail_ChallengerPositionLessThanChallenged() {

        Player challenger = new Player("Lis", "666", 3);
        Player challenged = new Player("Gui", "999", 7);

        boolean result = challengeService.challengerCanChallenge(challenger,challenged);
        assertTrue(result);
    }
}
