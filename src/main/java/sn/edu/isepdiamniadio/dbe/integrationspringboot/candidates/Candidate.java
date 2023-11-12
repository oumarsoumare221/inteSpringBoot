package sn.edu.isepdiamniadio.dbe.integrationspringboot.candidates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Candidate {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String party;
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
    public String getParty() {
        return party;
    }
    public void setParty(String party) {
        this.party = party;
    }
    
    public Candidate() {
    }
    public Candidate(Long id, String name, String party) {
        this.id = id;
        this.name = name;
        this.party = party;
    }
    
    
}
