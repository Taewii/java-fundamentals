package loggers;

import abstractions.Logger;
import enums.LogType;
import interfaces.Handler;

public class CombatLogger extends Logger {

    public void handle(LogType type, String message) {
        if (type == LogType.ATTACK || type == LogType.MAGIC) {
            System.out.println(type.name() + ": " + message);
        } else {
            if (super.getSuccessor() != null) {
                super.passToSuccessor(type, message);
            }
        }
    }

    @Override
    public void setSuccessor(Handler successor) {
        super.setSuccessor(successor);
    }
}
