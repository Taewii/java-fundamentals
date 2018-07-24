package avatar.contracts.core;

public interface Logic {

    void createBender(String type, String name, int power, double secondaryParameter);

    void createMonument(String type, String name, int affinity);

    String status(String nation);

    void war(String nation);

    String quit();
}
