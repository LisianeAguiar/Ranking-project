package rankingproject.domain;

public class Game {

    private String id;
    private int score;
    private Player challenger;
    private Player challenged;
    private int challengerScore;
    private int challengedScore;
    private Player result;

    public Game(String id, int score, Player challenger, Player challenged,
                int challengerScore, int challengedScore, Player result) {
        this.id = id;
        this.score = score;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public Player getResult() {
        return result;
    }

    public void setResult(Player result) {
        this.result = result;
    }
}
