package rankingproject.repository;

import org.springframework.stereotype.Repository;
import rankingproject.domain.Challenge;
import rankingproject.domain.Status;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class ChallengeRepository {

    private List<Challenge> challenges = new ArrayList<>();

    public ChallengeRepository() {
        challenges.add(new Challenge("111", Status.WAITING, "123", "345"));
        challenges.add(new Challenge("222", Status.WAITING, "789", "555"));
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public Challenge findChallenge(String id) {

        for (int i = 0; i < challenges.size(); i++) {
            if (challenges.get(i).getId().equals(id)) {
                return challenges.get(i);
            }
        }
        throw new RuntimeException();
    }

    public void save(Challenge challenge) {

        challenges.add(challenge);
    }
}
