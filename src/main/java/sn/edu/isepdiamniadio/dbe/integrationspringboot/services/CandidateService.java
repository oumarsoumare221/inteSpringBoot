package sn.edu.isepdiamniadio.dbe.integrationspringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.dbe.integrationspringboot.candidates.Candidate;
import sn.edu.isepdiamniadio.dbe.integrationspringboot.repositories.CandidateRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(Long id) {
        Optional<Candidate> candidateOptional = candidateRepository.findById(id);
        return candidateOptional.orElse(null);
    }

    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }

    public Candidate createCandidate(Candidate candidate) {
        if (candidate == null || candidate.getId() != null) {
            throw new RuntimeException("L'identifiant du candidat est invalide.");
        }

        Optional<Candidate> existingCandidate = candidateRepository.findById(candidate.getId());
        if (existingCandidate.isPresent()) {
            throw new RuntimeException("Un candidat avec le même identifiant existe déjà.");
        }

        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(Long id, Candidate updatedCandidate) {
        if (id == null || updatedCandidate == null) {
            throw new IllegalArgumentException("L'ID du candidat et le candidat mis à jour sont obligatoires.");
        }

        Optional<Candidate> existingCandidate = candidateRepository.findById(id);
        if (existingCandidate.isPresent()) {
            // Mettez à jour les champs du candidat existant avec les nouvelles valeurs.
            Candidate candidateToUpdate = existingCandidate.get();
            candidateToUpdate.setName(updatedCandidate.getName());
            candidateToUpdate.setParty(updatedCandidate.getParty());

            return candidateRepository.save(candidateToUpdate);
        } else {
            return null; // Retournez null si le candidat n'existe pas.
        }
    }
}
