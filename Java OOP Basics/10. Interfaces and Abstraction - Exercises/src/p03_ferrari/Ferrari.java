package p03_ferrari;

public class Ferrari implements Car{

    private static final String CAR_MODEL = "488-Spider";

    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
    }

    public String getDriver() {
        return this.driver;
    }

    @Override
    public String pushBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", CAR_MODEL, pushBrakes(), pushGasPedal(), getDriver());
    }
}
