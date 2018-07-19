package app.io;

import app.interfaces.io.WriteOutput;

public class ConsoleWriter implements WriteOutput {

    public ConsoleWriter() {
    }

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
