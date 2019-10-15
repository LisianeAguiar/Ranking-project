package rankingproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import rankingproject.domain.Game;
import rankingproject.service.GameService;

import java.util.List;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

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

    @PutMapping("/updateChallengerScore/{id}/{challengerId}")
    public ResponseEntity updateChallengerScore(@PathVariable String id, @PathVariable  String challengerId) {

        try {
            service.updateChallengerScore(id, challengerId);

        } catch (NullPointerException exception) {
            return badRequest().body("Jogo não existe");
        }

        Game game = service.getGame(id);
        return ok(game);

    }

    @PutMapping("/updateChallengedScore/{id}/{challengedId}")
    public ResponseEntity updateChallengedScore(@PathVariable String id, @PathVariable  String challengedId) {

        try {
            service.updateChallengedScore(id, challengedId);

        } catch (NullPointerException exception) {
            return badRequest().body("Jogo não existe");
        }

        Game game = service.getGame(id);
        return ok(game);
    }
}
