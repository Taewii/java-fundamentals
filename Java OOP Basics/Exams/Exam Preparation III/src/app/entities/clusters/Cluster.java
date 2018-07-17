package app.entities.clusters;

import app.entities.cells.Cell;
import app.interfaces.ClusterInterface;

public class Cluster implements ClusterInterface {

    private String id;
    private int rows;
    private int cols;
    private Cell[][] cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getRows() {
        return this.rows;
    }

    @Override
    public int getCols() {
        return this.cols;
    }

    @Override
    public Cell[][] getCells() {
        return this.cells;
    }
}
