package callofduty.models.missions;

import callofduty.Constants;

public class SurveillanceMission extends BaseMission {
    public SurveillanceMission(String id, Double rating, Double bounty) {
        super(id, rating * Constants.SURVEILLANCE_MISSION_RATING, bounty * Constants.SURVEILLANCE_MISSION_BOUNTY);
    }
}
