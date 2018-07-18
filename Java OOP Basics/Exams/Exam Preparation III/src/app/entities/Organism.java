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

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayList<>();
    }

    @Override
    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public Cluster getClusterById(String id) {
        for (Cluster cluster : clusters) {
            if (cluster.getId().equals(id)) {
                return cluster;
            }
        }
        return null;
    }

    @Override
    public void addCluster(Cluster cluster) {
        this.clusters.add(cluster);
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
    public boolean clusterExists(String id) {
        for (Cluster cluster : clusters) {
            if (cluster.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void moveClusterToTheEnd() {
        Cluster cluster = this.getClusters().get(0);
        this.clusters.remove(0);
        this.clusters.add(cluster);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Organism - %s%n--Clusters: %d%n--Cells: %d%n", this.getName(), this.getClusters().size(), getCellsCount()));

        for (Cluster cluster : clusters) {
            sb.append(cluster.toString());
        }

        return sb.toString();
    }
}
