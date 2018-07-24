package avatar.core;

import avatar.contracts.core.EngineInterface;
import avatar.io.ConsoleReader;
import avatar.io.ConsoleWriter;

public class Engine implements EngineInterface {

    private ConsoleReader reader;
    private ConsoleWriter writer;
    private BusinessLogic businessLogic;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.businessLogic = new BusinessLogic();
    }

    @Override
    public void run() {
        while (true) {
            String[] args = this.reader.readLine().split(" ");

            switch (args[0]) {
                case "Bender":
                    this.businessLogic.createBender(args[1], args[2], Integer.parseInt(args[3]), Double.parseDouble(args[4]));
                    break;
                case "Monument":
                    this.businessLogic.createMonument(args[1], args[2], Integer.parseInt(args[3]));
                    break;
                case "Status":
                    this.writer.write(this.businessLogic.status(args[1]));
                    break;
                case "War":
                    this.businessLogic.war(args[1]);
                    break;
                case "Quit":
                    this.writer.write(this.businessLogic.quit());
                    return;
            }
        }
    }
}
