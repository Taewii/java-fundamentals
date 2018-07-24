package avatar.entities.benders;

import avatar.contracts.benders.BenderInterface;

public abstract class Bender implements BenderInterface {

    private String name;
    private int power;

    public Bender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPower() {
        return this.power;
    }
}
