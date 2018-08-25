package callofduty.models.missions;

import callofduty.Constants;

public class HuntMission extends BaseMission {
    public HuntMission(String id, Double rating, Double bounty) {
        super(id, rating * Constants.HUNT_MISSION_RATING, bounty * Constants.HUNT_MISSION_BOUNTY);
    }
}
