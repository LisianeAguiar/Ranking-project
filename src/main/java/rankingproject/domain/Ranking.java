package rankingproject.domain;

import java.util.ArrayList;
import java.util.List;

public class Ranking {

    private List<Player> ranking;

    public Ranking() {
        this.ranking = new ArrayList<>();
    }

    public List<Player> getRanking() {
        return ranking;
    }

    public Player findPlayerById(String id) {

        return getRanking()
                .stream()
                .filter(player -> player.getId().equals(id))
                .findAny()
                .orElse(null);
    }

}
