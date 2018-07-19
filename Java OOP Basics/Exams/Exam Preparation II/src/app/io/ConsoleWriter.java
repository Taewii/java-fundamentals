package app.io;

import app.interfaces.io.WriteOutput;

public class ConsoleWriter implements WriteOutput {

    public ConsoleWriter() {
    }

    @Override
    public void write(String line) {
        System.out.print(line);
    }
}
