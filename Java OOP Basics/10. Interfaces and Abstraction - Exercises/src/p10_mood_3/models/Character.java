package p10_mood_3.models;

public abstract class Character {

    private String type;
    private String username;
    private int level;

    public Character(String username, String type, int level) {
        this.type = type;
        this.username = username;
        this.level = level;
    }

    public String getUsername() {
        return this.username;
    }

    public int getLevel() {
        return this.level;
    }

    public String getType() {
        return this.type;
    }
}
