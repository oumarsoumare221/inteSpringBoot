package sn.edu.isepdiamniadio.dbe.integrationspringboot.votes;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import sn.edu.isepdiamniadio.dbe.integrationspringboot.candidates.Candidate;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nationalId;
    private LocalDate dateOfBirth;
    private String voterId;
    private String password;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    public Vote() {
    }

    public Vote(Long id, String name, String nationalId, LocalDate dateOfBirth, String voterId, String password) {
        this.id = id;
        this.name = name;
        this.nationalId = nationalId;
        this.dateOfBirth = dateOfBirth;
        this.voterId = voterId;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
