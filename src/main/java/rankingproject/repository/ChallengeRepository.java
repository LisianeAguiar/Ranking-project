package rankingproject.repository;

import rankingproject.domain.Challenge;
import rankingproject.domain.Status;

import java.util.List;

import static java.util.Arrays.asList;

public class ChallengeRepository {

    private List<Challenge> challenges = asList (

        new Challenge("222", Status.WAITING, "123", "345")
    );

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public Challenge findChallenge(String id) {

        return challenges.stream()
                .filter(challenge -> challenge.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public void save(Challenge challenge) {

        challenges.add(challenge);
    }
}
