package rankingproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import rankingproject.domain.GenerateId;
import rankingproject.domain.Player;
import rankingproject.domain.Ranking;
import rankingproject.repository.PlayerRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;
    private GenerateId generateId;

    public PlayerService(PlayerRepository repository, GenerateId generateId) {
        this.repository = repository;
        this.generateId = generateId;
    }

    public void createPlayer(Player player) {

        List<Player> list = repository.getPlayers();
        if (list.size() == 0) {
            player.setPosition(1);
            repository.save(player);
        }
        else {
            list.sort(Comparator.comparing(Player::getPosition));
            int lastPosition = list.get( list.size() -1 ).getPosition();
            player.setPosition(lastPosition + 1);
            repository.save(player);
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
        
        List<Player> list = repository.getPlayers();
        list.sort(Comparator.comparing(Player::getPosition));
        return list;
    }
}
