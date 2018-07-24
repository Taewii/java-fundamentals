package app;

import app.contracts.EngineInterface;
import app.entities.Colonist;
import app.factories.ColonistFactory;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.util.Arrays;
import java.util.List;

public class Engine implements EngineInterface {

    private ConsoleWriter writer;
    private ConsoleReader reader;
    private Colony colony;

    protected Engine() {
        writer = new ConsoleWriter();
        reader = new ConsoleReader();
        int[] capacities = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        colony = new Colony(capacities[0], capacities[1]);
    }

    @Override
    public void run() {
        String input;
        while (!"end".equals(input = reader.readLine())) {
            String[] args = input.split("\\s+");
            String command = args[0];

            switch (command) {
                case "insert":
                    Colonist colonist;
                    if (args.length == 7) {
                        colonist = ColonistFactory.createColonist(args[1], args[2], args[3],
                                Integer.parseInt(args[4]),
                                Integer.parseInt(args[5]), args[6]);
                    } else {
                        colonist = ColonistFactory.createColonist(args[1], args[2], args[3],
                                Integer.parseInt(args[4]),
                                Integer.parseInt(args[5]));
                    }
                    try {
                        this.colony.addColonist(colonist);
                    } catch (IllegalArgumentException ex) {
                        this.writer.writeLine(ex.getMessage());
                    }
                    break;
                case "remove":
                    if ("colonist".equals(args[1])) {
                        this.colony.removeColonist(args[2], args[3]);
                    } else {
                        this.colony.removeFamily(args[2]);
                    }
                    break;
                case "grow":
                    this.colony.grow(Integer.parseInt(args[1]));
                    break;
                case "potential":
                    this.writer.write(String.format("potential: %d%n", this.colony.getPotential()));
                    break;
                case "capacity":
                    this.writer.write(this.colony.getCapacity());
                    break;
                case "family":
                    try {
                        List<Colonist> colonists = this.colony.getColonistsByFamilyId(args[1]);
                        StringBuilder sb = new StringBuilder();
                        sb.append(args[1]).append(":").append(System.lineSeparator());
                        for (Colonist colonist1 : colonists) {
                            sb.append(colonist1);
                        }
                        this.writer.write(sb.toString());
                    } catch (IllegalArgumentException ex) {
                        this.writer.writeLine(ex.getMessage());
                    }
                    break;
            }
        }
    }
}
