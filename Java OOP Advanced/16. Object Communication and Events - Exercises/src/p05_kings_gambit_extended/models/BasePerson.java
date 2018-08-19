package p05_kings_gambit_extended.models;

public abstract class BasePerson {

    private String name;

    protected BasePerson(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
