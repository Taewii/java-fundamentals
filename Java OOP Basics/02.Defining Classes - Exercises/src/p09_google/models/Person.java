package p09_google.models;

import java.util.List;

public class Person {

    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person(Company company, List<Pokemon> pokemons, List<Parent> parents, List<Child> children, Car car) {
        this.company = company;
        this.pokemons = pokemons;
        this.parents = parents;
        this.children = children;
        this.car = car;
    }

    public Company getCompany() {
        return this.company;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Child> getChildren() {
        return this.children;
    }

    public Car getCar() {
        return this.car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company:").append(System.lineSeparator());
        sb.append(this.company);
        sb.append("Car:").append(System.lineSeparator());
        sb.append(this.car);
        sb.append("Pokemon:").append(System.lineSeparator());
        this.pokemons.forEach(p -> sb.append(p.toString()));
        sb.append("Parents:").append(System.lineSeparator());
        this.parents.forEach(p -> sb.append(p.toString()));
        sb.append("Children:").append(System.lineSeparator());
        this.children.forEach(c -> sb.append(c.toString()));

        return sb.toString();
    }
}
