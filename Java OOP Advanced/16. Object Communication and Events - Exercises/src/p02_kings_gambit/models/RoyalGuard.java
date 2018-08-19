package p02_kings_gambit.models;

import p02_kings_gambit.interfaces.Responder;

public class RoyalGuard extends BasePerson implements Responder {

    private boolean isAlive;

    public RoyalGuard(String name) {
        super(name);
        this.isAlive = true;
    }

    @Override
    public void respond() {
        if (isAlive) {
            System.out.println(String.format("Royal Guard %s is defending!", super.getName()));
        }
    }

    public void kill() {
        this.isAlive = false;
    }
}
