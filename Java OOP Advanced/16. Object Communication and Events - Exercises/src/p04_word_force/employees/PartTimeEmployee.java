package p04_word_force.employees;

public class PartTimeEmployee extends BaseEmployee {

    public PartTimeEmployee(String name) {
        super(name);
        setWorkHoursPerWeek(20);
    }
}
