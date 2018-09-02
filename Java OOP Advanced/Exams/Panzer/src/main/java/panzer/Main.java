package panzer;

import panzer.contracts.BattleOperator;
import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.core.Engine;
import panzer.core.PanzerBattleOperator;
import panzer.core.VehicleManager;
import panzer.io.ConsoleReader;
import panzer.io.ConsoleWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new ConsoleReader(new BufferedReader(new InputStreamReader(System.in)));
        OutputWriter writer = new ConsoleWriter();
        BattleOperator battleOperator = new PanzerBattleOperator();
        Manager manager = new VehicleManager(battleOperator);
        Runnable engine = new Engine(reader, writer, manager);

        engine.run();
    }
}
