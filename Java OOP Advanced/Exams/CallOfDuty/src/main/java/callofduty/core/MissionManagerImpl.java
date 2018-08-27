package callofduty.core;

import callofduty.Constants;
import callofduty.interfaces.*;
import callofduty.models.agents.MasterAgent;
import callofduty.models.agents.NoviceAgent;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MissionManagerImpl implements MissionManager {

    private MissionControl missionControl;
    private Map<String, Agent> agents;
    private Map<String, Mission> missions;
    private int assignedMissions;

    public MissionManagerImpl(MissionControl missionControl) {
        this.missionControl = missionControl;
        this.agents = new LinkedHashMap<>();
        this.missions = new LinkedHashMap<>();
    }

    @Override
    public String agent(List<String> arguments) {
        Agent agent = new NoviceAgent(arguments.get(1), arguments.get(2));
        this.agents.put(arguments.get(1), agent);

        return String.format(Constants.REGISTERED_AGENT_MESSAGE, arguments.get(2), arguments.get(1));
    }

    @Override
    public String request(List<String> arguments) {
        Mission mission = this.missionControl.generateMission(
                arguments.get(2),
                Double.parseDouble(arguments.get(3)),
                Double.parseDouble(arguments.get(4)));
        Agent agent = this.agents.get(arguments.get(1));

        agent.acceptMission(mission);
        this.missions.put(mission.getId(), mission);
        this.assignedMissions++;

        return String.format(Constants.ASSIGNED_MISSION_MESSAGE, mission.getClass()
                        .getSimpleName().replace("Mission", " Mission"),
                arguments.get(2), agent.getName());
    }

    @Override
    public String complete(List<String> arguments) {
        Agent agent = this.agents.get(arguments.get(1));
        setMissionsToCompleted(agent);
        agent.completeMissions();

        String result = String.format(Constants.COMPLETION_MISSION_MESSAGE, agent.getName(), agent.getId());

        if (getCompletedMissionsCount(agent) > 2 && agent instanceof NoviceAgent) {
            Agent masterAgent = upgradeAgent(agent);

            this.agents.remove(agent.getId());
            this.agents.put(masterAgent.getId(), masterAgent);
        }

        return result;
    }

    @Override
    public String status(List<String> arguments) {
        if (this.missions.containsKey(arguments.get(1))) {
            return this.missions.get(arguments.get(1)).toString();
        } else if (this.agents.containsKey(arguments.get(1))) {
            return this.agents.get(arguments.get(1)).toString();
        }

        return "Mission/Agent doesn't exist.";
    }

    private void setMissionsToCompleted(Agent agent) {
        Map<String, Mission> completedMissionsById = getCompletedMissionsId(agent);
        for (String mission : completedMissionsById.keySet()) {
            completeMission(this.missions.get(mission));
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, Mission> getCompletedMissionsId(Agent agent) {
        Map<String, Mission> missionMap = new LinkedHashMap<>();
        try {
            Field missions = agent.getClass().getSuperclass().getDeclaredField("missions");
            missions.setAccessible(true);
            missionMap = (Map<String, Mission>) missions.get(agent);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return missionMap;
    }

    private void completeMission(Mission mission) {
        try {
            Field isCompleted = mission.getClass().getSuperclass().getDeclaredField("isCompleted");
            isCompleted.setAccessible(true);
            isCompleted.set(mission, true);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private Agent upgradeAgent(Agent agent) {
        Agent masterAgent = new MasterAgent(agent.getId(), agent.getName());
        try {
            Field completedMissionsField = agent.getClass().getSuperclass().getDeclaredField("completedMissions");
            completedMissionsField.setAccessible(true);
            int completedMissions = (int) completedMissionsField.get(agent);

            Field missions = masterAgent.getClass().getSuperclass().getDeclaredField("missions");
            Field rating = masterAgent.getClass().getSuperclass().getDeclaredField("rating");
            Field missionsCompleted = masterAgent.getClass().getSuperclass().getDeclaredField("completedMissions");
            missions.setAccessible(true);
            rating.setAccessible(true);
            missionsCompleted.setAccessible(true);

            missions.set(masterAgent, getCompletedMissionsId(agent));
            rating.set(masterAgent, agent.getRating());
            missionsCompleted.set(masterAgent, completedMissions);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return masterAgent;
    }

    private int getTotalCompletedMissionsCount() {
        int missions = 0;
        for (Agent agent : agents.values()) {
            missions += getCompletedMissionsCount(agent);
        }

        return missions;
    }

    private int getCompletedMissionsCount(Agent agent) {
        try {
            Field completedMissions = agent.getClass().getSuperclass().getDeclaredField("completedMissions");
            completedMissions.setAccessible(true);
            return (int) completedMissions.get(agent);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public String over(List<String> arguments) {
        int noviceAgents = 0;
        int masterAgents = 0;
        double totalRatingGiven = 0;
        double totalBountyGiven = 0;

        for (Agent agent : this.agents.values()) {
            if (agent instanceof MasterAgent) {
                masterAgents++;
                totalBountyGiven += ((MasterAgent) agent).getBounty();
            } else {
                noviceAgents++;
            }
            totalRatingGiven += agent.getRating();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Novice Agents: %d%n", noviceAgents));
        sb.append(String.format("Master Agents: %d%n", masterAgents));
        sb.append(String.format("Assigned Missions: %d%n", this.assignedMissions));
        sb.append(String.format("Completed Missions: %d%n", getTotalCompletedMissionsCount()));
        sb.append(String.format("Total Rating Given: %.2f%n", totalRatingGiven));
        sb.append(String.format("Total Bounty Given: $%.2f", totalBountyGiven));

        return sb.toString();
    }
}
