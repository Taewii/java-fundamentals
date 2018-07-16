package p08_military_elite.models;

public class Spy extends Soldier {

    private String codeNumber;

    public Spy(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s%nCode Number: %s%n", getFirstName(), getLastName(), getId(), this.codeNumber);
    }
}
