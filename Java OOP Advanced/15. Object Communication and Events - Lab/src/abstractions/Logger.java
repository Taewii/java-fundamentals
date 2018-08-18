package abstractions;

import enums.LogType;
import interfaces.Handler;

public abstract class Logger implements Handler {

    private Handler successor;

    protected Logger() {
    }

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected void passToSuccessor(LogType type, String message) {
        this.successor.handle(type, message);
    }

    protected Handler getSuccessor() {
        return this.successor;
    }

    public abstract void handle(LogType type, String message);
}
