package p04_word_force.employees;

import java.util.LinkedHashMap;
import java.util.Map;

public class EmployeeCollection {

    private Map<String, BaseEmployee> employees;

    public EmployeeCollection() {
        this.employees = new LinkedHashMap<>();
    }

    public void add(BaseEmployee employee) {
        this.employees.put(employee.getName(), employee);
    }

    public BaseEmployee getEmployee(String employee) {
        return this.employees.get(employee);
    }
}
