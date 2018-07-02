package p02_creating_constructors;

public class Person {
    public static final int DEFAULT_AGE = 1;
    public static final String DEFAULT_NAME = "No name";

    private String name;
    private int age;

    public Person() {
        this(DEFAULT_NAME, DEFAULT_AGE);
    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Person(int age) {
        this.name = DEFAULT_NAME;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
