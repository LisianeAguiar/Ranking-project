package rankingproject.domain;

import java.util.ArrayList;
import java.util.List;

public class Ranking {

    private List<String> ranking;

    public Ranking() {
        this.ranking = new ArrayList<>();
    }

    public List<String> getRanking() {
        return ranking;
    }


}
