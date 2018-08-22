package app.models;

public final class Config {

    private Config() {
    }

    public static final int HERO_HEALTH_MULTIPLIER = 10;
    public static final int LEVEL_UP_MULTIPLIER = 2;

    public static final int WIZARD_BASE_STRENGTH = 3;
    public static final int WIZARD_BASE_DEXTERITY= 3;
    public static final int WIZARD_BASE_INTELLIGENCE = 4;
    public static final int WIZARD_BASE_HEALTH = WIZARD_BASE_STRENGTH * HERO_HEALTH_MULTIPLIER;
    public static final int WIZARD_BASE_DAMAGE = WIZARD_BASE_INTELLIGENCE * 5 + WIZARD_BASE_DEXTERITY;

    public static final int WARRIOR_BASE_STRENGTH = 5;
    public static final int WARRIOR_BASE_DEXTERITY= 4;
    public static final int WARRIOR_BASE_INTELLIGENCE = 1;
    public static final int WARRIOR_BASE_DAMAGE = WARRIOR_BASE_STRENGTH * 2 + WARRIOR_BASE_DEXTERITY;
    public static final int WARRIOR_BASE_HEALTH = WARRIOR_BASE_STRENGTH * HERO_HEALTH_MULTIPLIER;

    public static final int NECROMANCER_BASE_STRENGTH = 4;
    public static final int NECROMANCER_BASE_DEXTERITY = 3;
    public static final int NECROMANCER_BASE_INTELLIGENCE = 3;
    public static final int NECROMANCER_BASE_HEALTH = NECROMANCER_BASE_STRENGTH * HERO_HEALTH_MULTIPLIER;
    public static final int NECROMANCER_BASE_DAMAGE = (NECROMANCER_BASE_DEXTERITY + NECROMANCER_BASE_INTELLIGENCE + NECROMANCER_BASE_STRENGTH) * 2;

    public static final double HERO_START_GOLD = 200.0;
    
    public static final double BOSS_GOLD = 100;
    public static final double BOSS_HEALTH = 500;
    public static final double BOSS_DAMAGE = 5;
    public static final double BOSS_INDIVIDUAL_REWARD = 50;
}
