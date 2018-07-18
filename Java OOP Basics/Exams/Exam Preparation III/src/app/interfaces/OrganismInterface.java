package app.interfaces;

import app.entities.clusters.Cluster;

import java.util.List;

public interface OrganismInterface {

    String getName();

    int getCellsCount();

    boolean clusterExists(String id);

    void addCluster(Cluster cluster);

    void moveClusterToTheEnd();

    List<Cluster> getClusters();
}
