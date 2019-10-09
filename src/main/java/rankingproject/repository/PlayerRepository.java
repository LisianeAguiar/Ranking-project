package rankingproject.repository;

import rankingproject.domain.Player;

import java.util.List;

import static java.util.Arrays.asList;

public class PlayerRepository {

    private List<Player> players =  asList (

           new Player("Lisiane", "123"),
           new Player("Carol", "345")

    );
}
