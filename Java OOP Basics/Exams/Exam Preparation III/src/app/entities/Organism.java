package app.entities;

import app.entities.clusters.Cluster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Organism {

    private String name;
    private List<Cluster> clusters;

    public Organism() {
        this.clusters = new ArrayList<>();
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }
}
