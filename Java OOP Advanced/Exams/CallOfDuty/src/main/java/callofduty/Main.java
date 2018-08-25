package callofduty;

import callofduty.core.Engine;
import callofduty.core.MissionControlImpl;
import callofduty.core.MissionManagerImpl;
import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionControl;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;
import callofduty.io.ConsoleReader;
import callofduty.io.ConsoleWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)  {

        OutputWriter writer = new ConsoleWriter();
        InputReader reader = new ConsoleReader(new BufferedReader(new InputStreamReader(System.in)));
        MissionControl missionControl = new MissionControlImpl();
        MissionManager missionManager = new MissionManagerImpl();

        Runnable engine = new Engine(writer, reader, missionControl, missionManager);

        engine.run();
    }
}




