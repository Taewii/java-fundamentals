package app.entities.microbes;

import app.entities.cells.Cell;
import app.interfaces.microbes.MicrobeInterface;

public abstract class Microbe extends Cell implements MicrobeInterface {

    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    @Override
    public int getVirulence() {
        return this.virulence;
    }
}
