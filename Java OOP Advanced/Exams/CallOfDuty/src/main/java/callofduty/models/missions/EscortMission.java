package callofduty.models.missions;

import callofduty.Constants;

public class EscortMission extends BaseMission {
    public EscortMission(String id, Double rating, Double bounty) {
        super(id, rating * Constants.ESCORT_MISSION_RATING, bounty * Constants.ESCORT_MISSION_BOUNTY);
    }
}
