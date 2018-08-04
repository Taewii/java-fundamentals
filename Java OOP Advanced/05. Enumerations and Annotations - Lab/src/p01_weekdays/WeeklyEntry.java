package p01_weekdays;

public class WeeklyEntry implements Comparable<WeeklyEntry> {

    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
        this.notes = notes;
    }

    @Override
    public int compareTo(WeeklyEntry o) {
        return this.weekday.compareTo(o.weekday);
    }

    @Override
    public String toString() {
        return this.weekday + " - " + this.notes;
    }
}
