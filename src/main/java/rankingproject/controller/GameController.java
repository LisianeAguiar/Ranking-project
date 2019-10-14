package rankingproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import rankingproject.domain.Game;
import rankingproject.service.GameService;

import java.util.List;

@RestController
@RequestMapping("api/v1/Game")

public class GameController {

    private GameService service;

    @Autowired
    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping("/showGames")
    public List<Game> showGames() {

        return service.get();
    }

    @PostMapping("/updateChallengerScore/{id}/{challengerId}")
    public void updateChallengerScore(@PathVariable String id, @PathVariable  String challengerId) {

        service.updateChallengerScore(id, challengerId);

    }

    @PostMapping("/updateChallengedScore/{id}/{challengedId}")
    public void updateChallengedScore(@PathVariable String id, @PathVariable  String challengedId) {

        service.updateChallengedScore(id, challengedId);

    }
}
