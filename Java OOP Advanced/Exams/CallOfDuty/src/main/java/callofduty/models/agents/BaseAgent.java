package callofduty.models.agents;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseAgent implements Agent {

    private String id;
    private String name;
    private Double rating;
    private Map<String, Mission> missions;
    private Integer completedMissions;

    protected BaseAgent(String id, String name) {
        this.id = id;
        this.name = name;
        this.rating = 0d;
        this.completedMissions = 0;
        this.missions = new LinkedHashMap<>();
    }

    @Override
    public void acceptMission(Mission mission) {
        this.missions.put(mission.getId(), mission);
    }

    @Override
    public void completeMissions() {
        this.completedMissions += this.missions.size();
        for (Mission mission : missions.values()) {
            this.rating += mission.getRating();
            if (this instanceof MasterAgent) {
                //setBounty(mission.getBounty());
                ((MasterAgent) this).setBounty(((MasterAgent) this).getBounty() + mission.getBounty());
            }
        }

        this.missions.clear();
    }

//    private void setBounty(Double value) {
//        try {
//            Field bounty = Class.forName(Constants.AGENTS_PATH + "MasterAgent").getDeclaredField("bounty");
//            bounty.setAccessible(true);
//            Double currentValue = (Double) bounty.get(this);
//            bounty.set(this, currentValue + value);
//        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s - %s%n", this.getClass().getSimpleName().replace("Agent", " Agent"), this.getName()));
        sb.append(String.format("Personal Code: %s%n", this.getId()));
        sb.append(String.format("Assigned Missions: %d%n", this.missions.size()));
        sb.append(String.format("Completed Missions: %d%n", this.completedMissions));
        sb.append(String.format("Rating: %.2f", this.getRating()));

        return sb.toString();
    }
}
