package rankingproject.domain;

public class Challenge {

    private String id;
    private Status status;
    private Player challenger;
    private Player challenged;

    public Challenge(String id, Status status, Player challenger, Player challenged) {
        this.id = id;
        this.status = status;
        this.challenger = challenger;
        this.challenged = challenged;
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

    public Player getChallenger() {
        return challenger;
    }

    public void setChallenger(Player challenger) {
        this.challenger = challenger;
    }

    public Player getChallenged() {
        return challenged;
    }

    public void setChallenged(Player challenged) {
        this.challenged = challenged;
    }
}
