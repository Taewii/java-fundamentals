package app.engine;

import app.entities.Organism;
import app.entities.cells.Cell;
import app.entities.clusters.Cluster;
import app.factories.cellFactory;
import app.interfaces.HealthManagerInterface;

import java.util.LinkedHashMap;
import java.util.Map;

public class HealthManager implements HealthManagerInterface {

    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new LinkedHashMap<>();
    }

    @Override
    public String checkCondition(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            return this.organisms.get(organismName).toString();
        }
        return "";
    }

    @Override
    public String createOrganism(String name) {

        if (!this.organisms.containsKey(name)) {
            this.organisms.put(name, new Organism(name));
            return String.format("Created organism %s%n", name);
        }

        return String.format("Organism %s already exists%n", name);
    }

    @Override
    public String addCluster(String organismName, String id, int rows, int cols) {
        Cluster cluster = new Cluster(id, rows, cols);

        if (this.organisms.containsKey(organismName)) {
            if (!this.organisms.get(organismName).clusterExists(id)) {
                this.organisms.get(organismName).addCluster(cluster);
                return String.format("Organism %s: Created cluster %s%n", organismName, id);
            }
        }

        return "";
    }

    @Override
    public String addCell(String organismName, String clusterId, String cellType, String cellId,
                          int health, int positionRow, int positionCol, int additionalProperty) {

        Cell cell = cellFactory.createCell(cellType, cellId, health, positionRow, positionCol, additionalProperty);

        if (this.organisms.containsKey(organismName)) {
            Cluster cluster = this.organisms.get(organismName).getClusterById(clusterId);
            if (cluster != null) {
                cluster.addCell(cell);
                return String.format("Organism %s: Created cell %s in cluster %s%n", organismName, cellId, clusterId);
            }
        }

        return "";
    }

    @Override
    public String activateCluster(String name) {
        if (this.organisms.containsKey(name)) {
            if (this.organisms.get(name).getClusters().size() > 0) {
                Cluster cluster = this.organisms.get(name).getClusters().get(0);

                cluster.activate();

                this.organisms.get(name).moveClusterToTheEnd();

                return String.format("Organism %s: Activated cluster %s. Cells left: %d%n", name, cluster.getId(), cluster.getCellsCount());
            }
        }
        return "";
    }
}
