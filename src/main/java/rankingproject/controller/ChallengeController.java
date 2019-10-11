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

    @GetMapping("/list")
    public ResponseEntity<List<Challenge>> listChallenges() {

        List<Challenge> list = service.get();
        return ok(list);
    }

    @PostMapping("/createChallenge")
    public ResponseEntity createChallenge(@RequestBody ChallengeRequest request) {

        String challengerId = request.challenger;
        String challengedId = request.challenged;

        Challenge c = service.createChallenge(challengerId, challengedId);
        if (c != null) {
            return ok(c);
        }
        return badRequest().body("Posição do desafiador deve ser no máximo 3 abaixo do desafiado.");
    }

    @PostMapping("/acceptChallenge")
    public Challenge acceptChallenge(@RequestBody AcceptRejectRequest request){

        String challengedId = request.challenged;

        service.accept(request.id, request.challenged);

        return service.getChallenge(request.id);
    }


    @PostMapping("/rejectChallenge")
    public Challenge rejectChallenge(@RequestBody AcceptRejectRequest request){

        String challengedId = request.challenged;

        service.reject(request.id, request.challenged);

        return service.getChallenge(request.id);
    }
}



