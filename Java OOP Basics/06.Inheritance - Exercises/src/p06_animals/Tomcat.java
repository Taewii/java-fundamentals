package p06_animals;

public class Tomcat extends Cat {

    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("Give me one million b***h");
    }
}
