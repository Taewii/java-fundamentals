package app.engine;

import app.interfaces.EngineInterface;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;

public class Engine implements EngineInterface {

    private static final String EMPTY_STRING = "";

    private ConsoleReader reader;
    private ConsoleWriter writer;
    private HealthManager manager;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.manager = new HealthManager();
    }

    @Override
    public void run() throws IOException {

        String input;
        while (!"BEER IS COMING".equals(input = reader.readLine())) {
            String[] args = input.split("\\s+");
            String command = args[0];
            String organismName = args[1];
            String result = EMPTY_STRING;

            switch (command) {
                case "checkCondition":
                    result = this.manager.checkCondition(organismName);

                    if (!EMPTY_STRING.equals(result)) {
                        this.writer.writeLine(result);
                    }
                    break;
                case "createOrganism":
                    result = this.manager.createOrganism(organismName);
                    this.writer.writeLine(result);
                    break;
                case "addCluster":
                    result = this.manager.addCluster(organismName, args[2], Integer.parseInt(args[3]), Integer.parseInt(args[4]));

                    if (!EMPTY_STRING.equals(result)) {
                        this.writer.writeLine(result);
                    }
                    break;
                case "addCell":
                    result = this.manager.addCell(organismName, args[2], args[3], args[4], Integer.parseInt(args[5]),
                            Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[8]));

                    if (!EMPTY_STRING.equals(result)) {
                        this.writer.writeLine(result);
                    }
                    break;
                case "activateCluster":
                    result = this.manager.activateCluster(organismName);

                    if (!EMPTY_STRING.equals(result)) {
                        this.writer.writeLine(result);
                    }
                    break;
            }
        }
    }
}
