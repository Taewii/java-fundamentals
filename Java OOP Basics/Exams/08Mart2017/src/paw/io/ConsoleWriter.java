package paw.io;

import paw.contracts.io.OutputWriter;

public class ConsoleWriter implements OutputWriter {

    public ConsoleWriter() {
    }

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }

    @Override
    public void write(String line) {
        System.out.print(line);
    }
}
