package rankingproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import rankingproject.domain.Challenge;
import rankingproject.domain.Ranking;
import rankingproject.domain.Status;
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

    private ChallengeRepository repository = mock(ChallengeRepository.class);

    private PlayerRepository playerRepository = mock(PlayerRepository.class);

    private GameService gameService = mock(GameService.class);

    private ChallengeService service = new ChallengeService(repository, playerRepository, gameService);

    private Challenge challenge;

    public ChallengeServiceTest() {

        challenge = new Challenge("555", Status.WAITING, "123", "345");

    }
    @Test
    public void accept_shouldFail_playerIdDifferentFromChallangedId() {

       // ChallengeService service = new ChallengeService(repository, playerRepository, gameService, ranking);

        //Challenge challenge = new Challenge("555", Status.WAITING, "123", "345");

        when(repository.findChallenge(anyString())).thenReturn(challenge);

        service.accept(challenge.getId(), "444");
        assertThat(challenge.getStatus(), is(Status.ACCEPTED));
    }

    @Test
    public void reject_shouldFail_playerIdDifferentFromChallangedId() {

       // Challenge challenge = new Challenge("555", Status.WAITING, "123", "345");

        when(repository.findChallenge(anyString())).thenReturn(challenge);

        service.accept(challenge.getId(), "444");
        assertThat(challenge.getStatus(), is(Status.REJECTED));
    }

    @Test
    public void accept_shouldPass_playerIdEqualsChallangedId() {

      //  Challenge challenge = new Challenge("555", Status.WAITING, "123", "345");

        when(repository.findChallenge("555")).thenReturn(challenge);

        service.accept(challenge.getId(), "345");
        assertThat(challenge.getStatus(), is(Status.ACCEPTED));
    }

    @Test
    public void reject_shouldPass_playerIdEqualsFromChallangedId() {

      //  Challenge challenge = new Challenge("555", Status.WAITING, "123", "345");

        when(repository.findChallenge(anyString())).thenReturn(challenge);

        service.accept(challenge.getId(), "345");
        assertThat(challenge.getStatus(), is(Status.ACCEPTED));
    }

    //testar se a criacao de um desafio gera um game
    @Test
    public void shouldPass_challengeGeneratesGame() {

       // Challenge challenge = new Challenge();
    }

}
