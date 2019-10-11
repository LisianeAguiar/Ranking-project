package rankingproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import rankingproject.domain.*;
import rankingproject.repository.ChallengeRepository;
import rankingproject.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {

    private ChallengeRepository challenges;
    private PlayerRepository players;
    private Ranking ranking;
    private GameService gameService;

    @Autowired
    public ChallengeService(ChallengeRepository repository, PlayerRepository playerRepository, GameService gameService, Ranking ranking) {
        this.challenges = repository;
        this.players = playerRepository;
        this.ranking = ranking;
        this.gameService = gameService;
    }

    public Challenge getChallenge (String id) {
         return challenges.findChallenge(id);
    }

    public List<Challenge> get() {
        return challenges.getChallenges();
    }

    public Challenge createChallenge(String challengerId, String challengedId) {

        Player challenger = players.findPlayerById(challengerId);
        Player challenged = players.findPlayerById(challengedId);
        Challenge challenge = null;

        if(challenger != null && challenged != null) {
            if (challenger.getPosition() - challenged.getPosition() <= 3) {

                String id = Double.toString(Math.random());
                challenge = new Challenge(id, Status.WAITING, challengerId, challengedId);
                challenges.save(challenge);
            }
        }

        return challenge;
    }

    public void accept(String id, String challengedId) {

        Challenge challenge = challenges.findChallenge(id);

        if(challenge.getChallenged().equals(challengedId)) {

            challenge.setStatus(Status.ACCEPTED);
            gameService.createGame(challenge.getChallenger(), challengedId);
        }
    }

    public void reject(String id, String challengedId) {

        challenges.getChallenges();
        Challenge challenge = challenges.findChallenge(id);
        challenge.setStatus(Status.REJECTED);

    }
}
