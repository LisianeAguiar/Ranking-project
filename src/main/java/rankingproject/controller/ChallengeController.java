package rankingproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import rankingproject.domain.Challenge;
import rankingproject.domain.Status;
import rankingproject.service.ChallengeService;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@Service
@RestController
@RequestMapping("api/v1/Challenges")
public class ChallengeController {

    private ChallengeService service;

    @Autowired
    public ChallengeController(ChallengeService service) {
        this.service = service;
    }

    @GetMapping("/showChallenges")
    public ResponseEntity<List<Challenge>> listChallenges() {

        List<Challenge> list = service.get();
        return ok(list);
    }

    @PostMapping("/createChallenge")
    public ResponseEntity createChallenge(@RequestBody ChallengeRequest request) {

        String challengerId = request.challenger;
        String challengedId = request.challenged;

        Challenge challenge;
        try {
            challenge = service.createChallenge(challengerId, challengedId);

        } catch (IllegalArgumentException exception) {
            return badRequest().body("ChallengerID ou ChallengedID inválidos");
        }

        if (challenge != null) {
            return ok(challenge);
        }
        return badRequest().body("Não é possível desafiar a pessoa.");

    }

    @PutMapping("/acceptChallenge/{id}/{challengedId}")
    public ResponseEntity acceptChallenge(@PathVariable String id, @PathVariable String challengedId){

        service.accept(id, challengedId);

        Challenge challenge = service.getChallenge(id);
        if (challenge != null) {
            return ok(challenge);
        }
        return badRequest().body("Desafio inexistente.");
    }


    @PutMapping("/rejectChallenge/{id}/{challengedId}")
    public ResponseEntity rejectChallenge(@PathVariable String id, @PathVariable String challengedId){

        service.reject(id, challengedId);

        Challenge challenge = service.getChallenge(id);
        if (challenge != null) {
            return ok(challenge);
        }
        return badRequest().body("Desafio inexistente.");
    }
}



