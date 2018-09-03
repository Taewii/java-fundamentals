package panzer.core;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public Engine(InputReader reader, OutputWriter writer, Manager manager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            String[] tokens = this.reader.readLine().split("\\s+");
            String command = tokens[0];
            List<String> arguments = Arrays.stream(tokens).skip(1).collect(Collectors.toList());
            String result = "";

            switch (command) {
                case "Vehicle":
                    result = this.manager.addVehicle(arguments);
                    break;
                case "Part":
                    result = this.manager.addPart(arguments);
                    break;
                case "Inspect":
                    result = this.manager.inspect(arguments);
                    break;
                case "Battle":
                    result = this.manager.battle(arguments);
                    break;
                case "Terminate":
                    result = this.manager.terminate(arguments);
                    break;
            }

            this.writer.println(result);

            if ("Terminate".equals(command)) {
                break;
            }
        }
    }
}
