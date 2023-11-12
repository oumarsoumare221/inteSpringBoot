package sn.edu.isepdiamniadio.dbe.integrationspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.edu.isepdiamniadio.dbe.integrationspringboot.candidates.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    
}
