package callofduty.models.agents;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

public abstract class BaseAgent implements Agent {

    private String id;
    private String name;
    private Double rating;

    protected BaseAgent(String id, String name) {
        this.id = id;
        this.name = name;
        this.rating = 0d;
    }

    @Override
    public void acceptMission(Mission mission) {
        //todo
    }

    @Override
    public void completeMissions() {
        //todo
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }
}
