package callofduty;

public final class Constants {

    public static final String MISSIONS_PATH = "callofduty.models.missions.";

    //Mission stats
    public static final double ESCORT_MISSION_RATING = 0.75;
    public static final double ESCORT_MISSION_BOUNTY = 1.25;

    public static final double HUNT_MISSION_RATING = 1.50;
    public static final double HUNT_MISSION_BOUNTY = 2.0;

    public static final double SURVEILLANCE_MISSION_RATING = 0.25;
    public static final double SURVEILLANCE_MISSION_BOUNTY = 1.5;

    public static final Integer MISSION_ID_MAXIMUM_LENGTH = 6;
    public static final Double MISSION_RATING_MINIMUM_VALUE = 0D;
    public static final Double MISSION_RATING_MAXIMUM_VALUE = 100D;
    public static final Double MISSION_BOUNTY_MINIMUM_VALUE = 0D;
    public static final Double MISSION_BOUNTY_MAXIMUM_VALUE = 1000000D;

    private Constants() {
    }
}
