package sn.edu.isepdiamniadio.dbe.integrationspringboot.votes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import sn.edu.isepdiamniadio.dbe.integrationspringboot.candidates.Candidate;

@Entity
public class VoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "voter_id")
    private Vote voter;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    // Getters and setters

    public Vote getVoter() {
        return voter;
    }

    public void setVoter(Vote voter) {
        this.voter = voter;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
