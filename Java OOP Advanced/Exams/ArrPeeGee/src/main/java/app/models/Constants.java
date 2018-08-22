package app.models;

public final class Constants {

    private Constants() {
    }

    //Paths
    public static final String ACTIONS_PATH = "app.models.actions.";
    public static final String HEROES_PATH = "app.models.participants.";

    //BattleField texts
    public static final String PARTICIPANT_IS_NOT_ON_THE_BATTLEFIELD = "%s is not on the battlefield. %s failed.";
    public static final String ACTION_DOES_NOT_EXIST = "Action does not exist.";
    public static final String PARTICIPANT_NAME_IS_TAKEN = "Participant with that name already exists.";
    public static final String TARGETABLE_HAS_ENTERED_THE_BATTLEGROUND = "%s %s entered the battlefield.";
    public static final String PARTICIPANT_CLASS_DOES_NOT_EXIST = "Participant class does not exist.";
    public static final String BATTLEFIELD_IS_EMPTY = "There are no participants on the battlefield.";
    public static final String PARTICIPANT_SEPARATOR = "* * * * * * * * * * * * * * * * * * * *";
    public static final String THERE_ARE_NO_ACTIONS_ON_THE_BATTLEFIELD = "There are no actions on the battlefield.";
    public static final String TARGET_HAS_BEEN_REMOVED_FROM_THE_BATTLEFIELD = "%s has been removed from the battlefield.";

    //Engine commands
    public static final String TERMINATING_COMMAND = "Peace";
    public static final String INVALID_COMMAND_MESSAGE = "Invalid command";
    public static final String WORD_SPLITTER = "\\s+";
    public static final String CREATE_PARTICIPANT = "createparticipant";
    public static final String CREATE_ACTION = "createaction";
    public static final String CREATE_SPECIAL = "createspecial";
    public static final String STAT_PARTICIPANTS = "statparticipants";
    public static final String STAT_ACTIONS = "statactions";

    //OneVsOne texts
    public static final String EXACTLY_TWO_PARTICIPANTS_NEEDED = "There should be exactly 2 participants for OneVsOne!";
    public static final String WINNER_STRING = "%s is victorious!%s%s";

    //Targetable texts
    public static final String DEAD_HERO_CAN_NOT_ATTACK = "%s is dead! Cannot attack.";
    public static final String DEAD_TARGET_CAN_NOT_BE_ATTACKED = "%s is dead! Cannot be attacked.";
    public static final String HERO_ATTACKED = "%s attacked!";
    public static final String HERO_HAS_BEEN_SLAIN_BY = " %s has been slain by %s.";

    //Object toStrings
    public static final String NAME_AND_CLASS = "  Name: %s | Class: %s";
    public static final String BOSS_STATS = "  Health: %.2f | Damage: %.2f | %.2f Gold";
    public static final String HERO_STATS = "  Health: %.2f | Damage: %.2f";
    public static final String HERO_STATS2 = "  %d STR | %d DEX | %d INT | %.2f Gold";
}
