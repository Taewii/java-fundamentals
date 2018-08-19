package p05_kings_gambit_extended.models;

import p05_kings_gambit_extended.interfaces.Responder;

public class RoyalGuard extends BasePerson implements Responder {

    private int health;

    public RoyalGuard(String name) {
        super(name);
        this.health = 3;
    }

    public void kill() {
        this.health--;
    }

    @Override
    public void respond() {
        if (this.health > 0) {
            System.out.println(String.format("Royal Guard %s is defending!", super.getName()));
        }
    }
}
