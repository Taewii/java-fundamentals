package cresla.core;

import cresla.interfaces.Engine;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineImpl implements Engine {

    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public EngineImpl(InputReader reader, OutputWriter writer, Manager manager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }

    @Override
    public void run() {
        terminate:
        while (true) {
            String[] tokens = this.reader.readLine().split("\\s+");
            String command = tokens[0];
            List<String> arguments = Arrays.stream(tokens).skip(1).collect(Collectors.toList());

            switch (command) {
                case "Reactor":
                    this.writer.writeLine(this.manager.reactorCommand(arguments));
                    break;
                case "Module":
                    this.writer.writeLine(this.manager.moduleCommand(arguments));
                    break;
                case "Report":
                    this.writer.writeLine(this.manager.reportCommand(arguments));
                    break;
                case "Exit":
                    this.writer.writeLine(this.manager.exitCommand(arguments));
                    break terminate;
            }
        }
    }
}
