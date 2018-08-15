package p01_system_resources;

import p01_system_resources.contracts.GreetingDevice;
import p01_system_resources.models.ConsoleWriter;
import p01_system_resources.models.GreetingClock;
import p01_system_resources.models.TimeProviderImpl;

public class Main {
    public static void main(String[] args) {

        GreetingDevice clock = new GreetingClock(new TimeProviderImpl(), new ConsoleWriter());
        clock.greeting();
    }
}
