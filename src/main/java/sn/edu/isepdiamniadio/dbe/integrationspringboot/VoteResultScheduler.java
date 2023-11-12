package sn.edu.isepdiamniadio.dbe.integrationspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sn.edu.isepdiamniadio.dbe.integrationspringboot.repositories.VoteEntityRepository;

import java.util.List;

@Component
public class VoteResultScheduler {

    private final VoteEntityRepository voteEntityRepository;

    @Autowired
    public VoteResultScheduler(VoteEntityRepository voteEntityRepository) {
        this.voteEntityRepository = voteEntityRepository;
    }

    public void displayTopCandidates() {
        // Ajoutez ici la logique pour afficher les 3 premiers candidats avec leurs votes
        List<Object[]> topCandidates = voteEntityRepository.findTopCandidates();
        // Affichez les résultats sur la console 
             for (Object[] result : topCandidates) {
            System.out.println("Candidat: " + result[0] + ", Votes: " + result[1]);
        }
    }
}


