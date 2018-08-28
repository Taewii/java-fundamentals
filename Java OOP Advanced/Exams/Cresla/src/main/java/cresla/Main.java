package cresla;

import cresla.core.CreslaManager;
import cresla.core.EngineImpl;
import cresla.entities.io.ConsoleReader;
import cresla.entities.io.ConsoleWriter;
import cresla.interfaces.Engine;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new ConsoleReader(new BufferedReader(new InputStreamReader(System.in)));
        OutputWriter writer = new ConsoleWriter();
        Manager manager = new CreslaManager();
        Engine engine = new EngineImpl(reader, writer, manager);

        engine.run();
    }
}
