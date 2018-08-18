import commands.*;
import interfaces.*;
import loggers.CombatLogger;
import loggers.ErrorLogger;
import loggers.EventLogger;
import models.Dragon;
import models.Group;
import models.Warrior;

public class Main {
    public static void main(String[] args) {
        Handler combatLogger = new CombatLogger();
        Handler eventLogger = new EventLogger();
        Handler errorLogger = new ErrorLogger();

        combatLogger.setSuccessor(eventLogger);
        eventLogger.setSuccessor(errorLogger);

        Attacker attacker = new Warrior("warrior", 10, combatLogger);
        Attacker attacker2 = new Warrior("warrior2", 10, combatLogger);
        Attacker attacker3 = new Warrior("warrior3", 10, combatLogger);
        Attacker attacker4 = new Warrior("warrior4", 10, combatLogger);
        Target target = new Dragon("dragon", 40, 10, combatLogger);

        target.register(attacker);
        target.register(attacker2);
        target.register(attacker3);
        target.register(attacker4);

        AttackGroup group = new Group();
        group.addMember(attacker);
        group.addMember(attacker2);
        group.addMember(attacker3);
        group.addMember(attacker4);

        Command groupTargetCommand = new GroupTargetCommand(group, target);
        Command groupAttackCommand = new GroupAttackCommand(group);

        Executor executor = new CommandExecutor();

        executor.executeCommand(groupTargetCommand);
        executor.executeCommand(groupAttackCommand);
    }
}
