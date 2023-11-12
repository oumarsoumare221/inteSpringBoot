package sn.edu.isepdiamniadio.dbe.integrationspringboot.votes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.edu.isepdiamniadio.dbe.integrationspringboot.LoginRequest;
import sn.edu.isepdiamniadio.dbe.integrationspringboot.services.VoterService;

@RestController
@RequestMapping("/api/voters")
public class VoterController {
    @Autowired
    private VoterService voterService;

    @PostMapping("/register")
    public ResponseEntity<String> registerVoter(@RequestBody VoteEntity voteEntity) {
        try {
            voterService.registerVoter(voteEntity);
            return ResponseEntity.ok("Enregistré avec succès");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de l'enregistrement de l'électeur: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            boolean isAuthenticated = voterService.authenticateVoter(loginRequest.getVoterId(), loginRequest.getPassword());
            if (isAuthenticated) {
                return ResponseEntity.ok("Connecté avec succès");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Échec de l'authentification");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'authentification: " + e.getMessage());
        }
    }
}
