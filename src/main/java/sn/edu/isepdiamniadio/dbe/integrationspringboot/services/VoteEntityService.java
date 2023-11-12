package sn.edu.isepdiamniadio.dbe.integrationspringboot.services;

import org.springframework.beans.factory.annotation.Autowired;

import sn.edu.isepdiamniadio.dbe.integrationspringboot.repositories.VoteEntityRepository;

public class VoteEntityService {
     @Autowired
    private VoteEntityRepository voteRepository;

    public void castVote(String voterId, Long candidateId) {
        // Ajoutez ici la logique pour vérifier si le candidat a déjà été voté pour
        // et enregistrez le vote si ce n'est pas le cas
    }
}
