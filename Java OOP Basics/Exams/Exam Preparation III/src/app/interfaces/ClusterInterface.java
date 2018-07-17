package app.interfaces;

import app.entities.cells.Cell;

public interface ClusterInterface {

    String getId();

    int getRows();

    int getCols();

    Cell[][] getCells();
}
