package rankingproject;

import org.junit.Test;
import rankingproject.domain.Challenge;
import rankingproject.domain.Status;
import rankingproject.service.ChallengeService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChallengeServiceTest {

    private ChallengeService service = new ChallengeService();
    @Test
    public void shouldFail_playerIdDifferentFromChallangedId () {

        Challenge underTest =  new Challenge("222", Status.WAITING, "123", "345");
        service.accept("222", "444");
        assertThat(underTest.getStatus(), is(Status.ACCEPTED));
    }


}
