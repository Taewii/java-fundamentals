package p08_military_elite.models;

import p08_military_elite.contracts.MissionInterface;

public class Mission implements MissionInterface {

    private static final String FINISHED_CODE_STATE = "Finished";
    private static final String IN_PROGRESS_STATE = "inProgress";

    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        setState(state);
    }

    @Override
    public void setState(String state) {
        if (!state.equals(FINISHED_CODE_STATE) && !state.equals(IN_PROGRESS_STATE)) {
            throw new IllegalArgumentException();
        }
        this.state = state;
    }

    @Override
    public void completeMission() {
        this.state = FINISHED_CODE_STATE;
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s%n", this.codeName, this.state);
    }
}
