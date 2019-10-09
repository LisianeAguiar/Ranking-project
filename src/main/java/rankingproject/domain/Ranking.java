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


}
