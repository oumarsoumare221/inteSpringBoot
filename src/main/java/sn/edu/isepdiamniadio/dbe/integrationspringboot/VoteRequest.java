package sn.edu.isepdiamniadio.dbe.integrationspringboot;

public class VoteRequest {
    private String voterId;
    private Long candidateId;

    

    public VoteRequest() {
    }

    public VoteRequest(String voterId, Long candidateId) {
        this.voterId = voterId;
        this.candidateId = candidateId;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }
}
