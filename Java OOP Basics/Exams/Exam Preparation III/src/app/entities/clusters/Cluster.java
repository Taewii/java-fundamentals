package app.entities.clusters;

import app.entities.cells.Cell;
import app.interfaces.ClusterInterface;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void addCell(Cell cell) {
        this.cells[cell.getPositionRow()][cell.getPositionCol()] = cell;
    }

    @Override
    public int getCellsCount() {
        int count = 0;

        for (Cell[] cells : this.getCells()) {
            for (Cell cell : cells) {
                if (cell != null) {
                    count++;
                }
            }
        }

        return count;
    }

    @Override
    public void activate() {
        List<Cell> cellList = new ArrayList<>();

        for (Cell[] cell : this.cells) {
            for (Cell cell1 : cell) {
                if (cell1 != null) {
                    cellList.add(cell1);
                }
            }
        }

        while (cellList.size() > 0) {
            if (cellList.size() == 1) {
                break;
            }

            Cell startCell = cellList.get(0);
            cellList.remove(0);

            Cell secondCell = cellList.get(0);
            cellList.remove(0);

            Cell winner = fight(startCell, secondCell);
            cellList.add(0, winner);
        }

        this.cells = new Cell[rows][cols];

        for (Cell cell : cellList) {
            this.cells[cell.getPositionRow()][cell.getPositionCol()] = cell;
        }
    }

    @Override
    public Cell fight(Cell startCell, Cell secondCell) {
        String cellType = startCell.getClass().getSimpleName();

        switch (cellType) {
            case "RedBloodCell":
            case "WhiteBloodCell":
                startCell.setHealth(startCell.getHealth() + secondCell.getHealth());
                startCell.setPositionRow(secondCell.getPositionRow());
                startCell.setPositionCol(secondCell.getPositionCol());
                return startCell;
            default:
                while (true) {
                    secondCell.setHealth(secondCell.getHealth() - startCell.getEnergy());
                    if (secondCell.getHealth() <= 0) {
                        startCell.setPositionRow(secondCell.getPositionRow());
                        startCell.setPositionCol(secondCell.getPositionCol());
                        return startCell;
                    }

                    startCell.setHealth(startCell.getHealth() - secondCell.getEnergy());
                    if (startCell.getHealth() <= 0) {
                        secondCell.setPositionRow(startCell.getPositionRow());
                        secondCell.setPositionCol(startCell.getPositionCol());
                        return secondCell;
                    }
                }

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("----Cluster %s%n", this.getId()));
        for (Cell[] cell : cells) {
            for (Cell cell1 : cell) {
                if (cell1 != null) {
                    sb.append(cell1);
                }
            }
        }
        return sb.toString();
    }
}
