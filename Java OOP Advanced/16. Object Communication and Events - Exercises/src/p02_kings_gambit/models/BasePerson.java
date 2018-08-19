package p02_kings_gambit.models;

public abstract class BasePerson {

    private String name;

    protected BasePerson(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
