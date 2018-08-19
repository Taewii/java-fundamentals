package p02_kings_gambit.models;

import p02_kings_gambit.interfaces.Responder;

public class FootMan extends BasePerson implements Responder {

    private boolean isAlive;

    public FootMan(String name) {
        super(name);
        this.isAlive = true;
    }

    public void kill() {
        this.isAlive = false;
    }


    @Override
    public void respond() {
        if (isAlive) {
            System.out.println(String.format("Footman %s is panicking!", super.getName()));
        }
    }
}
