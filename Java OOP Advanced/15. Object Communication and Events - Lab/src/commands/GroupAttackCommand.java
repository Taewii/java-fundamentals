package commands;

import interfaces.AttackGroup;
import interfaces.Command;

public class GroupAttackCommand implements Command {

    private AttackGroup attackers;

    public GroupAttackCommand(AttackGroup attackers) {
        this.attackers = attackers;
    }

    @Override
    public void execute() {
        this.attackers.groupAttack();
    }
}
