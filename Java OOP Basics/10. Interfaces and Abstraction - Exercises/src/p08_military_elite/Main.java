package p08_military_elite;

import p08_military_elite.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class Main { // it works without the interfaces, but I added some of em for the fun of it...
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<Soldier> soldiers = new ArrayList<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String type = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];
            double salary = Double.parseDouble(tokens[4]);

            try {
                switch (type) {
                    case "Private":
                        soldiers.add(new Private(id, firstName, lastName, salary));
                        break;
                    case "Spy":
                        soldiers.add(new Spy(id, firstName, lastName, tokens[4]));
                        break;
                    case "LeutenantGeneral":
                        addLeutenant(soldiers, tokens, id, firstName, lastName, salary);
                        break;
                    case "Engineer":
                        addEngineer(soldiers, tokens, id, firstName, lastName, salary);
                        break;
                    case "Commando":
                        addCommando(soldiers, tokens, id, firstName, lastName, salary);
                        break;
                }
            } catch (IllegalArgumentException ex) {
                continue;
            }
        }
        soldiers.forEach(System.out::print);
    }

    private static void addCommando(List<Soldier> soldiers, String[] tokens, int id,
                                    String firstName, String lastName, double salary) {
        Soldier commando = new Commando(id, firstName, lastName, salary, tokens[5]);

        for (int i = 6; i < tokens.length; i += 2) {
            try {
                Mission mission = new Mission(tokens[i], tokens[i + 1]);
                ((Commando) commando).getMissions().add(mission);
            } catch (IllegalArgumentException ex) {
                continue;
            }
        }
        soldiers.add(commando);
    }

    private static void addEngineer(List<Soldier> soldiers, String[] tokens, int id,
                                    String firstName, String lastName, double salary) {
        Soldier engineer = new Engineer(id, firstName, lastName, salary, tokens[5]);

        for (int i = 6; i < tokens.length; i += 2) {
            Repair repair = new Repair(tokens[i], Integer.parseInt(tokens[i + 1]));
            ((Engineer) engineer).getRepairs().add(repair);
        }
        soldiers.add(engineer);
    }

    private static void addLeutenant(List<Soldier> soldiers, String[] tokens, int id,
                                     String firstName, String lastName, double salary) {
        Soldier general = new LeutenantGeneral(id, firstName, lastName, salary);

        for (int i = 5; i < tokens.length; i++) {
            for (Soldier soldier : soldiers) {
                if (soldier instanceof Private && soldier.getId() == Integer.parseInt(tokens[i])) {
                    ((LeutenantGeneral) general).getPrivates().add((Private) soldier);
                }
            }
        }
        soldiers.add(general);
    }
}
