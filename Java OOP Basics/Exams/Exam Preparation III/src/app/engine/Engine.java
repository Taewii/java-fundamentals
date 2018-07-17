package app.engine;

import app.interfaces.EngineInterface;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

public class Engine implements EngineInterface {

    private ConsoleReader reader;
    private ConsoleWriter writer;
    private HealthManager manager;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.manager = new HealthManager();
    }

    @Override
    public void run() {

    }
}
