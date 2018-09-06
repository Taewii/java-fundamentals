package bg.softuni;

import bg.softuni.collection.EmergencyRegister;
import bg.softuni.core.EmergencyManagementSystem;
import bg.softuni.core.EngineImpl;
import bg.softuni.interfaces.*;
import bg.softuni.io.ConsoleReader;
import bg.softuni.io.ConsoleWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new ConsoleReader(new BufferedReader(new InputStreamReader(System.in)));
        OutputWriter writer = new ConsoleWriter();
        Register register = new EmergencyRegister();
        Manager manager = new EmergencyManagementSystem(register);
        Engine engine = new EngineImpl(reader, writer, manager);

        engine.run();
    }
}
