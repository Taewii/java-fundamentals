package p01_weekdays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeeklyCalendar {

    private List<WeeklyEntry> calendar;

    public WeeklyCalendar() {
        this.calendar = new ArrayList<>();
    }

    public void addEntry(String weekday, String notes) {
        this.calendar.add(new WeeklyEntry(weekday, notes));
    }

    public Iterable<WeeklyEntry> getWeeklySchedule() {
        Collections.sort(this.calendar);
        return this.calendar;
    }
}
