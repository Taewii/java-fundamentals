package p08_military_elite.models;

import p08_military_elite.contracts.SoldierInterface;

public abstract class Soldier implements SoldierInterface {

    private int id;
    private String firstName;
    private String lastName;

    protected Soldier(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
