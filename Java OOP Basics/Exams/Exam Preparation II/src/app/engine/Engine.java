package app.engine;

import app.interfaces.engine.EngineInterface;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

public class Engine implements EngineInterface {

    private ConsoleReader reader;
    private ConsoleWriter writer;
    private CarManager manager;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.manager = new CarManager();
    }

    @Override
    public void run() {

    }
}
