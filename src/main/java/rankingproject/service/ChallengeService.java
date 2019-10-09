package rankingproject.service;

import rankingproject.domain.*;
import rankingproject.repository.ChallengeRepository;
import rankingproject.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

public class ChallengeService {

    private ChallengeRepository challenges = new ChallengeRepository();
    private PlayerRepository players = new PlayerRepository();
    private Ranking ranking = new Ranking();

    public void createChallenge(String challengerId, String challengedId) {

        Player challenger = players.findPlayerById(challengerId);
        Player challenged = players.findPlayerById(challengedId);

        if (challenger.getPosition() - challenged.getPosition() < 3) {

            String id = Double.toString(Math.random());
            Challenge challenge = new Challenge(id, Status.WAITING, challengerId, challengedId);
            challenges.save(challenge);
        }

    }

    public void accept(String id, String challengedId) {

        challenges.getChallenges();
        Challenge challenge = challenges.findChallenge(id);

        if(challenge.getChallenged().equals(challengedId)) {

            challenge.setStatus(Status.ACCEPTED);
            GameService.createGame(challenge.getChallenger(), challengedId);

        }
    }

    public void reject(String id, String challengedId) {

        challenges.getChallenges();
        Challenge challenge = challenges.findChallenge(id);
        challenge.setStatus(Status.REJECTED);

    }
}
