package sn.edu.isepdiamniadio.dbe.integrationspringboot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.edu.isepdiamniadio.dbe.integrationspringboot.votes.Vote;

@Repository
public interface VoterRepository extends JpaRepository<Vote, Long> {
    boolean existsByVoterIdAndCandidateId(String voterId, Long candidateId);
    
    boolean existsByVoterId(String voterId);
    
    Optional<Vote> findByVoterId(String voterId);

}
