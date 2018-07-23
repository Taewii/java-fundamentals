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

        String input;
        while (!"Cops Are Here".equals(input = reader.readLine())) {
            String[] args = input.split("\\s+");
            String command = args[0];
            int id = Integer.parseInt(args[1]);

            switch (command) {
                case "register":
                    this.manager.register(id, args[2], args[3], args[4],
                            Integer.parseInt(args[5]),
                            Integer.parseInt(args[6]),
                            Integer.parseInt(args[7]),
                            Integer.parseInt(args[8]),
                            Integer.parseInt(args[9]));
                    break;
                case "check":
                    writer.write(this.manager.check(id));
                    break;
                case "open":
                    if ("Circuit".equals(args[2]) || "TimeLimit".equals(args[2])) {
                        this.manager.open(id, args[2], Integer.parseInt(args[3]), args[4], Integer.parseInt(args[5]), Integer.parseInt(args[6]));
                    } else {
                        this.manager.open(id, args[2], Integer.parseInt(args[3]), args[4], Integer.parseInt(args[5]));
                    }
                    break;
                case "participate":
                    this.manager.participate(id, Integer.parseInt(args[2]));
                    break;
                case "start":
                    this.writer.write(this.manager.start(id));
                    break;
                case "park":
                    this.manager.park(id);
                    break;
                case "unpark":
                    this.manager.unpark(id);
                    break;
                case "tune":
                    this.manager.tune(id, args[2]);
                    break;
            }
        }
    }
}
