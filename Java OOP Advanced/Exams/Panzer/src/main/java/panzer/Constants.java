package panzer;

public final class Constants {

    //Vanguard modifiers
    public static final double VANGUARD_WEIGHT_MODIFIER = 2;
    public static final double VANGUARD_ATTACK_MODIFIER = 0.75;
    public static final double VANGUARD_DEFENCE_MODIFIER = 1.50;
    public static final double VANGUARD_HITPOINTS_MODIFIER = 1.75;

    //Revenger modifiers
    public static final double REVENGER_PRICE_MODIFIER = 1.50;
    public static final double REVENGER_ATTACK_MODIFIER = 2.50;
    public static final double REVENGER_DEFENCE_MODIFIER = 0.50;
    public static final double REVENGER_HITPOINTS_MODIFIER = 0.50;

    //Output messages
    public static final String VEHICLE_CREATION_MESSAGE = "Created %s Vehicle - %s";
    public static final String PART_CREATION_MESSAGE = "Added %s - %s to Vehicle - %s";
    public static final String BATTLE_MESSAGE = "%s versus %s -> %s Wins! Flawless Victory!";

    private Constants() {
    }
}
