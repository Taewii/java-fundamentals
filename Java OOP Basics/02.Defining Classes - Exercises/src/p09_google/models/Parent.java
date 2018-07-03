package p09_google.models;

public class Parent {

    private String name;
    private String birthday;

    public Parent(String name, String birthday) {
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
