package rankingproject.domain;

public class Player {

    private String name;
    private String id;
    private int position;

    public Player(String name, String id, int position) {
        this.name = name;
        this.id = id;
        this.position = position;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
