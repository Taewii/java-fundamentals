package p04_word_force.employees;

public class StandardEmployee extends BaseEmployee {

    public StandardEmployee(String name) {
        super(name);
        setWorkHoursPerWeek(40);
    }
}
