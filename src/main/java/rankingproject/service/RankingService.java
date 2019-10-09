package rankingproject.service;

import rankingproject.domain.Player;
import rankingproject.domain.Ranking;
import rankingproject.repository.PlayerRepository;

public class RankingService {

    private PlayerRepository repository = new PlayerRepository();
    private Ranking ranking = new Ranking();

    public void createPlayer(Player player) {
        ranking.getRanking().add(player);
    }
}
