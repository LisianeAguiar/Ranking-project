package rankingproject.service;

import rankingproject.domain.Player;
import rankingproject.domain.Ranking;
import rankingproject.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

public class RankingService {

    private PlayerRepository repository = new PlayerRepository();
    private Ranking ranking = new Ranking();

    public void createPlayer(Player player) {

        ranking.getRanking().add(player);

    }


    public void changePositions(String winnerId, String loserId) {

        List<Player> rankingList = ranking.getRanking();
        Player winner =ranking.findPlayerById(winnerId);
        Player loser =ranking.findPlayerById(loserId);
        int newPosition = loser.getPosition();
        rankingList.remove(winner);
        winner.setPosition(newPosition);
        rankingList.add(newPosition, winner);
    }
}
