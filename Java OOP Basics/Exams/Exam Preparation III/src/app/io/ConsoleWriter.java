package app.io;

import app.interfaces.io.OutputWriter;

public class ConsoleWriter implements OutputWriter {

    public ConsoleWriter() {
    }

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
