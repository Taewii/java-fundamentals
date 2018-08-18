package commands;

import interfaces.AttackGroup;
import interfaces.Command;
import interfaces.Target;

public class GroupTargetCommand implements Command {

    private AttackGroup attackers;
    private Target target;

    public GroupTargetCommand(AttackGroup attackers, Target target) {
        this.attackers = attackers;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attackers.groupTarget(this.target);
    }
}
