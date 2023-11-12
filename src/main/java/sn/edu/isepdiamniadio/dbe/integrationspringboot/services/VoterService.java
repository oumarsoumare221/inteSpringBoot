package sn.edu.isepdiamniadio.dbe.integrationspringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.dbe.integrationspringboot.candidates.Candidate;
import sn.edu.isepdiamniadio.dbe.integrationspringboot.repositories.CandidateRepository;
import sn.edu.isepdiamniadio.dbe.integrationspringboot.repositories.VoteEntityRepository;
import sn.edu.isepdiamniadio.dbe.integrationspringboot.repositories.VoterRepository;
import sn.edu.isepdiamniadio.dbe.integrationspringboot.votes.VoteEntity;

import java.util.Optional;

@Service
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private VoteEntityRepository voteEntityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String>registerVoter(VoteEntity voteEntity) {
        String voterId = voteEntity.getVoter().getVoterId();

        // Validation : Vérifiez si l'électeur existe déjà avec le même identifiant
        if (voterRepository.existsByVoterId(voterId)) {
            return ResponseEntity.badRequest().body("Un électeur avec le même identifiant existe déjà.");
        }

        // Hachage du mot de passe avant de le sauvegarder dans la base de données
        String hashedPassword = passwordEncoder.encode(voteEntity.getVoter().getPassword());
        voteEntity.getVoter().setPassword(hashedPassword);

        // Enregistrez l'électeur dans la base de données
        voteEntityRepository.save(voteEntity);
        return ResponseEntity.ok("Électeur enregistré avec succès");
    }

    public boolean authenticateVoter(String voterId, String password) {
        return voterRepository.findByVoterId(voterId)
                .map(vote -> passwordEncoder.matches(password, vote.getPassword()))
                .orElse(false);
    }

    public ResponseEntity<String> castVote(String voterId, Long candidateId) {
        if (voterRepository.existsByVoterIdAndCandidateId(voterId, candidateId)) {
            return ResponseEntity.badRequest().body("Vous avez déjà voté pour ce candidat.");
        }

        // Obtenez le candidat
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new IllegalArgumentException("Candidat non trouvé"));

        // Enregistrez le vote ici
        Optional<VoteEntity> existingVote = voterRepository.findByVoterId(voterId)
                .map(voter -> {
                    VoteEntity vote = new VoteEntity();
                    vote.setVoter(voter);
                    vote.setCandidate(candidate);
                    return vote;
                });

        existingVote.ifPresent(voteEntityRepository::save);

        return ResponseEntity.ok("Vote enregistré avec succès");
    }

    // Ajoutez ici les autres méthodes nécessaires pour le service Vote
}
