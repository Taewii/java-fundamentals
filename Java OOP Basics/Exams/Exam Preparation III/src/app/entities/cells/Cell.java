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
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    @Override
    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]%n", getId(), getPositionRow(), getPositionCol());
    }
}
