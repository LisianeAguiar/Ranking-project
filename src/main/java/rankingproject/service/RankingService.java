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

        int lastPosition = ranking.getRanking().size();
        player.setPosition(lastPosition);


    }

    public void changePositions(String winnerId, String loserId) {

        Player winner =repository.findPlayerById(winnerId);
        Player loser =repository.findPlayerById(loserId);

        List<Player> players = repository.getPlayers();
        int loserOldPos = loser.getPosition();  // 1

        winner.setPosition(loserOldPos);
        loser.setPosition(loserOldPos + 1);
        int lastPosition = loserOldPos + 1;

        int i = 0;
        Player player;

        while (i < players.size()) {

            player = players.get(i);

            if (player.getPosition() >= loser.getPosition() && player != loser && player != winner) {
                player.setPosition(lastPosition++);
            }

        }


    }
}
