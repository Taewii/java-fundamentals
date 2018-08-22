package app.core;

import app.contracts.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static app.models.Constants.*;

public class BattlefieldImplementation implements Battlefield {

    private Map<String, Targetable> participants;
    private List<Action> executedActions;
    private Writer writer;
    private TargetableFactory targetableFactory;
    private ActionFactory actionFactory;

    public BattlefieldImplementation(Writer writer, TargetableFactory targetableFactory, ActionFactory actionFactory) {
        this.targetableFactory = targetableFactory;
        this.actionFactory = actionFactory;
        this.executedActions = new ArrayList<>();
        this.participants = new TreeMap<>();
        this.writer = writer;
    }

    @Override
    public void createAction(String actionName, String... participantNames) {
        try {
            Action action = this.actionFactory.create(actionName);

            List<Targetable> actionParticipants = new ArrayList<>();
            for (String name : participantNames) {
                if (this.participants.containsKey(name)) {
                    actionParticipants.add(this.participants.get(name));
                } else {
                    this.writer.writeLine(String.format(PARTICIPANT_IS_NOT_ON_THE_BATTLEFIELD, name, actionName));
                    return;
                }
            }

            this.writer.writeLine(action.executeAction(actionParticipants));
            checkForDeadParticipants();
            this.executedActions.add(action);
        } catch (Exception e) {
            this.writer.writeLine(ACTION_DOES_NOT_EXIST);
        }
    }

    @Override
    public void createParticipant(String name, String className) {

        if (this.participants.containsKey(name)) {
            this.writer.writeLine(PARTICIPANT_NAME_IS_TAKEN);
            return;
        }

        try {
            Targetable targetable = this.targetableFactory.create(name, className);
            this.participants.put(targetable.getName(), targetable);
            this.writer.writeLine(
                    String.format(TARGETABLE_HAS_ENTERED_THE_BATTLEGROUND,
                            targetable.getClass().getSimpleName(),
                            targetable.getName()));
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            this.writer.writeLine(PARTICIPANT_CLASS_DOES_NOT_EXIST);
        }
    }

    @Override
    public void createSpecial(String name, String specialName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reportParticipants() {
        if (this.participants.size() < 1) {
            this.writer.writeLine(BATTLEFIELD_IS_EMPTY);
            return;
        }

        for (Targetable participant : this.participants.values()) {
            this.writer.writeLine(participant.toString()); //todo check if i didn't fuck this up
            this.writer.writeLine(PARTICIPANT_SEPARATOR);
        }
    }

    @Override
    public void reportActions() {
        if (this.executedActions.size() < 1) {
            this.writer.writeLine(THERE_ARE_NO_ACTIONS_ON_THE_BATTLEFIELD);
            return;
        }

        for (Action executedAction : executedActions) {
            this.writer.writeLine(executedAction.getClass().getSimpleName());
        }
    }

    private void checkForDeadParticipants() {
        Map<String, Targetable> aliveParticipants = new TreeMap<>();

        for (Targetable participant : this.participants.values()) {
            if (!participant.isAlive()) {
                this.writer.writeLine(String.format(TARGET_HAS_BEEN_REMOVED_FROM_THE_BATTLEFIELD, participant.getName()));
            } else {
                aliveParticipants.put(participant.getName(), participant);
            }
        }

        this.participants = aliveParticipants;
    }
}
