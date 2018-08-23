package hell.interfaces;

public interface Repository {

    void addHero(Hero hero);

    Hero getHero(String name);

    String getStatistics();
}
