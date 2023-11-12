package sn.edu.isepdiamniadio.dbe.integrationspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sn.edu.isepdiamniadio.dbe.integrationspringboot.votes.VoteEntity;

import java.util.List;

@Repository
public interface VoteEntityRepository extends JpaRepository<VoteEntity, Long> {

    // Exemple de requête native SQL pour obtenir les 3 premiers candidats avec leurs votes
    @Query(value = "SELECT candidate_id, COUNT(candidate_id) as vote_count " +
                   "FROM vote_entity " +
                   "GROUP BY candidate_id " +
                   "ORDER BY vote_count DESC " +
                   "LIMIT 3", nativeQuery = true)
    List<Object[]> findTopCandidates();
}
