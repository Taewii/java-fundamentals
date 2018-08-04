package p02_warning_levels;

public class Message {

    private Importance importance;
    private String message;

    public Message(Importance importance, String message) {
        this.importance = importance;
        this.message = message;
    }

    public Importance getImportance() {
        return this.importance;
    }

    @Override
    public String toString() {
        return this.importance + ": " + this.message;
    }
}
