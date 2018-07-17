package app.entities.cells;

import app.interfaces.cells.RedBloodCellInterface;

public class RedBloodCell extends Cell implements RedBloodCellInterface {

    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    @Override
    public int getVelocity() {
        return this.velocity;
    }
}
