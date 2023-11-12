package sn.edu.isepdiamniadio.dbe.integrationspringboot.votes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.edu.isepdiamniadio.dbe.integrationspringboot.services.VoterService;

@RestController
@RequestMapping("/api/voting")
public class VoteController {

    @Autowired
    private VoterService voterService;

    @PostMapping("/cast-vote")
    public ResponseEntity<String> castVote(@RequestBody Vote vote) {
        try {
            // Extrayez les informations nécessaires du vote
            String voterId = vote.getVoterId();
            Long candidateId = vote.getId();

            // Appelez la méthode du service avec les informations extraites
            return voterService.castVote(voterId, candidateId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de l'enregistrement du vote: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerVoter(@RequestBody VoteEntity voteEntity) {
        return voterService.registerVoter(voteEntity);
    }
}
