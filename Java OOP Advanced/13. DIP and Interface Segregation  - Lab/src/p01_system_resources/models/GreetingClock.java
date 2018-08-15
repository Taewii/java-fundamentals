package p01_system_resources.models;

import p01_system_resources.contracts.GreetingDevice;
import p01_system_resources.contracts.TimeProvider;
import p01_system_resources.contracts.Writer;

public class GreetingClock implements GreetingDevice {

   private TimeProvider timeProvider;
   private Writer writer;

    public GreetingClock(TimeProvider timeProvider, Writer writer) {
        this.timeProvider = timeProvider;
        this.writer = writer;
    }

    @Override
    public void greeting() {
        if (this.timeProvider.getHour() < 12) {
            this.writer.writeLine("Good morning...");
        } else if (this.timeProvider.getHour() < 18) {
            this.writer.writeLine("Good afternoon...");
        } else {
            this.writer.writeLine("Good evening...");
        }
    }
}
