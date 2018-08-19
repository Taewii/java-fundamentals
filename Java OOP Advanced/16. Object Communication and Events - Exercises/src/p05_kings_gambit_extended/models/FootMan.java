package p05_kings_gambit_extended.models;

import p05_kings_gambit_extended.interfaces.Responder;

public class FootMan extends BasePerson implements Responder {

    private int health;

    public FootMan(String name) {
        super(name);
        this.health = 2;
    }

    @Override
    public void kill() {
        this.health--;
    }

    @Override
    public void respond() {
        if (this.health > 0) {
            System.out.println(String.format("Footman %s is panicking!", super.getName()));
        }
    }
}
