package app.entities;

import app.entities.cells.Cell;
import app.entities.clusters.Cluster;
import app.interfaces.OrganismInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Organism implements OrganismInterface {

    private String name;
    private List<Cluster> clusters;

    public Organism() {
        this.clusters = new ArrayList<>();
    }

    protected List<Cluster> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCellsCount() {
        int count = 0;

        for (Cluster cluster : clusters) {
            for (Cell[] cells : cluster.getCells()) {
                for (Cell cell : cells) {
                    if (cell != null) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Organism - ").append(this.getName()).append(System.lineSeparator());
        sb.append("--Clusters: ").append(this.getClusters().size()).append(System.lineSeparator());
        sb.append("--Cells: ").append(getCellsCount()).append(System.lineSeparator());

        for (Cluster cluster : clusters) {
            sb.append(cluster.toString());
        }

        return sb.toString();
    }


}
