package app.entities.cells;

import app.interfaces.cells.WhiteBloodCellInterface;

public class WhiteBloodCell extends BloodCell implements WhiteBloodCellInterface {

    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getEnergy() {
        return (super.getHealth() + getSize()) * 2;
    }

    @Override
    public String toString() {
        return String.format("%s--------Health: %d | Size: %d | Energy: %d%n", super.toString(), super.getHealth(),
                this.getSize(), this.getEnergy());
    }
}
