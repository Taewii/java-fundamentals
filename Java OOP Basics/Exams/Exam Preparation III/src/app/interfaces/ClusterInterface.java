package app.interfaces;

import app.entities.cells.Cell;

public interface ClusterInterface {

    String getId();

    int getRows();

    int getCols();

    Cell[][] getCells();

    void addCell(Cell cell);

    int getCellsCount();

    void activate();

    Cell fight(Cell startCell, Cell secondCell);
}
