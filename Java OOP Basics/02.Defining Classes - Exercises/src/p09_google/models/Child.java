package p09_google.models;

public class Child {

    private String name;
    private String birthday;

    public Child(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        if (this.name == null) {
            return "";
        }
        return String.format("%s %s%n", this.name, this.birthday);
    }
}
