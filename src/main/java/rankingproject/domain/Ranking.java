package rankingproject.domain;

import org.springframework.stereotype.Component;
import rankingproject.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class Ranking {

    private List<Player> ranking;

    public Ranking(PlayerRepository repository) {
        this.ranking = repository.getPlayers();
    }

    public List<Player> getRanking() { // retornar ranking ordenado, de acordo com a posicao


        return ranking;
    }


}
