package p03_employee_info.models;

import p03_employee_info.contracts.Formatter;
import p03_employee_info.contracts.InfoProvider;

public class ConsoleClient {

    private InfoProvider infoProvider;
    private Formatter formatter;

    public ConsoleClient(InfoProvider infoProvider, Formatter formatter) {
        this.infoProvider = infoProvider;
        this.formatter = formatter;
    }

    public String getInfo() {
        return this.formatter.format(this.infoProvider.getEmployeesByName());
    }
}
