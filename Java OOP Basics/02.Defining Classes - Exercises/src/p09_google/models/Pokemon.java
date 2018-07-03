package p09_google.models;

public class Pokemon {

    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        if (this.name == null) {
            return "";
        }
        return String.format("%s %s%n", this.name, this.type);
    }
}
