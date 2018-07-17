package app.entities.cells;

import app.interfaces.cells.WhiteBloodCellInterface;

public class WhiteBloodCell extends Cell implements WhiteBloodCellInterface {

    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
