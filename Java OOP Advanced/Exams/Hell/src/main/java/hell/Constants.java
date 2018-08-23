package hell;

public final class Constants {

    public static final int BARBARIAN_BASE_STRENGTH = 90;
    public static final int BARBARIAN_BASE_AGILITY = 25;
    public static final int BARBARIAN_BASE_INTELLIGENCE = 10;
    public static final int BARBARIAN_BASE_HITPOINTS = 350;
    public static final int BARBARIAN_BASE_DAMAGE = 150;

    public static final int ASSASSIN_BASE_STRENGTH = 25;
    public static final int ASSASSIN_BASE_AGILITY = 100;
    public static final int ASSASSIN_BASE_INTELLIGENCE = 15;
    public static final int ASSASSIN_BASE_HITPOINTS = 150;
    public static final int ASSASSIN_BASE_DAMAGE = 300;

    public static final int WIZARD_BASE_STRENGTH = 25;
    public static final int WIZARD_BASE_AGILITY = 25;
    public static final int WIZARD_BASE_INTELLIGENCE = 100;
    public static final int WIZARD_BASE_HITPOINTS = 100;
    public static final int WIZARD_BASE_DAMAGE = 250;

    //commands
    public static final String COMMANDS_PATH = "hell.commands.";
    public static final String HEROES_PATH = "hell.entities.heroes.";
    public static final String COMMANDS_SUFFIX = "Command";
    public static final String TERMINATING_COMMAND = "Quit";

    //messages
    public static final String CREATED_HERO = "Created %s - %s";
    public static final String ADDED_ITEM_TO_HERO = "Added item - %s to Hero - %s";
    public static final String ADDED_RECIPE_TO_HERO = "Added recipe - %s to Hero - %s";

    private Constants() {
    }
}
