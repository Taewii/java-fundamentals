package p02_kings_gambit;

import p02_kings_gambit.models.FootMan;
import p02_kings_gambit.models.King;
import p02_kings_gambit.models.RoyalGuard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        King king = new King(reader.readLine());

        String[] guards = reader.readLine().split(" ");
        String[] footmen = reader.readLine().split(" ");

        for (String guard : guards) {
            king.addResponder(new RoyalGuard(guard));
        }

        for (String footman : footmen) {
            king.addResponder(new FootMan(footman));
        }

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Attack":
                    king.respond();
                    break;
                case "Kill":
                    king.getResponder(tokens[1]).kill();
                    break;
            }
        }
    }
}
