package rankingproject.domain;

public class Challenge {

    private String id;
    private Status status;
    private String challengerId;
    private String challengedId;

    public Challenge(String id, Status status, String challengerId, String challengedId) {
        this.id = id;
        this.status = status;
        this.challengerId = challengerId;
        this.challengedId = challengedId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getChallenger() {
        return challengerId;
    }

    public void setChallenger(String challenger) {
        this.challengerId = challenger;
    }

    public String getChallenged() {
        return challengedId;
    }

    public void setChallenged(String challenged) {
        this.challengedId = challenged;
    }
}
