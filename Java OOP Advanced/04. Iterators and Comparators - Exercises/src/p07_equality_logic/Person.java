package p07_equality_logic;

import java.util.Objects;

public class Person implements Comparable<Person>{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Person o) {
        int result = this.name.compareTo(o.getName());

        if (result == 0) {
            result = Integer.compare(this.age, o.getAge());
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Person p = (Person) obj;
        return this.compareTo(p) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
