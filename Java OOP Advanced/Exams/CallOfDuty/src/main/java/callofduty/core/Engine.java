package callofduty.core;

import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionControl;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;

public class Engine implements Runnable {

    private OutputWriter writer;
    private InputReader reader;
    private MissionControl missionControl;
    private MissionManager missionManager;

    public Engine(OutputWriter writer, InputReader reader, MissionControl missionControl, MissionManager missionManager) {
        this.writer = writer;
        this.reader = reader;
        this.missionControl = missionControl;
        this.missionManager = missionManager;
    }

    @Override
    public void run() {

    }
}
