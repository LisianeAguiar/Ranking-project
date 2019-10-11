package rankingproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import rankingproject.domain.Player;
import rankingproject.domain.Ranking;
import rankingproject.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

@Service
public class RankingService {

    @Autowired
    private PlayerRepository repository;
    @Autowired
    private Ranking ranking;

    public RankingService() {
    }

    public void createPlayer(Player player) {

        List<Player> list = ranking.getRanking();
        bubbleSort(list);
        int lastPosition = list.get( list.size() -1 ).getPosition();
        player.setPosition(lastPosition + 1);
        repository.getPlayers().add(player);

    }

    public void bubbleSort(List<Player> list){

        boolean troca = true;
        Player aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getPosition() > list.get(i+1).getPosition()) {
                    aux = list.get(i);
                    list.set(i, list.get(i +1));
                    list.set(i + 1, aux);
                    troca = true;
                }
            }
        }
    }

    public void changePositions(String winnerId, String loserId) {

         Player winner = repository.findPlayerById(winnerId);
         Player loser = repository.findPlayerById(loserId);

        List<Player> players = repository.getPlayers();

        int winnerPosition = winner.getPosition();
        int loserPosition = loser.getPosition();
        Player current;

        for (int i = 0; i < players.size(); i ++) {

            current = players.get(i);
            if ( (current.getId() != winner.getId()) &&  (current.getId() != loser.getId())) {

                if(current.getPosition() < winnerPosition && current.getPosition() > loserPosition) {
                    current.setPosition(current.getPosition() + 1);
                }
            }
        }
        if (winnerPosition != 1) {
            loser.setPosition(loserPosition+1);
            winner.setPosition(loserPosition);
        }
    }

    public List<Player> showRanking() {

        bubbleSort(ranking.getRanking());
        return ranking.getRanking();
    }
}
