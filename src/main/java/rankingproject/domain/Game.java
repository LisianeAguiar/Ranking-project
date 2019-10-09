package rankingproject.domain;

public class Game {

    private String id;
    private String challenger;
    private String challenged;
    private int challengerScore;
    private int challengedScore;
    private String winnerId;

    public Game(String id, String challenger, String challenged,
                int challengerScore, int challengedScore) {
        this.id = id;
        this.challenger = challenger;
        this.challenged = challenged;
        this.challengerScore = challengerScore;
        this.challengedScore = challengedScore;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChallenger() {
        return challenger;
    }

    public void setChallenger(String challenger) {
        this.challenger = challenger;
    }

    public String getChallenged() {
        return challenged;
    }

    public void setChallenged(String challenged) {
        this.challenged = challenged;
    }

    public int getChallengerScore() {
        return challengerScore;
    }

    public void setChallengerScore(int challengerScore) {
        this.challengerScore = challengerScore;
    }

    public int getChallengedScore() {
        return challengedScore;
    }

    public void setChallengedScore(int challengedScore) {
        this.challengedScore = challengedScore;
    }

    public String getResult() {
        return winnerId;
    }

    public void setResult(String id) {
        this.winnerId = id;
    }
}
