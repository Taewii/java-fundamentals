package callofduty.core;

import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private OutputWriter writer;
    private InputReader reader;
    private MissionManager missionManager;

    public Engine(OutputWriter writer, InputReader reader, MissionManager missionManager) {
        this.writer = writer;
        this.reader = reader;
        this.missionManager = missionManager;
    }

    @Override
    public void run() {
        String input = reader.readLine();
        while (true) {
            List<String> tokens = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());
            String result;

            switch (tokens.get(0)) {
                case "Agent":
                    result = this.missionManager.agent(tokens);
                    break;
                case "Request":
                    result = this.missionManager.request(tokens);
                    break;
                case "Complete":
                    result = this.missionManager.complete(tokens);
                    break;
                case "Status":
                    result = this.missionManager.status(tokens);
                    break;
                case "Over":
                    result = this.missionManager.over(tokens);
                    break;
                default:
                    result = "Invalid command!";
                    break;
            }

            this.writer.println(result);
            if ("Over".equals(input)) {
                break;
            }

            input = this.reader.readLine();
        }
    }
}
