package app.entities.cells;

import app.interfaces.cells.CellInterface;

public abstract class Cell implements CellInterface {

    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getPositionRow() {
        return this.positionRow;
    }

    @Override
    public int getPositionCol() {
        return this.positionCol;
    }

    @Override
    public String toString() {
        return String.format("o\t------Cell %s [%d, %d]", getId(), getPositionRow(), getPositionCol());
    }
}
