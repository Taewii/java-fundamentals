package app.interfaces.engine;

public interface Manager {

    void register(int id, String type, String brand, String model,
                  int yearOfProduction, int horsepower, int acceleration,
                  int suspension, int durability);

    String check(int id);

    void open(int id, String type, int length, String route, int prizePool);

    void participate(int id);

    String start(int id);

    void park(int id);

    void unpark(int id);

    void tune(int tuneIndex, String addOn);
}
