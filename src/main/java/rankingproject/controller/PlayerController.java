package rankingproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import rankingproject.domain.Player;
import rankingproject.domain.Ranking;
import rankingproject.service.PlayerService;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Service
@RestController
@RequestMapping("api/v1/Ranking")
public class PlayerController {

    private PlayerService service;

    @Autowired
    public PlayerController(PlayerService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Player>> get() {

        List<Player> list = service.showRanking();
        return ok(list);
    }

    @PostMapping
    public void createPlayer(@RequestBody Player player) {

        service.createPlayer(player);
    }


}
