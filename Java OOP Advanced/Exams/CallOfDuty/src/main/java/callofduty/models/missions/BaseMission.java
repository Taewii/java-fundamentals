package callofduty.models.missions;

import callofduty.interfaces.Mission;

public abstract class BaseMission implements Mission {

    private String id;
    private Double rating;
    private Double bounty;
    private boolean isCompleted;

    protected BaseMission(String id, Double rating, Double bounty) {
        this.id = id;
        this.rating = rating;
        this.bounty = bounty;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s - %s%n", this.getClass().getSimpleName().replace("Mission", " Mission"), this.getId()));
        sb.append("Status: ").append(this.isCompleted ? "Completed" : "Open").append(System.lineSeparator());
        sb.append(String.format("Rating: %.2f%n", this.getRating()));
        sb.append(String.format("Bounty: %.2f", this.getBounty()));

        return sb.toString();
    }
}
